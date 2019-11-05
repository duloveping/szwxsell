drop table if exists employee;
create table employee
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    username character varying(50),
    fullname character varying(50),
    nickname character varying(50),
    password character varying(50),
    lock_state integer,
    primary key (id)
);
comment on table employee is '员工';
comment on column employee.id is '流水号';
comment on column employee.creator_id is '创建人ID';
comment on column employee.create_time is '创建时间';
comment on column employee.editor_id is '编辑人ID';
comment on column employee.edit_time is '编辑时间';
comment on column employee.status is '状态';
comment on column employee.flag is '标记';
comment on column employee.username is '用户名';
comment on column employee.fullname is '全名（姓名）';
comment on column employee.nickname is '昵称';
comment on column employee.password is '密码';
comment on column employee.lock_state is '锁定状态';

drop table if exists member;
create table member
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    username character varying(50),
    fullname character varying(50),
    nickname character varying(50),
    password character varying(50),
    lock_state integer,
    grade integer,
    weixin_id character varying(50),
    id_card_no character varying(50),
    one_inviter bigint,
    two_inviter bigint,
    three_inviter bigint,
    one_bonus double precision default 0.00,
    two_bonus double precision default 0.00,
    three_bonus double precision default 0.00,
    total_bonus double precision default 0.00,
    primary key (id)
);
comment on table member is '会员';
comment on column member.id is '流水号';
comment on column member.creator_id is '创建人ID';
comment on column member.create_time is '创建时间';
comment on column member.editor_id is '编辑人ID';
comment on column member.edit_time is '编辑时间';
comment on column member.status is '状态';
comment on column member.flag is '标记';
comment on column member.username is '用户名';
comment on column member.fullname is '全名（姓名）';
comment on column member.nickname is '昵称';
comment on column member.password is '密码';
comment on column member.lock_state is '锁定状态';
comment on column member.grade is '会级等级';
comment on column member.weixin_id is '微信ID';
comment on column member.id_card_no is '身份证号码';
comment on column member.one_inviter is '一级邀请人';
comment on column member.two_inviter is '二级邀请人';
comment on column member.three_inviter is '三级邀请人';
comment on column member.one_bonus is '一级奖金';
comment on column member.two_bonus is '二级奖金';
comment on column member.three_bonus is '三级奖金';
comment on column member.total_bonus is '合计奖金';

drop table if exists member_contact;
create table member_contact
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    member_id bigint,
    category integer,
    mobile character varying(11),
    phone character varying(20),
    fax character varying(20),
    email character varying(50),
    qq character varying(20),
    live_address character varying(100),
    live_zip character varying(6),
    native_address character varying(100),
    native_zip character varying(6),
    company_name character varying(100),
    company_phone character varying(20),
    company_fax character varying(20),
    company_duty character varying(30),
    company_email character varying(20),
    company_address character varying(100),
    company_zip character varying(6),
    foreign key(member_id) references member(id),
    primary key (id)
);
comment on table member_contact is '会员联系方式';
comment on column member_contact.id is '流水号';
comment on column member_contact.creator_id is '创建人ID';
comment on column member_contact.create_time is '创建时间';
comment on column member_contact.editor_id is '编辑人ID';
comment on column member_contact.edit_time is '编辑时间';
comment on column member_contact.status is '状态';
comment on column member_contact.flag is '标记';
comment on column member_contact.member_id is '所属会员ID';
comment on column member_contact.category is '类型：1本人，2父母，3亲戚，4同事，5同学，6朋友';
comment on column member_contact.mobile is '手机号码';
comment on column member_contact.phone is '固定电话';
comment on column member_contact.fax is '传真号码';
comment on column member_contact.email is '邮箱';
comment on column member_contact.qq is 'QQ号码';
comment on column member_contact.live_address is '现居详细地址';
comment on column member_contact.live_zip is '现居地址邮编';
comment on column member_contact.native_address is '户籍详细地址';
comment on column member_contact.native_zip is '户籍地址邮编';
comment on column member_contact.company_name is '工作单位名称';
comment on column member_contact.company_phone is '工作电位电话';
comment on column member_contact.company_fax is '工作单位传真';
comment on column member_contact.company_duty is '工作单位职务';
comment on column member_contact.company_email is '工作单位邮箱';
comment on column member_contact.company_address is '工作单位地址';
comment on column member_contact.company_zip is '工作单位邮编';

drop table if exists loan_type;
create table loan_type
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    code character varying(30),
    name character varying(50),
    show_state boolean default false ,
    type_id bigint,
    serial_number integer default 0,
    foreign key(type_id) references loan_type(id),
    primary key (id)
);
comment on table loan_type is '贷款类别';
comment on column loan_type.id is '流水号';
comment on column loan_type.creator_id is '创建人ID';
comment on column loan_type.create_time is '创建时间';
comment on column loan_type.editor_id is '编辑人ID';
comment on column loan_type.edit_time is '编辑时间';
comment on column loan_type.status is '状态';
comment on column loan_type.flag is '标记';
comment on column loan_type.code is '编码';
comment on column loan_type.name is '名称';
comment on column loan_type.show_state is '显示状态';
comment on column loan_type.type_id is '所属类别ID';
comment on column loan_type.serial_number is '排序序号';

drop table if exists loan_label;
create table loan_label
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    code character varying(30),
    name character varying(50),
    show_state boolean default false,
    serial_number integer default 0,
    primary key (id)
);
comment on table loan_label is '贷款标签';
comment on column loan_label.id is '流水号';
comment on column loan_label.creator_id is '创建人ID';
comment on column loan_label.create_time is '创建时间';
comment on column loan_label.editor_id is '编辑人ID';
comment on column loan_label.edit_time is '编辑时间';
comment on column loan_label.status is '状态';
comment on column loan_label.flag is '标记';
comment on column loan_label.code is '编码';
comment on column loan_label.name is '名称';
comment on column loan_label.show_state is '显示状态';
comment on column loan_label.serial_number is '排序序号';

drop table if exists loan_bank;
create table loan_bank
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    code character varying(30),
    name character varying(50),
    image character varying(50),
    show_state boolean default false,
    serial_number integer default 0,
    primary key (id)
);
comment on table loan_bank is '贷款银行';
comment on column loan_bank.id is '流水号';
comment on column loan_bank.creator_id is '创建人ID';
comment on column loan_bank.create_time is '创建时间';
comment on column loan_bank.editor_id is '编辑人ID';
comment on column loan_bank.edit_time is '编辑时间';
comment on column loan_bank.status is '状态';
comment on column loan_bank.flag is '标记';
comment on column loan_bank.code is '编码';
comment on column loan_bank.name is '名称';
comment on column loan_bank.image is '名称';
comment on column loan_bank.show_state is '显示状态';
comment on column loan_bank.serial_number is '排序序号';

drop table if exists loan_product;
create table loan_product
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    code character varying(30),
    name character varying(200),
    show_state boolean default false,
    sell_state boolean default false,
    new_state boolean default false,
    hot_state boolean default false,
    sale_state boolean default false,
    serial_number integer default 0,
    one_bonus double precision default 0.00,
    two_bonus double precision default 0.00,
    three_bonus double precision default 0.00,
    product_feature character varying(1000),
    apply_condition character varying(1000),
    apply_flow character varying(1000),
    apply_data character varying(1000),
    product_award character varying(1000),
    primary key (id)
);
comment on table loan_product is '贷款标签';
comment on column loan_product.id is '流水号';
comment on column loan_product.creator_id is '创建人ID';
comment on column loan_product.create_time is '创建时间';
comment on column loan_product.editor_id is '编辑人ID';
comment on column loan_product.edit_time is '编辑时间';
comment on column loan_product.status is '状态';
comment on column loan_product.flag is '标记';
comment on column loan_product.code is '编码';
comment on column loan_product.name is '名称';
comment on column loan_product.show_state is '显示状态';
comment on column loan_product.sell_state is '上下架状态（销售状态）';
comment on column loan_product.new_state is '新品状态';
comment on column loan_product.hot_state is '热销状态';
comment on column loan_product.new_state is '新品状态';
comment on column loan_product.sale_state is '促销状态';
comment on column loan_product.serial_number is '排序序号';
comment on column loan_product.one_bonus is '一级奖金';
comment on column loan_product.two_bonus is '二级奖金';
comment on column loan_product.three_bonus is '三级奖金';
comment on column loan_product.product_feature is '产品特点';
comment on column loan_product.apply_condition is '申请条件（准入条件）';
comment on column loan_product.apply_flow is '申请流程';
comment on column loan_product.apply_data is '申请材料';
comment on column loan_product.product_award is '奖励措施';

drop table if exists loan_product_type;
create table loan_product_type
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    type_id bigint,
    product_id bigint,
    foreign key(type_id) references loan_type(id),
    foreign key(product_id) references loan_product(id),
    primary key (id)
);
comment on table loan_product_type is '贷款产品类别';
comment on column loan_product_type.id is '流水号';
comment on column loan_product_type.creator_id is '创建人ID';
comment on column loan_product_type.create_time is '创建时间';
comment on column loan_product_type.editor_id is '编辑人ID';
comment on column loan_product_type.edit_time is '编辑时间';
comment on column loan_product_type.status is '状态';
comment on column loan_product_type.flag is '标记';
comment on column loan_product_type.type_id is '贷款类别ID';
comment on column loan_product_type.product_id is '贷款产品ID';

drop table if exists loan_product_label;
create table loan_product_label
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    label_id bigint,
    product_id bigint,
    foreign key(label_id) references loan_label(id),
    foreign key(product_id) references loan_product(id),
    primary key (id)
);
comment on table loan_product_label is '贷款产品类别';
comment on column loan_product_label.id is '流水号';
comment on column loan_product_label.creator_id is '创建人ID';
comment on column loan_product_label.create_time is '创建时间';
comment on column loan_product_label.editor_id is '编辑人ID';
comment on column loan_product_label.edit_time is '编辑时间';
comment on column loan_product_label.status is '状态';
comment on column loan_product_label.flag is '标记';
comment on column loan_product_label.label_id is '贷款标签ID';
comment on column loan_product_label.product_id is '贷款产品ID';

drop table if exists loan_product_bank;
create table loan_product_bank
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    bank_id bigint,
    product_id bigint,
    foreign key(bank_id) references loan_bank(id),
    foreign key(product_id) references loan_product(id),
    primary key (id)
);
comment on table loan_product_bank is '贷款产品类别';
comment on column loan_product_bank.id is '流水号';
comment on column loan_product_bank.creator_id is '创建人ID';
comment on column loan_product_bank.create_time is '创建时间';
comment on column loan_product_bank.editor_id is '编辑人ID';
comment on column loan_product_bank.edit_time is '编辑时间';
comment on column loan_product_bank.status is '状态';
comment on column loan_product_bank.flag is '标记';
comment on column loan_product_bank.bank_id is '贷款银行ID';
comment on column loan_product_bank.product_id is '贷款产品ID';

drop table if exists member_loan_apply;
create table member_loan_apply
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    member_id bigint,
    full_name character varying(50),
    sex integer,
    id_card_id character varying(18),
    birth_date date,
    bank_id bigint,
    bank_code character varying(30),
    bank_name character varying(100),
    type_id bigint,
    type_code character varying(30),
    type_name character varying(100),
    label_id bigint,
    label_code character varying(30),
    label_name character varying(100),
    product_id bigint,
    product_code character varying(30),
    product_name character varying(100),
    apply_date timestamp without time zone,
    apply_money double precision default 0.00,
    audit_state integer default 1,
    audit_date timestamp without time zone,
    auditor_id bigint,
    loan_state integer default 1,
    loan_date timestamp without time zone,
    loan_money double precision default 0.00,
    loaner_id bigint,
    receive_state integer default 1,
    receive_date timestamp without time zone,
    one_bonus double precision,
    two_bonus double precision,
    three_bonus double precision,
    foreign key(member_id) references member(id),
    primary key (id)
);
comment on table member_loan_apply is '贷款产品类别';
comment on column member_loan_apply.id is '流水号';
comment on column member_loan_apply.creator_id is '创建人ID';
comment on column member_loan_apply.create_time is '创建时间';
comment on column member_loan_apply.editor_id is '编辑人ID';
comment on column member_loan_apply.edit_time is '编辑时间';
comment on column member_loan_apply.status is '状态';
comment on column member_loan_apply.flag is '标记';
comment on column member_loan_apply.member_id is '会员ID';
comment on column member_loan_apply.full_name is '姓名';
comment on column member_loan_apply.id_card_id is '身份证号码';
comment on column member_loan_apply.sex is '性别';
comment on column member_loan_apply.birth_date is '出生日期';
comment on column member_loan_apply.bank_id is '贷款银行ID';
comment on column member_loan_apply.bank_code is '贷款银行编码';
comment on column member_loan_apply.bank_name is '贷款银行名称';
comment on column member_loan_apply.type_id is '贷款类别ID';
comment on column member_loan_apply.type_code is '贷款类别编码';
comment on column member_loan_apply.type_name is '贷款类别名称';
comment on column member_loan_apply.label_id is '贷款标签ID';
comment on column member_loan_apply.label_code is '贷款标签编码';
comment on column member_loan_apply.label_name is '贷款标签名称';
comment on column member_loan_apply.product_id is '贷款产品ID';
comment on column member_loan_apply.product_code is '贷款产品编码';
comment on column member_loan_apply.product_name is '贷款产品名称';
comment on column member_loan_apply.apply_date is '申请日期';
comment on column member_loan_apply.apply_money is '申请金额';
comment on column member_loan_apply.audit_state is '审核状态：1待审，2通过，3驳回';
comment on column member_loan_apply.audit_date is '审核日期';
comment on column member_loan_apply.auditor_id is '审核人ID';
comment on column member_loan_apply.loan_state is '放款状态：1待放款，2已放款，3放款失败';
comment on column member_loan_apply.loan_date is '放款日期';
comment on column member_loan_apply.loan_money is '放款金额';
comment on column member_loan_apply.loaner_id is '放款人ID';
comment on column member_loan_apply.receive_state is '领取状态：1待领取，2已领取，3放弃领取';
comment on column member_loan_apply.receive_date is '领取日期';
comment on column member_loan_apply.one_bonus is '一级奖金';
comment on column member_loan_apply.two_bonus is '二级奖金';
comment on column member_loan_apply.three_bonus is '三级奖金';

drop table if exists member_loan_contact;
create table member_loan_contact
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    member_id bigint,
    apply_id bigint,
    category integer,
    mobile character varying(11),
    phone character varying(20),
    fax character varying(20),
    email character varying(50),
    qq character varying(20),
    live_address character varying(100),
    live_zip character varying(6),
    native_address character varying(100),
    native_zip character varying(6),
    company_name character varying(100),
    company_phone character varying(20),
    company_fax character varying(20),
    company_duty character varying(30),
    company_email character varying(20),
    company_address character varying(100),
    company_zip character varying(6),
    foreign key(member_id) references member(id),
    foreign key(apply_id) references member_loan_apply(id),
    primary key (id)
);
comment on table member_loan_contact is '会员贷款联系方式';
comment on column member_loan_contact.id is '流水号';
comment on column member_loan_contact.creator_id is '创建人ID';
comment on column member_loan_contact.create_time is '创建时间';
comment on column member_loan_contact.editor_id is '编辑人ID';
comment on column member_loan_contact.edit_time is '编辑时间';
comment on column member_loan_contact.status is '状态';
comment on column member_loan_contact.flag is '标记';
comment on column member_loan_contact.member_id is '所属会员ID';
comment on column member_loan_contact.apply_id is '所属贷款申请ID';
comment on column member_loan_contact.category is '类型：1本人，2父母，3亲戚，4同事，5同学，6朋友';
comment on column member_loan_contact.mobile is '手机号码';
comment on column member_loan_contact.phone is '固定电话';
comment on column member_loan_contact.fax is '传真号码';
comment on column member_loan_contact.email is '邮箱';
comment on column member_loan_contact.qq is 'QQ号码';
comment on column member_loan_contact.live_address is '现居详细地址';
comment on column member_loan_contact.live_zip is '现居地址邮编';
comment on column member_loan_contact.native_address is '户籍详细地址';
comment on column member_loan_contact.native_zip is '户籍地址邮编';
comment on column member_loan_contact.company_name is '工作单位名称';
comment on column member_loan_contact.company_phone is '工作电位电话';
comment on column member_loan_contact.company_fax is '工作单位传真';
comment on column member_loan_contact.company_duty is '工作单位职务';
comment on column member_loan_contact.company_email is '工作单位邮箱';
comment on column member_loan_contact.company_address is '工作单位地址';
comment on column member_loan_contact.company_zip is '工作单位邮编';

drop table if exists member_bill;
create table member_bill
(
    id bigserial,
    creator_id bigint,
    create_time timestamp without time zone,
    editor_id bigint,
    edit_time timestamp without time zone,
    status boolean default true,
    flag boolean default true,
    member_id bigint,
    category integer,
    bill_time timestamp without time zone,
    bill_money double precision default 0.00,
    content character varying(300),
    foreign key(member_id) references member(id),
    primary key (id)
);
comment on table member_bill is '会员帐单';
comment on column member_bill.id is '流水号';
comment on column member_bill.creator_id is '创建人ID';
comment on column member_bill.create_time is '创建时间';
comment on column member_bill.editor_id is '编辑人ID';
comment on column member_bill.edit_time is '编辑时间';
comment on column member_bill.status is '状态';
comment on column member_bill.flag is '标记';
comment on column member_bill.member_id is '会员ID';
comment on column member_bill.category is '类型：1收入，2支付';
comment on column member_bill.bill_time is '帐单时间';
comment on column member_bill.bill_money is '帐单金额';
comment on column member_bill.content is '帐单内容';
