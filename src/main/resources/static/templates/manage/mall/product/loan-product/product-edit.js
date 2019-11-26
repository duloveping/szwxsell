layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index',
    tinymce: 'lib/tinymce/tinymce',
    xmSelect: 'lib/xm-select',
}).use(['layer', 'util','form', 'upload', 'layedit', 'tinymce', 'xmSelect'], function () {
    let $ = layui.$;
    let layer = layui.layer;
    let util = layui.util;
    let form = layui.form;
    let upload = layui.upload;
    let tinymce = layui.tinymce;
    let layedit = layui.layedit;
    let xmSelect = layui.xmSelect;
    let id = $("#id").val();

    // let edit = tinymce.render({
    //     elem: "textarea",
    //     height: 400,
    //     width:'100%'
    // });

    let productFeature = layedit.build("productFeature");
    let applyCondition = layedit.build("applyCondition");
    let applyFlow = layedit.build("applyFlow");
    let applyData = layedit.build("applyData");
    let productAward = layedit.build("productAward");

    let bankList =xmSelect.render({
        el: '#loanProductBankList',
        toolbar: {show: true},
        data: []
    });

    if (id !== "") {
        $.ajax({
            type: "get",
            url: "/manage/mall/product/loan-product-bank/product-bank-list?productId=" + id + "&rnd=" + Math.random(),
            dataType: "json",
            success: function (res) {
                if (res.status == RESULT_STATUS_SUCCESS) {
                    bankList.update({
                        data: res.datas,
                        autoRow: true,
                    })
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert("加载银行列表时出错！");
            }
        });
    } else {
        $.ajax({
            type: "get",
            url: "/manage/mall/product/loan-bank/select-list?rnd=" + Math.random(),
            dataType: "json",
            success: function (res) {
                if (res.status == RESULT_STATUS_SUCCESS) {
                    bankList.update({
                        data: res.datas,
                        autoRow: true,
                    })
                }
            },
            error : function(XmlHttpRequest, textStatus, errorThrown) {
                top.layer.alert("加载银行列表时出错！");
            }
        });
    }

    $("#backButton").on("click", function () {
        document.location.href = "/manage/mall/product/loan-label/index";
    });

    $("#testButton").on("click", function () {
        console.log(edit.getContent());
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
        let loanProduct = new LoanProduct();
        let field = data.field;

        loanProduct.id = field.id;
        loanProduct.code = field.code
        loanProduct.name = field.name;
        loanProduct.image = field.image;
        loanProduct.showState = field.showState;
        loanProduct.sellState = field.sellState;
        loanProduct.newState = field.newState;
        loanProduct.hotState = field.hotState;
        loanProduct.saleState = field.saleState;
        loanProduct.oneBonus = field.oneBonus;
        loanProduct.twoBonus = field.twoBonus;
        loanProduct.threeBonus = field.threeBonus;
        loanProduct.productFeature = layedit.getContent(productFeature);
        loanProduct.applyCondition = layedit.getContent(applyCondition);
        loanProduct.applyFlow = layedit.getContent(applyFlow);
        loanProduct.applyData = layedit.getContent(applyData);
        loanProduct.productAward = layedit.getContent(productAward);

        $.ajax({
            type: "post",
            url: "/manage/mall/product/loan-product/save",
            cache: false,
            data: loanProduct,
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