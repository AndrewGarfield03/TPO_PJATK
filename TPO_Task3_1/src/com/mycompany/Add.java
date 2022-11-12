package com.mycompany;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/add")
public class Add extends HttpServlet {
    private static final long serialVersionUID = -2585335197645597110L;
    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final Pattern NUMBER_REGEX = Pattern.compile(NUMBER_PATTERN);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        BigInteger component1 = parameter(request, "component1");
        BigInteger component2 = parameter(request, "component2");

        PrintWriter out = response.getWriter();
        if (component1 == null || component2 == null) {
            out.println("wrong input parameters");
        } else {
            BigInteger result = component1.add(component2);
            out.println("result: " + result);
        }
        out.close();
    }

    private static BigInteger parameter(HttpServletRequest request, String name) {
        String parameter = request.getParameter(name);
        return parse(parameter);

    }

    private static BigInteger parse(String input) {
        if (input == null) {
            return null;
        }
        Matcher matcher = NUMBER_REGEX.matcher(input);
        if (!matcher.matches()) {
            return null;
        }
        return new BigInteger(input);
    }

}
