<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONArray" %>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addGroup" var="addGroupRenderURL"/>

<%
    String groups= renderRequest.getRenderParameters().getValue("groups");
    JSONArray array = new JSONArray(groups);
    List<JSONObject> list = new ArrayList();
    for (int i = 0; i < array.length();list.add(array.getJSONObject(i++)));
%>

<h2>Add Group Form here !</h2>

<aui:form action="<%=addGroupRenderURL %>" name="groupForm" method="POST">


    <aui:input name="name" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>
    <aui:input name="description" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>

    <aui:select name="parentGroup">
        <aui:validator name="required"/>
        <aui:validator name="string"/>
        <option value="0">Default</option>

        <% for (JSONObject string : list) { %>
        <option value="<%= string.getString("id") %>"> <%= string.getString("name") %></option>
        <% } %>
    </aui:select>
    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>
