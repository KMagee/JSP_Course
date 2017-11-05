

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To Do List</title>
</head>
<body>

<!--Step 1: Create the form -->

<form action="todo-demo.jsp">

Add new item <input type="text" name="theItem"/>

			<input type="submit" name="submit"/>
</form>

<br/>

<!-- Step2: Add the new items to the to-do list -->

<%
List<String> items = (List<String>) session.getAttribute("myToDoList");


//creating the arraylist and adding it to the session object
if (items == null) {
	items = new ArrayList<String>();
	session.setAttribute("myToDoList", items);
}


//adding items to the arrayList items
String theItem = request.getParameter("theItem");
if ((theItem != null) && (!theItem.trim().equals("")))
{ items.add(theItem);
	}


%>


<!-- Display all to do items from session -->
<hr>

<b>To Do List Items:</b><br/>

<ol>
<%
for(String temp:items){
	out.println("<li>" + temp + "</li>");
}
%>
</ol>






</body>
</html>