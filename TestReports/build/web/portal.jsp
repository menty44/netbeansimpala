<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Reports in different formats</title>
</head>

<body>
<script type="text/javascript">
function myFunction() {
   var x = document.getElementById("formats").value;
 document.getElementById("it").innerHTML = x;
 }
</script>
<h2>Please select the format of the report to download</h2>
  
<!--<select id="formats" name="opts">  -->
 <form action="formats" method="post">
  <select name="opts">
  <option value="pdf">PDF</option>
  <option value="xls">XLS</option>
  <option value="csv">CSV</option>
  </select> 
  <input type="submit" value="VIEW" />
  </form>
<br>

<br>
<button type="button" onclick="myFunction()">View</button>
 <p id="it"></p>

</body>
</html>