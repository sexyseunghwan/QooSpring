/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2021-05-19 12:59:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class qoolog_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Users/신승환/Desktop/java/QooSpring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringTest/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/views/inc/qooasset.jsp", Long.valueOf(1619531350831L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1619012585268L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel = \"stylesheet\" href = \"resources/css/bootstrap.css\">\r\n");
      out.write("<link rel = \"stylesheet\" href = \"resources/css/jquery-ui.css\">\r\n");
      out.write("<script src = \"resources/js/jquery-1.12.4.js\"></script>\r\n");
      out.write("<script src = \"resources/js/jquery-ui.js\"></script>\r\n");
      out.write("<script src = \"resources/js/bootstrap.js\"></script>");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=380, height=740, user-scalable=yes, initial-scale=1.0, maximum-scale=2.0\"/>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write(" <style>\r\n");
      out.write("        /* 넥슨 글씨체 */\r\n");
      out.write("        @font-face {\r\n");
      out.write("            font-family: 'NEXON Lv1 Gothic OTF';\r\n");
      out.write("            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff');\r\n");
      out.write("            font-weight: normal;\r\n");
      out.write("            font-style: normal;\r\n");
      out.write("        }\r\n");
      out.write("        /* 로그인 이미지 */\r\n");
      out.write("        #qoo10login {\r\n");
      out.write("            /* border : 1px solid red; */\r\n");
      out.write("            margin: 0px auto;\r\n");
      out.write("            margin-top: 40px;\r\n");
      out.write("            height: 100px;\r\n");
      out.write("            width: 200px;\r\n");
      out.write("        }\r\n");
      out.write("        #qoo10login img {\r\n");
      out.write("            width:100%;\r\n");
      out.write("            height : 100%;\r\n");
      out.write("        }\r\n");
      out.write("        /* 전체적인 바디 */\r\n");
      out.write("        body {\r\n");
      out.write("            /* border : 1px solid red; */\r\n");
      out.write("            height : 740px;\r\n");
      out.write("            background-color : #F5F6F7;\r\n");
      out.write("        }\r\n");
      out.write("        /* 아이디 비밀번호 치는곳 */\r\n");
      out.write("        .inputform {\r\n");
      out.write("            /* border: 1px solid blue; */\r\n");
      out.write("            margin: 5px auto;\r\n");
      out.write("            width : 355px;\r\n");
      out.write("            height : 50px;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .inputform input {\r\n");
      out.write("            width : 340px;\r\n");
      out.write("            height : 40px;\r\n");
      out.write("            border: 1px solid #E5E5E6;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #copyright {\r\n");
      out.write("            /* border : 1px solid blue; */\r\n");
      out.write("            width : 310px;\r\n");
      out.write("            margin: 20px auto;\r\n");
      out.write("            font-size: 0.9em;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #inputid:focus {\r\n");
      out.write("            outline: none;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        #inputpw:focus {\r\n");
      out.write("            outline:none;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        /* 광고관련 */\r\n");
      out.write("        #advertise {\r\n");
      out.write("            height: 200px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #advertise:hover{\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("        #etcinfo {\r\n");
      out.write("            margin: 5px auto;\r\n");
      out.write("            width : 260px;\r\n");
      out.write("            height : 30px;\r\n");
      out.write("            padding: 6px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #etcinfo a,span {\r\n");
      out.write("            color: #8E8E8E;\r\n");
      out.write("            font-family: 'NEXON Lv1 Gothic OTF';\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("         #etcinfo:hover {\r\n");
      out.write("             cursor : pointer;\r\n");
      out.write("         }\r\n");
      out.write("\t\t\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <div id = \"qoo10login\">\r\n");
      out.write("        <img src = \"resources/images/Qoo10_Logo.png\">    \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <form action=\"loginVerification.action\" method = \"POST\" id = \"inputform\"><!-- 여기도 변화를 줘야하는데 어떤식으로 주면 될까 -->\r\n");
      out.write("        <!-- 아이디 -->\r\n");
      out.write("        <div class = \"inputform\">\r\n");
      out.write("            <input type=\"text\" name = \"id\" autocomplete=\"off\" id = \"inputid\" placeholder = \"아이디\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 비밀번호 -->\r\n");
      out.write("        <div class = \"inputform\">\r\n");
      out.write("            <input type=\"password\" name = \"pw\" autocomplete=\"off\" id = \"inputpw\" placeholder = \"비밀번호\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 로그인 버튼 -->\r\n");
      out.write("        <div class = \"inputform\">\r\n");
      out.write("            <input id = \"go\" type=\"submit\" value = \"SIGN IN\" style = \"font-weight: bold; font-size: 1.3em; background-color: #EC2E3C; color:white;\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("    <div id = \"etcinfo\">\r\n");
      out.write("        <a target=\"_blank\" href = \"\">아이디 찾기</a>\r\n");
      out.write("        <span class = \"bar\">|</span>\r\n");
      out.write("        <a target=\"_blank\" href = \"\">비밀번호 찾기</a>\r\n");
      out.write("        <span class = \"bar\">|</span>\r\n");
      out.write("        <a target=\"_blank\" href = \"/spring/signUp.action\">회원 가입</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id = \"copyright\" style=\"font-family: 'NEXON Lv1 Gothic OTF'\">\r\n");
      out.write("        Copyright &copy; <span style=\"font-weight: bold;\">Qoo10 Corp.</span> All rights reserved.\r\n");
      out.write("    </div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 광고칸 -->\r\n");
      out.write("    <div id = \"advertise\" class = \"inputform\" style = \"background: url('resources/images/adver/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${picName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'); background-size: cover;\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        \r\n");
      out.write("        //광고 클릭했을 경우\r\n");
      out.write("        $(\"#advertise\").click(function(){\r\n");
      out.write("            location.href = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
