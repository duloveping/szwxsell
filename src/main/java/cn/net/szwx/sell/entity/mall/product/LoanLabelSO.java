package cn.net.szwx.sell.entity.mall.product;

import cn.net.szwx.sell.entity.SOSupport;

public class LoanLabelSO extends SOSupport {
    /** 编码 */
    private String code;
    /** 名称 */
    private String name;
    /** 显示状态 */
    private Boolean showState;

    public LoanLabelSO() {
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

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }
}
