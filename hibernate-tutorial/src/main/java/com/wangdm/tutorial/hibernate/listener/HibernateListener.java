package com.wangdm.tutorial.hibernate.listener;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Application Lifecycle Listener implementation class HibernateListener
 *
 */
@WebListener
public class HibernateListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, HttpSessionIdListener, ServletRequestListener, ServletRequestAttributeListener, AsyncListener {

	private static final Logger logger = LogManager.getLogger(HibernateListener.class);
	
    public HibernateListener() {
    }

    public void onError(AsyncEvent event) throws java.io.IOException { 
    }

    public void onTimeout(AsyncEvent event) throws java.io.IOException { 
    }

    public void onStartAsync(AsyncEvent event) throws java.io.IOException { 
    }

    public void onComplete(AsyncEvent event) throws java.io.IOException { 
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	logger.debug("Servlet context initialized");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	logger.debug("Servlet context destroyed");
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	logger.debug("Context attribute added("+scae.getName()+" = "+scae.getValue()+")");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	logger.debug("Context attribute removed("+scae.getName()+" = "+scae.getValue()+")");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	logger.debug("Context attribute replaced("+scae.getName()+" = "+scae.getValue()+")");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	logger.debug("Servlet session created("+se.getSession()+")");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	logger.debug("Servlet session destroyed("+se.getSession()+")");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	logger.debug("Session attribute added("+se.getName()+" = "+se.getValue()+")");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	logger.debug("Session attribute removed("+se.getName()+" = "+se.getValue()+")");
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	logger.debug("Session attribute replaced("+se.getName()+" = "+se.getValue()+")");
    }

    public void sessionIdChanged(HttpSessionEvent se, String oldSessionId)  { 
    	logger.debug("sessionIdChanged");
    }

    public void sessionWillPassivate(HttpSessionEvent se)  { 
    	logger.debug("sessionWillPassivate");
    }

    public void sessionDidActivate(HttpSessionEvent se)  { 
    	logger.debug("sessionDidActivate");
    }

    public void valueBound(HttpSessionBindingEvent event)  { 
    	logger.debug("valueBound");
    }

    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	logger.debug("valueUnbound");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	logger.debug("Servlet request initialized("+sre.getServletRequest().getRemoteAddr()+":"+sre.getServletRequest().getRemotePort()+")");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	logger.debug("Servlet request destroyed("+sre.getServletRequest().getRemoteAddr()+":"+sre.getServletRequest().getRemotePort()+")");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	logger.debug("Servlet request attribute added("+srae.getName()+" = "+srae.getValue()+")");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	logger.debug("Servlet request attribute removed("+srae.getName()+" = "+srae.getValue()+")");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	logger.debug("Servlet request attribute replaced("+srae.getName()+" = "+srae.getValue()+")");
    }
	
}
