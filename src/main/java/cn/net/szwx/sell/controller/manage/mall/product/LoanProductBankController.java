package cn.net.szwx.sell.controller.manage.mall.product;

import cn.net.szwx.sell.controller.BaseController;
import cn.net.szwx.sell.entity.mall.product.LoanBank;
import cn.net.szwx.sell.entity.mall.product.LoanProduct;
import cn.net.szwx.sell.entity.mall.product.LoanProductBank;
import cn.net.szwx.sell.entity.mall.product.LoanProductBankSO;
import cn.net.szwx.sell.service.mall.product.LoanProductBankService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manage/mall/product/loan-product-bank")
public class LoanProductBankController extends BaseController {
    @Autowired
    private LoanProductBankService loanProductBankService;

    @ResponseBody
    @RequestMapping("list")
    public JSONObject list(){
        LoanProduct product = new LoanProduct();
        product.setShowState(Boolean.TRUE);

        LoanBank bank = new LoanBank();
        bank.setShowState(Boolean.TRUE);

        LoanProductBankSO so = new LoanProductBankSO();
        so.setLoanProduct(product);
        so.setLoanbank(bank);

        List<LoanProductBank> list = loanProductBankService.list(so);
        JSONObject json = resultSuccess();
        json.put("datas", list);
        return json;
    }
}
