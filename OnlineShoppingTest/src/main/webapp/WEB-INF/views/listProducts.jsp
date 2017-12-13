<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">

	<div class="row">

		<!-- display sidebar of All products-->
		<div class="col-md-3">
			<%@ include file="./shared/shopitems.jsp"%>
		</div>
		<!--  display product-->
		<div class="col-md-9">

			<!-- add breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
				
					<c:if test="${clickAllProducts == true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
					</ol>
					</c:if>
					
					<c:if test="${clickCategoryProduct == true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
					</c:if>
				</div>

			</div>

		</div>

	</div>
</div>