<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta  content="text/html ;charset=utf-8" http-equiv="content-type"  />
		<title>Java开发腾讯大数据批量导入系统</title>
		<meta name="keywords" content="关键字，关键词" />
		<meta name="description" content="" />
        <style type="text/css">
        	*{margin: 0; padding: 0;}
        	body{font-size: 12px; font-family: "微软雅黑"; color: #666;}
        	/*h1 start*/
        	h1{text-align: center; line-height: 100px;}
        	/*end h1*/
        	
        	/*import start*/
        	.import{width: 800px;margin: 0 auto;}        	
        	.import .i-btn{width: 140px; height: 38px;display: block;background: #66ccff; text-align: center;
        	line-height: 38px;text-decoration: none;color: #ffffff; font-size: 14px; border-radius: 3px;}
        	.import .i-btn:hover{background: #1081dc;}
        	.import .i-list p{font-size: 14px; line-height: 46px;padding-left: 10px;}
        	.import .i-con{border-top: 1px solid #e2e2e2; border-bottom: 1px solid #E2E2E2;margin: 40px 0;}
        	.import .i-con .i-list{margin: 20px 0;}
        	.import .i-con .i-list:hover{background: #f7f7f7;}
        	/*end import*/
        	
        </style>
        <!-- jquery文件不要放在head中，打开页面会提前加载head内容，影响速度 -->
	</head>
	<body>
		<!--h1 start-->
		<h1>Java开发腾讯大数据批量导入系统</h1>
		<!--end h1-->
		
		<!--import start-->
		<div class="import">
			 <a class="i-btn">上传批量数据<a/>
			<div class="i-con">
				<!-- <div id="" class="i-list">
					<p>名称</p>
					<p>描述</p>
				</div> -->
			</div>
		</div>
		<!--end import-->
		
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<script>
			jQuery(function(){
				$(".i-btn").click(function(){
					$.ajax({
						type:"post",
						url:"data.jsp",
						beforeSend:function(data){
							//数据正在解析
							//函数自己写
							//loading("数据正在解析");
						},
						success:function(data){
							var jdata=eval("("+data+")");
							var html="";
							for(var i=0;i<jdata.length;i++){
								html+="<div class='i-list'>"+
								       "<p>第"+(i+1)+"节课名称："+jdata[i].title+"</p>"+
								       "<p>第"+(i+1)+"节课描述："+jdata[i].desc+"</p>"+
								       "</div>";
							}
							$(".i-con").html(html);
							//函数自己写
							//loading("数据解析成功！",3);
						}
					});
				});
			});
			
		</script>
	</body>
</html>

