package cn.net.szwx.sell.service.system.user;

import cn.net.szwx.sell.entity.system.user.Employee;
import cn.net.szwx.sell.entity.system.user.EmployeeSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(Employee entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(Employee entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<Employee> list(EmployeeSO so);

    PageInfo<Employee> findPage(EmployeeSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);
}
