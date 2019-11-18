layui.config({
    base: '/static/layuiadmin/'
}).extend({
    index: 'lib/index'
}).use(['index', 'form', 'table', 'upload'], function () {
    var table = layui.table;
    var $ = layui.$;

    table.render({
        elem: '#data-table-list',
        url: '/manage/mall/product/loan-bank/list',
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
            field: 'code',
            title: '编码'
        }, {
            field: 'name',
            title: '名称'
        }, {
            field: 'showState',
            title: '显示状态',
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
                content: '/manage/mall/product/loan-bank/view?id=' + data.id + "&rnd=" + Math.random()
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除么', function (index) {
                $.ajax({
                    url: '/manage/mall/product/loan-bank/delete',
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
            document.location.href = '/manage/mall/product/loan-bank/edit?id=' + data.id + "&rnd=" + Math.random();
        }
    });

    var active = {
        reload: function () {
            var code = $("input[name=code][type=text]").val();
            var name = $("input[name=name][type=text]").val();
            var showState = $("select[name=showState]").val();
            table.reload('data-table-list', {
                request: {pageName: 'pageNum', limitName: 'pageSize'},
                page: { curr: 1 },
                where: {
                    code: code,
                    name: name,
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
        document.location.href = '/manage/mall/product/loan-bank/edit';
    });
});
