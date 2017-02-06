<%@ page import ="java.sql.*" %>
<%
    //int id = 6;
    String title = request.getParameter("title");    
    String fname = request.getParameter("fname");
    String mname = request.getParameter("mname");
    String lname = request.getParameter("lname");
    String countryofres = request.getParameter("countryofres");
    String postalcode = request.getParameter("postalcode");
    String address1 = request.getParameter("address1");
    String address2 = request.getParameter("address2");
    String city = request.getParameter("city");
    String govtidpass = request.getParameter("govtidpass");
    String phoneno = request.getParameter("phoneno");
    String dob = request.getParameter("dob");
    String nationality = request.getParameter("nationality");
    String morethanthreeyrs = request.getParameter("morethanthreeyrs");
    String convictedofcrime = request.getParameter("convictedofcrime");
    String relationship = request.getParameter("relationship");
    String estimatemonthlyvol = request.getParameter("estimatemonthlyvol");
    String tradehowoften = request.getParameter("tradehowoften");
    String purposeoftrade = request.getParameter("purposeoftrade");
    String sendmoneyto = request.getParameter("sendmoneyto");
    String recievepaymentfrom = request.getParameter("recievepaymentfrom");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    //String created_at = request.getParameter("created_at");
    String role = request.getParameter("role");
    
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trdr",
            "root", "");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into users(title, fname, mname, lname, countryofres, postalcode, address1, address2, city, govtidpass, phoneno, dob, nationality, morethanthreeyrs, convictedofcrime, relationship, estimatemonthlyvol, tradehowoften, purposeoftrade, sendmoneyto, recievepaymentfrom, password, email, created_at, role) "
            + "values ('" + title + "','"
            + fname + "','" 
            + mname + "','" 
            + lname + "','" 
            + countryofres + "','" 
            + postalcode + "','"
            + address1 + "','"
            + address2 + "','" 
            + city + "','" 
            + govtidpass + "','" 
            + phoneno + "','" 
            + dob + "','" 
            + nationality + "','" 
            + morethanthreeyrs + "','"
            + convictedofcrime + "','" 
            + relationship + "','" 
            + estimatemonthlyvol + "','"
            + tradehowoften + "','" 
            + purposeoftrade + "','" 
            + sendmoneyto + "','" 
            + recievepaymentfrom + "','" 
            + password + "','" 
            + email + "','" 
            //+ created_at + "','" 
            + role + "', CURDATE())");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("success.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("reg.jsp");
    }
%>