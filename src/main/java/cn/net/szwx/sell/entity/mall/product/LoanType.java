package cn.net.szwx.sell.entity.mall.product;

import cn.net.szwx.sell.entity.EntitySupport;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 贷款类别
 * @author 广东鼎和信息科技有限公司 - 杜永生
 * @version 0.0.1
 */
public class LoanType extends EntitySupport {
    /** 编码 */
    private String code;
    /** 名称 */
    private String name;
    /** 显示状态 */
    private Boolean showState;
    /** 所属分类ID */
    private Long typeId;
    /** 所属分类ID */
    private String typeCode;
    /** 所属分类名称 */
    private String typeName;
    /** 所属分类 */
    @JsonIgnore
    private LoanType type;

    public LoanType() {
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }
}
