layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index'
}).use(['form'], function () {

});

function getLoanTypeFormData() {
    let showState = document.getElementsByName("showState");

    let obj = new LoanType();
    obj.id = document.getElementById("id").value;
    obj.typeId = document.getElementById("typeId").value;
    obj.code = document.getElementById("code").value.trim();
    obj.name = document.getElementById("name").value.trim();

    for(let i = 0; i < showState.length; i++){
        if(showState[i].checked){
            obj.showState = showState[i].value;
            break;
        }
    }

    return obj;
}