package com.mycompany;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@WebServlet("/regex")
public class RegexServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String result = "";

        String regexp = request.getParameter("component1");
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regexp);
        } catch (PatternSyntaxException e) {
            result = "The entered pattern is not compatible with Java regular expression syntax.";
        }

        if (result.isEmpty()) {
            String val = request.getParameter("component2");

            Matcher matcher = pattern.matcher(val);

            while (matcher.find()) {
                result += (" " + matcher.group() + " (start index: " + matcher.start() + ", end index: " + matcher.end() + ")" );
            }
            if (result.isEmpty()) {
                result = "No matches have been found.";
            }
        }
        PrintWriter out = response.getWriter();
        out.write("{ \"" + "regex" + "\": \"" + result + "\"}");
        out.close();
    }
}
