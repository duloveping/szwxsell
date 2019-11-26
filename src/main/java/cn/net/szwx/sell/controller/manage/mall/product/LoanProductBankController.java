package cn.net.szwx.sell.controller.manage.mall.product;

import cn.net.szwx.sell.controller.BaseController;
import cn.net.szwx.sell.entity.mall.product.*;
import cn.net.szwx.sell.service.mall.product.LoanBankService;
import cn.net.szwx.sell.service.mall.product.LoanProductBankService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manage/mall/product/loan-product-bank")
public class LoanProductBankController extends BaseController {
    @Autowired
    private LoanBankService loanBankService;
    @Autowired
    private LoanProductBankService loanProductBankService;

    @ResponseBody
    @RequestMapping("product-bank-list")
    public JSONObject productBankList(@RequestParam Long productId){
        LoanBankSO loanBankSO = new LoanBankSO();
        loanBankSO.setShowState(true);
        List<LoanBank> bankList = loanBankService.list(loanBankSO);

        LoanProductBankSO loanProductBankSO = new LoanProductBankSO();
        loanProductBankSO.setProductId(productId);
        List<LoanProductBank> loanProductBankList = loanProductBankService.list(loanProductBankSO);

        JSONArray array = new JSONArray();
        if (CollectionUtils.isNotEmpty(bankList)) {
            for (LoanBank bank : bankList) {
                boolean selected = false;
                if (CollectionUtils.isNotEmpty(loanProductBankList)) {
                    for (LoanProductBank productBank : loanProductBankList) {
                        if (productBank.getBankId().equals(bank.getId())) {
                            selected = true;
                            break;
                        }
                    }
                }

                JSONObject data = new JSONObject();
                data.put("value", bank.getId());
                data.put("name", bank.getName());
                data.put("selected", selected);
                array.add(data);
            }
        }

        JSONObject json = resultSuccess();
        json.put("datas", array);
        return json;
    }

    @ResponseBody
    @RequestMapping("list")
    public JSONObject list(LoanProductBankSO so){
        LoanProduct product = new LoanProduct();
        product.setShowState(Boolean.TRUE);
        product.setId(so.getProductId());

        LoanBank bank = new LoanBank();
        bank.setShowState(Boolean.TRUE);
        bank.setId(so.getBankId());

        so.setLoanProduct(product);
        so.setLoanbank(bank);

        List<LoanProductBank> list = loanProductBankService.list(so);
        JSONObject json = resultSuccess();
        json.put("datas", list);
        return json;
    }
}
