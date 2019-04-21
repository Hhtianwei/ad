<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String basePath = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<body>
<script type="text/javascript">
    var projectPath = "<%=basePath%>";
</script>
<script type="text/javascript" src="/static/js/adItemList.js"></script>

    <table id="empManageTable"></table>

</body>
</html>
