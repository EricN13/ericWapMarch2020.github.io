
package mum.wap;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nkuri
 */
@WebServlet(name = "Mycalculator", urlPatterns = {"/Mycalculator"})
public class Mycalculator extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num1 = Integer.parseInt(request.getParameter("nbr1"));
        int num2 = Integer.parseInt(request.getParameter("nbr2"));
        String operator=request.getParameter("operator");
//        int num3 = Integer.parseInt(request.getParameter("nbr3"));
//        int num4 = Integer.parseInt(request.getParameter("nbr4"));
           int sum = 0;
           if(operator.equals("+")){
               sum=num1+num2;
           }
        if(operator.equals("*")){
            sum=num1*num2;
        }
        //int multi = num3*num4;

        PrintWriter out = response.getWriter();
        out.print("<html><head><meta charset='ISO-8859-1'><title>Calculator</title></head><body>");
        out.print("<form action='Mycalculator'>");
        out.print("<input type='number'  name='nbr1' value='"+num1+"' /> ");
        out.print("<input type='text' name='operator'/>");
        out.print("<input type='number' name='nbr2' value='"+num2+"' /> = ");
        out.print("<input type='number' name='nbrSum' value='"+sum+"' />  <br/>");
//        out.print("<input type='number' name='nbr3' value='"+num3+"' /> * ");
//        out.print("<input type='number' name='nbr4' value='"+num4+"' /> = ");
//        out.print("<input type='number' name='nbrMu' value='"+multi+"' /> <br/><br/>");
        out.print("<input type='submit' name='submit' value='Submit'>");
        out.print("</form>");
        out.print("</body></html>");

    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><meta charset='ISO-8859-1'><title>Calculator</title></head><body>");
        out.print("<form action='Mycalculator' method='POST'>");
        out.print("<input type='number'  name='nbr1'/> ");
        out.print("<input type='text' name='operator'/>");
        out.print("<input type='number' name='nbr2'/> = ");
        out.print("<input type='number' name='nbrSum'/>  <br/>");
//        out.print("<input type='number' name='nbr3'/> * ");
//        out.print("<input type='number' name='nbr4'/> = ");
//        out.print("<input type='number' name='nbrMu'/> <br/><br/>");
        out.print("<input type='submit' name='submit' value='Submit'>");
        out.print("</form></body></html>");
    }
}
