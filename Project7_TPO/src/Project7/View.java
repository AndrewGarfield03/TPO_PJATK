package Project7;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class View extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        Model A_model=(Model)req.getAttribute("MODEL");
        HttpSession Req_session=req.getSession();
        Model S_model=(Model)Req_session.getAttribute("MODEL");
        PrintWriter write=res.getWriter();
        if(A_model!=null && S_model!=null)
        {
            write.println("Attribute Result: "+A_model.Result);
            write.println("Session Result: "+S_model.Result);

        }
        else
        {
           write.println("Error");
        }
        write.close();
    }
}
