package io.rayani.divar.service;

import io.rayani.divar.controller.Response.CategoryResponse;
import io.rayani.divar.exception.NotfoundException;

import java.util.List;

public interface CategoryService {

    public List<CategoryResponse> getAllCategories() ;

    public CategoryResponse getCategoryById(Long id) throws NotfoundException;

}
