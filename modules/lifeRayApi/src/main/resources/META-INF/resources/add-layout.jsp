<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addLayout" var="addLayoutRenderURL"/>

<%
    String my_array2= renderRequest.getRenderParameters().getValue("my_array2");
    JSONArray array = new JSONArray(my_array2);
    List<JSONObject> list = new ArrayList();
    for (int i = 0; i < array.length();list.add(array.getJSONObject(i++)));
%>

<h2>Add layout Form here !</h2>

<aui:form action="<%=addLayoutRenderURL %>" name="layoutForm" method="POST">

    <aui:input name="name" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>
    <aui:input name="title" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>
    <aui:input name="description" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>
    <aui:select name="type">
        <aui:validator name="required"/>
        <aui:validator name="string"/>
        <option value="url">Url</option>
        <option value="embedded">Embedded</option>
        <option value="portlet">Portlet</option>
    </aui:select>

    <aui:input name="typeSettings" >
        <aui:validator name="string"/>
    </aui:input>

    <aui:select name="parentSite">
        <aui:validator name="required"/>
        <aui:validator name="string"/>
        <option value="0">Default</option>

        <% for (JSONObject string : list) { %>
        <option value="<%= string.getString("id") %>"> <%= string.getString("name") %></option>
        <% } %>
    </aui:select>☺
    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>
