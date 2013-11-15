package com.akhi.store.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.akhi.store.general.User;

public class GeneralInterceptor implements HandlerInterceptor
    {
    private static org.apache.log4j.Logger log = Logger.getLogger(GeneralInterceptor.class);

    @Override
    public boolean preHandle( HttpServletRequest request,
			      HttpServletResponse response,
			      Object handler ) throws Exception
	{
	HttpSession session = request.getSession();
	if (session.getAttribute("customer") != null)
	    {
	    User user = (User) session.getAttribute("customer");
	    log.warn("User Active................: " + user);
	    if (user.getId() <= 0)
		{
		log.warn("No user found, redirecting to ......................... " + request.getContextPath());
		response.sendRedirect(request.getContextPath());
		}
	    }
	else
	    {
	    log.warn("No user found, redirecting to ......................... " + request.getContextPath());
	    response.sendRedirect(request.getContextPath());
	    }
	return true;
	}

    @Override
    public void postHandle( HttpServletRequest request,
			    HttpServletResponse response,
			    Object handler,
			    ModelAndView modelAndView ) throws Exception
	{
	log.warn("posthandle ....................");
	}

    @Override
    public void afterCompletion( HttpServletRequest request,
				 HttpServletResponse response,
				 Object handler,
				 Exception ex ) throws Exception
	{

	}

    }
