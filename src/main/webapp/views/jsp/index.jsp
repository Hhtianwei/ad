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
    <div>
        <ul>
            <li><a href="/adItem/adItemList">广告项列表</a></li>
            <li><a href="/order/listPage">订单列表</a></li>
        </ul>
    </div>
</body>

</html>