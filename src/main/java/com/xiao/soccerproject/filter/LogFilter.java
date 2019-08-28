package com.xiao.soccerproject.filter;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebFilter(filterName = "2_logFilter",urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class LogFilter implements Filter { // have to override doFilter method since Filter is implemented

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final List<String> excludedWords = Arrays.asList("newPasswd","confirmPasswd","passed","password");

    /*
    * https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
    * SimpleDateFormat is a concrete class for formatting and parsing dates in a locale-sensitive manner.
    * It allows for formatting (date -> text), parsing (text -> date), and normalization.
    * Date and Time Patterns are available through the url link
    * */

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// example 2001-07-04 12:08:56.235

    @Override
    public void init(FilterConfig filterConfig){
        // TODO Auto Generated method stub
        /*
        * It means that your IDE (or some other tool) has automatically generated a method for you,
        * but has left the body blank to be filled in by you (this is known as a "stub").
        * */
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,ServletException {
        long startTime = System.currentTimeMillis();
        HttpServletRequest req = (HttpServletRequest) request;
        String logInfo = logInfo(req);// the logInfo method will be defined later
        logger.info(logInfo.replace("responseTime", String.valueOf(System.currentTimeMillis() - startTime)));
        filterChain.doFilter(request, response);
    }


    public void destroy(){
        // TODO Auto Generated method stub
    }

    public boolean isIgnoredWord(String word, List<String> excludedWords){
        for (String excludedWord : excludedWords){
            if (word.toLowerCase().contains(excludedWord)) return true;
        }
        return false;
    }

    private String logInfo(HttpServletRequest req){
        String formDate = null;
        String httpMethod = req.getMethod();

        Date startDateTime = new Date();
        String requestURL = req.getRequestURI();
        String userIP = req.getRemoteHost();
        String sessionID = req.getSession().getId();
        Enumeration<String> parameterName = req.getParameterNames();
        List<String> parameters = new ArrayList<>();

        while (parameterName.hasMoreElements()){
            String paramName = parameterName.nextElement();
            if(isIgnoredWord(paramName, excludedWords)) continue;

            String paramValues = Arrays.asList(req.getParameterValues(paramName)).toString();
            parameters.add(paramName + "-" + paramValues);
        }

        if(!parameters.isEmpty()){
            formDate = parameters.toString().replaceAll("^.|.$","");
        }

        return new StringBuilder("| ")
                .append(formatter.format(startDateTime)).append(" | ")
                .append(userIP).append(" | ")
                .append(httpMethod).append(" | ")
                .append(requestURL).append(" | ")
                .append(sessionID).append(" | ")
                .append("responseTime").append(" | ")
                .append(formDate).toString();


    }

}
