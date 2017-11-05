<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>

<h3>Training Portal</h3>

<!-- READ THE FAVORITE PROGRAMMING LANGUAGE COOKIE -->

<%

//the default...if there are no cookies
String favLang = "Java";

//get the cookies from the browser
Cookie[] theCookies = request.getCookies();


//find our fav lang cookies

if(theCookies != null){
	
	for(Cookie tempCookie : theCookies){
		
		if("myApp.favoriteLanguage".equals(tempCookie.getName())){
			favLang=tempCookie.getValue();
			break;
			
			
		}
		
	}
	
}











%>

<!-- SHOW NEW BOOKS FOR LANGUAGE x -->

<h4>New Books for <%= favLang %> </h4>

<ul>

<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>Latest News Reports for <%= favLang %> </h4>

<ul>

<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>Jobs for <%= favLang %> </h4>

<ul>

<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>



<hr>
<a href="cookies-personalize-form.html">Personalize this page</a>




</body>
</html>