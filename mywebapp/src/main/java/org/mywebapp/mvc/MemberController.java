package org.mywebapp.mvc;

 //import javax.validation.Valid;

//import static org.junit.Assert.assertEquals;

//import org.junit.Test;
//import org.mywebapp.domain.Member;
//import org.mywebapp.repo.MemberDao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sonatype.mavenbook.service.LocationService;
import org.sonatype.mavenbook.utils.Page;
import org.sonatype.mavenbook.utils.serlvet.PageContext;
import org.sonatype.mavenbook.weather.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class MemberController
{
    @Autowired
    private LocationService locationService;
    //private MemberDao memberDao;
	
    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedMembers(Model model)
    {
        /*model.addAttribute("newMember", new Member());
        model.addAttribute("members", memberDao.findAllOrderedByName());*/
    	Location loc = locationService.findByZip("10002");
    	
    	model.addAttribute("newMember", loc);
        //model.addAttribute("members", memberDao.findAllOrderedByName());
        return "index";
    }
    
    @RequestMapping("/list")
    public ModelAndView pageList(HttpServletRequest request, HttpServletResponse response, Model model, Page pager){
    	
    	String pagez = request.getParameter("pager");
    	//PageContext.setPage(pager); //wuxg:已迁移到Page->new()方法中.　
    	PageContext.getPage();
    	
    	List<Location> locs = locationService.findAll();
    	
    	//制定视图，也就是list.jsp
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("locations",locs);
        //mav.addObject("pageStr",pageStr);
        //mav.addObject("newMember", loc);
        
        //model.addAttribute("locations",locs);
        //model.addAttribute("members", memberDao.findAllOrderedByName());
        //model.addAttribute("pager", page);             //这里将page返回前台 ,已有MyDispatcherSerlvet实现
        //return "list";
        return mav;
    }
    
/*
    @RequestMapping(method=RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
            memberDao.register(newMember);
            return "redirect:/";
        }
        else {
            model.addAttribute("members", memberDao.findAllOrderedByName());
            return "index";
        }
    }*/
}
