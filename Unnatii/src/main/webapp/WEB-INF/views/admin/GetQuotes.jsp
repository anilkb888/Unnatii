<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>
<div style="font-size:  inherit;">

<h3>Quote Details</h3>
<c:if  test="${!empty specList}">
<div style="width:100%;overflow-y:auto;">
<table  id="box-table-a" >
<thead>
<tr >
    <th >Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Company</th>
    <th>Product</th>
</tr>
</thead>
<tbody>
<c:forEach items="${specList}" var="spec">
    <tr>
        <td>${spec.firstname} &nbsp; ${spec.lastname}</td>
		<td>${spec.email}</td>
        <td>${spec.phone}</td>
        <td>${spec.company}</td>
        <td>${spec.product}</td>

    </tr>
</c:forEach>
</tbody>
</table>
</div>
</c:if>
	
</div>

<br/>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>