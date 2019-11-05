package cn.net.szwx.sell.entity.system.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 会员
 * @author 广东鼎和信息科技有限公司 - 杜永生
 * @version 0.0.1
 */
public class MemberSO extends AccountSO {
    private static final long serialVersionUID = -5429898153658348797L;
    /** 会员等级 */
    private Integer grade;
    /** 微信ID */
    private String weixinId;
    /** 身份证号码 */
    private String idCardNo;
    /** 一级邀请人 */
    private Long oneInviter;
    /** 二级邀请人 */
    private Long twoInviter;
    /** 三级邀请人 */
    private Long threeInviter;
    /** 一级奖金 */
    private Double oneBonus;
    /** 二级奖金 */
    private Double twoBonus;
    /** 三级奖金 */
    private Double threeBonus;
    /** 合计奖金 */
    private Double totalBonus;
    @JsonIgnore
    private MemberSO oneMember;
    @JsonIgnore
    private MemberSO twoMember;
    @JsonIgnore
    private MemberSO threeMember;

    public MemberSO() {
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Long getOneInviter() {
        return oneInviter;
    }

    public void setOneInviter(Long oneInviter) {
        this.oneInviter = oneInviter;
    }

    public Long getTwoInviter() {
        return twoInviter;
    }

    public void setTwoInviter(Long twoInviter) {
        this.twoInviter = twoInviter;
    }

    public Long getThreeInviter() {
        return threeInviter;
    }

    public void setThreeInviter(Long threeInviter) {
        this.threeInviter = threeInviter;
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

    public Double getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(Double totalBonus) {
        this.totalBonus = totalBonus;
    }

    public MemberSO getOneMember() {
        return oneMember;
    }

    public void setOneMember(MemberSO oneMember) {
        this.oneMember = oneMember;
    }

    public MemberSO getTwoMember() {
        return twoMember;
    }

    public void setTwoMember(MemberSO twoMember) {
        this.twoMember = twoMember;
    }

    public MemberSO getThreeMember() {
        return threeMember;
    }

    public void setThreeMember(MemberSO threeMember) {
        this.threeMember = threeMember;
    }
}
