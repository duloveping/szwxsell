layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index',
    tinymce: 'lib/tinymce/tinymce'
}).use(['layer', 'util','form', 'upload', 'tinymce'], function () {
    let $ = layui.$;
    let layer = layui.layer;
    let util = layui.util;
    let form = layui.form;
    let upload = layui.upload;
    let tinymce = layui.tinymce;

    var edit = tinymce.render({
        elem: "textarea",
        height: 400,
        width:'100%'
    });

    $("#backButton").on("click", function () {
        document.location.href = "/manage/mall/product/loan-label/index";
    });

    upload.render({
        elem: '#upload-image-button',
        url: '/manage/mall/product/loan-product/upload-image',
        done: function (res) {
            //上传完毕回调
            if (res.status == RESULT_STATUS_SUCCESS) {
                $("#previewImage").prop("src", res.url);
                $("#image").val( res.url);
            } else {
                top.layer.alert(res.info);
            }
        },
        error: function () {
            //请求异常回调
        }
    });


    form.on('submit(component-form-element)', function(data){
        $("#saveButton").prop("disabled", true);
        $("#resetButton").prop("disabled", true);
        $("#backButton").prop("disabled", true);

        let loadIndex = top.layer.load();
        let loanLabel = new LoanLabel();
        let field = data.field;

        loanLabel.id = field.id;
        loanLabel.code = field.code
        loanLabel.name = field.name;
        loanLabel.image = field.image;
        loanLabel.showState = field.showState;
        loanLabel.serialNumber = field.serialNumber;

        $.ajax({
            type: "post",
            url: "/manage/mall/product/loan-product/save",
            cache: false,
            data: loanLabel,
            dataType: "json",
            success: function (res) {
                top.layer.close(loadIndex);

                if (res.status == RESULT_STATUS_SUCCESS) {
                    document.location.href = "/manage/mall/product/loan-product/index";
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