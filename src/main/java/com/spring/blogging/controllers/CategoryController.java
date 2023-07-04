package com.spring.blogging.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blogging.dtos.CategoryDto;
import com.spring.blogging.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save")
	public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto savedCategory = this.categoryService.save(categoryDto);
		return new ResponseEntity<CategoryDto>(savedCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id){
		CategoryDto categoDto = this.categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(categoDto, HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDto>> getallCategory(){
		List<CategoryDto> categories = this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable int id){
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		this.categoryService.deleteCategoryById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	

}
