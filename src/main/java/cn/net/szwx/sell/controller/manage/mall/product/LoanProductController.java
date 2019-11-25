package cn.net.szwx.sell.controller.manage.mall.product;

import cn.net.szwx.sell.controller.UploadController;
import cn.net.szwx.sell.entity.mall.product.LoanBank;
import cn.net.szwx.sell.entity.mall.product.LoanBankSO;
import cn.net.szwx.sell.entity.mall.product.LoanProduct;
import cn.net.szwx.sell.entity.mall.product.LoanProductSO;
import cn.net.szwx.sell.service.mall.product.LoanBankService;
import cn.net.szwx.sell.service.mall.product.LoanProductService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manage/mall/product/loan-product")
public class LoanProductController extends UploadController {
    @Autowired
    private LoanProductService loanProductService;
    @Autowired
    private LoanBankService loanBankService;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("manage/mall/product/loan-product/index");
    }

    @ResponseBody
    @RequestMapping("list")
    public JSONObject list(LoanProductSO so){
        PageInfo<LoanProduct> pageInfo = loanProductService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(required = false) Long id) {
        LoanProduct loanProduct = new LoanProduct();
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-product/edit");
        if (null != id && id > 0) {
            loanProduct = loanProductService.getById(id);
        } else {
            loanProduct.setShowState(Boolean.FALSE);
            loanProduct.setSellState(Boolean.FALSE);
            loanProduct.setNewState(Boolean.FALSE);
            loanProduct.setSaleState(Boolean.FALSE);
            loanProduct.setOneBonus(0.0);
            loanProduct.setTwoBonus(0.0);
            loanProduct.setThreeBonus(0.0);
            loanProduct.setSerialNumber(0);
        }
        mv.getModel().put("so", loanProduct);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-product/view");
        mv.getModel().put("so", loanProductService.getById(id));
        return mv;
    }

    @ResponseBody
    @RequestMapping("save")
    public JSONObject save(LoanProductSO so){
        LoanProduct loanProduct = new LoanProduct();
        if (null != so.getId() && so.getId() > 0) {
            loanProduct = loanProductService.getById(so.getId());
        }
        loanProduct.setCode(StringUtils.trimToNull(so.getCode()));
        loanProduct.setName(StringUtils.trimToNull(so.getName()));
        loanProduct.setImage(StringUtils.trimToNull(so.getImage()));
        loanProduct.setShowState(so.getShowState());
        loanProduct.setSellState(so.getSellState());
        loanProduct.setNewState(so.getNewState());
        loanProduct.setSaleState(so.getSaleState());
        loanProduct.setOneBonus(so.getOneBonus());
        loanProduct.setTwoBonus(so.getTwoBonus());
        loanProduct.setThreeBonus(so.getThreeBonus());
        loanProduct.setApplyCondition(StringUtils.trimToNull(so.getApplyCondition()));
        loanProduct.setProductFeature(StringUtils.trimToNull(so.getProductFeature()));
        loanProduct.setApplyData(StringUtils.trimToNull(so.getApplyData()));
        loanProduct.setApplyFlow(StringUtils.trimToNull(so.getApplyFlow()));
        loanProduct.setProductAward(StringUtils.trimToNull(so.getProductAward()));
        loanProduct.setSerialNumber(so.getSerialNumber());
        if (null != so.getId() && so.getId() > 0) {
            loanProductService.update(loanProduct);
        } else {
            loanProductService.insert(loanProduct);
        }

        LoanBankSO bankSO = new LoanBankSO();
        bankSO.setShowState(Boolean.TRUE);
        List<LoanBank> bankList =loanBankService.list(bankSO);
        loanProduct.setLoanBankList(bankList);


        JSONObject result = resultSuccess();;
        result.put("data", loanProduct);
        return result;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JSONObject delete(@RequestParam Long id){
        loanProductService.deleteById(id);
        return resultSuccess();
    }
}
