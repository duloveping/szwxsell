layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index'
}).use(['form'], function () {
    let $ = layui.$;
    let form = layui.form;

    $("#backButton").on("click", function () {
        document.location.href = "/manage/mall/product/loan-label/index";
    });

    form.on('submit(component-form-element)', function(data){
        $("#saveButton").prop("disabled", true);
        $("#resetButton").prop("disabled", true);
        $("#backButton").prop("disabled", true);



        let loadIndex = top.layer.load();
        let loanLabel = new LoanLabel();
        let field = data.field;

        console.log(field);
        console.log(field.showState);

        loanLabel.id = field.id;
        loanLabel.code = field.code
        loanLabel.name = field.name;
        loanLabel.showState = field.showState;
        loanLabel.serialNumber = field.serialNumber;

        $.ajax({
            type: "post",
            url: "/manage/mall/product/loan-label/save",
            cache: false,
            data: loanLabel,
            dataType: "json",
            success: function (res) {
                top.layer.close(loadIndex);

                if (res.status == RESULT_STATUS_SUCCESS) {
                    document.location.href = "/manage/mall/product/loan-label/index";
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