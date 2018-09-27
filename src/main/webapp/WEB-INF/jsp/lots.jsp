<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <title>Лоты</title>

</head>
<body style="margin-top: 20px">
<c:url var="addLot" value="/lots/add"/>
<div class="container-fluid">

    <a href="${addLot}"><button type="button" class="btn btn-default">Создать лот</button></a>
    <main>
        <h2>Акутальные лоты</h2>
        <table class="table table-striped table-bordered" style="text-align: center">
            <thead>
            <tr>
                <td></td>
                <td>№</td>
                <td>Название</td>
                <td>Категория</td>
                <td>Последняя ставка</td>
                <td>Дата начала торгов</td>
                <td>Дата окончания торгов</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lots}" var="lot">
                <c:url var="ticketUrl" value="/lot/${lot.id}"/>
                <tr>
                    <td><a href="${ticketUrl}" class="editUrl" style="display: block"><span
                            class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                    </a></td>
                    <td><c:out value="${lot.id}"/>
                    </td>
                    <td>
                        <c:out value="${lot.name}"/>
                    </td>
                    <td>
                        <c:out value="${lot.categoryId}"/>
                    </td>
                    <td>
                        <c:out value="${lot.bid}"/>
                    </td>
                    <td>
                        <fmt:formatDate
                                pattern="dd.MM.yyyy" value="${lot.startDate}"/>
                    </td>
                    <td><fmt:formatDate
                            pattern="dd.MM.yyyy" value="${lot.finishDate}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>
</body>
</html>
