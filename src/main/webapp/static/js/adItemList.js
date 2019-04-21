$(function(){
    $('#empManageTable').datagrid({
        url: projectPath + "/adItem/list",
        method: "get",
        fit: true,
        fitColumns:false,
        pagination: true,
        rownumbers: true,
        singleSelect:false,
        selected:false,
        pageList: [10,20,50,300,1000],
        idField:'id',
        checkOnSelect: false,
        loadMsg: "数据加载中，请稍候……",
        toolbar: [
            { text: '添加', iconCls: 'icon-add', handler: function () {
                    append();
                }
            },
            { text: '删除', iconCls: 'icon-remove', handler: function () {
                    remove();
                }
            },
            { text: '生成订单', iconCls: 'icon-more', handler: function () {
                    //createOrder();
                    openOrderCreateWin();
                }
            }

            ],
                frozenColumns: [[ //保持不动的列
            {field: 'id', title: '编号', checkbox: true}

        ]],
        columns: [
            [
                { field: 'createTimeString', title: '创建时间', sortable: true, align: 'left', width: 120 },
                { field: 'content', title: '内容', sortable: true, align: 'left', width: 160 },
                { field: 'specification', title: '规格', sortable: true, align: 'left', width: 160 },
                { field: 'num', title: '数量', sortable: true, align: 'left', width: 50 },
                { field: 'size', title: '平米', sortable: true, align: 'left', width: 80 ,formatter: function(value,row,index){
                        if(value == ''){
                            return "--";
                        }else{
                            return value;
                        }
                    }},
                { field: 'material', title: '材料', sortable: true, align: 'left', width: 170 },
                { field: 'unitPriceString', title: '单价', sortable: true, align: 'left', width: 80 },
                { field: 'totalPriceString', title: '金额（元）', sortable: true, align: 'left', width: 100 },
                { field: 'remark', title: '备注', sortable: true, align: 'left', width: 150 }
            ]
        ]
    });

    $("#sure").on("click",function(){
        $('#win').window('close');
        createOrder();
    });

});

function append() {
        $("div.wu-main").load("/adItem/add");
}

function remove(){
    var deletes = $('#empManageTable').datagrid("getSelections");//获取删除状态的行
    if(!(deletes.length)){
        $.messager.alert('Warning','未选择');
    }else{
        $.messager.confirm('删除','是否确定删除?',function(r){
            if(!r){
                return ;
            }

            var ids = [];
            for(var i=0;i<deletes.length;i++){
                ids[i] = deletes[i].id;
            }
            $.ajax({
                url:"/adItem/remove",
                data:JSON.stringify(ids),
                contentType:"application/json",
                type:"delete",
                success:function (result) {
                    if(result.success){
                        $("div.wu-main").load("/adItem/adItemList");
                    }
                }
            });

        });
    }
}

function createOrder(){
    alert(1);
    var all = $('#empManageTable').datagrid("getSelections");//获取选中的行
    if(!(all.length)){
        $.messager.alert('Warning','必须选择好数据项');
    }else{

        var orderName = $("#orderName").val();

        var order = {};
        var items = [];
        var ids = [];
        for(var i=0;i<all.length;i++){
            items[i] = {"id":all[i].id};
        }
        order.name = orderName;
        order.items = items;
        $.ajax({
            url:"/order/create",
            data:JSON.stringify(order),
            contentType:"application/json",
            type:"post",
            success:function (result) {
                $("#orderName").val('');
                if(result.success){
                    window.location.href = "/";
                    //进入order列表页面
                    $("div.wu-main").load("/order/listPage");
                }
            }
        });
    }
}

function openOrderCreateWin() {
    var all = $('#empManageTable').datagrid("getSelections");//获取选中的行
    if(!(all.length)){
        $.messager.alert('Warning','必须选择好数据项');
    }else{
        $('#win').window('open');
    }
}
