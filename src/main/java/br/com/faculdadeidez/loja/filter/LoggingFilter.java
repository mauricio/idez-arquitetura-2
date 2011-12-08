package br.com.faculdadeidez.loja.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter implements Filter {

	private static final Logger log = LoggerFactory
			.getLogger(LoggingFilter.class);

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig config) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		try {
			chain.doFilter(request, response);
		} finally {

			HttpServletRequest req = (HttpServletRequest) request;

			StringBuilder builder = new StringBuilder();

			builder.append(String.format("%nRequest: %s %s%n", req.getMethod(), req.getRequestURI()));
			builder.append("Headers:\n");

			for (String header : Collections.list(req.getHeaderNames())) {
				builder.append(String.format("%s: %s%n", header,
						req.getHeader(header)));
			}

			builder.append("Parameters:\n");

			for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
				builder.append(String.format("%s: %s%n", entry.getKey(),
						Arrays.asList(entry.getValue())));
			}

			builder.append("\n");
			log.warn(builder.toString());

		}

	}

}
