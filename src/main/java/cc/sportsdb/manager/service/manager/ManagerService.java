package cc.sportsdb.manager.service.manager;

import cc.sportsdb.common.database.annotation.DataSource;
import cc.sportsdb.manager.constant.DataSourceConstant;
import cc.sportsdb.manager.dao.manager.ManagerDAO;
import cc.sportsdb.manager.domain.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
