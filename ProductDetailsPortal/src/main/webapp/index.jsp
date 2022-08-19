<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Product.jsp">
<h1>Insert Product</h1>
Enter Product ID<Input type="text" name="id" required><br/>
Enter Product Name<Input type="text" name="sname" required><br/>
Enter Product Price<Input type="text" name="price" required><br/>

<input type="submit" value="submit">

</form>
<%
   if (request.getParameter("error") != null)
         out.println("<b>Your session has expired or is invalid input.</b><br>");   
%>
</body>
</html>