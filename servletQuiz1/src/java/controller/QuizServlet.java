package controller;

import model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class QuizServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        Quiz myQuiz = new Quiz();
//        HttpSession sess = req.getSession();
//        sess.setAttribute("quiz", myQuiz);
//        System.out.println("Setting quiz in the session");
        doPost(req, resp);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();

        HttpSession sess = req.getSession();
        Quiz myQuiz = (Quiz) sess.getAttribute("quiz");
        /* checks if myQuiz is null */
        if (myQuiz == null) {
            myQuiz = new Quiz();
            sess.setAttribute("quiz", myQuiz);
        }



        /* processing an input from the user */
        String answer = req.getParameter("answer");
        System.out.println("Answer is: " + answer);

        boolean error = true;
        /* i.e., if answer is correct then increment the question index and score */
        if ((answer != null) && myQuiz.isCorrect(answer)) {
            error = false;
            myQuiz.scoreAnswer();
        }

        /* checks if the questions are done, and the prints last page*/
        if (myQuiz.getNumQuestions() == myQuiz.getCurrentQuestionIndex()) {
            System.out.println("have finished quiz");
            genQuizOverPage(out);
        } else {
            /* get a question and print it out */
            String currQuest = myQuiz.getCurrentQuestion();
            genQuizPage(myQuiz, out, currQuest, error, answer);
        }
    }


    private void genQuizPage(Quiz myQuiz, PrintWriter out, String currQuest, boolean error, String answer) {

        out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form method='post'>");
        out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(myQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print(currQuest + "</p>");

        out.print("<p>Your answer:<input type='text' name='answer' value='' /></p> ");

        /* if incorrect, then print out error message */
        if (error && (answer != null)) {
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
        out.print("<p><input type='submit' name='btnNext' value='Next' /></p> ");

        out.print("</form>");
        out.print("</body></html>");
    }

    private void genQuizOverPage(PrintWriter out) {
        out.print("<html> ");
        out.print("<head >");
        out.print("<title>NumberQuiz is over</title> ");
        out.print("</head> ");
        out.print("<body> ");
        out.print("<p style='color:red'>The number quiz is over!</p>	</body> ");
        out.print("</html> ");
    }
}
