package cc.sportsdb.manager.controller;

import cc.sportsdb.common.test.AbstractMockController;
import cc.sportsdb.common.util.JsonUtil;
import cc.sportsdb.manager.SportsdbManagerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SportsdbManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends AbstractMockController<UserController> {

    @Autowired
    @Qualifier("httpRestTemplate")
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Test
    public void loginTest() throws Exception {
        MvcResult result = mockGet("/user/json");
        logger.info("result: {}", result.getResponse().getContentAsString());
    }

    @Test
    public void linkTest() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
//        String html = restTemplate.exchange("https://jtp.tuandai.com/ajax/recharge_handler.ashx?action=auto_recharge", HttpMethod.GET, new HttpEntity<>(headers), String.class, "a", "b").getBody();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "test");
        String response = restTemplate.postForObject("http://www.toutiao.com/stream/widget/local_weather/city/?a=100&a=45&b=rr", JsonUtil.toJsonString(map), String.class);
//        String response = restTemplate.postForObject("https://www.baidu.com?a=100&a=45&b=rr", JsonUtil.toJsonString(map), String.class);
    }
}
