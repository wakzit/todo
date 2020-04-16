<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div style="background-color:#e83e8c;
background-attachment: scroll;">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${modeTitle} Todo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/validate.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/nav-bar.jsp"/>

<div class="container col-9">
    <form:form action="${pageContext.request.contextPath}/todo/${mode}" method="post" modelAttribute="todo">
        <form:hidden path="id"/>
        <div class="row bg-primary text-white mt-4">
            <div class="col-12 p-2">
                <h4>${modeTitle} Todo</h4>
            </div>
        </div>
        <div class="form-group offset-1 col-10">
            <form:label path="title">Title</form:label>
            <div class="row justify-content-start">
                <form:input class="form-control" path="title"></form:input>

            </div>
            <div class="row justify-content-end">
                <form:errors class="alert alert-danger " role="alert" path="title"></form:errors>
            </div>

        </div>
        <div class="form-group offset-1 col-10">
            <form:label path="description">Description</form:label>
            <div class="row justify-content-start">
                <form:textarea class="form-control" path="description" cols="60" rows="10"></form:textarea>
            </div>
            <div class="row justify-content-end">
                <form:errors class="alert alert-danger" role="alert" path="description"></form:errors>
            </div>
        </div>
        <div class="row offset-1 col-10">
            <input class="btn btn-primary" alert="Submitted" type="submit" onclick="javascript:alert('YOU HAVE SUBMITTED')" name="submit" value="Submit"  >

            <form:button class="btn btn-secondary" name="cancel">Cancel</form:button>


        </div>
        <form:select path="grading">
            <form:option value="" label="...." />
            <form:options items="${gradingList}"/>
        </form:select>
    </form:form>



</div>
</body>
</html>