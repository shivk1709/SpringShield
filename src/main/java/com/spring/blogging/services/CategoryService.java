package com.spring.blogging.services;

import java.util.List;
import com.spring.blogging.dtos.CategoryDto;

public interface CategoryService {
	
	public CategoryDto save(CategoryDto categoryDto);
	public List<CategoryDto> getAllCategory();
	public CategoryDto getCategoryById(int id);
	public CategoryDto updateCategory(CategoryDto categoryDto, int id);
	public void deleteCategoryById(int id);

}
