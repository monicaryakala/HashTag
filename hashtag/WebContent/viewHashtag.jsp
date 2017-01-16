<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Map" %>
     <%@ page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>viewHashtag</title>
</head>
<body style="background-color:#81F7BE;">
<%String s=(String)request.getAttribute("title");
out.println(s);
Map map=(Map)request.getAttribute("map");
List id=(List)map.get("id");
List post=(List)map.get("post");
List reply=(List)map.get("reply");
Iterator id1 = id.iterator();
Iterator post1=post.iterator();
Iterator reply1=reply.iterator();

%> 
 
<form action="viewHashtag" method="post">
<textarea name="text" >
</textarea>
<input type="hidden" name="title" value="<%=s %>">
<input type="submit" name="button" value="post"><br><br>
</form>


<%while(id1.hasNext())
{
	
	out.println(post1.next());
	%></br>
	<%
	List rep = (List)reply1.next();
	Iterator a=rep.iterator();
	try{
	while(a.hasNext()){
		out.println(a.next()); %>
		 </br><br><br>
	<% }
	}catch(Exception e){
		
	}
	%>
	
	
	<form method="post" action="viewHashtag">
	<input type="text" name ="reply">
	<input type="hidden" name="id" value="<%=id1.next()%>">
	<input type="hidden" name="title" value="<%=s %>">
	<input type="submit" name="button" value="reply">
	</form>
<%  




} 
%>


</body>
</html> 