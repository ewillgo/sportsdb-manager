package cc.sportsdb.manager.controller.manager;

import cc.sportsdb.common.database.mybatis.Page;
import cc.sportsdb.common.dto.Result;
import cc.sportsdb.manager.constant.RedisConstant;
import cc.sportsdb.manager.domain.manager.Manager;
import cc.sportsdb.manager.dto.manager.ManagerDTO;
import cc.sportsdb.manager.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static cc.sportsdb.manager.controller.manager.ManagerConst.MANAGER_ADD_FAIL;
import static cc.sportsdb.manager.controller.manager.ManagerConst.MANAGER_ADD_SUCCESS;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/login")
    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#60")
    public String login() {
        return "manager/manager-login";
    }

    @ResponseBody
    @PostMapping("/add")
    public Result add(@Valid @ModelAttribute("manager") ManagerDTO manager, Result result) {
        boolean res = managerService.addManager(manager.toPO());
        result.setStatus(res ? MANAGER_ADD_SUCCESS.getStatus() : MANAGER_ADD_FAIL.getStatus());
        result.setMessage(res ? MANAGER_ADD_SUCCESS.getMessage() : MANAGER_ADD_FAIL.getMessage());
        return result;
    }

    @ResponseBody
    @PostMapping("/getManagers")
//    @Cacheable(value = RedisConstant.KEY_MANAGER + "#60", key = "#manager.id")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#60")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#60", key = "#root.methodName")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS, key = "#root.methodName")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#60#50", key = "#root.methodName")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#60#50", key = "#manager.id")
    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#60#50")
    public Map<String, Object> getManagers(@ModelAttribute("manager") Manager manager, Page<Manager> page) {
        Result result = new Result();
        result.setStatus(1);
        result.setMessage("ok");
        managerService.getManagers(page);
        result.setData(page);
        return result;
    }

    @ResponseBody
    @PostMapping("/getManagerById")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS, key = "#managerId")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#60#50", key = "#managerId")
    public Map<String, Object> getManagerById(@RequestParam String managerId) {
        Result<Manager> result = new Result<>();
        Manager manager = managerService.getManagerById(managerId, "email");
        result.setStatus(manager != null ? 0 : -1);
        result.setData(manager);
        return result;
    }

    @ResponseBody
    @PostMapping("/getManagerByEmailAndPassword")
    public Map<String, Object> getManagerByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        Result<Manager> result = new Result<>();
        Manager manager = managerService.getManagerByEmailAndPassword(email, password, "email, password");
        result.setStatus(manager != null ? 0 : -1);
        result.setData(manager);
        return result;
    }
}
