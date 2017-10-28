package cc.sportsdb.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/login")
    public String login() {

        return "manager/manager-login";
    }

    @ResponseBody
    @GetMapping("/json")
    public Map<String, Object> json() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("age", 99);
        return map;
    }
}
