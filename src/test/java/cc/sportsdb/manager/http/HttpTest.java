package cc.sportsdb.manager.http;

import cc.sportsdb.common.util.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpTest {

    private static final Logger logger = LoggerFactory.getLogger(HttpTest.class);

    @Test
    public void okhttp3LoggerTest() {
        String html = HttpUtil.httpGet("https://www.baidu.com?a=10", String.class);
        logger.info("{}", html);
    }
}
