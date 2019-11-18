package cn.net.szwx.sell.controller.manage.mall.product;

import cn.net.szwx.sell.controller.UploadController;
import cn.net.szwx.sell.entity.mall.product.LoanBank;
import cn.net.szwx.sell.entity.mall.product.LoanBankSO;
import cn.net.szwx.sell.service.mall.product.LoanBankService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/mall/product/loan-bank")
public class LoanBankController extends UploadController {
    @Autowired
    private LoanBankService loanBankService;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("manage/mall/product/loan-bank/index");
    }

    @ResponseBody
    @RequestMapping("list")
    public JSONObject list(LoanBankSO so){
        PageInfo<LoanBank> pageInfo = loanBankService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(required = false) Long id) {
        LoanBank loanBank = new LoanBank();
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-bank/edit");
        if (null != id && id > 0) {
            loanBank = loanBankService.getById(id);
        } else {
            loanBank.setImage("/static/images/bank/bank.jpg");
            loanBank.setShowState(Boolean.FALSE);
            loanBank.setSerialNumber(0);
        }
        mv.getModel().put("so", loanBank);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-bank/view");
        mv.getModel().put("so", loanBankService.getById(id));
        return mv;
    }

    @ResponseBody
    @RequestMapping("save")
    public JSONObject save(LoanBankSO so){
        LoanBank loanBank = new LoanBank();
        if (null != so.getId() && so.getId() > 0) {
            loanBank = loanBankService.getById(so.getId());
        }
        loanBank.setCode(StringUtils.trimToNull(so.getCode()));
        loanBank.setName(StringUtils.trimToNull(so.getName()));
        loanBank.setShowState(so.getShowState());
        loanBank.setImage(StringUtils.trimToNull(so.getImage()));
        loanBank.setSerialNumber(so.getSerialNumber());
        if (null != so.getId() && so.getId() > 0) {
            loanBankService.update(loanBank);
        } else {
            loanBankService.insert(loanBank);
        }

        JSONObject result = resultSuccess();;
        result.put("data", loanBank);
        return result;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JSONObject delete(@RequestParam Long id){
        loanBankService.deleteById(id);
        return resultSuccess();
    }
}
