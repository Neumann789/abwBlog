package com.abw.boot;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 解决跨域问题
 */
public class WebFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse rsp = (HttpServletResponse) response;
        rsp.setHeader("Access-Control-Allow-Origin", "*");
        rsp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        rsp.setHeader("Access-Control-Max-Age", "3600");
        rsp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        chain.doFilter(request, rsp);



    }

    @Override
    public void destroy() {
    }
}
