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
	<c:forEach items="${appList}" var="app">
		<div class="card">
			<img class="card-img-top" src="https://picsum.photos/309/200?image=1050" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">${app.getTitle()}</h5>
				<p class="card-text">${app.getDescription()}</p>
				<a href="${app.getUrl()}" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</c:forEach>
	</div>
</div>
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