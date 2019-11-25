package cn.net.szwx.sell.entity.mall.product;

import cn.net.szwx.sell.entity.SOSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class LoanProductSO extends SOSupport {
    /** 编码 */
    private String code;
    /** 名称 */
    private String name;
    /** 图片 */
    private String image;
    /** 显示状态 */
    private Boolean showState;
    /** 上下架状态（销售状态） */
    private Boolean sellState;
    /** 新品状态 */
    private Boolean newState;
    /** 热销状态 */
    private Boolean hotState;
    /** 促销状态 */
    private Boolean saleState;
    /** 一级奖金 */
    private Double oneBonus;
    /** 二级奖金 */
    private Double twoBonus;
    /** 三级奖金 */
    private Double threeBonus;
    /** 产品特点 */
    private String productFeature;
    /** 申请条件（准入条件） */
    private String applyCondition;
    /** 申请流程 */
    private String applyFlow;
    /** 申请材料 */
    private String applyData;
    /** 奖励措施 */
    private String productAward;
    @JsonIgnore
    private List<LoanType> loanTypeList;
    @JsonIgnore
    private List<LoanBank> loanBankList;
    @JsonIgnore
    private List<LoanLabel> loanLabelList;
    @JsonIgnore
    private List<LoanProductBank> loanProductBankList;
    @JsonIgnore
    private List<LoanProductLabel> loanProductLabelList;
    @JsonIgnore
    private List<LoanProductType> loanProductTypeList;

    public LoanProductSO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Boolean getSellState() {
        return sellState;
    }

    public void setSellState(Boolean sellState) {
        this.sellState = sellState;
    }

    public Boolean getNewState() {
        return newState;
    }

    public void setNewState(Boolean newState) {
        this.newState = newState;
    }

    public Boolean getHotState() {
        return hotState;
    }

    public void setHotState(Boolean hotState) {
        this.hotState = hotState;
    }

    public Boolean getSaleState() {
        return saleState;
    }

    public void setSaleState(Boolean saleState) {
        this.saleState = saleState;
    }

    public Double getOneBonus() {
        return oneBonus;
    }

    public void setOneBonus(Double oneBonus) {
        this.oneBonus = oneBonus;
    }

    public Double getTwoBonus() {
        return twoBonus;
    }

    public void setTwoBonus(Double twoBonus) {
        this.twoBonus = twoBonus;
    }

    public Double getThreeBonus() {
        return threeBonus;
    }

    public void setThreeBonus(Double threeBonus) {
        this.threeBonus = threeBonus;
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature;
    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    public String getApplyFlow() {
        return applyFlow;
    }

    public void setApplyFlow(String applyFlow) {
        this.applyFlow = applyFlow;
    }

    public String getApplyData() {
        return applyData;
    }

    public void setApplyData(String applyData) {
        this.applyData = applyData;
    }

    public String getProductAward() {
        return productAward;
    }

    public void setProductAward(String productAward) {
        this.productAward = productAward;
    }

    public List<LoanType> getLoanTypeList() {
        return loanTypeList;
    }

    public void setLoanTypeList(List<LoanType> loanTypeList) {
        this.loanTypeList = loanTypeList;
    }

    public List<LoanBank> getLoanBankList() {
        return loanBankList;
    }

    public void setLoanBankList(List<LoanBank> loanBankList) {
        this.loanBankList = loanBankList;
    }

    public List<LoanLabel> getLoanLabelList() {
        return loanLabelList;
    }

    public void setLoanLabelList(List<LoanLabel> loanLabelList) {
        this.loanLabelList = loanLabelList;
    }

    public List<LoanProductBank> getLoanProductBankList() {
        return loanProductBankList;
    }

    public void setLoanProductBankList(List<LoanProductBank> loanProductBankList) {
        this.loanProductBankList = loanProductBankList;
    }

    public List<LoanProductLabel> getLoanProductLabelList() {
        return loanProductLabelList;
    }

    public void setLoanProductLabelList(List<LoanProductLabel> loanProductLabelList) {
        this.loanProductLabelList = loanProductLabelList;
    }

    public List<LoanProductType> getLoanProductTypeList() {
        return loanProductTypeList;
    }

    public void setLoanProductTypeList(List<LoanProductType> loanProductTypeList) {
        this.loanProductTypeList = loanProductTypeList;
    }
}
