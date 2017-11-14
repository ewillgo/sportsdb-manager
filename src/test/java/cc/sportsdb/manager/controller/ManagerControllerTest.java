package cc.sportsdb.manager.controller;

import cc.sportsdb.common.test.AbstractMockController;
import cc.sportsdb.common.util.ToolUtil;
import cc.sportsdb.manager.controller.manager.ManagerController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

public class ManagerControllerTest extends AbstractMockController<ManagerController> {

    private static final Logger logger = LoggerFactory.getLogger(ManagerControllerTest.class);

    @Test
    public void addTest() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("managerId", ToolUtil.getUUID());
        data.put("email", "test5@qq.com<script>alert(0);</script>");
        data.put("password", "asdf");
        data.put("nickname", "will");
        MvcResult result = mockPost("/manager/add", data);
        String res = result.getResponse().getContentAsString();
        logger.info("result: {}", res);
    }

    @Test
    public void loginTest() throws Exception {
        MvcResult result = mockGet("/manager/login");
        logger.info("result: {}", result.getResponse().getContentAsString());
    }

}
