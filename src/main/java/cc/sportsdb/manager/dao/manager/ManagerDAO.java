package cc.sportsdb.manager.dao.manager;

import cc.sportsdb.manager.domain.manager.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerDAO {

    /**
     * 添加管理员
     *
     * @param manager 管理员对象
     * @return
     */
    boolean addManager(Manager manager);

    List<Manager> getManagers();

    /**
     * 根据管理员ID获取数据
     *
     * @param managerId 管理员ID
     * @param fields    查询字段
     * @return
     */
    Manager getManagerById(@Param("managerId") String managerId, @Param("fields") String fields);
}
