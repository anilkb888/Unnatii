<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>




<body onload='document.f.j_username.focus();'>

<div class="box-content" style="height:300px; width: 300px;padding-left: 10%;">
	<h3 style="font-size: 20px;color: #333;padding: 2px 0;margin: 0 auto;">EXISTING USER? LOGIN</h3>
 
	<c:if test="${not empty error}">
		<div class="err">
			Invalid Details<br /> 
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
 
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<div class="err"></div>
			
				<label>User Name </label><br/>
				<input type='text' name='j_username' value=''>
				<div class="err"></div>
				
				<label>Password</label><br/>
				<input type='password' name='j_password' />
				<div class="err"></div>
				<div style="padding-left: 25px;">
				<input name="submit" type="submit" value="LOGIN"  class="btn" />
				</div>
	</form>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>