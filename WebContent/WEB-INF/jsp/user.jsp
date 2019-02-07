<%@ include file="/WEB-INF/jsp/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>

User creation

<form:form modelAttribute="user">
	login<form:input path="login" size="15" maxlength="60" /><form:errors path="login" />
	<br />
	password<form:input path="password" size="15" maxlength="60" /><form:errors path="password" />
	<br />
	name<form:input path="name" size="15" maxlength="100" /><form:errors path="name" />
	<br />
	<input type="submit" value="Create" />
</form:form>