<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url var="css" value="/res/css" />
<spring:url var="js" value="/res/js" />
<spring:url var="img" value="/res/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap readble theme CSS -->
<link href="${css}/bootstrap-readble-theme.css" rel="stylesheet">

<!-- Bootstrap DataTables theme CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@ include file="./shared/navigation.jsp"%>
		<!-- Page Content -->

		<div class="content">

			<c:if test="${clickHome == true}">
				<%@ include file="home.jsp"%>
			</c:if>

			<c:if test="${clickAbout ==true}">
				<%@ include file="about.jsp"%>
			</c:if>

			<c:if test="${clickContact ==true}">
				<%@ include file="contact.jsp"%>
			</c:if>

			<c:if test="${clickAllProducts == true}">
				<%@ include file="listProducts.jsp"%>
			</c:if>

			<c:if test="${clickCategoryProduct == true}">
				<%@ include file="listProducts.jsp"%>
			</c:if>
			
			<c:if test="${clickOnSingleProduct == true}">
				<%@ include file="singleProduct.jsp"%>
			</c:if>

		</div>
		<!-- Footer Section -->
		<%@ include file="./shared/footer.jsp"%>
	</div>

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

	<!-- DataTable plug-in -->
	<script src="${js}/jquery.dataTables.js"></script>
	
	<!-- DataTable bootstrap plug-in -->
	<script src="${js}/dataTables.bootstrap.js"></script>

	<!--  Custome JS-->
	<script src="${js}/myapp.js"></script>


</body>

</html>
