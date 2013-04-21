<%@ include file="/WEB-INF/views/include/tag-lib.jsp" %>
<%@ include file="/WEB-INF/views/include/top-header.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<%@ include file="/WEB-INF/views/include/slider.jsp" %>





<div style="font-size:  inherit;">
<form:form method="POST" action="${pageContext.servletContext.contextPath}/admin/GetQts">
<br/>
<span align="center"><input type="submit" value="Get Quote Details" style="width: 400px;font-face: 'Comic Sans MS'; font-size: larger; color: black; background-color: red; border: 3pt lightgrey" class="button"/></span>
 <br/> 
</form:form>
	<br/> 
<h3>Quote Details</h3>
<c:if  test="${!empty specList}">
<div style="width:1070px;height:200px;overflow-y:scroll;">
<table class="data" border="1" style="background-color:white;">
<tr style="background-color:darkgreen;color:yellow;">
    <th>FirstName</th>
    <th>LastName</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Company</th>
    <th>Address</th>
    <th>City</th>
    <th>State</th>
    <th>Pincode</th>
    <th>Got Information From</th>
    <th>Product</th>
    <th>Quantity</th>
    <th>ExpectedBy</th>
    <th>Budget</th>
    <th>Request Description</th>
    <th>Delete</th>
</tr>
<c:forEach items="${specList}" var="spec">
    <tr>
        <td>${spec.firstname}</td>
        <td>${spec.lastname}</td>
        <td>${spec.email}</td>
        <td>${spec.phone}</td>
        <td>${spec.company}</td>
        <td>${spec.address}</td>
        <td>${spec.city}</td>
        <td>${spec.state}</td>
        <td>${spec.pincode}</td>
        <td>${spec.via}</td>
        <td>${spec.product}</td>
        <td>${spec.quantity}</td>
        <td>${spec.expectedby}</td>
        <td>${spec.budget}</td>
        <td>${spec.reqDesc}</td>
        <td><a href="deleteQuote/${spec.id}"><U><Font color="red">delete</Font></U></a></td> 
    </tr>
</c:forEach>
</table>
</div>
</c:if>
	
</div>

<br/>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>