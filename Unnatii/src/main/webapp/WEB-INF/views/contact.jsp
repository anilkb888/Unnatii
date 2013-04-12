<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<%@ include file="/WEB-INF/views/include/top-header.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!-- <%@ include file="/WEB-INF/views/include/slider.jsp" %> -->
<script type="text/javascript">
    function validate(){
	var varname=document.getElementById("txtname");
	var varemail=document.getElementById("txtemail");
	var vartelephone=document.getElementById("txttelephone");
	var vardesc=document.getElementById("txtdesc");
	
	if (varname.value==null || varname.value=="")
	   {
	   alert("Please provide Name");
	    return false;
	   }
	if (varemail.value==null || varemail.value=="")
	   {
	   alert("Please provide Email");
	    return false;
	   }
	if (vartelephone.value==null || vartelephone.value=="")
	   {
	   alert("Please provide Telephone No.");
	    return false;
	   }
	if (vardesc.value==null || vardesc.value=="")
	   {
	   alert("Please provide Description");
	    return false;
	   }
	
	
	   var atpos=varemail.value.indexOf("@");
			
	   var dotpos=varemail.value.lastIndexOf(".");
	 	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=varemail.value.length)
	   {
	   alert("Please enter a valid e-mail address");
	   return false;
	   }
	 	if (isNaN(vartelephone.value))
	 	{
	 		alert("Please enter a valid phone number");	
	 		 return false;
	 	}
	
}
</script>
<div id="slider">
	<a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/Banners/02-Rocket concept.jpg"
		width="1081px" style="border-radius: 10px;" /></a>
</div>


<div style="padding-top: 30px;">
<h2>Contact Us</h2>
<form:form method="POST" action="${pageContext.servletContext.contextPath}/addContact" onsubmit="return validate();">
   <table>
    <tr>
        <td><form:label class="label-Font" path="name">Name<font color="red">*</font></form:label></td>
        <td><form:input path="name" id="txtname" class="text-box" placeholder="FirstName LastName"/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="email">Email<font color="red">*</font></form:label></td>
        <td><form:input path="email" id="txtemail" class="text-box" placeholder="myemail@email.com"/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="telephone">Phone<font color="red">*</font></form:label></td>
        <td><form:input path="telephone"  id="txttelephone" class="text-box" placeholder="+91 991 612 0189"/></td>
    </tr>
     <tr>
        <td><form:label class="label-Font" path="description">Description<font color="red">*</font></form:label></td>
        <td><form:textarea path="description" id="txtdesc" class="text-box" style="height:75px;" placeholder="My Needs And Enquiry "/></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Done" class="button"/>
        </td>
    </tr>
</table>  
</form:form>
</div >

<%@ include file="/WEB-INF/views/include/footer.jsp" %>