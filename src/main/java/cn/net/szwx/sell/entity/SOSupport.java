package cn.net.szwx.sell.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class SOSupport  extends PageInfo implements Serializable {
    private static final long serialVersionUID = -2346772070956280733L;
    /** 流水号 */
    private Long id;
    /** 创建人ID */
    private String creatorId;
    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /** 创建时间 */
    private Date createTime;
    /** 编辑人ID */
    private String editorId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /** 编辑时间 */
    private Date editTime;
    /** 状态 */
    private Boolean status;
    /** 标记 */
    private Boolean flag;
    private Integer serialNumber;
    private Long exceptId;

    public SOSupport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getExceptId() {
        return exceptId;
    }

    public void setExceptId(Long exceptId) {
        this.exceptId = exceptId;
    }
}
