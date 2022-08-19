<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table" border=2>
  <thead>
  <h1>Product Display</h1>
    <tr>
    <th scope="col">Product ID</th>
      <th scope="col">Product Name</th>
      <th scope="col">Price</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      
      <td> <%=session.getAttribute("id")%></td>
      <td> <%=session.getAttribute("sname")%></td>
      <td> <%=session.getAttribute("price")%></td>
      
      
    </tr>
  </tbody>
</table>
</body>
</html>