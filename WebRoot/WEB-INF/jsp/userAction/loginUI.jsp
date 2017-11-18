<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>登录</title>
    <%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	<link  href="${pageContext.request.contextPath}/style/blue/pintuer.css" rel="stylesheet" type=text/css>
    <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/script/pintuer.js"></script>  
	<script type="text/javascript">
		$(function(){
			document.forms[0].loginName.focus();
		});
		
		// 在被嵌套时就刷新上级窗口
		if(window.parent != window){
			window.parent.location.reload(true);
		}
	</script>
</head>
<s:form action="userAction_login" focusElement="loginNameInput">
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
           <form method="post" name="actForm" action="../index.html">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top text-mix" ><h1>QIT-OA管理系统</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                       <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="loginName" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                 
                </div>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            </form>  
			 <div class="text-center padding-big-top text-black">@ 版权所有 QIT-OA管理系统  2017毕业设计  @lianjifu</div>
        </div>
    </div>
</div>

  </s:form>
</html>

