/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE603_Client_Side_Authentication__Servlet_15.java
Label Definition File: CWE603_Client_Side_Authentication__Servlet.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 603 Use of client-side authentication
* Sinks:
*    GoodSink: perform the authentication on the server side
*    BadSink : authentication is performed in JavaScript
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE603_Client_Side_Authentication;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE603_Client_Side_Authentication__Servlet_15 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            StringBuilder authnScript = new StringBuilder("<script type=\"text/javascript\">");
            authnScript.append("function passWord() {");
            authnScript.append("var pass1 = prompt('Please Enter Your Password',' ');");
            authnScript.append("while (1) {");
            authnScript.append("if (!pass1)");
            authnScript.append("history.go(-1);");
            authnScript.append("if (pass1 == \"I am 4 sUp3r 53cr37 password\") {"); /* FLAW: Authentication performed in JavaScript */
            authnScript.append("window.open('admin.html');");
            authnScript.append("break;");
            authnScript.append("}");
            authnScript.append("var pass1 =");
            authnScript.append("prompt('Access Denied - Password Incorrect, Please Try Again.','Give Me The Password');");
            authnScript.append("}");
            authnScript.append("if (pass1.toLowerCase()!=\"password\" & testV == 3)");
            authnScript.append("history.go(-1);");
            authnScript.append("return \" \";");
            authnScript.append("}");
            authnScript.append("</script>");
            PrintWriter out = response.getWriter();
            out.println(authnScript.toString());
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String passwd = request.getParameter("password");
            if( (passwd == null) )
            {
                response.sendRedirect("login.html");
                return;
            }
            /* FIX: Authentication performed on the server side */
            if( (passwd.equals("I am 4 sUp3r 53cr37 password")) )
            {
                response.sendRedirect("admin.html");
            }
            else
            {
                response.sendError(1, "You have entered an incorrect password.");
                response.sendRedirect("login.html");
            }
        }
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            StringBuilder authnScript = new StringBuilder("<script type=\"text/javascript\">");
            authnScript.append("function passWord() {");
            authnScript.append("var pass1 = prompt('Please Enter Your Password',' ');");
            authnScript.append("while (1) {");
            authnScript.append("if (!pass1)");
            authnScript.append("history.go(-1);");
            authnScript.append("if (pass1 == \"I am 4 sUp3r 53cr37 password\") {"); /* FLAW: Authentication performed in JavaScript */
            authnScript.append("window.open('admin.html');");
            authnScript.append("break;");
            authnScript.append("}");
            authnScript.append("var pass1 =");
            authnScript.append("prompt('Access Denied - Password Incorrect, Please Try Again.','Give Me The Password');");
            authnScript.append("}");
            authnScript.append("if (pass1.toLowerCase()!=\"password\" & testV == 3)");
            authnScript.append("history.go(-1);");
            authnScript.append("return \" \";");
            authnScript.append("}");
            authnScript.append("</script>");
            PrintWriter out = response.getWriter();
            out.println(authnScript.toString());
        }
        break;
        default:
        {
            String passwd = request.getParameter("password");
            if( (passwd == null) )
            {
                response.sendRedirect("login.html");
                return;
            }
            /* FIX: Authentication performed on the server side */
            if( (passwd.equals("I am 4 sUp3r 53cr37 password")) )
            {
                response.sendRedirect("admin.html");
            }
            else
            {
                response.sendError(1, "You have entered an incorrect password.");
                response.sendRedirect("login.html");
            }
        }
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            String passwd = request.getParameter("password");
            if( (passwd == null) )
            {
                response.sendRedirect("login.html");
                return;
            }
            /* FIX: Authentication performed on the server side */
            if( (passwd.equals("I am 4 sUp3r 53cr37 password")) )
            {
                response.sendRedirect("admin.html");
            }
            else
            {
                response.sendError(1, "You have entered an incorrect password.");
                response.sendRedirect("login.html");
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            StringBuilder authnScript = new StringBuilder("<script type=\"text/javascript\">");
            authnScript.append("function passWord() {");
            authnScript.append("var pass1 = prompt('Please Enter Your Password',' ');");
            authnScript.append("while (1) {");
            authnScript.append("if (!pass1)");
            authnScript.append("history.go(-1);");
            authnScript.append("if (pass1 == \"I am 4 sUp3r 53cr37 password\") {"); /* FLAW: Authentication performed in JavaScript */
            authnScript.append("window.open('admin.html');");
            authnScript.append("break;");
            authnScript.append("}");
            authnScript.append("var pass1 =");
            authnScript.append("prompt('Access Denied - Password Incorrect, Please Try Again.','Give Me The Password');");
            authnScript.append("}");
            authnScript.append("if (pass1.toLowerCase()!=\"password\" & testV == 3)");
            authnScript.append("history.go(-1);");
            authnScript.append("return \" \";");
            authnScript.append("}");
            authnScript.append("</script>");
            PrintWriter out = response.getWriter();
            out.println(authnScript.toString());
        }
        break;
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
