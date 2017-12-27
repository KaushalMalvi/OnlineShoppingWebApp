$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#pList').addClass('active');
		break;

	default:
		$('#home').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// code for jquery DataTable
	
	var $table = $('#productListTable');

	// execute below code only when we have this table
	if ($table.length) {
		// console.log('Inside table');

		var jsonUrl = '';
		if (window.categoryId == '') {

			jsonUrl = window.contextRoot + '/json/data/all/products';

		} else {

			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}

		$table.DataTable({

			lengthMenu : [ [ 3, 5, 10, -1 ],[ '3 Pro', '5 Pro', '10 Pro', 'ALL' ] ],
			pagelength : 5,	
			ajax: {
				
				url : jsonUrl,
				dataSrc : ''
			},
			
			columns: [
				
				{
					data :'name'	
				},
				
				{
					data :'brand'	
				},
				
				{
					data :'unitPrice',
					mRender: function(data, type, row){
						return '&#8377; '+ data
					}
				},
				
				{
					data :'quantity'	
				},
				
				{
					data : 'id',
					mRender : function(data, type, row){
						var str = '';
						str += '<a href="'+window.contextRoot+'/show/'+data+'/product">View</a>';
						str += '<a href="'+window.contextRoot+'/cart/add'+data+'/product">Add to Cart </a>';
						return str
					}
				}
			]
		});
	}

});