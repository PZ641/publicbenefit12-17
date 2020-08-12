<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  	<h1>更新用户</h1><hr/>
  	<form action="updateUser" method="post">
    <input type="hidden" name="_method" value="put" />
  		<input type="hidden" name="id" value="${company.id }"/>
  		账号：<input type="text" name="username" value="${company.username }"/><p/>
  		密码：<input type="text" name="password" value="${company.password }"/><p/>
  		状态：<input type="text" name="status" value="${company.status }"/><p/>
  		<input type="submit" value="修改"/>
  	</form>
  </body>
</html>
