<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%

String Mime =(String)request.getAttribute("Mime");
if (Mime == null)
{
	
	request.setCharacterEncoding("UTF-8");
}
else if (Mime.equals("EXCEL"))
{
	System.out.println("sadsad");
	response.setContentType("application/vnd.ms-excel; charset=UTF-8");
	response.setHeader("Content-Disposition","attachment;filename=Report.xls");

}%>
<title>Display</title>
</head>
<body>
 <%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

		if (session.getAttribute("username") == null)
			response.sendRedirect("ApplicationLogin.jsp");
	%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bank</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
       <li><form action="Display" ><button type="submit" class="btn btn-link navbar-btn navbar-link">Display</button></form></li>
      </li>
      <li class="nav-item">
       
        <a class="nav-link" href="#"  NAME ='btnClose' onClick = 'javascript:fnExcel();'>Export</a>
      </li>
    </ul>
     <li class="nav-item">
       <li><form action="Logout" ><button type="submit" class="btn btn-link navbar-btn navbar-link">Logout</button></form></li>
      </li>
  </div>
</nav>
<form method="post" action="Display1">
		<br><br><br><br><br><br>
		<table width="700px" align="center" style="border:1px solid #000000;">
		<tr>
		<td colspan=8 align="center" style="background-color:ffeeff">
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
ArrayList al =new ArrayList();
al=(ArrayList)request.getAttribute("table");
System.out.println(al); 
System.out.println( "hffggggff "); 
if(request.getAttribute("table")!=null)
	{
	
		ArrayList gl = (ArrayList)request.getAttribute("table");
		for (int i = 0; i < al.size(); i++) 
            System.out.println(al.get(i) + "hii "); 
		Iterator itr = al.iterator();
			while(itr.hasNext()){
					if((count%2)==0){
							color = "#eeffee";}
					else{
							color = "#F9EBB3";}
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
 </form>
 <a href="#"  NAME ='btnClose' onClick = 'javascript:fnExcel();'>exceltoreport</a>
 <script>


function fnExcel()
{
	url="./Display1?mimeType=EXCEL";	
	openExcelWindow(url);
}


var excelWin = new Array();
var excelWindowCount = -1; 
function closeExcelWindow() 
{ 
	var win_child =null;
	for( var i =0; i < excelWin.length ; i++)
	{
		win_child = excelWin[i];
		if(win_child != undefined && (!win_child.closed))
			win_child.close(); 
	}

}

function openExcelWindow(url)
{
	alert("dhhd");
	var x = screen.width - 25;
	var y = screen.height - 25;

	excelWin[++excelWindowCount]  =	open(url,'excel',"width=25,height=25,status=no,resizable=yes,scrollbars=no,top="+y+",left="+ x );
}
</script>
</body>
</html>