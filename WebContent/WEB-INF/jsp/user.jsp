<%@ include file="/WEB-INF/jsp/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>

<s:message code="user.create.title"/>

<form:form modelAttribute="user">
	<s:message code="user.create.login"/><form:input path="login" size="15" maxlength="60" /><form:errors path="login" />
	<br />
	<s:message code="user.create.password"/><form:input path="password" size="15" maxlength="60" /><form:errors path="password" />
	<br />
	<s:message code="user.create.name"/><form:input path="name" size="15" maxlength="100" /><form:errors path="name" />
	<br />
	<s:message code="user.create" var="createText"/>
	<input type="submit" value="${createText}" />
</form:form>