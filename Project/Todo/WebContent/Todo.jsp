<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<LINK href="css/mystyle.css"
  rel="stylesheet" type="text/css">
</head>
<body style="text-align:center;">
<h3>Todo list</h3>
<f:view>
  <h:messages layout="table" style="text-align:center;"></h:messages>

  <h:form>
    <h:commandLink binding="#{todoController.addCommand}" accesskey="n"
      action="#{todoController.addNew}" value="Add Item">
    </h:commandLink>
  </h:form>

  <h:form binding="#{todoController.form}" rendered="false">
    <h:panelGrid columns="2">
      <h:outputText value="Title"></h:outputText>
      <h:inputText value="#{todoController.todo.title}" required="true"
        requiredMessage="Title is required">
      </h:inputText>
      <h:outputText value="Notes"></h:outputText>
      <h:inputTextarea value="#{todoController.todo.description}" cols="40"
        rows="4"></h:inputTextarea>
      <h:outputText value="Priority"></h:outputText>
      <h:selectOneMenu validatorMessage="required"
        value="#{todoController.todo.priority}">
        <f:selectItems value="#{todoController.priorities}" />
      </h:selectOneMenu>
    </h:panelGrid>
    <h:panelGroup>
      <h:commandButton action="#{todoController.save}" value="Save"
        accesskey="s">
      </h:commandButton>
      <h:commandButton action="#{todoController.cancel}" value="Cancel"
        accesskey="c" immediate="true">
      </h:commandButton>
    </h:panelGroup>
  </h:form>
  <br />
  <h:form binding="#{todoController.tableForm}">
    <h:dataTable value="#{todoController.todos}" var="todo"
      width="80%" bgcolor="#CCFFFF" >
      <h:column>
        <%-- Via this facet we define the table header (column 1) --%>
        <f:facet name="header">
          <h:column>
            <h:outputText value="Prio"></h:outputText>
          </h:column>
        </f:facet>
        <h:outputText value="#{todo.priority}"></h:outputText>
      </h:column>
      <h:column>
        <%-- Via this facet we define the table header (column 2) --%>
        <f:facet name="header">
          <h:column>
            <h:outputText value="Title"></h:outputText>
          </h:column>
        </f:facet>
        <h:outputText value="#{todo.title}"></h:outputText>

      </h:column>

      <h:column>
        <%-- Via this facet we define the table header (column 3) --%>
        <f:facet name="header">
          <h:column>
            <h:outputText value="Notes"></h:outputText>
          </h:column>
        </f:facet>
        <h:outputText value="#{todo.description}"></h:outputText>
      </h:column>

      <h:column>
        <%-- Via this facet we define the table header (column 4) --%>
        <f:facet name="header">
          <h:column>
            <h:outputText value="Actions"></h:outputText>
          </h:column>
        </f:facet>
        <h:panelGrid columns="2">
          <h:commandLink value="delete" action="#{todoController.delete}">
            <f:setPropertyActionListener target="#{todoController.todo}"
              value="#{todo}" />
          </h:commandLink>
        </h:panelGrid>
      </h:column>
    </h:dataTable>

  </h:form>
    <h:form>
    <h:panelGrid columns="2">
      <h:commandLink id="hide"
        actionListener="#{todoController.displayTable}" value="Hide List" >
      </h:commandLink>
      <h:commandLink id="show"
        actionListener="#{todoController.displayTable}" value="Show List" style="text-align:center;">
      </h:commandLink>
    </h:panelGrid>
  </h:form>
</f:view>
</body>
</html> 