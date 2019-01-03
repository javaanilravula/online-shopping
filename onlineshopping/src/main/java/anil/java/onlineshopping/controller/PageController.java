package anil.java.onlineshopping.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import anil.java.shoppingbackend.dao.CategoryDAO;
import anil.java.shoppingbackend.dto.Category;


@Controller
public class PageController {
	@Inject
	private CategoryDAO categoryDao;
	/*@Autowired
	private CategoryDAO categoryDAO;
*/	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "Home");
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	//Method  to load the all products based on category
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDao.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;				
	}	
	
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("page");
		Category category=null;
		category=categoryDao.get(id);
		mv.addObject("tittle", category.getName());
		mv.addObject("categories",categoryDao.list());
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
}
