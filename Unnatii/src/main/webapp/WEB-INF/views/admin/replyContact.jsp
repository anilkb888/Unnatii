<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>

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



<span style="padding-top: 30px; width:50%;">


<form:form method="POST" action="${pageContext.servletContext.contextPath}/addContactReply" onsubmit="return validate();">
<fieldset class="grey_bg">
 <legend><h2>Feedback Details</h2></legend>
<table style= "border:10px;width:100%;"><tr>
  <td>
   <table>
   <tr>
        <td><form:label class="label-Font" path="id">ID</form:label></td>
        <td><form:input path="id" id="txtname" class="text-box"   readonly="true"/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="name">Name</form:label></td>
        <td><form:input path="name" id="txtname" class="text-box"   readonly="true"/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="email">Email</form:label></td>
        <td><form:input path="email" id="txtemail" class="text-box" readonly="true" /></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="telephone">Phone</form:label></td>
        <td><form:input path="telephone"  id="txttelephone" class="text-box" readonly="true"/></td>
    </tr>
     <tr>	
        <td><form:label class="label-Font" path="id">Description</form:label></td>
        <td><form:textarea path="description" id="txtdesc" readonly="true" class="text-box" style="height:75px;" /></td>
    </tr>
   
    <tr style="text-align: center;">
        
      

    </tr>
</table> 
</td>
<td>

</td>
</tr></table>
</fieldset>
<fieldset class="grey_bg">
 <legend><h2>Reply</h2></legend>
 <table>
    
    <tr>
        <td><form:label class="label-Font" path="email">To</form:label></td>
        <td><form:input path="email" id="txtemail2" class="text-box" readonly="true" /></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="email">Subject</form:label></td>
        <td><form:input path="replyContact.subject"  id="txtsubject" class="text-box" /></td>
    </tr>
     <tr>	
        <td><form:label class="label-Font" path="description">Description</form:label></td>
        <td><form:textarea path="replyContact.description" id="txtreplydescription"  class="text-box" style="height:75px;" /></td>
    </tr>
   
    <tr style="text-align: center;">
        
      <td colspan="2">
            <input type="submit" value="Send" class="button"/>
                    
      </td>

    </tr>
</table> 
 </fieldset>

</form:form>
</span >



<%@ include file="/WEB-INF/views/include/footer.jsp" %>