package Project7;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet("/date")
public final class Date extends HttpServlet {

	private static final DateFormat DateF= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final String Date = "date";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter write = response.getWriter();
		write.write("{ \"" + Date + "\": \"" + getDate() + "\" }");
		write.close();
	}

	private static String getDate() {
		Date date = new Date();
		return DateF.format(date);
	}
}