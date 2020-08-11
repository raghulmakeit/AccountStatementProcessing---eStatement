<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Details</title>
</head>
<body>
	<br><br><br><br><br><br>
<table width="700px" align="center"
style="border:1px solid #000000;">
<tr>
<td colspan=8 align="center"
style="background-color:ffeeff">
<b>Transaction</b></td>
</tr>
<tr style="background-color:efefef;">
<td><b>TxnRefNumber</b></td>
<td><b> AccountNumber</b></td>
<td><b>DateTime</b></td>
<td><b>Description</b></td>
<td><b>Withdrawals</b></td>
<td><b>Credit</b></td>
<td><b>RunningBalance</b></td>

</tr>
<%
int count=0;
String color = "#F9EBB3";


if(request.getAttribute("AccountNumber")!=null)
{
ArrayList al = (ArrayList)request.getAttribute("AccountNumber");
Iterator itr = al.iterator();


while(itr.hasNext()){

if((count%2)==0){
color = "#eeffee";
}
else{
color = "#F9EBB3";
}
count++;
ArrayList accList = (ArrayList)itr.next();
%>
<tr style="background-color:<%=color%>;">
<td><%=accList.get(0)%></td>
<td><%=accList.get(1)%></td>
<td><%=accList.get(2)%></td>
<td><%=accList.get(3)%></td>
<td><%=accList.get(4)%></td>
<td><%=accList.get(5)%></td>
<td><%=accList.get(6)%></td>

</tr>
<%
}
}
%>
<%
if(count==0){
%>
<tr>
<td colspan=8 align="center"
style="background-color:eeffee"><b>No Record</b></td>
</tr>
<%
}
%>
</table>
</body>
</html>