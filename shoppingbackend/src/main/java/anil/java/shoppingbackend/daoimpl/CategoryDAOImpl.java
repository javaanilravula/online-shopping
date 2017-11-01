package anil.java.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import anil.java.shoppingbackend.dao.CategoryDAO;
import anil.java.shoppingbackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements  CategoryDAO {
	private static List<Category> categories=new ArrayList<>();
	static{
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("desc  for tv");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("desc  for Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("desc  for Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}
	

	@Override
	public List<Category> list() {
		
		return categories;
	}


	@Override
	public Category get(int id) {
		//for loop
		for(Category category:categories) {
			if(category.getId()==id) return category;
		}
		return null;
	}

}
