<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<%@ include file="/WEB-INF/views/include/top-header.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<%@ include file="/WEB-INF/views/include/slider.jsp" %>





<div style="font-size:  inherit;">
<form:form method="POST" action="${pageContext.servletContext.contextPath}/GetDetails">
<br/>
<span align="center"><input type="submit" value="Get Contact Details" style="width: 400px;font-face: 'Comic Sans MS'; font-size: larger; color: black; background-color: red; border: 3pt lightgrey" class="button"/></span>
 <br/>
</form:form>
	<br/>
<h3>Contacts Details</h3>
<c:if  test="${!empty contactList}">
<div style="width:600px;height:250px;overflow-y:scroll;">
<table class="data" border="1" style="background-color:white;">
<tr style="background-color:darkgreen;color:yellow;">
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Description</th>
    <th>Delete</th>
</tr>

<c:forEach items="${contactList}" var="contact">
    <tr>
        <td>${contact.name}</td>
        <td>${contact.email}</td>
        <td>${contact.telephone}</td>
        <td>${contact.description}</td>
        <td><a href="delete/${contact.id}"><U><Font color="red">delete</Font></U></a></td> 
    </tr>
</c:forEach>

</table>

</div>
</c:if>

</div>

<br/>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>