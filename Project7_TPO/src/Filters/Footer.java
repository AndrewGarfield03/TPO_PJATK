package Filters;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName = "footer", urlPatterns = { "*.html", "*.servlet", "/*" })
public final class Footer implements Filter {
    private static final String Footer_Date = //
            "<div id=\"date\"></div>" //
                    + "</body></html>";

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
    public void doFilter(ServletRequest _Request, ServletResponse _Response, FilterChain chain)
            throws IOException, ServletException {
       ResponseWrapper Wrapper_Response = new ResponseWrapper(_Response);
        chain.doFilter(_Request, Wrapper_Response);
        Add_Generated_Response(_Response, Wrapper_Response);
        Add_the_Footer(_Request,_Response);

    }

    private void Add_Generated_Response(ServletResponse _Response, ResponseWrapper Wrapper_Response)
            throws IOException {
        String wrContent = Wrapper_Response.content();
        PrintWriter _ResponseWriter = _Response.getWriter();
        _ResponseWriter.print(wrContent);
    }

    private void Add_the_Footer(ServletRequest _Request, ServletResponse _Response) throws IOException {
        PrintWriter write = _Response.getWriter();
        Locale l = _Request.getLocale();
        DateFormat dateF = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.MEDIUM, l);
        write.println("<br>");
        write.println("Footer: (" + dateF.format(new Date()) + ")");
        //write.println(Footer_Date);
        write.close();
    }
}
