package cn.net.szwx.sell.entity.mall.product;

import cn.net.szwx.sell.entity.EntitySupport;

public class LoanBank extends EntitySupport {
    /** 编码 */
    private String code;
    /** 名称 */
    private String name;
    /** 图片 */
    private String image;
    /** 显示状态 */
    private Boolean showState;

    public LoanBank() {
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
}
