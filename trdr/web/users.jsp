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

    <script src="jsdash/jquery.min.js"></script>
    <script src="jsdash/nprogress.js"></script>
    <script>
        NProgress.start();
    </script>
    
     <link href="ratejquery/css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
                                    <link href="ratejquery/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
                                    <!-- Include jTable script file. -->
                                    <script src="ratejquery/js/jquery-3.0.0.js" type="text/javascript"></script>
                                    <script src="ratejquery/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
                                    <script src="ratejquery/js/jquery.jtable.js" type="text/javascript"></script>
                                    <script type="text/javascript">
                                        $(document).ready(function () {
                                            $('#PersonTableContainer').jtable({
                                                title: 'Table of people',
                                                actions: {
                                                    listAction: 'SiddhuCRUDController?action=list',
                                                    createAction:'SiddhuCRUDController?action=create',
                                                    updateAction: 'SiddhuCRUDController?action=update',
                                                    deleteAction: 'SiddhuCRUDController?action=delete'
                                                },
                                                fields: {
                                                    userid: {
                                                     title:'Id',
                                                        key: true,
                                                        list: true,
                                                        create:true
                                                    },
                                                    firstName: {
                                                        title: 'Rate Name',
                                                        width: '30%',
                                                        edit:false
                                                    },
                                                    lastName: {
                                                        title: 'Rate Value',
                                                        width: '30%',
                                                        edit:true
                                                    },
                                                    email: {
                                                        title: 'Created On',
                                                        width: '20%',
                                                        edit: true
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
                                
                                <li><a><i class="fa fa-edit"></i> Users Management <span class="fa fa-gears"></span></a>
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
    <script type="text/javascript" src="jsdash/gauge/gauge.min.js"></script>
    <script type="text/javascript" src="jsdash/gauge/gauge_demo.js"></script>
    <!-- chart js -->
    <script src="jsdash/chartjs/chart.min.js"></script>
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
    <script>
        $(document).ready(function () {
            // [17, 74, 6, 39, 20, 85, 7]
            //[82, 23, 66, 9, 99, 6, 2]
            var data1 = [[gd(2012, 1, 1), 17], [gd(2012, 1, 2), 74], [gd(2012, 1, 3), 6], [gd(2012, 1, 4), 39], [gd(2012, 1, 5), 20], [gd(2012, 1, 6), 85], [gd(2012, 1, 7), 7]];

            var data2 = [[gd(2012, 1, 1), 82], [gd(2012, 1, 2), 23], [gd(2012, 1, 3), 66], [gd(2012, 1, 4), 9], [gd(2012, 1, 5), 119], [gd(2012, 1, 6), 6], [gd(2012, 1, 7), 9]];
            $("#canvas_dahs").length && $.plot($("#canvas_dahs"), [
                data1, data2
            ], {
                series: {
                    lines: {
                        show: false,
                        fill: true
                    },
                    splines: {
                        show: true,
                        tension: 0.4,
                        lineWidth: 1,
                        fill: 0.4
                    },
                    points: {
                        radius: 0,
                        show: true
                    },
                    shadowSize: 2
                },
                grid: {
                    verticalLines: true,
                    hoverable: true,
                    clickable: true,
                    tickColor: "#d5d5d5",
                    borderWidth: 1,
                    color: '#fff'
                },
                colors: ["rgba(38, 185, 154, 0.38)", "rgba(3, 88, 106, 0.38)"],
                xaxis: {
                    tickColor: "rgba(51, 51, 51, 0.06)",
                    mode: "time",
                    tickSize: [1, "day"],
                    //tickLength: 10,
                    axisLabel: "Date",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 10
                        //mode: "time", timeformat: "%m/%d/%y", minTickSize: [1, "day"]
                },
                yaxis: {
                    ticks: 8,
                    tickColor: "rgba(51, 51, 51, 0.06)",
                },
                tooltip: false
            });

            function gd(year, month, day) {
                return new Date(year, month - 1, day).getTime();
            }
        });
    </script>

    <!-- worldmap -->
    <script type="text/javascript" src="jsdash/maps/jquery-jvectormap-2.0.1.min.js"></script>
    <script type="text/javascript" src="jsdash/maps/gdp-data.js"></script>
    <script type="text/javascript" src="jsdash/maps/jquery-jvectormap-world-mill-en.js"></script>
    <script type="text/javascript" src="jsdash/maps/jquery-jvectormap-us-aea-en.js"></script>
    <script>
        $(function () {
            $('#world-map-gdp').vectorMap({
                map: 'world_mill_en',
                backgroundColor: 'transparent',
                zoomOnScroll: false,
                series: {
                    regions: [{
                        values: gdpData,
                        scale: ['#E6F2F0', '#149B7E'],
                        normalizeFunction: 'polynomial'
                    }]
                },
                onRegionTipShow: function (e, el, code) {
                    el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
                }
            });
        });
    </script>
    <!-- skycons -->
    <script src="jsdash/skycons/skycons.js"></script>
    <script>
        var icons = new Skycons({
                "color": "#73879C"
            }),
            list = [
                "clear-day", "clear-night", "partly-cloudy-day",
                "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
                "fog"
            ],
            i;

        for (i = list.length; i--;)
            icons.set(list[i], list[i]);

        icons.play();
    </script>

    <!-- dashbord linegraph -->
    <script>
        var doughnutData = [
            {
                value: 30,
                color: "#455C73"
            },
            {
                value: 30,
                color: "#9B59B6"
            },
            {
                value: 60,
                color: "#BDC3C7"
            },
            {
                value: 100,
                color: "#26B99A"
            },
            {
                value: 120,
                color: "#3498DB"
            }
    ];
        var myDoughnut = new Chart(document.getElementById("canvas1").getContext("2d")).Doughnut(doughnutData);
    </script>
    <!-- /dashbord linegraph -->
    <!-- datepicker -->
    <script type="text/javascript">
        $(document).ready(function () {

            var cb = function (start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
                $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                //alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
            }

            var optionSet1 = {
                startDate: moment().subtract(29, 'days'),
                endDate: moment(),
                minDate: '01/01/2012',
                maxDate: '12/31/2015',
                dateLimit: {
                    days: 60
                },
                showDropdowns: true,
                showWeekNumbers: true,
                timePicker: false,
                timePickerIncrement: 1,
                timePicker12Hour: true,
                ranges: {
                    'Today': [moment(), moment()],
                    'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                    'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                    'This Month': [moment().startOf('month'), moment().endOf('month')],
                    'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                },
                opens: 'left',
                buttonClasses: ['btn btn-default'],
                applyClass: 'btn-small btn-primary',
                cancelClass: 'btn-small',
                format: 'MM/DD/YYYY',
                separator: ' to ',
                locale: {
                    applyLabel: 'Submit',
                    cancelLabel: 'Clear',
                    fromLabel: 'From',
                    toLabel: 'To',
                    customRangeLabel: 'Custom',
                    daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
                    monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
                    firstDay: 1
                }
            };
            $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
            $('#reportrange').daterangepicker(optionSet1, cb);
            $('#reportrange').on('show.daterangepicker', function () {
                console.log("show event fired");
            });
            $('#reportrange').on('hide.daterangepicker', function () {
                console.log("hide event fired");
            });
            $('#reportrange').on('apply.daterangepicker', function (ev, picker) {
                console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
            });
            $('#reportrange').on('cancel.daterangepicker', function (ev, picker) {
                console.log("cancel event fired");
            });
            $('#options1').click(function () {
                $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
            });
            $('#options2').click(function () {
                $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
            });
            $('#destroy').click(function () {
                $('#reportrange').data('daterangepicker').remove();
            });
        });
    </script>
    <script>
        NProgress.done();
    </script>
    <!-- /datepicker -->
    <!-- /footer content -->
</body>

</html>

