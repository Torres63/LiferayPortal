<%@ page import="crudapps.model.CrudApps" %>
<%@ page import="java.util.List" %>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<%  List<CrudApps> appList = (List<CrudApps>)request.getAttribute("appList"); %>
<portlet:renderURL var="addAppRenderURL">
	<portlet:param name="mvcPath" value="/add-app.jsp"/>
</portlet:renderURL>

<div class="mb-5">
	<a href="<%= addAppRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add App
	</a>
</div>
<c:forEach items="${appList}" var="app">
	<h1>
		Responsive Column Rows
	</h1>
	<ul>
		<li class="xs">1 column xs</li>
		<li class="sm">2 column sm</li>
		<li class="md">3 column md</li>
		<li class="lg">4 column lg</li>
		<li class="xl">5 column xl</li>
	</ul>


	<div class="container">
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
			<div class="col mb-4">
				<div class="card">
					<img src="https://dummyimage.com/600x400/000/fff.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${app.getTitle()}</h5>
						<p class="card-text">${app.getDescription()}</p>
						<a href="${app.getUrl()}" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->
</c:forEach>


<table class="table table-striped">
	<tr >
		<th>Title</th>
		<th>Description</th>
		<th>URL</th>
		<th colspan="2" style="width: 100px">Action</th>
	</tr>
	<c:forEach items="${appList}" var="app">

		<portlet:renderURL var="updateAppRenderURL">
			<portlet:param name="mvcPath" value="/update-app.jsp"/>
			<portlet:param name="title" value="${app.title}"/>
			<portlet:param name="description" value="${app.description}"/>
			<portlet:param name="url" value="${app.url}"/>
			<portlet:param name="appId" value="${app.appId}"/>

		</portlet:renderURL>

		<portlet:actionURL name="deleteApp" var="deleteAppActionURL">
			<portlet:param name="appId" value="${app.getAppId()}"/>
		</portlet:actionURL>

		<tr>
			<td>${app.getTitle()}</td>
			<td>${app.getDescription()}</td>
			<td>${app.getUrl()}</td>
			<td class="text-center" style="width: 50px">
				<a href="<%=updateAppRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
					<i class ="glyphicon glyphicon-edit"></i>
				</a>
			</td>
			<td class="text-center" style="width:50px">
				<a href="<%=deleteAppActionURL%>"
				   class="btn  btn-primary btn-default btn-sm px-2 py-1"
				   onclick="return confirm('Are you sure you want to delete this item?');">
					<i class ="glyphicon glyphicon-remove"></i>
				</a>
			</td>
		</tr>
	</c:forEach>
</table>