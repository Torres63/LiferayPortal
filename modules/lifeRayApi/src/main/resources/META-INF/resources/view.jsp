<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>
<portlet:defineObjects />


<%
	List<String> my_array = (List<String>)renderRequest.getAttribute("my_array");
	List<String> my_array2 = (List<String>)renderRequest.getAttribute("my_array2");

%>

<portlet:renderURL var="addLayoutRenderURL">
	<portlet:param name="mvcPath" value="/add-layout.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addGroupRenderURL">
	<portlet:param name="mvcPath" value="/add-group.jsp"/>
	<portlet:param name="my_array" value="${my_array}"/>
	<portlet:param name="my_array2" value="${my_array2}"/>

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

<div class="alert alert-success" role="alert">
	<c:out value="${response}"/>
</div>




<%--<aui:select name="title">--%>
<%--	<% for (String string : appList) { %>--%>
<%--	<option value=""> <%= string %></option>--%>
<%--	<% } %>--%>
<%--</aui:select>--%>
<%--<aui:select name="title2">--%>
<%--	<c:forEach items="${appList}" var="currOption">--%>
<%--		<option value=""> ${currOption}</option>--%>
<%--	</c:forEach>--%>

<%--</aui:select>--%>
