<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addGroup" var="addGroupRenderURL"/>

<%
//    List<String> appList = Collections.singletonList(renderRequest.getRenderParameters().getValue("my_array"));
    String my_array= renderRequest.getRenderParameters().getValue("my_array");
    String my_array2= renderRequest.getRenderParameters().getValue("my_array2");

    my_array = my_array.replace("[", "").replace("]", "");
    String[] split = my_array.split(",");
    List<String> list = Arrays.asList(split);

    my_array2 = my_array2.replace("[", "").replace("]", "");
    String[] split2 = my_array2.split(",");
    List<String> list2 = Arrays.asList(split2);

    ArrayList<String[]> outerArr = new ArrayList<String[]>();

    for (String string : list2) {
             String[] split3 =string.split(";");
             String[] myString1= {split3[0],split[1]};
                outerArr.add(myString1);

         }
   
    for (String[] arr2 : outerArr) {
        System.out.println("result XD=" +Arrays.toString(arr2));

    }
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

<%--    <aui:select name="parentGroup">--%>
<%--        <aui:validator name="required"/>--%>
<%--        <aui:validator name="string"/>--%>
<%--        <% for (String string : list) { %>--%>
<%--        <option value="<%= string %>"> <%= string %></option>--%>
<%--        <% } %>--%>
<%--    </aui:select>--%>
<%--    <aui:select name="parentGroup">--%>
<%--        <aui:validator name="required"/>--%>
<%--        <aui:validator name="string"/>--%>
<%--        <% for (String string : list2) { %>--%>
<%--        <option value="<%= string[0] %>"> <%= string %></option>--%>
<%--        <% } %>--%>
<%--    </aui:select>--%>


    <aui:select name="parentGroup">
        <aui:validator name="required"/>
        <aui:validator name="string"/>
        <% for (String[] string : outerArr) { %>
        <option value="<%= string[1] %>"> <%= string[0] %></option>
        <% } %>
    </aui:select>

    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>
