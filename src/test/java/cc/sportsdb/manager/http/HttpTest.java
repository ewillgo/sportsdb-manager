package cc.sportsdb.manager.http;

import cc.sportsdb.common.http.HttpUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpTest {

    private static final Logger logger = LoggerFactory.getLogger(HttpTest.class);

    @Test
    public void okhttp3LoggerTest() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Connection", "Close");
        httpHeaders.setContentType(MediaType.TEXT_HTML);
        String html = HttpUtil.httpGet("https://www.baidu.com?a=10", String.class, httpHeaders);
        logger.info("{}", html);
    }

    @Test
    public void downloadTest() throws IOException {
//        String file = "https://www.baidu.com/img/bd_logo1.png";
        String file = "http://img.championat.com/news/big/l/c/ujejn-runi_1439911080563855663.jpg";

        HttpHeaders httpheaders = new HttpHeaders();
        httpheaders.setAccept(Arrays.asList(MediaType.IMAGE_JPEG));
        ByteArrayOutputStream bos = HttpUtil.download(file, httpheaders);
        Thumbnails.of(new ByteArrayInputStream(bos.toByteArray()))
                .size(100, 100).toFile(new File("e:/abc.jpg"));

        System.out.println();
    }

    @Test
    public void httpPostTest() {
        String url = "https://www.baidu.com";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "baidu");
        String html = HttpUtil.httpPost(url, String.class, requestBody, requestBody);
        System.out.println(html);
    }
}
