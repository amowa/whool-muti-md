package org.sonatype.mavenbook.utils.serlvet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sonatype.mavenbook.utils.Page;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
/*
将位于Control类中 侵入性的分页相关代码: model.addAttribute("pager", page) 移入过滤器。
发现当前的 Url  在配置文件中有匹配是就构造Page对象，并加入到Response中。
继承 DispatcherSerlvet，覆写 render方法，在渲染之前吧 Page 放入ModelAndView里面。
（DispatcherSerlvet变了，要修改Servlet配置）
*/
public class MyDispatcherSerlvet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8108906625422688656L;

	protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {  
	    //Page page = SystemContext.getPage();  
	    Page page = PageContext.getPage();  
	    if ( page != null ){  
	        //mv.addObject( "page", page);  
	        mv.addObject( "pager", page);  
	    }  
	    super.render(mv, request, response);  
	}  
	
}
