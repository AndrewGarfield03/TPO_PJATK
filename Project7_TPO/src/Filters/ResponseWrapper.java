package Filters;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class ResponseWrapper extends HttpServletResponseWrapper {

	private final StringWriter write = new StringWriter();

	public ResponseWrapper(HttpServletResponse response) {
		super(response);
	}
	
	public ResponseWrapper(ServletResponse response) { //
		this((HttpServletResponse)response);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return new PrintWriter(write);
	}

	public ServletOutputStream getOutputStream() throws IOException {
		throw new IllegalStateException("getOutputStream() not allowed for ResponseWrapper");
	}
	
	public String content() { //
		return write.toString();
	}
}