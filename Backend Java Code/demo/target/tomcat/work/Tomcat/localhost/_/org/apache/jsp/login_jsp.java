/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-05-01 06:14:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Real Estate Website</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/styles.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- Header -->\n");
      out.write("    <header>\n");
      out.write("        <h1>Singapore's best real deals!</h1>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <!-- Navigation -->\n");
      out.write("    <nav>\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"index.html\">Home</a></li>\n");
      out.write("            <li><a href=\"listings.html\">Property Listings</a></li>\n");
      out.write("            <li><a href=\"calculator.html\">Mortgage Calculator</a></li>\n");
      out.write("            <li><a href=\"reviews.html\">Agent Reviews</a></li>\n");
      out.write("            <li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <!-- Main Content -->\n");
      out.write("    <main>\n");
      out.write("        <div class = \"hero\">\n");
      out.write("\n");
      out.write("            <div class = \"form-box\">\n");
      out.write("                <form action=\"/myapp/LoginBoundary\" method=\"post\" id=\"login\" class=\"input-group\">\n");
      out.write("                    <input id=\"username\" name=\"username\" type=\"text\" class=\"input-field\" placeholder=\"User Id\" required>\n");
      out.write("                    <input id=\"password\" name=\"password\" type=\"password\" class=\"input-field\" placeholder=\"Enter Password\" required>\n");
      out.write("                    <input type=\"checkbox\" class=\"check-box\"><span>Remember Password</span>\n");
      out.write("                    <button type=\"submit\" class=\"submit-btn\" onclick=\"storeUsername()\">Log in</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Real Estate Website. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("<!-- JavaScript for showing a popup when login is unsuccessful -->\n");
      out.write("<script>\n");
      out.write("    // Check if the loginError flag is present in the session\n");
      out.write("    var loginError = \"");
      out.print(session.getAttribute("loginError"));
      out.write("\";\n");
      out.write("    if (loginError && loginError === \"true\") {\n");
      out.write("        // Show a popup\n");
      out.write("        alert(\"Invalid username or password.\");\n");
      out.write("        // Remove the flag from the session\n");
      out.write("        ");

            session.removeAttribute("loginError");
        
      out.write("\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!-- Storing username in session-->\n");
      out.write("<script>\n");
      out.write("    function storeUsername() {\n");
      out.write("        var username = document.getElementById('username').value;\n");
      out.write("        sessionStorage.setItem('username', username);\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
