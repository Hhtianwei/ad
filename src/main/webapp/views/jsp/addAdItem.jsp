<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String basePath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="copyright" content="All Rights Reserved, Copyright (C) 2013, Wuyeguo, Ltd." />
    <title>广告管理平台</title>
    <link rel="stylesheet" type="text/css" href="/static/easyui/1.3.4/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/wu.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/icon.css" />
    <script type="text/javascript" src="/static/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="/static/easyui/1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
<script type="text/javascript">
    var projectPath = "<%=basePath%>";
</script>
<script type="text/javascript" src="/static/js/addAdItem.js"></script>
<form action="#">
    <label for="content">内容：</label>
    <input type="text" placeholder="内容" id="content">
    <br>
    <label for="specification">规格：</label>
    <input type="text" placeholder="规格" id="specification">
    <br>

    <label for="num">数量：</label>
    <input type="text" placeholder="数量" id="num">
    <br>

    <label for="size">平米：</label>
    <input type="text" placeholder="平米" id="size">
    <br>

    <label for="material">材料：</label>
    <input type="text" placeholder="材料" id="material">
    <br>

    <label for="unitPrice">单价：</label>
    <input type="text" placeholder="单价" id="unitPrice">
    <br>

    <label for="totalPrice">总额：</label>
    <input type="text" placeholder="总额" id="totalPrice">
    <br>

    <label for="remark">备注：</label>
    <textarea name="remark" id="remark" cols="30" rows="5" placeholder="备注"></textarea>
    <br>

    <a href="#" id="addItemBtn" class="easyui-linkbutton" iconCls="icon-ok">新增</a>
</form>

</body>
</html>
