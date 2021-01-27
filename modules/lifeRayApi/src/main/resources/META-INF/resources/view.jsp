<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ include file="/init.jsp" %>
<portlet:defineObjects />

<%
	String groups = (String) renderRequest.getAttribute("groups");
	List<String> responses = (List<String>) renderRequest.getAttribute("responses");

%>
	<!-- Position toasts -->
	<div class="toast-container position-absolute top-0 end-0 p-3" style="top: 0; right: 0;">


		<% for (String string : responses) { %>
		<div class="toast fade show"  role="alert" aria-live="assertive" aria-atomic="true">
			<div class="toast-header">
				<strong class="mr-auto"><i class="fa fa-globe"></i> Nueva aplicacion!</strong>
				<button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
			</div>
			<div class="toast-body">
				<%= string %>
			</div>
		</div>
		<% } %>


	</div>


<portlet:renderURL var="addLayoutRenderURL">
	<portlet:param name="mvcPath" value="/add-layout.jsp"/>
	<portlet:param name="groups" value="${groups}"/>

</portlet:renderURL>
<portlet:renderURL var="addGroupRenderURL">
	<portlet:param name="mvcPath" value="/add-group.jsp"/>
	<portlet:param name="groups" value="${groups}"/>

</portlet:renderURL>

<div class="mb-5">
	<a href="<%= addLayoutRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add Layout
	</a>
</div>
<div class="mb-5">
	<a href="<%= addGroupRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add Group
	</a>

</div>

<script>
	$(document).ready(function(){
		$(".toast").toast();
	});
</script>
