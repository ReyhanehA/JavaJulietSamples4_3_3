/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE605_Multiple_Binds_Same_Port__basic_07.java
Label Definition File: CWE605_Multiple_Binds_Same_Port__basic.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 605 Multiple binds to the same port
* Sinks:
*    GoodSink: two binds on different ports
*    BadSink : two binds on one port
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE605_Multiple_Binds_Same_Port;

import testcasesupport.*;

import java.net.ServerSocket;
import java.net.InetSocketAddress;

public class CWE605_Multiple_Binds_Same_Port__basic_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        if (private_five==5)
        {
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */

        }
    }

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1() throws Throwable
    {
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */
        }
        else {

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_five==5)
        {
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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