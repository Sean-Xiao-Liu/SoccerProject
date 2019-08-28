package com.xiao.soccerproject.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "2_logFilter",urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class LogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
