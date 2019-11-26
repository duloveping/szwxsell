package cn.net.szwx.sell.entity.mall.product;

import cn.net.szwx.sell.entity.EntitySupport;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoanProductBank extends EntitySupport {
    /** 所属贷款银行ID */
    private Long bankId;
    /** 所属贷款产品ID */
    private Long productId;
    /** 所属贷款银行 */
    @JsonIgnore
    private LoanBank loanbank;
    /** 所属贷款产品 */
    @JsonIgnore
    private LoanProduct loanProduct;

    public LoanProductBank() {
    }

    public LoanProductBank(Long bankId, Long productId) {
        this.bankId = bankId;
        this.productId = productId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LoanBank getLoanbank() {
        return loanbank;
    }

    public void setLoanbank(LoanBank loanbank) {
        this.loanbank = loanbank;
    }

    public LoanProduct getLoanProduct() {
        return loanProduct;
    }

    public void setLoanProduct(LoanProduct loanProduct) {
        this.loanProduct = loanProduct;
    }
}
