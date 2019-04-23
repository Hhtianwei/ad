$(function(){
    $("#addItemBtn").on("click",function(){
        var adItem = {
            "content":$("#content").val(),
            "specification":$("#specification").val(),
            "num":$("#num").val(),
            "size":$("#size").val(),
            "material":$("#material").val(),
            "unitPrice":$("#unitPrice").val(),
            "totalPrice":$("#totalPrice").val(),
            "remark":$("#remark").val()
        };

        $.ajax({
            url:"/adItem/add",
            data:JSON.stringify(adItem),
            contentType:"application/json",
            type:"post",
            success:function (result) {
                if(result.success){
                    window.location.href = "/adItem/adItemList";
                }
            }
        });
    });
});