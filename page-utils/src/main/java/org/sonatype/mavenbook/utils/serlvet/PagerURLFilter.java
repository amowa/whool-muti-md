/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sonatype.mavenbook.utils.serlvet;

import java.io.*;
//import java.net.*;
import java.util.*;
//import java.text.*;
//import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.sonatype.mavenbook.utils.Page;

/**
 *
 * @author M083256
 */
public class PagerURLFilter implements Filter {

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public PagerURLFilter() {
    }

    
    @SuppressWarnings("unused")
	private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoBeforeProcessing");
            //
            // Write code here to process the request and/or response before
            // the rest of the filter chain is invoked.
            //

            //
            // For example, a logging filter might log items on the request object,
            // such as the parameters.
            //
	/*
            for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
            String name = (String)en.nextElement();
            String values[] = request.getParameterValues(name);
            int n = values.length;
            StringBuffer buf = new StringBuffer();
            buf.append(name);
            buf.append("=");
            for(int i=0; i < n; i++) {
            buf.append(values[i]);
            if (i < n-1)
            buf.append(",");
            }
            log(buf.toString());
            }
             */
            

            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            ServletContext appCxt = session.getServletContext();
            Object pager_pros = appCxt.getAttribute("PAGER_URLS");
            if(pager_pros == null){
    			//查询url 配置文件，当前访问url在配置表中则生成Pager实例。
    			//读取web.xml中的当前这个Servlet的初始化参数
    			//config.getServletContext().getInitParameterNames();
            	
            	String pagerConfigFile = filterConfig.getInitParameter("pagerConfigLocation"); 
    			//String pagerConfig = getServletConfig().getInitParameter("pagerConfigLocation");
    			
    			InputStream in;
    	        try {
    	        	//in = new BufferedInputStream (new FileInputStream(pagerConfig));
    	        	in = appCxt.getResourceAsStream(pagerConfigFile);
    	        	Properties pros = new Properties();
    	        	//pros.load(in);
    	        	pros.loadFromXML(in); //pros.storeToXML(fos, null);
    	            in.close();
    	            pager_pros = pros;
    	            appCxt.setAttribute("PAGER_URLS", pros);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    		}
            
        }
    }

    @SuppressWarnings("unused")
	private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoAfterProcessing");
            //
            // Write code here to process the request and/or response after
            // the rest of the filter chain is invoked.
            //
            //
            // For example, a logging filter might log the attributes on the
            // request object after the request has been processed.
            //
	/*
            for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
            String name = (String)en.nextElement();
            Object value = request.getAttribute(name);
            log("attribute: " + name + "=" + value.toString());

            }
             */
            //

            //
            // For example, a filter might append something to the response.
            //
	/*
            PrintWriter respOut = new PrintWriter(response.getWriter());
            respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
             */
        }
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	doBeforeProcessing(request, response);
    	
        request.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest) request;
        //HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        //session.setAttribute("SID", session.getId());
        
        ServletContext appCxt = session.getServletContext();
        Object pager_pros = appCxt.getAttribute("PAGER_URLS");
        if(pager_pros != null){
        	//Object pager_pros = config.getServletContext().getAttribute("PAGER_URLS");
			Properties pros = (Properties) pager_pros;
			String curr_urlpage = req.getServletPath();
			//req.getRequestURI();req.getContextPath();req.getRequestURL();
			if(pros.containsKey(curr_urlpage)){
				//替换{0}，可以使用MessageFormat，
				//MessageFormat.format((String)pros.get("welcome"), "snowolf"); //welcome=欢迎您，{0}！  ,欢迎您，snowolf！
				if(PageContext.getPage()==null)
					PageContext.setPage(Page.newBuilder(1, Integer.valueOf(Page.DEFAULT_PAGESIZE), "")); 
				else if(req.getParameter("pageNo") != null)
					PageContext.setPage(Page.newBuilder(Integer.valueOf(req.getParameter("pageNo")), Integer.valueOf(req.getParameter("pageSize")), "")); 
				else 
					PageContext.setPage(Page.newBuilder(1, Integer.valueOf(Page.DEFAULT_PAGESIZE), "")); 
		    	//PageContext.getPage();
			}
		}  
        
        chain.doFilter(request, response);
        /*
        String urlpage = req.getRequestURI();
      //  System.out.println("SID=" + session.getId() + " : " + urlpage);
        if (session.getAttribute("USER_ID") != null || urlpage.indexOf("/UserLogin") >= 0) {
            chain.doFilter(request, response);
        } else {
            System.out.println(urlpage);
            if (urlpage.indexOf("/Public") >= 0) {
                session.setAttribute("LOGIN_BACK", urlpage);
            }
            res.sendRedirect(req.getContextPath() + "/UserLogin/Login.html");
        }*/
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {

        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter 
     *
     */
    public void destroy() {
    }

    /**
     * Init method for this filter 
     *
     */
    public void init(FilterConfig filterConfig) {

        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("LoginFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    public String toString() {

        if (filterConfig == null) {
            return ("LoginFilter()");
        }
        StringBuffer sb = new StringBuffer("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());

    }

    @SuppressWarnings("unused")
	private void sendProcessingError(Throwable t, ServletResponse response) {

        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {

            try {

                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N

                pw.close();
                ps.close();
                response.getOutputStream().close();
                ;
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
                ;
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {

        String stackTrace = null;

        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
    private static final boolean debug = true;
}
