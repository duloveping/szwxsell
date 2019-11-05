layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index'
}).use(['index', 'form', 'table', 'upload'], function () {

});
