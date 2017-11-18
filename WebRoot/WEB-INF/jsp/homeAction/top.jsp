<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>TopMenu</title>
	<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
	<LINK href="${pageContext.request.contextPath}/style/blue/top.css" type=text/css rel=stylesheet>
	 <link  href="${pageContext.request.contextPath}/style/blue/pintuer.css" rel="stylesheet">
	<script type="text/javascript">
	</script>
	<style type="text/css">
		#messageArea{
			color: white;
			font-size: 14px;
			font-weight: bold;
		}
	</style>
</head>

<body class="PageBody" style="margin: 0">
	
	<div id="Head1">
		<div id="Logo">
			<a id="msgLink" href="javascript:void(0)"></a>

        <div class="logo margin-big-left fadein-top">
          <img src="style/images/y.jpg" class="radius-circle rotate-hover" height="48" /><font id="Headtitle">QIT-OA管理系统</font>
        </div>
		
        </div>
		
		        	<div id="Head1Right_Button1"  class="button button-little bg-green">
						<span class="icon-user"></span> 您好，管理员
			    		</div>
		
		        	<div id="Head1Right_Button2" >
		             <a href="javascript:void(0)" class="button button-little bg-blue" target="_parent">
							  	<span class="icon-wrench"></span> 个人设置
							</a>
					</div>
					<div  id="Head1Right_Button3">
				
					 <a target="_parent" href="${pageContext.request.contextPath}/userAction_logout.action"  class="button button-little bg-red" >
						<span class="icon-power-off"></span> 退出登录
					</a>
					</div>
				</div>	
	    
    <div id="Head2">
        <div id="Head2_Awoke">
            <ul id="AwokeNum">
                <li><a target="desktop" href="javascript:void(0)" class="button button-little bg-green" >
					<span class="icon-pencil"></span> 消息
						<span id="msg"></span>
					</a>
				</li>
                <li class="Line"></li>
                <li><a target="desktop" href="javascript:void(0)"  class="button button-little bg-green" >
						<span class="icon-envelope"></span> 邮件
						<span id="mail"></span>
					</a>
				</li>
                <li class="Line"></li>
				  <!-- 是否有待审批文档的提示1，数量 -->
                <li><a href="${pageContext.request.contextPath}/formFlowAction_myTaskList.action" target="desktop" class="button button-little bg-green">
                		
						<span class="icon-comment"></span> 待办事项（<span id="wait" class="taskListSize">1</span>）
                	</a>
                </li>
			 	  
                <!-- 是否有待审批文档的提示2，提示审批
                <li id="messageArea">&nbsp;&nbsp;&nbsp;&nbsp;您有 1 个待审批文档，请及时审批！★★★★★</li>  -->
            </ul>  
        </div>
        
		<div id="Head2_FunctionList">
			<marquee style="WIDTH: 100%;" onMouseOver="this.stop()" onMouseOut="this.start()" 
				scrollamount=1 scrolldelay=30 direction=left>
				<b>这是滚动的通知</b>
			</marquee>
		</div>
	</div>

</body>

</html>
