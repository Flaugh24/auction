<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <%--    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" />--%>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <title>Вход в систему</title>
</head>
<body>

<c:url var="login" value="/login"/>

<div class="container" style="margin-top: 100px">
    <div row>
        <div class="col-md-offset-4 col-md-4">

            <form:form modelAttribute="auth" method="post" action="${login}">
                <div>
                    <form:label class="sr-only" path="username">Имя пользователя</form:label>
                    <form:input name="username" path="username" type="text" class="form-control" placeholder="Имя пользователя"
                                autofocus="true" required="true"/>
                </div>

                <div class="form-group">
                    <form:label class="sr-only" path="password">Пароль</form:label>
                    <form:input name="password" path="password" type="password" class="form-control" placeholder="Пароль"
                           required="true"/>
                </div>
                <div class="form-group">
                    <form:button class="btn btn-primary" type="submit" style="width: 100px">Войти</form:button>
                </div>

            </form:form>
        </div>
    </div>
</div>
</body>
</html>
