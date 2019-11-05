layui.config({
    base: '/static/layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'user'], function(){
    var $ = layui.$
        ,setter = layui.setter
        ,admin = layui.admin
        ,form = layui.form
        ,router = layui.router();

    form.render();

    //提交
    form.on('submit(LAY-user-reg-submit)', function(obj){
        var field = obj.field;

        //确认密码
        if(field.password !== field.repass){
            return layer.msg('两次密码输入不一致');
        }

        //是否同意用户协议
        if(!field.agreement){
            return layer.msg('你必须同意用户协议才能注册');
        }

        //请求接口
        admin.req({
            url: layui.setter.base + 'json/user/reg.js' //实际使用请改成服务端真实接口
            ,data: field
            ,done: function(res){
                layer.msg('注册成功', {
                    offset: '15px'
                    ,icon: 1
                    ,time: 1000
                }, function(){
                    location.hash = '/user/login'; //跳转到登入页
                });
            }
        });

        return false;
    });
});