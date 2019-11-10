var editObj = null, ptable = null, treeGrid = null, tableId = 'treeTable', layer = null;
layui.config({
    base: '/static/layuiadmin/'
}).extend({
    treeGrid: 'layui/extend/treeGrid'
}).use(['jquery', 'treeGrid', 'layer'], function () {
    let $ = layui.jquery;
    let treeGrid = layui.treeGrid;
    let layer = layui.layer;

    treeGrid.render({
        id: tableId,
        elem: '#' + tableId,
        idField: 'id',
        url: '/manage/mall/product/loan-type/list',
        cellMinWidth: 100,
        treeId: 'id', // 树形id字段名称
        treeUpId: 'pId', // 树形父id字段名称
        treeShowName: 'name', // 以树形式显示的字段
        cols: [[
            {field: 'name', edit: 'text', title: '类别名称'},
            {field: 'code', edit: 'text', width: 200, title: '类别编码'},
            {field: 'id', width: 200, title: '流水号'},
            {field: 'pId', width: 200, title: '所属类别ID'},
            {
                width: 130, title: '操作', align: 'center',
                templet: function (d) {
                    var addBtn = '<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="add">添加</a>';
                    var delBtn = '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                    return addBtn + delBtn;
                }
            },
        ]],
        page: false
    });

    treeGrid.on('tool(' + tableId + ')', function (obj) {
        if (obj.event === 'del') {//删除行
            top.layer.confirm("你确定删除数据吗？", {icon: 3, title: '提示'}, function (index) {
                let loadIndex = top.layer.load();

                $.ajax({
                    type: "get",
                    url: "/manage/mall/product/loan-type/delete?id=" + obj.data.id,
                    cache: false,
                    dataType: "json",
                    success: function (res) {
                        obj.del();
                        layer.close(index);
                        top.layer.close(loadIndex);
                    },
                    error : function(XmlHttpRequest, textStatus, errorThrown) {
                        top.layer.close(loadIndex);
                        top.layer.alert('数据保存失败');
                    }
                });
            });
        } else if (obj.event === "add") {
            var index = top.layer.open({
                type: 2,
                title: '添加贷款类别',
                shadeClose: true,
                shade: 0.8,
                area: ['640px', '480px'],
                maxmin: true,
                content: '/manage/mall/product/loan-type/edit?typeId=' + obj.data.id,
                btn: ['保存', '关闭'],
                btn1: function () {
                    let fh = window["layui-layer-iframe" + index].getLoanTypeFormData();
                    let flag = true;
                    if (fh.code == "") {
                        flag = false;
                        top.layer.alert("贷款类别编码不能为空");
                    } else if (fh.name == "") {
                        flag = false;
                        top.layer.alert("贷款类别名称不能为空");
                    }

                    if (flag) {
                        let loadIndex = top.layer.load();

                        $.ajax({
                            type: "post",
                            url: "/manage/mall/product/loan-type/save",
                            cache: false,
                            data: fh,
                            dataType: "json",
                            success: function (res) {
                                top.layer.close(loadIndex);

                                if (res.status == RESULT_STATUS_SUCCESS) {
                                    fh.id = res.data.id;
                                    fh.pId = res.data.typeId;

                                    treeGrid.addRow(tableId, obj.data.LAY_TABLE_INDEX + 1, fh);
                                    top.layer.closeAll();
                                } else {
                                    top.layer.alert(res.info);
                                }
                            },
                            error : function(XmlHttpRequest, textStatus, errorThrown) {
                                top.layer.close(loadIndex);
                                top.layer.alert('数据保存失败');
                            }
                        });
                    }
                },
                btn2: function () {
                    top.layer.closeAll();
                }
            });
            top.layer.full(index);
        }
    });

    $("#addButton").on("click", function () {
        var index = top.layer.open({
            type: 2,
            title: '添加贷款类别',
            shadeClose: true,
            shade: 0.8,
            area: ['640px', '480px'],
            maxmin: true,
            content: '/manage/mall/product/loan-type/edit',
            btn: ['保存', '关闭'],
            btn1: function () {
                let fh = window["layui-layer-iframe" + index].getLoanTypeFormData();
                let flag = true;
                if (fh.code == "") {
                    flag = false;
                    top.layer.alert("贷款类别编码不能为空");
                } else if (fh.name == "") {
                    flag = false;
                    top.layer.alert("贷款类别名称不能为空");
                }

                if (flag) {
                    let loadIndex = top.layer.load();

                    $.ajax({
                        type: "post",
                        url: "/manage/mall/product/loan-type/save",
                        cache: false,
                        data: fh,
                        dataType: "json",
                        success: function (res) {
                            top.layer.close(loadIndex);

                            if (res.status == RESULT_STATUS_SUCCESS) {
                                fh.id = res.data.id;
                                fh.pId = res.data.typeId;
                                treeGrid.addRow(tableId, 0, fh);
                                top.layer.closeAll();
                            } else {
                                top.layer.alert(res.info);
                            }
                        },
                        error : function(XmlHttpRequest, textStatus, errorThrown) {
                            top.layer.close(loadIndex);
                            top.layer.alert('数据保存失败');
                        }
                    });
                }
            },
            btn2: function () {
                top.layer.closeAll();
            }
        });
        top.layer.full(index);
    });
});