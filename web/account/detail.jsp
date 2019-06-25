<%@ page import="entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 6/24/2019
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account =(Account) request.getAttribute("account");
%>
<style>
    .no_hope{
        color: green;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>ACCOUNT DETAILS</h2>
<div>
    <br>
</div>
<form action="/account/detail" method="post">
    <div>
        Username: <span class="no_hope"> <%= account.getUsername()%></span>
    </div>
    <div>
        Password: <span class="no_hope"> <%=account.getPassword()%></span>
    </div>
    <div>
        Salt: <span class="no_hope"> <%=account.getSalt()%></span>
    </div>
</form>
</body>
</html>
