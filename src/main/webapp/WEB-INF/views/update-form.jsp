<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

</head>
<body>
	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update Your Product Details</h1>

				<form action="${pageContext.request.contextPath}/update-product" method="post">
					<div class="form-group">
						<input type="hidden" name="productId" value="${product.getProductId()}">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" name="productName"
							placeholder="Enter Product Name Here" value="${product.getProductName()}">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea rows="5" class="form-control" id="description"
							name="productDesc" placeholder="Enter Product Description" >${product.getProductDesc()}</textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Price</label> <input type="text"
							class="form-control" name="productPrice"
							placeholder="Enter Product Price" value="${product.getProductPrice()}">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Update</button>
					</div>
				</form>
			</div>

		</div>


	</div>


</body>
</html>