package com.mycompany;


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
    private static final long serialVersionUID = -2585335197645597110L;
    private static final String OPERAND1 = "operand1";
    private static final String OPERAND2 = "operand2";
    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final Pattern NUMBER_REGEX = Pattern.compile(NUMBER_PATTERN);

    private static BigInteger value(String input) {
        Matcher matcher = NUMBER_REGEX.matcher(input);
        if (!matcher.matches()) {
            return null;
        }
        return new BigInteger(input);
    }

    private final Logic _logic;

    public Controller() {
        this._logic = new Logic();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // extract logical data from incoming request
        BigInteger operand1 = value(request.getParameter(OPERAND1));
        BigInteger operand2 = value(request.getParameter(OPERAND2));
        //calling the logic which may run complex processing
        LogicCall call = new LogicCall(operand1, operand2);
        Model model = this._logic.add(call);

        //pass the model to view (we can either pass attributes or session)
        request.setAttribute("MODEL", model);
        HttpSession session = request.getSession();
        session.setAttribute("MODEL", model);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/result");

        //pass modified request and responce to view
        dispatcher.forward(request, response);
    }

}
