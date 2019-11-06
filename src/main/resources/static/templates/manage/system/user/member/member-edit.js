layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index'
}).use(['form'], function () {
    let $ = layui.$;
    let form = layui.form;

    $("#backButton").on("click", function () {
        document.location.href = "/manage/system/user/member/index";
    });

    form.on('submit(component-form-element)', function(data){
        $("#saveButton").prop("disabled", true);
        $("#resetButton").prop("disabled", true);
        $("#backButton").prop("disabled", true);

        let loadIndex = top.layer.load();
        let member = new Member();
        let field = data.field;

        member.id = field.id;
        member.fullname = field.fullname;
        member.username = field.username;
        member.nickname = field.nickname;
        member.password = field.password;
        member.lockState = field.lockState;
        member.grade = field.grade;
        member.weixinId = field.weixinId;
        member.idCardNo = field.idCardNo;
        member.oneInviter = field.oneInviter;
        member.twoInviter = field.twoInviter;
        member.threeInviter = field.threeInviter;
        member.oneBonus = field.oneBonus;
        member.twoBonus = field.twoBonus;
        member.threeBonus = field.threeBonus;
        member.totalBonus = field.totalBonus;
        member.oneMemberFullName = field.oneMember;
        member.twoMemberFullName = field.twoMember;
        member.threeMemberFullName = field.threeMember;

        $.ajax({
            type: "post",
            url: "/manage/system/user/member/save",
            cache: false,
            data: member,
            dataType: "json",
            success: function (res) {
                top.layer.close(loadIndex);

                if (res.status == RESULT_STATUS_SUCCESS) {
                    document.location.href = "/manage/system/user/member/index";
                } else {
                    $("#saveButton").prop("disabled", false);
                    $("#resetButton").prop("disabled", false);
                    $("#backButton").prop("disabled", false);
                    top.layer.alert(res.info);
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                $("#saveButton").prop("disabled", false);
                $("#resetButton").prop("disabled", false);
                $("#backButton").prop("disabled", false);

                top.layer.close(loadIndex);
                top.layer.alert('数据保存失败');
            }
        });
        return false;
    });
});
