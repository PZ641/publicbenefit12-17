<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords"
			content="Seeking Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery-3.3.1.min.js"></script>	
<script type="text/javascript">
function sendBtn(node) {
    var url = node.href;/*得到href的值*/
    
    
    var msg = "您真的确定要删除吗？\n\n请确认！";
    if (confirm(msg)==true){
    	$.ajax({
            url:url,/*url也可以是json之类的文件等等*/
            type:'DELETE',/*DELETE、POST */
            success:function (result) {
                //判断result结果
                 if(result){
                    window.location.reload();
                }else{
                    alert("返回了false")
                }
            }
        })
    }else{
    return false;
    }
};

function addUserInfo() {
	window.location.href = "${pageContext.request.contextPath}/toAdd";
};

</script>
	</head>
	<body>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="9">
			<tbody>
				<tr>
					<c:forEach items="${companys}" var="c">
						<td>
							id：${c.id}
						</td>
						<td>
							用户名称：${c.username }
						</td>
						<td>
							密码：${c.password}
						</td>
						<td>
							状态：${c.status}
						</td>
						
						<td width="100" class="us_list">
							<a href="${pageContext.request.contextPath}/toUpd?id=${c.id }">修改信息</a>
						</td>
						<td width="100" class="us_list">
							<a href="${pageContext.request.contextPath}/deleteUser?id=${c.id }" onclick="sendBtn(this);return false;" >删除</a>
						</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<c:if test="${page != 1}">
		<a href="${pageContext.request.contextPath}/usersPage?page=${page-1}&size=${size}">上一页</a>	
	</c:if>
	<c:if test="${page != num}">
		<a href="${pageContext.request.contextPath}/usersPage?page=${page+1}&size=${size}">下一页</a>
		<a href="${pageContext.request.contextPath}/usersPage?page=${num}&size=${size}">尾页</a>
	</c:if>
		
		
		
		
		<a href="javascript:location.reload()">刷新</a> 

<input class="btn btn-primary btn-sm" style="float: left" type="button" name="Submit" onclick="addUserInfo();" value="添加用户">
<input class="btn btn-primary btn-sm" style="float: right" type="button" name="Submit" onclick="javascript:history.go(-1);" value="返回">
	</body>
</html>
