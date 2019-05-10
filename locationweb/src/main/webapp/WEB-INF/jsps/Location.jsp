<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>

<form action="saveLoc" method="post">
<div >
<pre>

Id: <input type="text" name="id" /> 
Code: <input type="text" name="code" />
name: <input type="text" name="name" />  
Type: Urban <input type="radio" name="type" value="Urban" /> 
      Rural<input type="radio" name="type" value="Rural" /> 
<input type="Submit" value="save"/>

</pre>     

</div> 
</form>

${msg}
<a href="displayLocations">View All</a>
</body>
</html>