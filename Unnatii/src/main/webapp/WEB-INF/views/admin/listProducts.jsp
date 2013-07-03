<%@ include file="/WEB-INF/views/include/adminInclude.jsp" %>

<div class="box-content" style="height:300px;">

<h3 style="font-size: 20px;color: #333;padding: 2px 0;margin: 0 auto;">Product Details</h3>

<c:if  test="${!empty productList}">
<div style="width:100%;height:250px;">
<table id="box-table-a" style="background-color:white;">
<thead>
<tr>
	<th>ID</th>
    <th>Product Name</th>
    <th>Product Code</th>
    <th>Image</th>
    <th>Delete</th>
    
    
   <!--  <th>Delete</th> -->
</tr>
</thead>
<tbody>
<c:forEach items="${productList}" var="product">
    <tr>
    	
    	<td><a href="${pageContext.servletContext.contextPath}/admin/editProduct/${product.id}"><Font color="red">${product.id}</Font></a></td>
        <td>${product.name}</td>
        <td>${product.productCode}</td>
        <td><img src="${product.image}" width="100" Height="80"/></td>
        <td><a href="${pageContext.servletContext.contextPath}/admin/deleteProduct/${product.id}"><U><Font color="red">delete</Font></U></a></td>
       
    </tr>
</c:forEach>
</tbody>
</table>

</div>
</c:if>

</div>

<br/>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>