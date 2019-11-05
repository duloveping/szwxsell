package cn.net.szwx.sell.controller.manage;

import cn.net.szwx.sell.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/main")
public class MainController extends BaseController {
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("manage/main/index");
        return mv;
    }
}
