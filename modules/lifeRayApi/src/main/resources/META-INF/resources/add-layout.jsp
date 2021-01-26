<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addLayout" var="addLayoutRenderURL"/>


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
    <aui:input name="type" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>
    <aui:input name="typeSettings" >
        <aui:validator name="string"/>
    </aui:input>
    <aui:input name="parentSite" >
        <aui:validator name="string"/>
    </aui:input>

    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>
