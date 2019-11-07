function Employee() {};

Employee.prototype = {
    id: "",
    fullname: "",
    username: "",
    nickname: "",
    password: "",
    lockState: ACCOUNT_LOCK_STATE_DISABLED
};

function Member() {};

Member.prototype = {
    id: "",
    fullname: "",
    username: "",
    nickname: "",
    password: "",
    lockState: ACCOUNT_LOCK_STATE_DISABLED,
    grade: 0,
    weixinId: "",
    idCardNo: "",
    oneInviter: "",
    twoInviter: "",
    threeInviter: "",
    oneBonus: "",
    twoBonus: "",
    threeBonus: "",
    totalBonus: "",
    oneMemberId: "",
    oneMemberFullName: "",
    twoMemberId: "",
    twoMemberFullName: "",
    threeMemberId: "",
    threeMemberFullName: ""
};