<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>相关下载</title>
<link href="<%=basePath%>style/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>js/jQuery-v1.11.1.js"></script>
<script type="text/javascript" src="<%=basePath%>js/main.js"></script>
</head>
<body>
	<div class="download">
		<c:forEach var="d" items="${list}" varStatus="status">     
	          <div class="dl_list clear">
			<div class="dl_box clear">
				<div class="icon">
					<img src="${d.logoFilePath}">
				</div>
				<div class="title">
					<h1>${d.name }</h1>
					<h3>大小${d.appSize } MB</h3>
					<div class="star">
						<ul>
						<%-- <c:forEach var="x" begin="1" end="${d.score }" step="1">  
							<li class="on"></li> --%>
							<c:if test="${d.score ==0 }">
								<li class=""></li>
								<li class=""></li>
								<li class=""></li>
								<li class=""></li>
								<li class=""></li>
							</c:if>
							<c:if test="${d.score ==1 }">
								<li class="on"></li>
								<li class=""></li>
								<li class=""></li>
								<li class=""></li>
								<li class=""></li>
							</c:if>
							<c:if test="${d.score ==2 }">
								<li class="on"></li>
								<li class="on"></li>
								<li class=""></li>
								<li class=""></li>
								<li class=""></li>
							</c:if>
							<c:if test="${d.score ==3 }">
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class=""></li>
								<li class=""></li>
							</c:if>
							<c:if test="${d.score ==4 }">
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class=""></li>
							</c:if>
							<c:if test="${d.score >=5 }">
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
							</c:if>
							
					   		<%-- </c:forEach>  --%>
						</ul>
					</div>
				</div>
			</div>
			<div class="btn">
				<a href="${d.iosAppId }">下载</a>
			</div>
			<i class="d"></i>
			<div class="text">${d.description }</div>
		</div>
		</c:forEach>  

	</div>
</body>
</html>