package com.mycompany;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

@WebServlet("/sum")
public class Sum extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String val = request.getParameter("component1");
        BigInteger parameter1 = new BigInteger(val);
        val = request.getParameter("component2");
        BigInteger parameter2 = new BigInteger(val);

        BigInteger sum = parameter1.add(parameter2);

        PrintWriter out = response.getWriter();
        out.write("{ \"" + "sum" + "\": " + sum.toString() + "}");
        out.close();
    }
}