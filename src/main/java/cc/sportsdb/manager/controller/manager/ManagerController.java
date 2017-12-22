package cc.sportsdb.manager.controller.manager;

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
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#6000#59", key = "#root.methodName")
    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#6000#59", key = "#manager.id")
//    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS + "#6000#59")
    public Map<String, Object> getManagers(@ModelAttribute("manager") Manager manager) {
        Result result = new Result();
        result.setStatus(1);
        result.setMessage("ok");
        result.setData(managerService.getManagers());
        return result;
    }

}
