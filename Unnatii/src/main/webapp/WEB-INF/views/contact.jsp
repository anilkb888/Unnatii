<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<%@ include file="/WEB-INF/views/include/top-header.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!-- <%@ include file="/WEB-INF/views/include/slider.jsp" %> -->

<div id="slider">
	<a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/Banners/02-Rocket concept.jpg"
		width="1081px" style="border-radius: 10px;" /></a>
</div>


<div style="padding-top: 30px;">
<h2>Contact Us</h2>
<form:form method="POST" action="${pageContext.servletContext.contextPath}/addContact">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" class="text-box"/></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" class="text-box"/></td>
    </tr>
    <tr>
        <td><form:label path="telephone">Phone</form:label></td>
        <td><form:input path="telephone" class="text-box" /></td>
    </tr>
     <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:textarea path="description" class="text-box" style="height:75px;"/></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="button"/>
        </td>
    </tr>
</table>  
</form:form>
</div >

<%@ include file="/WEB-INF/views/include/footer.jsp" %>