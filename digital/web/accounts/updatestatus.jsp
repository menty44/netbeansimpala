<!DOCTYPE html>
<%-- 
  Copyright (c) impalapay Ltd., June 23, 2014
  
  @author eugene chimita, eugenechimita@impalapay.com
--%>

    
    

<%@page import="com.impalapay.airtel.accountmgmt.session.SessionStatistics"%>
<%@ page import="com.impalapay.airtel.accountmgmt.admin.SessionConstants"%>  
<%@ page import="com.impalapay.airtel.beans.transaction.TransactionStatus"%> 

<%@ page import="com.impalapay.airtel.cache.CacheVariables"%>

<%@ page import="org.apache.commons.lang.StringUtils" %>

<%@ page import="net.sf.ehcache.Cache" %>
<%@ page import="net.sf.ehcache.CacheManager" %>
<%@ page import="net.sf.ehcache.Element" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Iterator"%>


<%
       // The following is for session management.    
    if (session == null) {
        response.sendRedirect("../index.jsp");
    }

    String sessionKey = (String) session.getAttribute(SessionConstants.ADMIN_SESSION_KEY);

    if (StringUtils.isEmpty(sessionKey)) {
        response.sendRedirect("../index.jsp");
    }

    session.setMaxInactiveInterval(SessionConstants.SESSION_TIMEOUT);
    response.setHeader("Refresh", SessionConstants.SESSION_TIMEOUT + "; url=../logout");
    //End of session management code
   
 
    CacheManager mgr = CacheManager.getInstance();
    Cache statisticsCache = mgr.getCache(CacheVariables.CACHE_ALL_ACCOUNTS_STATISTICS);
    Cache transactionstatusCache = mgr.getCache(CacheVariables.CACHE_TRANSACTIONSTATUS_BY_UUID);

   HashMap<String, String> transactionstatusHash = new HashMap<String, String>();

   List<TransactionStatus> transactionstatusList = new ArrayList<TransactionStatus>();

    TransactionStatus transactionsatus;
    Element element;
    List keys;

    keys = transactionstatusCache.getKeysWithExpiryCheck();
    for (Object key : keys) {
        if ((element = transactionstatusCache.get(key)) != null) {
            transactionstatusList.add((TransactionStatus) element.getObjectValue());
        }
    }
 

    SessionStatistics statistics = new SessionStatistics();

     if ((element = statisticsCache.get(CacheVariables.CACHE_ALL_ACCOUNTS_STATISTICS_KEY)) != null) {
        statistics = (SessionStatistics) element.getObjectValue();
    }

  

        
    
   

   

   
%>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ImpalaPay | Updatestatus</title>
    <link  rel="icon" type="image/png"  href="../images/logo.jpg">

    <!-- Bootstrap core CSS -->

    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <link href="../fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="../css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="../css/custom.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/maps/jquery-jvectormap-2.0.1.css" />
    <link href="../css/icheck/flat/green.css" rel="stylesheet">
    <link href="../css/floatexamples.css" rel="stylesheet" />

    <script src="../js/jquery.min.js"></script>

    <!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>


<body class="nav-md">

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">


                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="../images/img.png" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <h2><%=sessionKey%></h2>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                              <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-area-chart"></i> Home <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="../dashboard.jsp">Dashboard</a>
                                        </li>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-users"></i>Accounts<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accountsIndex.jsp">Add Account</a>
                                        </li>
                                        <li><a href="addManagementAccount.jsp">Add Management</a>
                                        </li>
                                         <li><a href="addroutedefine.jsp">Account->Network</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-database"></i> Transactions <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="alltransaction.jsp">View All Transactions</a>
                                        </li>
                                         <li><a href="updatestatus.jsp">Adjust Transaction Status</a>
                                        </li>
                                    </ul>
                                </li>
                                <!--<li><a><i class="fa fa-money"></i>Manage Balance<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="addFloat.jsp">Adjust Client Balance</a>
					<li><a href="floatHistory.jsp">Client Balance History</a>
                                    </ul>
                                </li>-->
								<li><a><i class="fa fa-wifi"></i>Manage Networks<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                       <li><a href="addCountry.jsp">Add Country(MNO)</a></li>
                                        </li>
                                       <li><a href="addmnoprefix.jsp">Define Prefix(MNO)</a></li>
                                        </li>
                                         <li><a href="addNetwork.jsp">Add Networks</a></li>
                                        </li>
										<li><a href="addBank.jsp">Add Bank</a></li>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-exclamation-triangle"></i>Manage Security<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="addSessionIp.jsp">IP-WhiteList/Session-Url</a>
                                        </li>
                                         <li><a href="systemlog.jsp">SystemLog History</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                   <!-- <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>-->
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <div class="top_nav">

                <div class="nav_menu">
                    <nav class="" role="navigation">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                            <li class="">
                                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <img src="../images/img.png" alt=""><%= sessionKey%>
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li>
                                        <form name="logoutForm" method="post" action="../logout">
                                            <p>
                                            <!--<input type="submit" class="btn btn-primary" name="logout" id="logout" value="Logout">-->
                                            <button type="submit" class="btn btn-primary"><i class="fa fa-sign-out pull-right"></i> Log Out</button>
                                           
                                            </p>
                                        </form>
                                     
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>

            </div>
            <!-- /top navigation -->


            <!-- page content -->
            <div class="right_col" role="main">

                                    <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Update Status</h3>
                         </div>  
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_content">Update

                                    <div class="row">
                    <div class="box-content">
                        <%
                    String addErrStr = (String) session.getAttribute(SessionConstants.ADMIN_UPDATE_TRANSACTIONSTATUS_ERROR_KEY);
                    String addSuccessStr = (String) session.getAttribute(SessionConstants.ADMIN_UPDATE_TRANSACTIONSTATUS_SUCCESS_KEY);
                    HashMap<String, String> paramHash = (HashMap<String, String>) session.getAttribute(
                            SessionConstants.ADMIN_UPDATE_TRANSACTIONSTATUS_PARAMETERS);

                    if (paramHash == null) {
                        paramHash = new HashMap<String, String>();
                    }

                    if (StringUtils.isNotEmpty(addErrStr)) {
                        out.println("<p class=\"alert alert-error\">");
                        out.println("Form error: " + addErrStr);
                        out.println("</p>");
                        session.setAttribute(SessionConstants.ADMIN_UPDATE_TRANSACTIONSTATUS_ERROR_KEY, null);
                    }

                    if (StringUtils.isNotEmpty(addSuccessStr)) {
                        out.println("<p class=\"alert alert-success\">");
                        out.println(addSuccessStr);
                        out.println("</p>");
                        session.setAttribute(SessionConstants.ADMIN_UPDATE_TRANSACTIONSTATUS_SUCCESS_KEY, null);
                    }
                %>
                        
                       
                        <form  class="form-horizontal form-label-left" action="updateTransaction" method="post">
                       
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Transaction Uuid
                                </label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                  <input id="input" name="transactionUuid" class="form-control col-md-7 col-xs-12" type="text"  autocomplete="false" <%
                                        out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("loginPasswd")) + "\"");  
                                         %> >
                                </div>
                             </div>
                             <input type="hidden"  name="username"  					<%
                                           out.println("value=\"" + StringUtils.trimToEmpty(sessionKey) + "\"");
                                    %>>  
               
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Transaction Status
                                </label>
                                <div class="col-md-7 col-sm-7 col-xs-12">
                                   <select name="transactionstatusUuid" id="input" class="form-control col-md-3 col-xs-12">
                                            <%
                                                for (TransactionStatus a : transactionstatusList) {
                                                    if (StringUtils.equalsIgnoreCase(a.getDescription(), "REVERSAL_INPROGRESS")) {
                                                        out.println("<option selected=\"selected\" value=\"" + a.getUuid() + "\">" + a.getDescription() + "</option>");
                                                    } else {
                                                        out.println("<option value=\"" + a.getUuid() + "\">" + a.getDescription() + "</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                </div>
                             </div>
                        
                                    
                   
                      
                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary" name="action">
                                <i class="icon-ok"></i>
                                Submit
                            </button>
                        </div>
                    </form>
                </div>

                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="clearfix"></div>

            
                <!-- footer content -->
                <footer>
                    <div class="">
                        <p>Copyright@ImpalaPay 2014-2015</p>
                            <a href="#">Terms &amp; Conditions</a> | <a href="#">Privacy
                            Policy</a> | ImpalaPay Ltd <%= Calendar.getInstance().get(Calendar.YEAR)%>. All rights reserved.
                            <!--<img id="madeInKenya" alt="Made in Kenya" src="#" width="100" height="100" />-->
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>

                <!-- /footer content -->

            </div>
            <!-- /page content -->
        </div>

    </div>

    <script src="../js/bootstrap.min.js"></script>

    <!-- chart js -->
    <script src="../js/chartjs/chart.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="../js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="../js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="../js/icheck/icheck.min.js"></script>

    <script src="../js/custom.js"></script>

</body>

</html>
