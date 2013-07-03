<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>

<span style="padding-top: 30px; width:50%;">
<h2>Add Template</h2>

<form:form commandName="template" method="POST" action="${pageContext.servletContext.contextPath}/admin/addTemplates"  enctype="multipart/form-data">
<table><tr>
  <td>
   <table>
    <tr>
        <td><form:label class="label-Font" path="name">Name<font color="red"></font></form:label></td>
        <td><form:input path="name" id="txtname" class="text-box" placeholder="Template Name"/></td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="productCode">Product<font color="red">*</font></form:label></td>
        <td>
        	<form:select path="productCode" id="productCode" class="select-box" >
        		<form:option value="0">Select Product</form:option>
        		<form:option value="1">Business Card</form:option>
        		<form:option value="2">ID Card</form:option>
        		<form:option value="3">Letter Head</form:option>
        		<form:option value="4">Envelops</form:option> 	
        	</form:select>      
        </td>
    </tr>
    <tr>
        <td><form:label class="label-Font" path="templateImage">Template Image<font color="red">*</font></form:label></td>
       <td><form:input type="file" path="templateImage" class="text-box"/>
       </td>
           </tr>
    <tr>
        <td><form:label class="label-Font" path="status">Status</form:label></td>
        <td><form:checkbox id="chkStatus" path="status" value="true"/> <form:label path="status" class="label-Font">Active</form:label></td>
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