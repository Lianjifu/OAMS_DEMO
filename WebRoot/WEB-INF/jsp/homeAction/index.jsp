<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>OA管理系统设计与实现</title>
	<%@ include file="/WEB-INF/jsp/public/common.jspf"%>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.cookie.js"></script>
</head>

	<frameset rows="100,*,25" framespacing=0 border=0 frameborder="0">
		<frame noresize name="TopMenu" scrolling="no" src="${pageContext.request.contextPath}/homeAction_top.action">
		<frameset cols="180,*" id="resize">
			<frame noresize name="menu" scrolling="yes" src="${pageContext.request.contextPath}/homeAction_left.action">
			<frame noresize name="right" scrolling="yes" src="${pageContext.request.contextPath}/homeAction_right.action">
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/homeAction_bottom.action">
	</frameset>

	<noframes><body>
</body>
</noframes></html>



