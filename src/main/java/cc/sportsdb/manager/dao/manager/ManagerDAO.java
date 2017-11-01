package cc.sportsdb.manager.dao.manager;

import cc.sportsdb.manager.domain.manager.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerDAO {

    /**
     * 添加管理员
     *
     * @param manager 管理员对象
     * @return
     */
    public boolean addManager(Manager manager);
}
