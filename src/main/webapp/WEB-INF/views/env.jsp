<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Environment Variables</title>
</head>
<body>
	<p>
		<a href="${LINK}">TRY ME</a>
	</p>

	<br>

	<table border="1">
		<tr>
			<td bgcolor="#669999">CF Variables</td>
			<td bgcolor="#669999">CF Variables Value</td>
		</tr>
		<c:forEach items="${vcap_details}" var="entry">
			<tr>
				<td bgcolor="#D1E0E0">${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>

	<br>

	<table border="1">
		<tr>
			<td bgcolor="#669999">Remote Attr</td>
			<td bgcolor="#669999">Remote Attr Value</td>
		</tr>
		<c:forEach items="${remote_details}" var="entry">
			<tr>
				<td bgcolor="#D1E0E0">${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>

	<br>

	<table border="1">
		<tr>
			<td bgcolor="#669999">Server Attr Name</td>
			<td bgcolor="#669999">Server Attr Value</td>
		</tr>
		<c:forEach items="${server_details}" var="entry">
			<tr>
				<td bgcolor="#D1E0E0">${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>

	<br>

	<table border="1">
		<tr>
			<td bgcolor="#669999">Header Name</td>
			<td bgcolor="#669999">Header Value</td>
		</tr>
		<c:forEach items="${header_details}" var="entry">
			<tr>
				<td bgcolor="#D1E0E0">${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>

	<br>

	<table border="1">
		<tr>
			<td bgcolor="#669999">Attribute Name</td>
			<td bgcolor="#669999">Attribute Value</td>
		</tr>
		<c:forEach items="${attr_details}" var="entry">
			<tr>
				<td bgcolor="#D1E0E0">${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>