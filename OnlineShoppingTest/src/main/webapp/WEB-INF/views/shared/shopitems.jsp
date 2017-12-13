<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<p class="lead">Shop Name</p>

<div class="list-group">

	<c:forEach items="${categories}" var="cats">
      <a href="${contextRoot}/show/category/${cats.id}/products" class="list-group-item" id="a_${cats.name}">${cats.name}</a>
    </c:forEach>
</div>