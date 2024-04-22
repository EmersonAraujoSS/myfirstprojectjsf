<%--
  Created by IntelliJ IDEA.
  User: emerson.araujo
  Date: 18/04/2024
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String nome = request.getParameter("nome");
    out.print(nome);
%>
</body>
</html>
