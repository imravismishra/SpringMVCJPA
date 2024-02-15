<%@page import="java.util.Optional"%>
<%@page import="com.cogent.dao.FormDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,th,td {
	border: 1px solid black	
}

</style>
</head>
<body>
	<%
	    Optional<FormDao> dao	= Optional.ofNullable((FormDao)request.getAttribute("data2"));
	%>
	
	<form action="insert" method="post" enctype="multipart/form-data">
		<input type="text" value="<%=dao.isPresent()?dao.get().getFname():"" %>" name="fname" placeholder="Enter First Name"><br>
		<input type="text" value="<%=dao.isPresent()?dao.get().getMname():"" %>" name="mname" placeholder="Enter Middle Name"><br>
		<input type="text" value="<%=dao.isPresent()?dao.get().getLname():"" %>" name="lname" placeholder="Enter Last Name"><br>
		<input type="email" value="<%=dao.isPresent()?dao.get().getEmail():"" %>" name="email" placeholder="Enter Email Name"><br>
		<input type="password" value="<%=dao.isPresent()?dao.get().getPassword():"" %>" name="password" placeholder="Enter Password"><br>
		<input type="tel" value="<%=dao.isPresent()?dao.get().getMobile():"" %>" name="mobile" placeholder="Enter Mobile Name"><br>
		<input type="date" value="<%=dao.isPresent()?dao.get().getDob():"" %>" name="dob" ><br>
		Male <input type="radio" <%=dao.isPresent()?(dao.get().getGender().equals("Male")?"checked":""):"" %> name="gender" value="Male" > | Female <input type="radio" <%=dao.isPresent()?(dao.get().getGender().equals("Female")?"checked":""):"" %> name="gender" value="Female" ><br>
		English <input type="checkbox" <%=dao.isPresent()?(dao.get().getEnglish().equals("English")?"checked":""):"" %> name="english" value="English"><br>
		Hindi <input type="checkbox" <%=dao.isPresent()?(dao.get().getHindi().equals("Hindi")?"checked":""):"" %> name="hindi" value="Hindi"><br>
		None of Above <input type="checkbox" <%=dao.isPresent()?(dao.get().getNone().equals("None of Above")?"checked":""):"" %> name="none" value="None of Above"><br>
		Select Highest Educaton : <select  name="education">
			<optgroup label="Graduation">
				<option value="B.Tech" <%=dao.isPresent()?(dao.get().getEducation().equals("B.Tech")?"selected":""):"" %>>B.Tech</option>
				<option value="B.Pharma" <%=dao.isPresent()?(dao.get().getEducation().equals("B.Pharma")?"selected":""):"" %>>B.Pharma</option>
				<option value="B.A" <%=dao.isPresent()?(dao.get().getEducation().equals("B.A")?"selected":""):"" %>>B.A</option>
				<option value="B.C.A" <%=dao.isPresent()?(dao.get().getEducation().equals("B.C.A")?"selected":""):"" %>>B.C.A</option>
			</optgroup>
			<optgroup label="Diploma">
				<option value="Designing" <%=dao.isPresent()?(dao.get().getEducation().equals("Designing")?"selected":""):"" %>>Designing</option>
				<option value="Computer"  <%=dao.isPresent()?(dao.get().getEducation().equals("Computer")?"selected":""):"" %>>Computer</option>
			</optgroup>
		</select><br>
		Select Image : <input type="file" name="file"><br>
		<input type="submit">
	</form>
	
	<table>

	
	<% 
	List<FormDao> fe = (List<FormDao>)request.getAttribute("data1");
	for(int i=0;i<fe.size();i++){
	%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=fe.get(i).getFname() %></td>
			<td><%=fe.get(i).getMname() %></td>
			<td><%=fe.get(i).getLname() %></td>
			<td><%=fe.get(i).getEmail() %></td>
			<td><%=fe.get(i).getPassword() %></td>
			<td><%=fe.get(i).getDob() %></td>
			<td><%=fe.get(i).getGender() %></td>
			<td><%=fe.get(i).getEducation() %></td>
			<td><%=fe.get(i).getMobile() %></td>
			<td><%=fe.get(i).getEnglish() %></td>
			<td><%=fe.get(i).getHindi() %></td>
			<td><%=fe.get(i).getNone() %></td>
	
			<td><img src="//localhost:8080/SpringMVCJPA/resources/images/<%=fe.get(i).getImagefile() %>" width="100px"/></td>
			<td><a href="update/<%=fe.get(i).getEmail() %>">Update</a> | <a href="delete/<%=fe.get(i).getEmail() %>">Delete</a></td>
	
		<%--  <td><a href="update?id=<%=i+1%>">Update</a></td> --%>
		</tr>
	<%} %>
	</table>
</body>
</html>