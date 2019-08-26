package com.xiao.soccerproject.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import javax.servlet.*;
import java.io.IOException;


@WebFilter(filterName = "securityFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class SecurityFilter implements Filter {


    private Logger logger = LoggerFactory.getLogger(this.getClass());// get logger
    private static String AUTH_URI = "/auth";

    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,ServletException{
        HttpServletRequest req = (HttpServletRequest)request;

        logger.info("the filter works");
        filterChain.doFilter(request,response);
    }

//    @Override
    public void destory(){

    }
}
