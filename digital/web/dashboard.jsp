<!DOCTYPE html>
<%-- 
  Copyright (c) impalapay Ltd., June 23, 2014
  
  @author eugene chimita, eugenechimita@impalapay.com
--%>
<!--
<%@page import="com.impalapay.airtel.beans.accountmgmt.Account"%>
<%@page import="com.impalapay.airtel.beans.geolocation.Country"%>
<%@page import="com.impalapay.airtel.beans.forex.Forex"%>




<%@page import="com.impalapay.airtel.accountmgmt.session.SessionStatistics"%>
<%@page import="com.impalapay.airtel.accountmgmt.admin.SessionConstants"%>


<%@page import="com.impalapay.airtel.cache.CacheVariables"%>

<%@page import="org.apache.commons.lang3.StringUtils" %>

<%@page import="org.apache.commons.lang3.StringUtils" %>

<%@page import="net.sf.ehcache.Cache" %>
<%@page import="net.sf.ehcache.CacheManager" %>
<%@page import="net.sf.ehcache.Element" %>
<%@page import="java.text.SimpleDateFormat" %>

<%@page import="java.util.Calendar" %>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>

<%
    // The following is for session management.    
    if (session == null) {
        response.sendRedirect("index.jsp");
    }

    String sessionKey = (String) session.getAttribute(SessionConstants.ADMIN_SESSION_KEY);

    if (StringUtils.isEmpty(sessionKey)) {
        response.sendRedirect("index.jsp");
    }

    session.setMaxInactiveInterval(SessionConstants.SESSION_TIMEOUT);
    response.setHeader("Refresh", SessionConstants.SESSION_TIMEOUT + "; url=logout");
    // End of session management code



    CacheManager mgr = CacheManager.getInstance();
    Cache statisticsCache = mgr.getCache(CacheVariables.CACHE_ALL_ACCOUNTS_STATISTICS);
    Cache countryCache = mgr.getCache(CacheVariables.CACHE_COUNTRY_BY_UUID);
    Cache usdforexCache = mgr.getCache(CacheVariables.CACHE_USDFOREX_BY_UUID);
     Cache gbpforexCache = mgr.getCache(CacheVariables.CACHE_GBPFOREX_BY_UUID);



    SessionStatistics statistics = new SessionStatistics();

    Element element;

    if ((element = statisticsCache.get(CacheVariables.CACHE_ALL_ACCOUNTS_STATISTICS_KEY)) != null) {
        statistics = (SessionStatistics) element.getObjectValue();
    }

    // This HashMap contains the UUIDs of countries as keys and the country names as values
    HashMap<String, String> countryHash = new HashMap<String, String>();
    
     List<Forex> usdforex = new ArrayList<Forex>();

     List<Forex> gbpforex = new ArrayList<Forex>();

    int count = 0; // A generic counter

    List keys;
    Country country;

    keys = countryCache.getKeys();
    for (Object key : keys) {
        element = countryCache.get(key);
        country = (Country) element.getObjectValue();
        countryHash.put(country.getUuid(), country.getName());
    }

    keys = usdforexCache.getKeys();
    for (Object key : keys) {
         if ((element = usdforexCache.get(key)) != null) {
            usdforex.add((Forex) element.getObjectValue());
        }
    }

     keys = gbpforexCache.getKeys();
    for (Object key : keys) {
         if ((element = gbpforexCache.get(key)) != null) {
            gbpforex.add((Forex) element.getObjectValue());
        }
    }
    
   
    Calendar calendar = Calendar.getInstance();
    
    final int DAYS_IN_MONTH = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + 1;
    final int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
    final int MONTH = calendar.get(Calendar.MONTH) + 1;
    final int YEAR = calendar.get(Calendar.YEAR);
    final int YEAR_COUNT = YEAR + 10;
%>-->
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ImpalaPay | Dashboard</title>
    <link  rel="icon" type="image/png"  href="images/logo.jpg">

    <!-- Bootstrap core CSS -->

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="css/custom.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/maps/jquery-jvectormap-2.0.1.css" />
    <link href="css/icheck/flat/green.css" rel="stylesheet">
    <link href="css/floatexamples.css" rel="stylesheet" />

    <script src="js/jquery.min.js"></script>

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
                            <img src="images/img.png" alt="..." class="img-circle profile_img">
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
                                        <li><a href="dashboard.jsp">Dashboard</a>
                                        </li>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-users"></i>Personal<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accounts/accountsIndex.jsp">Profile</a>
                                        </li>
                                        	<li><a href="accounts/addManagementAccount.jsp">Change Password</a>
                                        </li>
                                         <li><a href="accounts/addroutedefine.jsp">Email Notification</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-users"></i>Accounts<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accounts/accountsIndex.jsp">Manage Currencies</a>
                                        </li>
                                        	<li><a href="accounts/addManagementAccount.jsp">Manage Accounts</a>
                                        </li>
                                         <li><a href="accounts/addroutedefine.jsp">System Accounts</a>
                                        </li>
                                        <li><a href="accounts/accountsIndex.jsp">Schedule Payments</a>
                                        </li>
                                        	<li><a href="accounts/addManagementAccount.jsp">System Payments</a>
                                        </li>
                                         <li><a href="accounts/addroutedefine.jsp">Member Payments</a>
                                        </li>
                                        </li>
                                         <li><a href="accounts/addroutedefine.jsp">Account Fees</a>
                                        </li>
                                        <li><a href="accounts/accountsIndex.jsp">Manage Loans</a>
                                        </li>
                                        	<li><a href="accounts/addManagementAccount.jsp">Loan Payments</a>
                                        </li>
                                 
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-users"></i>User/UserGroup<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accounts/accountsIndex.jsp">Manage Members</a>
                                        </li>
                                        	<li><a href="accounts/addManagementAccount.jsp">Bulk Action</a>
                                        </li>
                                         <li><a href="accounts/addroutedefine.jsp">Import Members</a>
                                        </li>
                                        <li><a href="accounts/accountsIndex.jsp">Manage Admins</a>
                                        </li>
                                        	<li><a href="accounts/addManagementAccount.jsp">Connected Users</a>
                                        </li>
                                         <li><a href="accounts/addroutedefine.jsp">Pending Members</a>
                                        </li>
                                        <li><a href="accounts/accountsIndex.jsp">Registration Agreements</a>
                                        </li>
                                        	<li><a href="accounts/addManagementAccount.jsp">Permission Groups</a>
                                        </li>
                                         <li><a href="accounts/addroutedefine.jsp">Loan Groups</a>
                                        </li>
                                        <li><a href="accounts/addroutedefine.jsp">Member Records Type</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-database"></i>Access Devices<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accounts/alltransaction.jsp">View All Transactions</a>
                                        </li>
                                         <li><a href="accounts/updatestatus.jsp">Adjust Transaction Status</a>
                                        </li>
                                    </ul>
                                </li>
                                <!--<li><a><i class="fa fa-money"></i>Manage Balance<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accounts/addFloat.jsp">Adjust Client Balance</a>
                                        <li><a href="accounts/floatHistory.jsp">Client Balance History</a>
                                    </ul>
                                </li>-->
								<li><a><i class="fa fa-wifi"></i>Messages<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                       <li><a href="accounts/addCountry.jsp">Add Country(MNO)</a></li>
                                        </li>
                                       <li><a href="accounts/addmnoprefix.jsp">Define Prefix(MNO)</a></li>
                                        </li>
                                         <li><a href="accounts/addNetwork.jsp">Add Networks</a></li>
                                        </li>
                                        <li><a href="accounts/addBank.jsp">Add Bank</a></li>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-exclamation-triangle"></i>Settings<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accounts/addSessionIp.jsp">Local Setting</a>
                                        </li>
                                         <li><a href="accounts/systemlog.jsp">Alert Setting</a>
                                        </li>
                                        <li><a href="accounts/addSessionIp.jsp">Mail Setting</a>
                                        </li>
                                         <li><a href="accounts/systemlog.jsp">Log Setting</a>
                                        </li>
                                        <li><a href="accounts/addSessionIp.jsp">Channels</a>
                                        </li>
                                         <li><a href="accounts/systemlog.jsp">WebServices Clients</a>
                                        </li>
                                        <li><a href="accounts/addSessionIp.jsp">System Tasks</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-exclamation-triangle"></i>Reports<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="accounts/addSessionIp.jsp">IP-WhiteList/Session-Url</a>
                                        </li>
                                         <li><a href="accounts/systemlog.jsp">SystemLog History</a>
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
                                    <img src="images/img.png" alt=""><%= sessionKey%>
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li>
                                        <form name="logoutForm" method="post" action="logout">
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
                    
                    <div class="clearfix"></div>

                    <div class="row">


                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Line graph<small>Sessions</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <canvas id="canvas000"></canvas>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Bar graph <small>Sessions</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <canvas id="canvas_bar"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Radar <small>Sessions</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <canvas id="canvas_radar"></canvas>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Donut Graph <small>Sessions</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <canvas id="canvas_doughnut"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Pie Graph Chart <small>Sessions</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <canvas id="canvas_pie"></canvas>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Pie Area Graph <small>Sessions</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <canvas id="canvas_area"></canvas>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

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

    </div>

    <script src="js/bootstrap.min.js"></script>

    <!-- chart js -->
    <script src="js/chartjs/chart.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="js/icheck/icheck.min.js"></script>

    <script src="js/custom.js"></script>
    <script>
        var randomScalingFactor = function () {
            return Math.round(Math.random() * 100)
        };



        var barChartData = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    fillColor: "#26B99A", //rgba(220,220,220,0.5)
                    strokeColor: "#26B99A", //rgba(220,220,220,0.8)
                    highlightFill: "#36CAAB", //rgba(220,220,220,0.75)
                    highlightStroke: "#36CAAB", //rgba(220,220,220,1)
                    data: [51, 30, 40, 28, 92, 50, 45]
            },
                {
                    fillColor: "#03586A", //rgba(151,187,205,0.5)
                    strokeColor: "#03586A", //rgba(151,187,205,0.8)
                    highlightFill: "#066477", //rgba(151,187,205,0.75)
                    highlightStroke: "#066477", //rgba(151,187,205,1)
                    data: [41, 56, 25, 48, 72, 34, 12]
            }
        ],
        }

        $(document).ready(function () {
            new Chart($("#canvas_bar").get(0).getContext("2d")).Bar(barChartData, {
                tooltipFillColor: "rgba(51, 51, 51, 0.55)",
                responsive: true,
                barDatasetSpacing: 6,
                barValueSpacing: 5
            });
        });


        var lineChartData = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(38, 185, 154, 0.31)", //rgba(220,220,220,0.2)
                    strokeColor: "rgba(38, 185, 154, 0.7)", //rgba(220,220,220,1)
                    pointColor: "rgba(38, 185, 154, 0.7)", //rgba(220,220,220,1)
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [31, 74, 6, 39, 20, 85, 7]
            },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(3, 88, 106, 0.3)", //rgba(151,187,205,0.2)
                    strokeColor: "rgba(3, 88, 106, 0.70)", //rgba(151,187,205,1)
                    pointColor: "rgba(3, 88, 106, 0.70)", //rgba(151,187,205,1)
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: [82, 23, 66, 9, 99, 4, 2]
            }
        ]

        }

        $(document).ready(function () {
            new Chart(document.getElementById("canvas000").getContext("2d")).Line(lineChartData, {
                responsive: true,
                tooltipFillColor: "rgba(51, 51, 51, 0.55)"
            });
        });

        var sharePiePolorDoughnutData = [
            {
                value: 120,
                color: "#455C73",
                highlight: "#34495E",
                label: "Dark Grey"
        },
            {
                value: 50,
                color: "#9B59B6",
                highlight: "#B370CF",
                label: "Purple Color"
        },
            {
                value: 150,
                color: "#BDC3C7",
                highlight: "#CFD4D8",
                label: "Gray Color"
        },
            {
                value: 180,
                color: "#26B99A",
                highlight: "#36CAAB",
                label: "Green Color"
        },
            {
                value: 100,
                color: "#3498DB",
                highlight: "#49A9EA",
                label: "Blue Color"
        }

    ];

        $(document).ready(function () {
            window.myPie = new Chart(document.getElementById("canvas_pie").getContext("2d")).Pie(sharePiePolorDoughnutData, {
                responsive: true,
                tooltipFillColor: "rgba(51, 51, 51, 0.55)"
            });
        });

        var radarChartData = {
            labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(3, 88, 106, 0.2)",
                    strokeColor: "rgba(3, 88, 106, 0.80)",
                    pointColor: "rgba(3, 88, 106, 0.80)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 90, 81, 56, 55, 40]
            },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(38, 185, 154, 0.2)",
                    strokeColor: "rgba(38, 185, 154, 0.85)",
                    pointColor: "rgba(38, 185, 154, 0.85)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]
        };

        $(document).ready(function () {
            window.myRadar = new Chart(document.getElementById("canvas_radar").getContext("2d")).Radar(radarChartData, {
                responsive: true,
                tooltipFillColor: "rgba(51, 51, 51, 0.55)"
            });
        });

        var polarData = [
            {
                value: 300,
                color: "#F7464A",
                highlight: "#FF5A5E",
                label: "Red"
        },
            {
                value: 50,
                color: "#46BFBD",
                highlight: "#5AD3D1",
                label: "Green"
        },
            {
                value: 100,
                color: "#FDB45C",
                highlight: "#FFC870",
                label: "Yellow"
        },
            {
                value: 40,
                color: "#949FB1",
                highlight: "#A8B3C5",
                label: "Grey"
        },
            {
                value: 120,
                color: "#4D5360",
                highlight: "#616774",
                label: "Dark Grey"
        }

    ];

        $(document).ready(function () {
            window.myPolarArea = new Chart(document.getElementById("canvas_area").getContext("2d")).PolarArea(sharePiePolorDoughnutData, {
                responsive: true,
                tooltipFillColor: "rgba(51, 51, 51, 0.55)"
            });
        });


        $(document).ready(function () {
            window.myDoughnut = new Chart(document.getElementById("canvas_doughnut").getContext("2d")).Doughnut(sharePiePolorDoughnutData, {
                responsive: true,
                tooltipFillColor: "rgba(51, 51, 51, 0.55)"
            });
        });
    </script>

</body>

</html>
