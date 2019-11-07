package cn.net.szwx.sell.controller.manage.system.user;

import cn.net.szwx.sell.common.Constants;
import cn.net.szwx.sell.controller.BaseController;
import cn.net.szwx.sell.entity.system.user.Employee;
import cn.net.szwx.sell.entity.system.user.EmployeeSO;
import cn.net.szwx.sell.service.system.user.EmployeeService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/system/user/employee")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("manage/system/user/employee/index");
    }

    @ResponseBody
    @RequestMapping("list")
    public JSONObject list(EmployeeSO so){
        PageInfo<Employee> pageInfo = employeeService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(required = false) Long id) {
        Employee employee = new Employee();
        ModelAndView mv = new ModelAndView("manage/system/user/employee/edit");
        if (null != id && id > 0) {
            employee = employeeService.getById(id);
        } else {
            employee.setLockState(Constants.ACCOUNT_LOCK_STATE_DISABLED);
        }
        mv.getModel().put("so", employee);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam Long id) {
        ModelAndView mv = edit(id);
        mv.setViewName("manage/system/user/employee/view");
        return mv;
    }

    @ResponseBody
    @RequestMapping("save")
    public JSONObject save(EmployeeSO so){
        Employee employee = new Employee();
        if (null != so.getId() && so.getId() > 0) {
            employee = employeeService.getById(so.getId());
        }
        employee.setFullname(StringUtils.trimToNull(so.getFullname()));
        employee.setNickname(StringUtils.trimToNull(so.getNickname()));
        employee.setLockState(so.getLockState());
        if (StringUtils.isNotBlank(so.getPassword())) {
            employee.setPassword(DigestUtils.sha1Hex(so.getPassword()));
        }
        if (null != so.getId() && so.getId() > 0) {
            employeeService.update(employee);
        } else {
            employee.setUsername(StringUtils.trimToNull(so.getUsername()));
            employeeService.insert(employee);
        }
        return resultSuccess();
    }

    @ResponseBody
    @RequestMapping("delete")
    public JSONObject delete(@RequestParam Long id){
        employeeService.deleteById(id);
        return resultSuccess();
    }

}
