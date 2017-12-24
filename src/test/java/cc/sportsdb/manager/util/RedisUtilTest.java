package cc.sportsdb.manager.util;

import cc.sportsdb.common.data.redis.DataProvider;
import cc.sportsdb.common.data.redis.RedisUtil;
import cc.sportsdb.common.test.AbstractMockController;
import cc.sportsdb.manager.controller.manager.ManagerController;
import cc.sportsdb.manager.domain.manager.Manager;
import cc.sportsdb.manager.service.manager.ManagerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RedisUtilTest extends AbstractMockController<ManagerController> {

    @Autowired
    private ManagerService managerService;

    @Test
    @SuppressWarnings("unchecked")
    public void getCacheValueTest() {
        List<Manager> managerList = RedisUtil.getCacheValue("my:1000", List.class, new DataProvider<List<Manager>>() {

            @Override
            public List<Manager> getData(String key) {
                return managerService.getManagers();
            }

            @Override
            public long expires() {
                return 600;
            }
        });

        System.out.println(managerList);
    }
}
