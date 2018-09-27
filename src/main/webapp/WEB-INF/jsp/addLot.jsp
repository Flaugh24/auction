<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <title>Создание лота</title>
</head>
<body style="margin-top: 30px">

<c:url value="/lots/add2" var="saveUrl"/>

<div class="col-md-offset-2 col-md-8">
    <form:form modelAttribute="lot" method="POST"  action="${saveUrl}">

        <div class="form-group">
            <form:label path="name">Название</form:label><br/>
            <form:input cssClass="form-control" path="name"/>
        </div>
        <div class="form-group">
            <form:label path="descr">Описание</form:label>
            <form:textarea path="descr" rows="5" maxlength="1024"
                           cssClass="form-control" cssStyle="max-width:100%"/>
        </div>
        <div class="form-group">
            <form:label path="categoryId">Категория</form:label>
            <form:select path="categoryId" cssClass="form-control" cssStyle="width: auto">
                <c:forEach items="${categories}" var="cat">
                    <form:option value="${cat.id}"><c:out value="${cat.name}"/></form:option>>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="bid">Цена</form:label><br/>
            <form:input cssClass="form-control" path="bid"/>
        </div>

        <div class="form-group">
            <button name="button" type="submit" class="btn btn-default">Создать
            </button>
        </div>

    </form:form>
</div>
</body>
</html>
