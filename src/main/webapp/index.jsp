<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%-- <%
String path1 = request.getContextPath();
response.sendRedirect(path1 + "/login/toLogin.do");  
%> --%>


<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Mar 2016 12:28:43 GMT -->
<head>

	<script src="${pageContext.request.contextPath }/js/jquery.min63b9.js" type="text/javascript"></script>
    <%-- <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>登录</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery.min63b9.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/js/yc-alert.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min14ed.js?v=3.3.6"></script>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
    	if(window.top !== window.self){ window.top.location = window.location;}
    </script> --%>
</head>

<body>

mavendemo!!

<button type="button" onclick="login()">用户</button>

<script type="text/javascript">
function login(){
	alert("hah");
	var url = "${pageContext.request.contextPath}";
	window.location.href = url+"/user/showUser.do";
	//window.location.href = url+"/responseCode.do";
}
</script>
     <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">YC</h1>

            </div>
            <h3>欢迎侯婧珂</h3>

            <form class="m-t" role="form" id="detail">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="button" onclick="login()" class="btn btn-primary block full-width m-b">登 录</button>


                <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>
    
    <script type="text/javascript">
    
    document.onkeydown=keyDownSearch;  
    
    function keyDownSearch(e) {    
        // 兼容FF和IE和Opera    
        var theEvent = e || window.event;    
        var code = theEvent.keyCode || theEvent.which || theEvent.charCode;    
        if (code == 13) {    
        	login();
            return false;    
        }    
        return true;    
    }  
    var isWeixin = "${isWeixin}";
    $(function(){
    	
    });
    
    //登录方法
    var login = function (){
    	var url = "${pageContext.request.contextPath}";
    	$.ajax({
    		url:url+"/login/login.do?"+$("#detail").serialize(),
    		type:"POST",
    		dataType:"text",
    		success:function(data){
    			console.log(isWeixin);
    			if(isWeixin == 'true'){//如果微信跳转
    				window.location.href = url+"/weixin/toJump.do";
    			}else{
    				window.location.href = url+"/main/myIndex.do";
    			}
    		},
    		error:function(data){
    			$.YC.Alert("账号密码错误");
    			/* window.location.reload(); */
    		}
    	});
    };
    
    
    </script> 
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Mar 2016 12:28:43 GMT -->
</html>