package cc.sportsdb.manager.service.manager;

import cc.sportsdb.common.database.DataSource;
import cc.sportsdb.manager.constant.DataSourceConstant;
import cc.sportsdb.manager.dao.manager.ManagerDAO;
import cc.sportsdb.manager.domain.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerDAO managerDAO;

    /**
     * 添加管理员
     *
     * @param manager 管理员对象
     * @return
     */
    @DataSource(DataSourceConstant.DS_TEST)
    public boolean addManager(Manager manager) {
        return managerDAO.addManager(manager);
    }

    //    @Cacheable(value = RedisConstant.KEY_MANAGER_USERS, key = "#root.methodName")
    @DataSource(DataSourceConstant.DS_TEST)
    public List<Manager> getManagers() {
        return managerDAO.getManagers();
    }

    @DataSource(DataSourceConstant.DS_TEST)
    public Manager getManagerById(String managerId, String fields) {
        return managerDAO.getManagerById(managerId, fields);
    }
}
