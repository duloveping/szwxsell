package cn.net.szwx.sell.controller.manage.system.user;

import cn.net.szwx.sell.controller.BaseController;
import cn.net.szwx.sell.entity.system.user.Employee;
import cn.net.szwx.sell.entity.system.user.EmployeeSO;
import cn.net.szwx.sell.service.system.user.EmployeeService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public JSONObject list(EmployeeSO so){
        PageInfo<Employee> pageInfo = employeeService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
}
