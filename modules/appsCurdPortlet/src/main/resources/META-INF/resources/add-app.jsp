<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addApp" var="appAppActionURL"/>


<h2>Add Student Form here !</h2>

<aui:form action="<%=appAppActionURL %>" name="appForm" method="POST">

    <aui:input name="title" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>
    <aui:input name="description" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>
    <aui:input name="url" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>

    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>
