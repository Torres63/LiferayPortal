<%@ page import="javax.portlet.RenderParameters" %>
<%@ include file="init.jsp"%>
<portlet:defineObjects/>

<portlet:actionURL name="updateApp" var="updateAppActionURL"/>

<aui:form action="<%=updateAppActionURL%>" name="appForm" method="POST"/>

<%
    String appId = renderRequest.getRenderParameters().getValue("appId");
    String title = renderRequest.getRenderParameters().getValue("title");
    String description = renderRequest.getRenderParameters().getValue("description");
    String url = renderRequest.getRenderParameters().getValue("url");
%>
<aui:form action="<%= updateAppActionURL %>" method="post" >
    <aui:input name="appId" type="hidden" value="<%=Long.parseLong(appId)%>"/>
    <aui:input name="title" type="  text" value="${app.title}"/>
    <aui:input name="description" type="text" value="${app.description}"/>
    <aui:input name="url" type="text" value="${app.url}"/>
    <aui:input type="submit" value="Update" name="update"></aui:input>
</aui:form>