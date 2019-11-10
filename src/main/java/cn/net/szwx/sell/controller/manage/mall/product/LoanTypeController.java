package cn.net.szwx.sell.controller.manage.mall.product;

import cn.net.szwx.sell.common.Constants;
import cn.net.szwx.sell.controller.BaseController;
import cn.net.szwx.sell.entity.mall.product.LoanType;
import cn.net.szwx.sell.entity.mall.product.LoanTypeSO;
import cn.net.szwx.sell.service.mall.product.LoanTypeService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manage/mall/product/loan-type")
public class LoanTypeController extends BaseController {
    @Autowired
    private LoanTypeService loanTypeService;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("manage/mall/product/loan-type/index");
    }

    @ResponseBody
    @RequestMapping("list")
    public JSONObject list(LoanTypeSO so){
        so.setTypeId(0L);
        List<LoanType> typeList = loanTypeService.findRecursive(so);

        JSONArray array = new JSONArray();
        if (CollectionUtils.isNotEmpty(typeList)) {
            for (LoanType type : typeList) {
                JSONObject data = new JSONObject();
                data.put("id", type.getId());
                if (null == type.getTypeId()) {
                    data.put("pId", 0);
                } else {
                    data.put("pId", type.getTypeId());
                }
                data.put("name", type.getName());
                data.put("code", type.getCode());
                array.add(data);
            }
        }
        JSONObject result = new JSONObject();
        result.put("msg", "");
        result.put("code", Constants.SUCCESS);
        result.put("count", 1);
        result.put("is", true);
        result.put("tip", "操作成功");
        result.put("data", array);

        return result;
    }
    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") Long typeId) {
        LoanType loanType = new LoanType();
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-type/edit");
        if (null != id && id > 0) {
            LoanType parent = new LoanType();
            loanType = loanTypeService.getById(id);
            if (null == loanType.getTypeId()) {
                parent.setName("一级分类");
            } else {
                parent = loanTypeService.getById(loanType.getTypeId());
            }
            loanType.setType(parent);
        } else {
            LoanType parent = new LoanType();
            if (typeId.equals(0L)) {
                parent.setName("一级分类");
            } else {
                parent = loanTypeService.getById(typeId);
            }
            loanType.setType(parent);
            loanType.setShowState(Boolean.FALSE);
            loanType.setSerialNumber(0);
        }
        mv.getModel().put("so", loanType);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("manage/mall/product/loan-type/view");
        mv.getModel().put("so", loanTypeService.getById(id));
        return mv;
    }

    @ResponseBody
    @RequestMapping("save")
    public JSONObject save(LoanTypeSO so){
        LoanType loanType = new LoanType();
        if (null != so.getId() && so.getId() > 0) {
            loanType = loanTypeService.getById(so.getId());
        }
        loanType.setCode(StringUtils.trimToNull(so.getCode()));
        loanType.setName(StringUtils.trimToNull(so.getName()));
        loanType.setShowState(so.getShowState());
        loanType.setTypeId(so.getTypeId());
        loanType.setSerialNumber(so.getSerialNumber());
        if (null != so.getId() && so.getId() > 0) {
            loanTypeService.update(loanType);
        } else {
            loanTypeService.insert(loanType);
        }

        JSONObject result = resultSuccess();;
        result.put("data", loanType);
        return result;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JSONObject delete(@RequestParam Long id){
        loanTypeService.deleteById(id);
        return resultSuccess();
    }
}
