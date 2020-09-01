<%--
  Created by IntelliJ IDEA.
  User: kakao_ent
  Date: 2020/09/01
  Time: 1:29 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/sample/exUploadPost" method="post"
          enctype="multipart/form-data">
        <div>
            <input type = "file" name="files">
        </div>
        <div>
            <input type = "file" name="files">
        </div>
        <div>
            <input type = "file" name="files">
        </div>
        <div>
            <input type = "file" name="files">
        </div>
        <div>
            <input type = "file" name="files">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>
