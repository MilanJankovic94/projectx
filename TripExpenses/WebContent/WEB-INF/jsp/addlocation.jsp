<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add location</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/docreatelocation" method="post">
	<table class="formtable">
		<tr>
			<td class="label">Id: </td>
			<td class="control"><input name="locId" type=text></td>
		</tr>
		<tr>
			<td class="label">Name: </td>
			<td class="control">
			<input  class="control" name="locName"  />
			</td>
			
			
		</tr>
		<tr>
			<td class="label">Country: </td>
			<td class="control">
			<input    name="locCountry"  />
			</td>
		</tr>
		<tr>
			<td class="label">Daily allowance: </td>
			<td class="control">
			<input name="locDailyAllowance"  />
			</td>
		</tr>
		<tr>
			<td class="label">Loc distance: </td>
			<td class="control">
			<input name="locDistance"  />
			</td>
		</tr>
		<tr>
			<td class="label"></td>
			<td class="control"><input type="submit" value="Create new location"></td>
		</tr>
		
	</table>
	<!-- <input name="${_csrf.paramaterName }" type="hidden" value="${_csrf.token}}" /> -->
	
</form>
</body>
</html>