package com.akhi.store.listener;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.akhi.store.dao.LoggerDao;
import com.akhi.store.general.ProductServiceLog;

public class LoggingInterceptor implements HandlerInterceptor
    {
    private static org.apache.log4j.Logger log	   = Logger.getLogger(LoggingInterceptor.class);

    private static ThreadLocal<Long>       transactionId = new ThreadLocal<Long>()
							     {

								 @Override
								 protected Long initialValue()
								     {

								     return System.currentTimeMillis();
								     }

							     };

    @Inject
    private LoggerDao		      dao;

    @Override
    public boolean preHandle( HttpServletRequest request,
			      HttpServletResponse response,
			      Object handler ) throws Exception
	{

	log.info("LoggingInterceptor: prehandle......................................." + transactionId.get() + " DAO i have " + dao);
	return true;
	}

    @Override
    @Transactional()
    public void postHandle( HttpServletRequest request,
			    HttpServletResponse response,
			    Object handler,
			    ModelAndView modelAndView ) throws Exception
	{
	ProductServiceLog transaction = new ProductServiceLog();
	transaction.setClassName(getClass().getCanonicalName());
	transaction.setThreadName(Thread.currentThread().getName());
	transaction.setExecutionTime(System.currentTimeMillis() - transactionId.get());
	log.info("LoggingInterceptor: postHandle........................................." + transactionId.get() + " transaction: " + transaction);
	dao.makePersistent(transaction);
	}

    @Override
    public void afterCompletion( HttpServletRequest request,
				 HttpServletResponse response,
				 Object handler,
				 Exception ex ) throws Exception
	{

	log.debug("LoggingInterceptor: afterCompletion........................................." + transactionId);

	}

    }
