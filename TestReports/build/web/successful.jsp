<%@ page contentType="application/pdf" %> 
<%@ page trimDirectiveWhitespaces="true"%> 
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
 
<%
    Connection conn=null;
     try {
        //Connecting to the MySQL database
 
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/transactions_many?user=root&password=root");
 
        //Loading Jasper Report File from Local file system
 
        String jrxmlFile = session.getServletContext().getRealPath("/Success.jrxml");
        InputStream iS = new FileInputStream(new File(jrxmlFile));
 
        //Generating the report
 
        JasperReport jR = JasperCompileManager.compileReport(iS);
        JasperPrint jP = JasperFillManager.fillReport(jR, null, conn);
 
        //Exporting the report as a PDF
 
        JasperExportManager.exportReportToPdfStream(jP, response.getOutputStream());
 
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (JRException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    finally {
        if(conn!=null){
            conn.close();
        }
    }
%>