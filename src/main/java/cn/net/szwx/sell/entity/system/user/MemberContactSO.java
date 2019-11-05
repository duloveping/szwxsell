package cn.net.szwx.sell.entity.system.user;

import cn.net.szwx.sell.entity.SOSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 会员联系方式
 * @author 广东鼎和信息科技有限公司 - 杜永生
 * @version 0.0.1
 */
public class MemberContactSO extends SOSupport {
    private static final long serialVersionUID = -3856675312759762572L;
    @JsonIgnore
    private Member member;
    /** 所属会员ID */
    private Long memberId;
    /** 类型：1本人，2父母，3亲戚，4同事，5同学，6朋友 */
    private Integer category;
    /** 手机号码 */
    private String mobile;
    /** 固定电话 */
    private String phone;
    /** 传真号码 */
    private String fax;
    /** 邮箱 */
    private String email;
    /** QQ号码 */
    private String qq;
    /** 现居详细地址 */
    private String liveAddress;
    /** 现居地址邮编 */
    private String liveZip;
    /** 户籍详细地址 */
    private String nativeAddress;
    /** 户籍地址邮编 */
    private String nativeZip;
    /** 工作单位名称 */
    private String companyName;
    /** 工作电位电话 */
    private String companyPhone;
    /** 工作单位传真 */
    private String companyFax;
    /** 工作单位职务 */
    private String companyDuty;
    /** 工作单位邮箱 */
    private String companyEmail;
    /** 工作单位地址 */
    private String companyAddress;
    /** 工作单位邮编 */
    private String companyZip;

    public MemberContactSO() {
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getLiveZip() {
        return liveZip;
    }

    public void setLiveZip(String liveZip) {
        this.liveZip = liveZip;
    }

    public String getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(String nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    public String getNativeZip() {
        return nativeZip;
    }

    public void setNativeZip(String nativeZip) {
        this.nativeZip = nativeZip;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyDuty() {
        return companyDuty;
    }

    public void setCompanyDuty(String companyDuty) {
        this.companyDuty = companyDuty;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyZip() {
        return companyZip;
    }

    public void setCompanyZip(String companyZip) {
        this.companyZip = companyZip;
    }
}
