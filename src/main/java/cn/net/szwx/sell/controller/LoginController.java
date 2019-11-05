package cn.net.szwx.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("login/index");
    }
}
