package anil.java.shoppingbackend.daoimpl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import anil.java.shoppingbackend.dao.CategoryDAO;
import anil.java.shoppingbackend.dto.Category;

public class CategoryDAOImplTest {
	private static AnnotationConfigApplicationContext context;
	 
	private static CategoryDAO categoryDAO;
	
	private static Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("anil.java.shoppingbackend"); 
	context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testCategory() {
		category=new Category();
		category.setName("Television");
		category.setDescription("this is description for televiosion");
		category.setImageURL("CAT_1.png");
		assertEquals("SuccessFully added a category inside the table", true, categoryDAO.add(category));
		
		
	}*/
	/*@Test
	public void testGetCategory() {
		category=categoryDAO.get(3);
		assertEquals("SuccessFully fetched  a category from the table", "Television", category.getName());
		
		
		
	}*/
	/*@Test
	public void testUpdateCategory() {
		category=categoryDAO.get(3);
		category.setName("TV");
		
		assertEquals("SuccessFully updated  a category to the table", true, categoryDAO.update(category));
		
		
		
	}*/
	/*@Test
	public void testDeleteCategory() {
		category=categoryDAO.get(3);
		
		assertEquals("SuccessFully deleted  a category to the table", true, categoryDAO.delete(category));
		
		
		
	}*/
	/*@Test
	public void testListCategory() {
		category=categoryDAO.get(3);
		
		assertEquals("SuccessFully fetched the categories from the table", 3, categoryDAO.list().size());
		
		
		
	}*/
	@Test
	public void testCrudCategory() {
		category=new Category();
		category.setName("Television");
		category.setDescription("this is description for televiosion");
		category.setImageURL("CAT_1.png");
		assertEquals("SuccessFully added a category inside the table", true, categoryDAO.add(category));
		 
		category=new Category();
		category.setName("Laptop");
		category.setDescription("this is description for Laptop");
		category.setImageURL("CAT_2.png");
		assertEquals("SuccessFully added a category inside the table", true, categoryDAO.add(category));
		
		category=categoryDAO.get(2);
		category.setName("TV");
		
		assertEquals("SuccessFully updated  a category to the table", true, categoryDAO.update(category));
		
		
		assertEquals("SuccessFully deleted  a category to the table", true, categoryDAO.delete(category));
		
		assertEquals("SuccessFully fetched the categories from the table", 1, categoryDAO.list().size());
	}
}
