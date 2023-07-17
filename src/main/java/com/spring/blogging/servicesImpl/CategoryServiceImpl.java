package com.spring.blogging.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.blogging.beans.Category;
import com.spring.blogging.daos.CategoryDao;
import com.spring.blogging.dtos.CategoryDto;
import com.spring.blogging.exceptions.ResourceNotFoundException;
import com.spring.blogging.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category categoryDtoToBean = this.modelMapper.map(categoryDto, Category.class);
		return this.modelMapper.map(this.categoryDao.save(categoryDtoToBean), CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categories = this.categoryDao.findAll();
		return categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category = this.categoryDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category not Exist ", "with id ",Long.valueOf(id)));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
		// TODO Auto-generated method stub
		Category category = this.categoryDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category not Exist ", "with id ",Long.valueOf(id)));
		category.setCategoryName(categoryDto.getCategoryName());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		return this.modelMapper.map(this.categoryDao.save(category), CategoryDto.class);
	}

	@Override
	public void deleteCategoryById(int id) {
		// TODO Auto-generated method stub
		this.categoryDao.deleteById(id);;
		
	}

}
