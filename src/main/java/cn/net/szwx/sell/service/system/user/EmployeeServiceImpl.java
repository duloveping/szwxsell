package cn.net.szwx.sell.service.system.user;

import cn.net.szwx.sell.dao.system.user.EmployeeDao;
import cn.net.szwx.sell.entity.system.user.Employee;
import cn.net.szwx.sell.entity.system.user.EmployeeSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(Employee entity) {
        entity.preInsert();
        return employeeDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(Employee entity) {
        entity.preUpdate();
        return employeeDao.update(entity);
    }

    @Override
    public List<Employee> list(EmployeeSO so) {
        return employeeDao.list(so);
    }

    @Override
    public PageInfo<Employee> findPage(EmployeeSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<Employee> pageInfo = new PageInfo(employeeDao.list(so));
        return pageInfo;
    }

    @Override
    public Employee getById(Long id) {
        return employeeDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return employeeDao.deleteById(id);
    }
}
