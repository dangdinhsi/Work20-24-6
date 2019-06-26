<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Classroom" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 6/24/2019
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    Classroom room = (Classroom) request.getAttribute("room");
    HashMap<String,String> errors =(HashMap<String, String>) request.getAttribute("errors");
    if(errors == null){
        errors = new HashMap<>();
    }
    if(room == null){
        room = new Classroom();
    }

%>
<style>
    .error {
        color: red;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Classroom Form</h1>
<div></div>
<%
    if(errors.size() > 0){
%>
<div class="error">
    Bạn gặp lỗi, vui lòng sửa và thử lại !!!!
</div>
<%
    }
%>

<div>
    <br>
</div>

<form action="<%= blobstoreService.createUploadUrl("/classroom/create") %>" method="post" enctype="multipart/form-data">
    <div>
        Name <input type="text" name="name" value="<%= room.getName()%>">
        <%
            if(errors.containsKey("name")){
        %>
        <span class="error"><%=errors.get("name")%></span>
        <%
            }
        %>
    </div>

    <div>
        Description <input type="text" name="description" value="<%= room.getDescription()%>">
        <%
            if(errors.containsKey("description")){
        %>
        <span class="error"><%=errors.get("description")%></span>
        <%
            }
        %>
    </div>
    <div>Image <input type="file" name="imageUrl"></div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
