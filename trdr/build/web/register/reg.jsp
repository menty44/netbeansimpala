<%-- 
    Document   : reg
    Created on : Nov 29, 2016, 1:03:24 PM
    Author     : fred
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form method="post" action="registration.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>middle Name</td>
                        <td><input type="text" name="mname" value="" /></td>
                    </tr>
                    <tr>
                        <td>last name</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>country of residence</td>
                        <td><input type="text" name="countryofres" value="" /></td>
                    </tr>
                    <tr>
                        <td>postal code</td>
                        <td><input type="text" name="postalcode" value="" /></td>
                    </tr>
                    <tr>
                        <td>address 1</td>
                        <td><input type="text" name="address1" value="" /></td>
                    </tr>
                    <tr>
                        <td>adress 2</td>
                        <td><input type="text" name="address2" value="" /></td>
                    </tr>
                    <tr>
                        <td>city </td>
                        <td><input type="text" name="city" value="" /></td>
                    </tr>
                    <tr>
                        <td>govt id pass</td>
                        <td><input type="text" name="govtidpass" value="" /></td>
                    </tr>
                    <tr>
                        <td>phone no </td>
                        <td><input type="text" name="phoneno" value="" /></td>
                    </tr>
                    <tr>
                        <td>nationality</td>
                        <td><input type="text" name="nationality" value="" /></td>
                    </tr>
                    <tr>
                        <td>more than three year</td>
                        <td><input type="text" name="morethanthreeyrs" value="" /></td>
                    </tr>
                    <tr>
                        <td>convicted of crime</td>
                        <td><input type="text" name="convictedofcrime" value="" /></td>
                    </tr>
                    <tr>
                        <td>relationship</td>
                        <td><input type="text" name="relationship" value="" /></td>
                    </tr>
                    <tr>
                        <td>estimate monthly vol</td>
                        <td><input type="text" name="estimatemonthlyvol" value="" /></td>
                    </tr>
                    <tr>
                        <td>trade how often </td>
                        <td><input type="text" name="tradehowoften" value="" /></td>
                    </tr>
                    <tr>
                        <td>purpose of trade</td>
                        <td><input type="text" name="purposeoftrade" value="" /></td>
                    </tr>
                    <tr>
                        <td>send money to</td>
                        <td><input type="text" name="sendmoneyto" value="" /></td>
                    </tr>
                    <tr>
                        <td>receive payment from</td>
                        <td><input type="text" name="receivepaymentfrom" value="" /></td>
                    </tr>
                    <tr>
                        <td>password</td>
                        <td><input type="text" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td>email </td>
                        <td><input type="text" name="email" value="" /></td>
                    
                    <tr>
                        <td>role</td>
                        <td><input type="text" name="role" value="" /></td>
                    </tr>
                    
                    
                    
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="signin.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
