package cc.sportsdb.manager;

import cc.sportsdb.manager.base.MockBaseControllerTest;
import cc.sportsdb.manager.controller.UserController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MvcResult;

public class SportsdbManagerApplicationTests extends MockBaseControllerTest<UserController> {

    @Value("${local.server.port}")
    private String serverPort;

    private static final Logger logger = LoggerFactory.getLogger(SportsdbManagerApplicationTests.class);

    @Test
    public void loginTest() throws Exception {
        MvcResult result = mockGet("/user/login");
        logger.info("result: {}", result.getResponse().getContentAsString());
    }
}
