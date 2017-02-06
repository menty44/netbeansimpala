<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%     String exportToExcel = request.getParameter("exportToExcel");
        if (exportToExcel != null && exportToExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename="
                    + "Transactions.xls");
         }%>
    <%
        if (exportToExcel == null) {
    %>
    <a href="DisplayDatabase.jsp?exportToExcel=YES">Export to Excel</a>
    <%
        }
    %>
<h1>All the transactions from the database </h1><br>

  <% 
       Connection conn;
        try {
            //Connecting to the MySQL database
     
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/transactions_many?user=root&password=root");
            Statement statement = conn.createStatement() ;
            
            ResultSet resultset =  statement.executeQuery("select transaction_id, network_id, amount, recepient_number,"
            		+"recepient_network,sender_number, sender_network, transaction_status from transactions"); 
            
         
        %>
        <div id="dvData">
        <TABLE BORDER="1">
            <TR>
                <TH>Trans_ID</TH>
                <TH>Network_ID</TH>
                <TH>Amount</TH>
                <TH>Recepient_Number</TH>
                <TH>Recepient_Network</TH>
                <TH>Sender_Number</TH>
                <TH>Sender_Network</TH>
                <TH>Transaction_Status</TH>
               </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(1) %></TD>
                <TD> <%= resultset.getString(2) %></TD>
                <TD> <%= resultset.getString(3) %></TD>
                <TD> <%= resultset.getString(4) %></TD>
                <TD> <%= resultset.getString(5) %></TD>
                <TD> <%= resultset.getString(6) %></TD>
                <TD> <%= resultset.getString(7) %></TD>
                <TD> <%= resultset.getString(8) %></TD>
            </TR>
            <% } 
        }catch(SQLException e){
    }%>
 </TABLE></div>
 
</body>
</html>