<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!doctype html>
<html lang="en">
<head>

<meta charset="utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="./base.jsp"%>

</head>
<body>

	<div class="container mt-3">
		<div class="col-md-12">
			<h2 class="text-center mb-3">Welcome to Product App</h2>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Product Name</th>
						<th scope="col">Product Description</th>
						<th scope="col">Price</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<th scope="row">HQYP${product.getProductId()+3946}</th>
							<td>${product.getProductName()}</td>
							<td>${product.getProductDesc()}</td>
							<td class="font-weight-bold"> &#x20B9;${product.getProductPrice()}</td>
							<td>
							<a href="delete/${product.getProductId()}" style='margin-left : 8px;font-size:18px'><i class='fas fa-trash'></i></a>
							<a href="update/${product.getProductId()}" style='margin-left : 8px;font-size:18px '><i class='fas fa-pen'></i></a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<div class="container text-center">
				<a href="add-product" class="btn btn-outline-sucess ml-3">Add Product</a>
			</div>

		</div>
	</div>

</body>
</html>