package cn.net.szwx.sell.entity.mall.product;

import cn.net.szwx.sell.entity.SOSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoanProductLabelSO extends SOSupport {
    /** 所属贷款标签ID */
    private Long labelId;
    /** 所属贷款产品ID */
    private Long productId;
    /** 所属贷款标签 */
    @JsonIgnore
    private LoanLabel loanLabel;
    /** 所属贷款产品 */
    @JsonIgnore
    private LoanProduct loanProduct;

    public LoanProductLabelSO() {
    }

    public LoanProductLabelSO(Long labelId, Long productId) {
        this.labelId = labelId;
        this.productId = productId;
    }

    public LoanProductLabelSO(LoanLabel loanLabel, LoanProduct loanProduct) {
        this.loanLabel = loanLabel;
        this.loanProduct = loanProduct;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LoanLabel getLoanLabel() {
        return loanLabel;
    }

    public void setLoanLabel(LoanLabel loanLabel) {
        this.loanLabel = loanLabel;
    }

    public LoanProduct getLoanProduct() {
        return loanProduct;
    }

    public void setLoanProduct(LoanProduct loanProduct) {
        this.loanProduct = loanProduct;
    }
}
