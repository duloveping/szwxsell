layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index'
}).use(['index', 'form', 'table', 'upload'], function () {
    var table = layui.table;
    var $ = layui.$;

    table.render({
        elem: '#data-table-list',
        url: '/manage/system/user/member/list',
        request: {pageName: 'pageNum', limitName: 'pageSize'},
        parseData: function(res){
            return {code: res.status, msg: res.info, count: res.total, data: res.datas};
        },
        page: true,
        method: 'post',
        height: 'full-240',
        cellMinWidth: 80,
        limit: 30,
        cols: [[{
            field: 'username',
            title: '用户名'
        }, {
            field: 'fullname',
            title: '姓名'
        }, {
            field: 'nickname',
            title: '昵称'
        }, {
            field: 'lockState',
            title: '锁定状态',
            width: 100,
            templet: '#showState-table-switchTpl'
        }, {
            title: '操作',
            toolbar: '#dataTableListToolbar',
            width: 170,
        }
        ]]
    });

    table.on('tool(dataTableList)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            top.layer.open({
                type: 2,
                maxmin:true,
                area: ['800px', '600px'],
                content: '/manage/system/user/member/view?id=' + data.id + "&rnd=" + Math.random()
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除么', function (index) {
                $.ajax({
                    url: '/manage/system/user/member/delete',
                    data: {
                        id: data.id
                    },
                    success: function (data) {
                        obj.del();
                        layer.close(index);
                    }
                });
            });
        } else if (obj.event === 'edit') {
            document.location.href = '/manage/system/user/member/edit?id=' + data.id + "&rnd=" + Math.random();
        }
    });

    var active = {
        reload: function () {
            var userName = $("input[name=userName][type=text]").val();
            var fullName = $("input[name=fullName][type=text]").val();
            var showState = $("select[name=showState]").val();
            table.reload('data-table-list', {
                request: {pageName: 'pageNum', limitName: 'pageSize'},
                page: { curr: 1 },
                where: {
                    userName: userName,
                    fullName: fullName,
                    showState: showState
                }
            });
        }
    };

    $('#searchButton').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $('#addButton').on('click', function () {
        document.location.href = '/manage/system/user/member/edit';
    });
});