package cc.sportsdb.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Value("${test}")
    private String value;

    @ResponseBody
    @GetMapping("/value")
    public String value() {
        return value;
    }

    @GetMapping("/login")
    public String login() {

        return "user/user-login";
    }

    @ResponseBody
    @GetMapping("/json")
    public Map<String, Object> json() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("age", 18);
        return map;
    }
}
