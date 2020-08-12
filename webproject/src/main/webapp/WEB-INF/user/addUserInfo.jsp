<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  	<h1>添加用户</h1><hr/>
  	<form action="addUser" method="post">
  		ID：<input type="text" name="id"/><p/>
  		账号：<input type="text" name="username"/><p/>
  		密码：<input type="text" name="password"/><p/>
  		状态：<input type="text" name="status"/><p/>
  		<input type="submit" value="添加"/>
  	</form>
  </body>
</html>
