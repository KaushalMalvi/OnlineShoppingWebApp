<div class="container">

	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Product</a></li>
				<li class="active">${prod.name}</li>
				
			</ol>

		</div>

	</div>

	<div class="row">

		<!-- For image display -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">
				<img src="${images}/${prod.code}.jpg" class="img img-responsive"></img>
			</div>
		</div>

		<!-- for display product information -->
		<div class="col-xs-12 col-sm-8">

			<h3>${prod.name}</h3>
			<hr />
			<p>${prod.description}</p>
			<hr />
			<h4>
				Price : <strong>&#8377; ${prod.unitPrice} /-</strong>
			</h4>
			<hr />
			<h6>Que. Available : ${prod.quantity}</h6>
			<hr />	
			<a href="${contextRoot}/cart/add/${prod.id}/product" class="btn btn-success">
			 <span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a> 
			 
			 <a href="${contextRoot}/show/all/products" class="btn btn-primary"> Back </a>

		</div>

	</div>

</div>