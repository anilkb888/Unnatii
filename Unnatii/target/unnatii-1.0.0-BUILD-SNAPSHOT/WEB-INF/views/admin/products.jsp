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
<h2>Add Products</h2>

<form:form commandName="product" method="POST" action="${pageContext.servletContext.contextPath}/admin/addProducts"  enctype="multipart/form-data">
<table><tr>
  <td>
   <table>
    <tr>
        <td><form:label class="label-Font" path="name">Name<font color="red">*</font></form:label></td>
        <td><form:input path="name" id="txtname" class="text-box" placeholder="FirstName LastName"/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="productCode">Product Code<font color="red">*</font></form:label></td>
        <td><form:input path="productCode" id="txtemail" class="text-box" placeholder=""/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="productTag">Product TagLine<font color="red">*</font></form:label></td>
        <td><form:input path="productTag"  id="txttelephone" class="text-box" placeholder=""/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="fileData">Image<font color="red">*</font></form:label></td>
       <td><form:input type="file" path="fileData" class="text-box"/>
       </td>
           </tr>
    <tr>
        <td><form:label class="label-Font" path="status">Status</form:label></td>
        <td><form:checkbox id="chkStatus" path="status" value="true"/></td>
    </tr>
     <tr>
        <td><form:label class="label-Font" path="description">Description<font color="red">*</font></form:label></td>
        <td><form:textarea path="description" id="txtdesc" class="text-box" style="height:75px;" placeholder="My Needs And Enquiry "/></td>
    </tr>
   
    <tr style="text-align: center;">
        <td colspan="2">
            <input type="submit" value="Done" class="button"/>
            <input type="reset" value="Reset" class="button"/>
            
        </td>
      

    </tr>
</table> 
</td>
<td>

</td>
</tr></table>
</form:form>
</span >



<%@ include file="/WEB-INF/views/include/footer.jsp" %>