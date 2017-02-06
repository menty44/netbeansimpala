<%-- 
    Document   : welcome
    Created on : Nov 25, 2016, 12:16:21 PM
    Author     : fred
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
    <h3>Login successful!!!</h3>
    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4>
</body>
</html>-->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>TRDR Portal</title>

    <!-- Bootstrap core CSS -->

    <link href="cssdash/bootstrap.min.css" rel="stylesheet">

    <link href="fontsdash/css/font-awesome.min.css" rel="stylesheet">
    <link href="cssdash/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="cssdash/custom.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="cssdash/maps/jquery-jvectormap-2.0.1.css" />
    <link href="cssdash/icheck/flat/green.css" rel="stylesheet" />
    <link href="cssdash/floatexamples.css" rel="stylesheet" type="text/css" />

<!--    <script src="jsdash/jquery.min.js"></script>-->
<!--    <script src="jsdash/nprogress.js"></script>-->
<!--    <script>
        NProgress.start();
    </script>-->
    
     <link href="ratejquery/css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
                                    <link href="ratejquery/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
                                    <!-- Include jTable script file. -->
                                    <script src="ratejquery/js/jquery-1.9.1.js" type="text/javascript"></script>
                                    <script src="ratejquery/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
                                    <script src="ratejquery/js/jquery.jtable.js" type="text/javascript"></script>
                                    <script type="text/javascript">
                                        $(document).ready(function () {
                                            $('#PersonTableContainer').jtable({
                                                title: 'Table of Rates',
                                                actions: {
                                                    listAction: 'SiddhuCRUDController?action=list',
                                                    createAction:'SiddhuCRUDController?action=create',
                                                    updateAction: 'SiddhuCRUDController?action=update',
                                                    deleteAction: 'SiddhuCRUDController?action=delete'
                                                },
                                                fields: {
                                                    id: {
                                                     title:'Id',
                                                        key: true,
                                                        list: true,
                                                        create:true
                                                    },
                                                    ratename: {
                                                        title: 'Rate Name',
                                                        width: '50%',
                                                        edit:true
                                                    },
                                                    ratevalue: {
                                                        title: 'Rate Value',
                                                        width: '50%',
                                                        edit:true
                                                    }
                                                                   
                                                }
                                            });
                                            $('#PersonTableContainer').jtable('load');
                                        });
                                    </script>


</head>

<body class="nav-md">

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>TRDR </span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="imagesdash/img.jpg" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <h2> <%=session.getAttribute("name")%></h2>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <!-- <h3>General</h3> -->
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Dashboard <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="listcustomers.html">Home</a>
                                        </li>
                                        <!-- <li><a href="index2.html">Dashboard2</a>
                                        </li>
                                        <li><a href="index3.html">Dashboard3</a> -->
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-edit"></i> Payments <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="payments/payments.jsp">Make payments</a></li>
                                        <li><a href="history/history.jsp">Payment History</a></li>
                                        
                                    </ul>
                                </li>
                                
                                <li><a><i class="fa fa-edit"></i> Account Management <span class="fa fa-gears"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="payments/payments.jsp">Make payments</a></li>
                                        <li><a href="history/history.jsp">Payment History</a></li>
                                        
                                    </ul>
                                </li>

                            </ul>
                        </div>


                    </div>
                    <!-- /sidebar menu -->


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
                                    <img src="imagesdash/img.jpg" alt=""> <%=session.getAttribute("name")%>
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="javascript:;">  Profile</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            <span class="badge bg-red pull-right">50%</span>
                                            <span>Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Help</a>
                                    </li>
                                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                    </li>
                                </ul>
                            </li>

                            <li role="presentation" class="dropdown">
                                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="badge bg-green">6</span>
                                </a>
                                <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="imagesdash/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="imagesdash/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="imagesdash/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                        </a>
                              Gentallela Alela! |       </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="imagesdash/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="text-center">
                                            <a>
                                                <strong><a href="inbox.html">See All Alerts</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </nav>
                </div>

            </div>

            <div class="right_col" role="main">
                <div class="">

                    <div class="page-title">
                        <div class="title_left">
                            <!-- <h3>Form Elements</h3> -->
                        </div>

                    </div>


                    <div class="clearfix"></div>
                    <div class="row">

                    </div>

                    <div class="clearfix"></div>
                    <div class="row">

                    </div>

                    <!-- <div class="col-md-6 col-xs-12"> -->
                    <!-- <div class="col-md-12 col-sm-12 col-xs-12"> -->
                    <div class="col-md-12 col-sm-4 col-xs-12">

                        <div class="x_panel">
                            <div class="x_title">
                                <h2><small></small></h2>
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

                                <!-- start form for validation -->
                                <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

<!--                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Code <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-sm-12">
                                            <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>-->
                                    
<!--                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Name <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-sm-12">
                                            <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                        </div>-->

                                          
                                    
                                    <div style="width:100%;margin-right:0%;margin-left:0%;text-align:center;">
<h1>Rates Management</h1>

<div id="PersonTableContainer"></div>                    
                                    

                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                            <!-- <button type="submit" class="btn btn-primary">Cancel</button>
                                            <button type="submit" class="btn btn-success">Submit</button> -->
                                        </div>
                                    </div>

                                </form>

                                <!-- end form for validations -->

                            </div>
                        </div>


                    </div>


                    <div class="clearfix"></div>
                                      <div class="row">
                        <!-- <div class="col-md-6 col-xs-12"> -->
                        <!-- <div class="col-md-12 col-sm-12 col-xs-12"> -->
                        <div class="row">
                            <div class="col-md-6 col-xs-12">
                            


                        </div>

                        <div class="row">
                            <div class="col-md-6 col-xs-12">
                                
                            </div>



                          </br></p>
                            <div class="col-md-6 col-sm-12 col-xs-12">

                            </div>
                        </div>


                        <div class="clearfix"></div>
                                          <!-- <div class="row"> -->
                            <!-- <div class="col-md-6 col-xs-12"> -->



                            </div>



                      </br></p>
                        <div class="col-md-6 col-sm-12 col-xs-12">

                        </div>
                    </div>



                    <div class="col-md-12 col-sm-12 col-xs-12">

                    </div>



                <!-- /page content -->



            </div>

            <!-- /page content -->

        </div>

    </div>

    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>

    <script src="jsdash/bootstrap.min.js"></script>

    <!-- gauge js -->
<!--    <script type="text/javascript" src="jsdash/gauge/gauge.min.js"></script>
    <script type="text/javascript" src="jsdash/gauge/gauge_demo.js"></script>-->
    <!-- chart js -->
<!--    <script src="jsdash/chartjs/chart.min.js"></script>-->
    <!-- bootstrap progress js -->
    <script src="jsdash/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="jsdash/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="jsdash/icheck/icheck.min.js"></script>
    <!-- daterangepicker -->
    <script type="text/javascript" src="jsdash/moment.min.js"></script>
    <script type="text/javascript" src="jsdash/datepicker/daterangepicker.js"></script>

    <script src="jsdash/custom.js"></script>

    <!-- flot js -->
    <!--[if lte IE 8]><script type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
    <script type="text/javascript" src="jsdash/flot/jquery.flot.js"></script>
    <script type="text/javascript" src="jsdash/flot/jquery.flot.pie.js"></script>
    <script type="text/javascript" src="jsdash/flot/jquery.flot.orderBars.js"></script>
    <script type="text/javascript" src="jsdash/flot/jquery.flot.time.min.js"></script>
    <script type="text/javascript" src="jsdash/flot/date.js"></script>
    <script type="text/javascript" src="jsdash/flot/jquery.flot.spline.js"></script>
    <script type="text/javascript" src="jsdash/flot/jquery.flot.stack.js"></script>
    <script type="text/javascript" src="jsdash/flot/curvedLines.js"></script>
    <script type="text/javascript" src="jsdash/flot/jquery.flot.resize.js"></script>
    

    <!-- worldmap -->
    <script type="text/javascript" src="jsdash/maps/jquery-jvectormap-2.0.1.min.js"></script>
    <script type="text/javascript" src="jsdash/maps/gdp-data.js"></script>
    <script type="text/javascript" src="jsdash/maps/jquery-jvectormap-world-mill-en.js"></script>
    <script type="text/javascript" src="jsdash/maps/jquery-jvectormap-us-aea-en.js"></script>

    <!-- /dashbord linegraph -->
    
    <!-- /footer content -->
</body>

</html>

