<%@ page contentType="application/xls" %> 
<%@page import ="java.util.Map"%>
<%@ page trimDirectiveWhitespaces="true"%> 
<%@ page import ="java.io.*" %>
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="net.sf.jasperreports.engine.export.JRXlsExporter"%>
 <%@ page import="net.sf.jasperreports.engine.export.JRXlsExporterParameter"%>
<%
    Connection conn=null;
     try {
        //Connecting to the MySQL database
 
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/transactions_many?user=root&password=root");
 
        //Loading Jasper Report File from Local file system
 
        String jrxmlFile = session.getServletContext().getRealPath("/displayxls.jrxml");
        InputStream iS = new FileInputStream(new File(jrxmlFile));
 
        //Generating the report
 
        JasperReport jR = JasperCompileManager.compileReport(iS);
        JasperPrint jP = JasperFillManager.fillReport(jR, null, conn);
 
        //Exporting the report as a PDF
        
       //JasperExportManager.exportReportToPdfStream(jP, response.getOutputStream());
        OutputStream os =  response.getOutputStream();
        
        JRXlsExporter  exporter = new  JRXlsExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jP);
        exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,  os);  
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        exporter.exportReport();
            
    
     
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