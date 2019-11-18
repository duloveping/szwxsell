package cn.net.szwx.sell.entity.mall.product;

import cn.net.szwx.sell.entity.EntitySupport;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoanProductType extends EntitySupport {
    /** 所属贷款类别ID */
    private Long typeId;
    /** 所属贷款产品ID */
    private Long productId;
    /** 所属贷款类别 */
    @JsonIgnore
    private LoanType loanType;
    /** 所属贷款产品 */
    @JsonIgnore
    private LoanProduct loanProduct;

    public LoanProductType() {
    }

    public LoanProductType(Long typeId, Long productId) {
        this.typeId = typeId;
        this.productId = productId;
    }

    public LoanProductType(LoanType loanType, LoanProduct loanProduct) {
        this.loanType = loanType;
        this.loanProduct = loanProduct;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public LoanProduct getLoanProduct() {
        return loanProduct;
    }

    public void setLoanProduct(LoanProduct loanProduct) {
        this.loanProduct = loanProduct;
    }
}
