package Filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "header", urlPatterns = { "*.html", "*.servlet", "/*" })
public class Header implements Filter {
    private static final String Header_Script = "<html><head>" //
         + "<script src=\"scripts/index.js\"></script>" //
           + "</head><body>";

    private static final String Header = "<br>Header</br>";

    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest _Request, ServletResponse _Response, FilterChain chain)
            throws IOException, ServletException {
        PrintWriter write = _Response.getWriter();
       // write.write(Header_Script);
        write.write(Header);
        chain.doFilter(_Request, _Response);
    }

}
