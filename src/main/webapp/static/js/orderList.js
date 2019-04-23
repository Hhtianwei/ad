$(function(){
    $('#orderTable').datagrid({
        url: projectPath + "/order/list",
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
            { text: '删除', iconCls: 'icon-remove', handler: function () {
                    removeOrder();
                }
            }
            ],
                frozenColumns: [[ //保持不动的列
            {field: 'id', title: '编号', checkbox: true}

        ]],
        columns: [
            [
                { field: 'createTimeString', title: '创建时间', sortable: true, align: 'left', width: 120 },
                { field: 'name', title: '名称', sortable: true, align: 'left', width: 160 },
                { field: 'totalPriceString', title: '订单金额', sortable: true, align: 'left', width: 160 },
                { field: 'action', title: '操作', sortable: true, align: 'left', width: 210,formatter:function (value,row,index) {
                            var s = '<a href="#" onclick="showDetail('+row.id+')">查看</a> ';
                            var c = '<a href="#" onclick="downloadOrder('+row.id+')">下载</a>';
                            return s+c;
                    }}
            ]
        ]
    });

});

function showDetail(id){

}

function downloadOrder(id){
    window.location.href='/order/download/'+ id;
}

function getRowIndex(target){
    var tr = $(target).closest('tr.datagrid-row');
    return parseInt(tr.attr('datagrid-row-index'));
}

function removeOrder(){
    var deletes = $('#orderTable').datagrid("getSelections");//获取删除状态的行
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
                url:"/order/remove",
                data:JSON.stringify(ids),
                contentType:"application/json",
                type:"delete",
                success:function (result) {
                    alert(2);
                    if(result.success){
                        alert(3);
                        window.location.href = "/order/listPage";
                    }
                }
            });

        });
    }
}

