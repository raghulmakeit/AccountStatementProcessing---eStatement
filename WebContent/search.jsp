<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<br><br><br><br><br><br>
<form method="post" name="frm" action="search">
<table border="0" width="300" align="center" bgcolor="#CDFFFF">
<tr><td colspan=2 style="font-size:12pt;color:#00000;" align="center">
<h3>Search Account Number</h3></td></tr>
<tr><td ><b>Account Number</b></td>
<td>: <input  type="text" name="AccountNumber" id="AccountNumber">
</td></tr>
<tr><td ><b>DateTime</b></td>
<td>: <input  type="text" name="dateTime" id="dateTime">
</td></tr>
<tr><td ><b>Description</b></td>
<td>: <input  type="text" name="Description" id="Description">
</td></tr>
<tr><td ><b>TxnRefNumber</b></td>
<td>: <input  type="text" name="TxnRefNumber" id="TxnRefNumber">
</td></tr>
<tr><td colspan=2 align="center">
<input  type="submit" name="submit" value="Search"></td></tr>
</table>
</form>
</body>
</html>