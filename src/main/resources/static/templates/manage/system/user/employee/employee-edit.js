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
        let employee = new Employee();
        let field = data.field;

        employee.id = field.id;
        employee.fullname = field.fullname;
        employee.username = field.username;
        employee.nickname = field.nickname;
        employee.password = field.password;
        employee.lockState = field.lockState;

        $.ajax({
            type: "post",
            url: "/manage/system/user/employee/save",
            cache: false,
            data: employee,
            dataType: "json",
            success: function (res) {
                top.layer.close(loadIndex);

                if (res.status == RESULT_STATUS_SUCCESS) {
                    document.location.href = "/manage/system/user/employee/index";
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