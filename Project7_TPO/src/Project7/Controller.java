package Project7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/add")

public class Controller extends HttpServlet {
    public static String NumberP="^-?[0-9]+$";
    public static Pattern NumbPattern= Pattern.compile(NumberP);
    public Logic Logic_;
    public Controller()
    {
       Logic_=new Logic();
    }
    @Override
    public void service(HttpServletRequest Request_, HttpServletResponse Response_) throws ServletException, IOException {
        BigInteger First_=Parameter("First",Request_);
        BigInteger Second_=Parameter("Second",Request_);

        Call Call_=new Call(First_,Second_);
        Model Model_=Logic_.Add(Call_);
        Request_.setAttribute("MODEL", Model_);
        HttpSession Session_=Request_.getSession();
        Session_.setAttribute("MODEL", Model_);

        ServletContext Context_=getServletContext();
        RequestDispatcher Dispatcher_=Context_.getRequestDispatcher("/result");
        Dispatcher_.forward(Request_,Response_);

    }
    private static BigInteger Parameter(String Name,HttpServletRequest Request){
        String Parameter=(String) Request.getParameter(Name);
        return parse(Parameter);

    }
    private static BigInteger parse(String IN)
    {
        if (IN==null)
        {
            return null;
        }
        Matcher match= NumbPattern.matcher(IN);
        if (match.matches()){
            return new BigInteger(IN);
        }
        return null;

    }


}

