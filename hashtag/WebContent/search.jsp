<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
SEARCH<title>Searchhashtag</title>
</head>
<%String s=(String)request.getAttribute("error");
%>
<form action="SearchHashtag" method="post">
<input type="text" name="search" >
<input type="submit" value="search">
<%if(s!=null){
out.println(s);
}
%>
</form>
<body>
<body style="background-color:#81F7BE;">
</body>
</html>