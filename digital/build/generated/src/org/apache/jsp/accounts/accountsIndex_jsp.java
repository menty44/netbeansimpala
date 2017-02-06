package org.apache.jsp.accounts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.impalapay.airtel.accountmgmt.admin.pagination.account.AccountPage;
import com.impalapay.airtel.accountmgmt.admin.pagination.account.AccountPaginator;
import com.impalapay.airtel.beans.accountmgmt.Account;
import com.impalapay.airtel.beans.accountmgmt.AccountStatus;
import com.impalapay.airtel.persistence.accountmgmt.AccountStatusDAO;
import com.impalapay.airtel.beans.geolocation.Country;
import com.impalapay.airtel.accountmgmt.session.SessionStatistics;
import com.impalapay.airtel.accountmgmt.admin.SessionConstants;
import com.impalapay.airtel.cache.CacheVariables;
import org.apache.commons.lang.StringUtils;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Calendar;
import java.util.Iterator;

public final class accountsIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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
    // End of session management code
   
       // We assume Live and Developer AccountStatuses are equivalent.
   AccountStatusDAO accountStatusDAO = AccountStatusDAO.getInstance();
   List<AccountStatus> accountStatusList = accountStatusDAO.getAllAccountStatus();
   List<Account> accounts = new ArrayList<Account>();
   List<Account> accountList;

    CacheManager mgr = CacheManager.getInstance();
    Cache accountsCache = mgr.getCache(CacheVariables.CACHE_ACCOUNTS_BY_USERNAME);
    Cache statisticsCache = mgr.getCache(CacheVariables.CACHE_ALL_ACCOUNTS_STATISTICS);
    Cache countryCache = mgr.getCache(CacheVariables.CACHE_COUNTRY_BY_UUID);

    // This HashMap contains the UUIDs of countries as keys and the country names as values
    HashMap<String, String> countryHash = new HashMap<String, String>();


    Element element;
    Country country;
    List keys = accountsCache.getKeys();

    for (Object key : keys) {
        if ((element = accountsCache.get(key)) != null) {
            accounts.add((Account) element.getObjectValue());
        }
    }

    keys = countryCache.getKeys();
    for (Object key : keys) {
        element = countryCache.get(key);
        country = (Country) element.getObjectValue();
        countryHash.put(country.getCurrencycode(), country.getCurrency());
    }


    int count = 0;  // A generic counter
    int incount = 0;  // Generic counter
    
    AccountPaginator paginator = new AccountPaginator();

    SessionStatistics statistics = new SessionStatistics();

     if ((element = statisticsCache.get(CacheVariables.CACHE_ALL_ACCOUNTS_STATISTICS_KEY)) != null) {
        statistics = (SessionStatistics) element.getObjectValue();
    }

  

    incount = statistics.getAccountCountTotal();
    AccountPage accountPage;
    int accountCount = 0; // The current count of the Accounts sessions

    if (incount == 0) { 	// This user has no Incoming USSD in the account
        accountPage = new AccountPage();
        accountList = new ArrayList<Account>();
        accountCount = 0;

    } else {
        accountPage = (AccountPage) session.getAttribute("currentListPage");
        String referrer = request.getHeader("referer");
        String pageParam = (String) request.getParameter("page");

        // We are to give the first page
        if (accountPage == null
                || !StringUtils.endsWith(referrer, "accountsIndex.jsp")
                || StringUtils.equalsIgnoreCase(pageParam, "first")) {
            accountPage = paginator.getFirstPage();

            // We are to give the last page
        } else if (StringUtils.equalsIgnoreCase(pageParam, "last")) {
            accountPage = paginator.getLastPage();

            // We are to give the previous page
        } else if (StringUtils.equalsIgnoreCase(pageParam, "previous")) {
            accountPage = paginator.getPrevPage(accountPage);

            // We are to give the next page 
        } else {
            accountPage = paginator.getNextPage(accountPage);
        }

        session.setAttribute("currentListPage", accountPage);

        accountList = accountPage.getContents();

        accountCount = (accountPage.getPageNum() - 1) * accountPage.getPagesize() + 1;

        
    }

   

      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <!-- Meta, title, CSS, favicons, etc. -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("    <title>ImpalaPay | Accounts</title>\n");
      out.write("    <link  rel=\"icon\" type=\"image/png\"  href=\"../images/logo.jpg\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("\n");
      out.write("    <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <link href=\"../fonts/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../css/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom styling plus plugins -->\n");
      out.write("    <link href=\"../css/custom.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/maps/jquery-jvectormap-2.0.1.css\" />\n");
      out.write("    <link href=\"../css/icheck/flat/green.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../css/floatexamples.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    <script src=\"../js/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"../assets/js/ie8-responsive-file-warning.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body class=\"nav-md\">\n");
      out.write("\n");
      out.write("    <div class=\"container body\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"main_container\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-3 left_col\">\n");
      out.write("                <div class=\"left_col scroll-view\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("                    <!-- menu prile quick info -->\n");
      out.write("                    <div class=\"profile\">\n");
      out.write("                        <div class=\"profile_pic\">\n");
      out.write("                            <img src=\"../images/img.png\" alt=\"...\" class=\"img-circle profile_img\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"profile_info\">\n");
      out.write("                            <span>Welcome,</span>\n");
      out.write("                            <h2>");
      out.print(sessionKey);
      out.write("</h2>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /menu prile quick info -->\n");
      out.write("\n");
      out.write("                    <br />\n");
      out.write("\n");
      out.write("                    <!-- sidebar menu -->\n");
      out.write("                                  <div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\">\n");
      out.write("\n");
      out.write("                        <div class=\"menu_section\">\n");
      out.write("                            \n");
      out.write("                            <ul class=\"nav side-menu\">\n");
      out.write("                                <li><a><i class=\"fa fa-area-chart\"></i> Home <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                        <li><a href=\"../dashboard.jsp\">Dashboard</a>\n");
      out.write("                                        </li>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a><i class=\"fa fa-users\"></i>Accounts<span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                        <li><a href=\"accountsIndex.jsp\">Add Account</a>\n");
      out.write("                                        </li>\n");
      out.write("    \t\t\t\t\t\t\t\t\t<li><a href=\"addManagementAccount.jsp\">Add Management</a>\n");
      out.write("                                        </li>\n");
      out.write("                                         <li><a href=\"addroutedefine.jsp\">Account->Network</a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a><i class=\"fa fa-database\"></i> Transactions <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                        <li><a href=\"alltransaction.jsp\">View All Transactions</a>\n");
      out.write("                                        </li>\n");
      out.write("                                         <li><a href=\"updatestatus.jsp\">Adjust Transaction Status</a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <!--<li><a><i class=\"fa fa-money\"></i>Manage Balance<span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                        <li><a href=\"addFloat.jsp\">Adjust Client Balance</a>\n");
      out.write("   \t\t\t\t\t<li><a href=\"floatHistory.jsp\">Client Balance History</a>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>-->\n");
      out.write("\t\t\t\t\t\t\t\t<li><a><i class=\"fa fa-wifi\"></i>Manage Networks<span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                       <li><a href=\"addCountry.jsp\">Add Country(MNO)</a></li>\n");
      out.write("                                        </li>\n");
      out.write("                                       <li><a href=\"addmnoprefix.jsp\">Define Prefix(MNO)</a></li>\n");
      out.write("                                        </li>\n");
      out.write("                                         <li><a href=\"addNetwork.jsp\">Add Networks</a></li>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li><a href=\"addBank.jsp\">Add Bank</a></li>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a><i class=\"fa fa-exclamation-triangle\"></i>Manage Security<span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                        <li><a href=\"addSessionIp.jsp\">IP-WhiteList/Session-Url</a>\n");
      out.write("                                        </li>\n");
      out.write("                                         <li><a href=\"systemlog.jsp\">SystemLog History</a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /sidebar menu -->\n");
      out.write("\n");
      out.write("                    <!-- /menu footer buttons -->\n");
      out.write("                   <!-- <div class=\"sidebar-footer hidden-small\">\n");
      out.write("                        <a data-toggle=\"tooltip\" data-placement=\"top\" title=\"Settings\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-cog\" aria-hidden=\"true\"></span>\n");
      out.write("                        </a>\n");
      out.write("                        <a data-toggle=\"tooltip\" data-placement=\"top\" title=\"FullScreen\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-fullscreen\" aria-hidden=\"true\"></span>\n");
      out.write("                        </a>\n");
      out.write("                        <a data-toggle=\"tooltip\" data-placement=\"top\" title=\"Lock\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-eye-close\" aria-hidden=\"true\"></span>\n");
      out.write("                        </a>\n");
      out.write("                        <a data-toggle=\"tooltip\" data-placement=\"top\" title=\"Logout\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span>\n");
      out.write("                        </a>\n");
      out.write("                    </div>-->\n");
      out.write("                    <!-- /menu footer buttons -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- top navigation -->\n");
      out.write("            <div class=\"top_nav\">\n");
      out.write("\n");
      out.write("                <div class=\"nav_menu\">\n");
      out.write("                    <nav class=\"\" role=\"navigation\">\n");
      out.write("                        <div class=\"nav toggle\">\n");
      out.write("                            <a id=\"menu_toggle\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <li class=\"\">\n");
      out.write("                                <a href=\"javascript:;\" class=\"user-profile dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    <img src=\"../images/img.png\" alt=\"\">");
      out.print( sessionKey);
      out.write("\n");
      out.write("                                    <span class=\" fa fa-angle-down\"></span>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu dropdown-usermenu animated fadeInDown pull-right\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <form name=\"logoutForm\" method=\"post\" action=\"../logout\">\n");
      out.write("                                            <p>\n");
      out.write("                                            <!--<input type=\"submit\" class=\"btn btn-primary\" name=\"logout\" id=\"logout\" value=\"Logout\">-->\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fa fa-sign-out pull-right\"></i> Log Out</button>\n");
      out.write("                                           \n");
      out.write("                                            </p>\n");
      out.write("                                        </form>\n");
      out.write("                                     \n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /top navigation -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- page content -->\n");
      out.write("            <div class=\"right_col\" role=\"main\">\n");
      out.write("\n");
      out.write("                                    <div class=\"\">\n");
      out.write("                    <div class=\"page-title\">\n");
      out.write("                        <div class=\"title_left\">\n");
      out.write("                            <h3>Add Account</h3>\n");
      out.write("                         </div>  \n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <div class=\"x_panel\">\n");
      out.write("                                <div class=\"x_content\">\n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                    <div class=\"box-content\">\n");
      out.write("                        ");

                    String addErrStr = (String) session.getAttribute(SessionConstants.ADMIN_ADD_ACCOUNT_ERROR_KEY);
                    String addSuccessStr = (String) session.getAttribute(SessionConstants.ADMIN_ADD_ACCOUNT_SUCCESS_KEY);
                    HashMap<String, String> paramHash = (HashMap<String, String>) session.getAttribute(
                            SessionConstants.ADMIN_ADD_ACCOUNT_PARAMETERS);

                    if (paramHash == null) {
                        paramHash = new HashMap<String, String>();
                    }

                    if (StringUtils.isNotEmpty(addErrStr)) {
                        out.println("<p class=\"alert alert-error\">");
                        out.println("Form error: " + addErrStr);
                        out.println("</p>");
                        session.setAttribute(SessionConstants.ADMIN_ADD_ACCOUNT_ERROR_KEY, null);
                    }

                    if (StringUtils.isNotEmpty(addSuccessStr)) {
                        out.println("<p class=\"alert alert-success\">");
                        out.println("You have successfully added the new account. You may add others below. "
                                + "Please relogin to system to get new listing of accounts.");
                        out.println("</p>");
                        session.setAttribute(SessionConstants.ADMIN_ADD_ACCOUNT_SUCCESS_KEY, null);
                    }
                
      out.write("\n");
      out.write("                        \n");
      out.write("                       \n");
      out.write("                        <form  class=\"form-horizontal form-label-left\" action=\"addAccount\" method=\"post\">\n");
      out.write("                        <div class=\"col-md-6 col-sm-6 col-xs-12 form-group has-feedback\">\n");
      out.write("                                        <input id=\"firstname\" name=\"firstName\" class=\"form-control has-feedback-left\" type=\"text\" autocomplete=\"false\"    placeholder=\"First Name\" ");

                                         out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("firstName")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                            <span class=\"fa fa-user form-control-feedback left\" aria-hidden=\"true\"></span>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6 col-sm-6 col-xs-12 form-group has-feedback\">\n");
      out.write("                                           <input id=\"input\" name=\"lastName\" class=\"form-control has-feedback-left\" type=\"text\"  autocomplete=\"false\"  placeholder=\"Last Name\"");

                                        out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("lastName")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                            <span class=\"fa fa-user form-control-feedback right\" aria-hidden=\"true\"></span>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6 col-sm-6 col-xs-12 form-group has-feedback\">\n");
      out.write("                                          <input id=\"input\" name=\"email\" class=\"form-control has-feedback-left\" type=\"text\"  autocomplete=\"false\" placeholder=\"Email\"");

                                        out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("email")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                            <span class=\"fa fa-envelope form-control-feedback left\" aria-hidden=\"true\"></span>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6 col-sm-6 col-xs-12 form-group has-feedback\">\n");
      out.write("                                             <input id=\"input\" name=\"phone\" class=\"form-control has-feedback-left\" type=\"text\" autocomplete=\"false\" placeholder=\"Phone Number\" ");

                                      out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("phone")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                            <span class=\"fa fa-phone form-control-feedback right\" aria-hidden=\"true\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-6 col-sm-6 col-xs-12 form-group has-feedback\">\n");
      out.write("                                              <input id=\"input\" name=\"username\" class=\"form-control has-feedback-left\" type=\"text\"  autocomplete=\"false\" placeholder=\"Portal Username\"");

                                        out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("username")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                            <span class=\"fa fa-user form-control-feedback left\" aria-hidden=\"true\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-6 col-sm-6 col-xs-12 form-group has-feedback\">\n");
      out.write("                                             <input id=\"input\" name=\"apiUsername\" class=\"form-control has-feedback-left\" type=\"text\"  autocomplete=\"false\" placeholder=\"Api username\"");

                                         out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("apiUsername")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                            <span class=\"fa fa-user form-control-feedback right\" aria-hidden=\"true\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                        \n");
      out.write("    \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">Portal Password\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-9 col-sm-9 col-xs-12\">\n");
      out.write("                                    <input id=\"input\" name=\"loginPasswd\" class=\"form-control col-md-7 col-xs-12\" type=\"password\"  autocomplete=\"false\"  ");

                                         out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("loginPasswd")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                </div>\n");
      out.write("                             </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">Repeat Portal Password\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-9 col-sm-9 col-xs-12\">\n");
      out.write("                                    <input id=\"input\" name=\"loginPasswd2\" class=\"form-control col-md-7 col-xs-12\" type=\"password\"  autocomplete=\"false\"  ");

                                         out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("loginPasswd2")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                </div>\n");
      out.write("                             </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">Api Password\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-9 col-sm-9 col-xs-12\">\n");
      out.write("                                  <input id=\"input\" name=\"apiPasswd\" class=\"form-control col-md-7 col-xs-12\" type=\"password\"  autocomplete=\"false\" ");

                                        out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("apiPasswd")) + "\"");  
                                         
      out.write(" >\n");
      out.write("                                </div>\n");
      out.write("                             </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">Repeat Password\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-9 col-sm-9 col-xs-12\">\n");
      out.write("                                  <input id=\"input\" name=\"apiPasswd2\" class=\"form-control col-md-7 col-xs-12\" type=\"password\"  autocomplete=\"false\"  ");

                                       out.println("value=\"" + StringUtils.trimToEmpty(paramHash.get("apiPasswd2")) + "\"");
                                         
      out.write(" >\n");
      out.write("                                </div>\n");
      out.write("                             </div>\n");
      out.write("                             <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">Default Currency\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-7 col-sm-7 col-xs-12\">\n");
      out.write("                                   <select name=\"accounttype\" id=\"input\" class=\"form-control col-md-3 col-xs-12\" required>\n");
      out.write("                                        <option value=\"\" >Select Currency</option>\n");
      out.write("                                           ");

                                    Iterator c = countryHash.keySet().iterator();
                                   
                                    while (c.hasNext()) {

                                        String currencycodes = (String) c.next();

                                        String name = (String) countryHash.get(currencycodes);
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(currencycodes);
      out.write("\" >");
      out.print(name);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                             </div>\n");
      out.write("                             <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">Account Status\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-7 col-sm-7 col-xs-12\">\n");
      out.write("                                   <select name=\"accountStatus\" id=\"input\" class=\"form-control col-md-3 col-xs-12\">\n");
      out.write("                                            ");

                                                for (AccountStatus a : accountStatusList) {
                                                    if (StringUtils.equalsIgnoreCase(a.getDescription(), "Active")) {
                                                        out.println("<option selected=\"selected\" value=\"" + a.getUuid() + "\">" + a.getDescription() + "</option>");
                                                    } else {
                                                        out.println("<option value=\"" + a.getUuid() + "\">" + a.getDescription() + "</option>");
                                                    }
                                                }
                                            
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                </div>\n");
      out.write("                             </div>\n");
      out.write("                      \n");
      out.write("                        <div class=\"box-footer\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\" name=\"action\">\n");
      out.write("                                <i class=\"icon-ok\"></i>\n");
      out.write("                                Submit\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <div class=\"x_panel\">\n");
      out.write("                               \n");
      out.write("                                <div class=\"x_content\">\n");
      out.write("                                    <div align=\"right\">\n");
      out.write("                                                        <div id=\"pagination\">\n");
      out.write("                                                             <form name=\"pageForm\" method=\"post\" action=\"accountsIndex.jsp\">                                \n");
      out.write("\t\t\t\t\t                    ");
                                            if (!accountPage.isFirstPage()) {
					                    
      out.write("\n");
      out.write("\t\t\t\t\t                    <input class=\"btn btn-info\" type=\"submit\" name=\"page\" value=\"First\" />\n");
      out.write("\t\t\t\t\t                    <input class=\"btn btn-info\" type=\"submit\" name=\"page\" value=\"Previous\"/>\n");
      out.write("\t\t\t\t\t \n");
      out.write("\t\t\t\t\t                    ");

					                        }
					                    
      out.write("\n");
      out.write("\t\t\t\t\t                    <span class=\"pageInfo\">Page \n");
      out.write("\t\t\t\t\t                        <span class=\"pagePosition currentPage\">");
      out.print( accountPage.getPageNum());
      out.write("</span> of \n");
      out.write("\t\t\t\t\t                        <span class=\"pagePosition\">");
      out.print( accountPage.getTotalPage());
      out.write("</span>\n");
      out.write("\t\t\t\t\t                    </span>   \n");
      out.write("\t\t\t\t\t                    ");

					                        if (!accountPage.isLastPage()) {
					                    
      out.write("\n");
      out.write("\t\t\t\t\t                    <input class=\"btn btn-info\" type=\"submit\" name=\"page\"value=\"Next\"> \n");
      out.write("\t\t\t\t\t                    <input class=\"btn btn-info\" type=\"submit\"name=\"page\" value=\"Last\">\n");
      out.write("\t\t\t\t\t                    ");

					                        }
					                    
      out.write("                                \n");
      out.write("\t\t\t\t\t                </form>\n");
      out.write("                                                            \n");
      out.write("                                                        </div>\n");
      out.write("                                                     </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                                <!-- small box -->\n");
      out.write("                                                <div class=\"small-box\">\n");
      out.write("                                                    <div class=\"inner\">\n");
      out.write("                                                    <h5>ACTIVE ACCOUNTS</h5>\n");
      out.write("                                                    <div class=\"x_content\">\n");
      out.write("                                                        <table id=\"example\" class=\"table table-striped responsive-utilities jambo_table\">\n");
      out.write("                                                        <!--<table class=\"table table-striped bootstrap-datatable datatable\">-->\n");
      out.write("                                                        <thead>\n");
      out.write("                                                            <tr>\n");
      out.write("                                                               <th></th>\n");
      out.write("                                                            <th>First Name</th>\n");
      out.write("                                                            <th>Last Name</th>\n");
      out.write("                                                            <th>Username</th>\n");
      out.write("                                                            <th>Email</th>\n");
      out.write("                                                            <th>Phone</th>\n");
      out.write("                                                            <th>Creation Date</th>\n");
      out.write("                                                            <th>Account Type</th>\n");
      out.write("\t\t\t\t\t\t\t    <th>Account Status</th>\n");
      out.write("\n");
      out.write("                                                            </tr>\n");
      out.write("                                                        </thead>\n");
      out.write("                                                        <tbody>\n");
      out.write("                                                           ");

                                                            if (accountList != null) {
                                                                for (Account code : accountList) {
                                                                
      out.write("\n");
      out.write("\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <td width=\"5%\">");
      out.print(accountCount);
      out.write("</td>\n");
      out.write("                                                                    <td class=\"center\">");
      out.print(code.getFirstName());
      out.write("</td>\n");
      out.write("                                                                    <td class=\"center\">");
      out.print(code.getLastName());
      out.write("</td>\n");
      out.write("                                                                    <td class=\"center\">");
      out.print(code.getUsername());
      out.write("</td>\n");
      out.write("                                                                    <td class=\"center\">");
      out.print(code.getEmail());
      out.write("</td>\n");
      out.write("                                                                    <td class=\"center\">");
      out.print(code.getPhone());
      out.write("</td>\n");
      out.write("                                                                    <td class=\"center\">");
      out.print(code.getCreationDate());
      out.write("</td>\n");
      out.write("                                                                    <td class=\"center\">");
      out.print(code.getAccounttype());
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t    <td class=\"center\">");
      out.print(code.getAccountStatusUuid());
      out.write("</td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                 ");

                                                                    accountCount++;
                                                                }
                                                                }

                                                            
      out.write("\n");
      out.write("                                                        </tbody>\n");
      out.write("                                                        </table>\n");
      out.write("                                                     </div> \n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                           <!-- ./col -->\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("            \n");
      out.write("                <!-- footer content -->\n");
      out.write("                <footer>\n");
      out.write("                    <div class=\"\">\n");
      out.write("                        <p>Copyright@ImpalaPay 2014-2015</p>\n");
      out.write("                            <a href=\"#\">Terms &amp; Conditions</a> | <a href=\"#\">Privacy\n");
      out.write("                            Policy</a> | ImpalaPay Ltd ");
      out.print( Calendar.getInstance().get(Calendar.YEAR));
      out.write(". All rights reserved.\n");
      out.write("                            <!--<img id=\"madeInKenya\" alt=\"Made in Kenya\" src=\"#\" width=\"100\" height=\"100\" />-->\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                </footer>\n");
      out.write("\n");
      out.write("                <!-- /footer content -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /page content -->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- chart js -->\n");
      out.write("    <script src=\"../js/chartjs/chart.min.js\"></script>\n");
      out.write("    <!-- bootstrap progress js -->\n");
      out.write("    <script src=\"../js/progressbar/bootstrap-progressbar.min.js\"></script>\n");
      out.write("    <script src=\"../js/nicescroll/jquery.nicescroll.min.js\"></script>\n");
      out.write("    <!-- icheck -->\n");
      out.write("    <script src=\"../js/icheck/icheck.min.js\"></script>\n");
      out.write("\n");
      out.write("    <script src=\"../js/custom.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
