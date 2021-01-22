<%@ include file="/init.jsp" %>
<portlet:defineObjects />

<%  String appList = (String) request.getAttribute("layouts"); %>

<portlet:renderURL var="addLayoutRenderURL">
	<portlet:param name="mvcPath" value="/add-layout.jsp"/>
</portlet:renderURL>

<div class="mb-5">
	<a href="<%= addLayoutRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add Layout
	</a>
</div>


<div class="container">
	<div class="card-deck">
		<div class="card">
			<img class="card-img-top" src="https://picsum.photos/309/200?image=1050" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Data</h5>
				<p class="card-text">${appList}</p>
			</div>
		</div>
	</div>
</div>