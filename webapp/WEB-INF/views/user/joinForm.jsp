<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>
<body>
	<div id="center-content">
		
		<!-- 메인 해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>

		<div>		
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id"></td>
		      			<td><button id="btnIdCheck" type="button">아이디체크</button></td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2"><!-- 사용할 수 있는 아이디 입니다. --></td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password"  value=""></td>   
		      			<td></td>  			
		      		</tr> 
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName"  value=""></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="y">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="button" >회원가입</button>
				</div>
	      		
			</form>
			
		</div>
		
		
		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
	</div>

</body>

<script type="text/javascript">
	
	var dup;
	$("#btnIdCheck").on("click",function(){
		var id = $("#txtId").val();
		
		if(id==""){
			alert('아이디를 입력해주세요.');
			return false;
		}
		
		$.ajax({
			url: "${pageContext.request.contextPath}/user/dupCheck",
			type : "post",
			//contentType: "application/json",
			data : {id: id},
			dataType: "json",
			success : function(isDup){
				dup = isDup;
				if(isDup){
					$("#tdMsg").html('<span style="color:red">다른 아이디로 가입해주세요.</span>');
				}
				else{
					$("#tdMsg").html('사용할 수 있는 아이디입니다.');
					$("#txtId").attr("readonly",true);
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	$("#txtId").on("click",function(){
		$("#txtId").attr("readonly",false);
		dup = undefined;
		$("#tdMsg").html('');
	});
	
	$("#btnJoin").on("click",function(){
		
		if( $("#txtId").val() =="" ){
			alert("아이디를 입력해주세요");
		}
		else if( dup == true || dup == undefined ){
			alert("아이디 중복체크 해주세요");
		}
		else if( $("#txtPassword").val() == ""){
			alert("패스워드를 입력해주세요");
		}
		else if( $("#txtUserName").val() == ""){
			alert("이름을 입력해해주세요");
		}
		else if(! $("#chkAgree").is(":checked") ){
			alert("약관에 동의해주세요");
		}
		else{
			$("#joinForm").submit();
		}
	});
	
	$("#chkAgree").change(function(){
		if (this.checked) {
	       	open('https://www.naver.com/', 'agree-window', 'width=400, height=800');
	    }
	});
	
	
</script>

</html>