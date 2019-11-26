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

function LoanType() {};

LoanType.prototype = {
    id: "",
    code: "",
    name: "",
    showState: false,
    typeId: "",
    typeCode: "",
    typeName: "",
    serialNumber: 0
};

function LoanLabel() {};

LoanLabel.prototype = {
    id: "",
    code: "",
    name: "",
    showState: false,
    serialNumber: 0
};

function LoanLabel() {};

LoanLabel.prototype = {
    id: "",
    code: "",
    name: "",
    showState: false,
    image: "",
    serialNumber: 0
};

function LoanProductBank() {};

LoanProductBank.prototype = {
    id: "",
    bankId: "",
    productId: ""
};

function LoanProduct() {};

LoanProduct.prototype = {
    id: "",
    code: "",
    name: "",
    image: "",
    showState: false,
    sellState: false,
    newState: false,
    hotState: false,
    saleState: false,
    oneBonus: 0.0,
    twoBonus: 0.0,
    threeBonus: 0.0,
    productFeature: "",
    applyCondition: "",
    applyFlow: "",
    applyData: "",
    productAward: "",
    loanTypeList: new Array(),
    loanBankList: new Array(),
    loanLabelList: new Array(),
    loanProductBankList: new Array(),
    loanProductLabelList: new Array(),
    loanProductTypeList: new Array(),
    serialNumber: 0
};