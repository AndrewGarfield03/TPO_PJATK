package com.mycompany;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public final class View extends HttpServlet {

    private static final long serialVersionUID = -2585335197645597110L;


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //extract model from request cuz it  passed by controller
        Model attributeModel = (Model)request.getAttribute("MODEL");
        HttpSession session = request.getSession();
        Model sessionModel = (Model)session.getAttribute("MODEL");

        if(attributeModel == null || sessionModel == null ){
            String message  = String.format("%s%s" , request.getContextPath(), request.getServletPath());
            response.sendError(400, message);
            return;
        }
        //generate a message
        PrintWriter writer = response.getWriter();
        writer.println("Attribute result: " + attributeModel.getResult());
        writer.println("Session result: " + sessionModel.getResult());
        writer.close();
    }

}