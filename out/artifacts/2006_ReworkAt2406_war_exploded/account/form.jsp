<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 6/24/2019
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Create Account</h1>
<div>
    <br>
</div>

<form action="<%=blobstoreService.createUploadUrl("/account/register")%>" method="post" enctype="multipart/form-data">
    <div>
        Username: <input type="text" name="username">
    </div>
    <div>
        Password:<input type="text" name="password">
    </div>

    <div>
        Re-Pass: <input type="text" name="re-password">
    </div>
    <div>
        Rollnumber <input type="text" name="rollNumber">
    </div>
    <div>
        Fullname <input type="text" name="fullName">
    </div>
    <div>
        Avatar <input type="file" name="myFile">
    </div>
    <div>
        <input type="submit" value="OK">
    </div>
</form>
</body>
</html>
