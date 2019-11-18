package cn.net.szwx.sell.controller.manage.mall.product;

import cn.net.szwx.sell.controller.BaseController;
import cn.net.szwx.sell.entity.mall.product.LoanLabel;
import cn.net.szwx.sell.entity.mall.product.LoanLabelSO;
import cn.net.szwx.sell.service.mall.product.LoanLabelService;
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
@RequestMapping("/manage/mall/product/loan-label")
public class LoanLabelController extends BaseController {
    @Autowired
    private LoanLabelService loanLabelService;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("manage/mall/product/loan-label/index");
    }

    @ResponseBody
    @RequestMapping("list")
    public JSONObject list(LoanLabelSO so){
        PageInfo<LoanLabel> pageInfo = loanLabelService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(required = false) Long id) {
        LoanLabel loanLabel = new LoanLabel();
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-label/edit");
        if (null != id && id > 0) {
            loanLabel = loanLabelService.getById(id);
        } else {
            loanLabel.setShowState(Boolean.FALSE);
            loanLabel.setSerialNumber(0);
        }
        mv.getModel().put("so", loanLabel);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-label/view");
        mv.getModel().put("so", loanLabelService.getById(id));
        return mv;
    }

    @ResponseBody
    @RequestMapping("save")
    public JSONObject save(LoanLabelSO so){
        LoanLabel loanLabel = new LoanLabel();
        if (null != so.getId() && so.getId() > 0) {
            loanLabel = loanLabelService.getById(so.getId());
        }
        loanLabel.setCode(StringUtils.trimToNull(so.getCode()));
        loanLabel.setName(StringUtils.trimToNull(so.getName()));
        loanLabel.setShowState(so.getShowState());
        loanLabel.setSerialNumber(so.getSerialNumber());
        if (null != so.getId() && so.getId() > 0) {
            loanLabelService.update(loanLabel);
        } else {
            loanLabelService.insert(loanLabel);
        }

        JSONObject result = resultSuccess();;
        result.put("data", loanLabel);
        return result;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JSONObject delete(@RequestParam Long id){
        loanLabelService.deleteById(id);
        return resultSuccess();
    }
}
