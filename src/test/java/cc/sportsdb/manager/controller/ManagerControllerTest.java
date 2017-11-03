package cc.sportsdb.manager.controller;

import cc.sportsdb.common.test.AbstractMockController;
import cc.sportsdb.manager.SportsdbManagerApplication;
import cc.sportsdb.manager.controller.manager.ManagerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SportsdbManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerControllerTest extends AbstractMockController<ManagerController> {

    private static final Logger logger = LoggerFactory.getLogger(ManagerControllerTest.class);

    @Test
    public void addTest() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("email", "test@qq.com<script>alert(0)</script>");
        data.put("password", "asdf");
        data.put("nickname", "will");
        MvcResult result = mockPost("/manager/add", data);
        logger.info("result: {}", result.getResponse().getContentAsString());
    }

    @Test
    public void loginTest() throws Exception {
        MvcResult result = mockGet("/user/json");
        logger.info("result: {}", result.getResponse().getContentAsString());
    }

}
