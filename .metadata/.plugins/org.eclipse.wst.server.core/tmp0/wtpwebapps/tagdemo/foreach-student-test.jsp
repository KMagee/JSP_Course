<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import ="java.util.*,com.luv2code.jsp.tagdemo.Student" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
//THIS SCRIPLET IS JUST TO SET UP SOME SAMPLE DATA, NORMALLY DONE BY AN MVC SYSTEM
//USE TAGS INSTEAD OF SCRIPLETS IN JSP FILES

//array list of students
List<Student> data = new ArrayList<>();

data.add(new Student("John", "Doe", false));
data.add(new Student("Jane", "Johnson", true));
data.add(new Student("Ken", "Magee", false));

pageContext.setAttribute("myStudents", data);

%>

<body>

<table border ="1">

<tr>

<th>First Name</th>
<th>Last Name</th>
<th>Gold Customer</th>

</tr>


<c:forEach var="tempStudent" items="${myStudents}">


<!-- getters will be used in the background to get the first and last name -->

<tr>
<td>${tempStudent.firstName}</td>
<td>${tempStudent.lastName}</td>
<td>${tempStudent.goldCustomer}</td>

</tr>

</c:forEach>

</table>




</body>
</html>