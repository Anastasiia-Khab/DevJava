<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form action="/admin/country" method="post" modelAttribute="country">
		<form:input path="id" type="hidden"/>
		<table>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Country name</th>
		</tr>
		<c:forEach items="${countries.content}" var="country">
			<tr>
				<td>${country.name}</td>
				<td>
					<a href="/admin/country/delete/${country.id}">delete</a>
				</td>
				<td>
					<a href="/admin/country/update/${country.id}">update</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<c:if test="${countries.number ne 0}">
					<a href="/admin/country?page=${countries.number}&size=${countries.size}">previous</a>
				</c:if>
			</td>
			<td>
				<c:if test="${countries.number ne countries.totalPages-1}">
					<a href="/admin/country?page=${countries.number+2}&size=${countries.size}">next</a>
				</c:if>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/admin/country?page=1&size=1">1</a></td>
			<td><a href="/admin/country?page=1&size=5">5</a></td>
			<td><a href="/admin/country?page=1&size=10">10</a></td>
			<td><a href="/admin/country?page=1&size=20">20</a></td>
		</tr>
	</table>
</body>
</html>