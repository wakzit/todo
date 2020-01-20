<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/nav-bar.jsp"/>
<div class="container-fluid">
    <div class="row mt-4">
        <div class="col-12">
            <h3 class="bg-primary text-white p-2">Todo Items</h3>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col"><label>#</label></th>
            <th scope="col"><label>Title</label></th>
            <th scope="col"><label>Completed</label></th>
            <th scope="col"><label>Action</label></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="todo" items="${todos}">
        <tr>
            <th scope="row">${todo.id}</th>
            <td>
                    ${todo.title}
            </td>
            <td>
                    ${todo.completed}
            </td>
            <td>
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/todo/edit/${todo.id}">Edit</a>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/todo/complete/${todo.id}">Complete</a>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/todo/delete/${todo.id}">Delete</a>
                </div>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
