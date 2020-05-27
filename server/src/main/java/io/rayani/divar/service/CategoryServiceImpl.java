package io.rayani.divar.service;

import io.rayani.divar.controller.Response.CategoryResponse;
import io.rayani.divar.entity.Category;
import io.rayani.divar.exception.NotfoundException;
import io.rayani.divar.reposiory.CategoryRepository;
import io.rayani.divar.util.ConvertDtoAndEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER= LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;
    private final ConvertDtoAndEntity convertDtoAndEntity;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ConvertDtoAndEntity convertDtoAndEntity) {
        this.categoryRepository = categoryRepository;
        this.convertDtoAndEntity = convertDtoAndEntity;
    }

    public List<CategoryResponse> getAllCategories() {
        LOGGER.info("Inside getAllCategories() ");
        List<Category> categoriesList = categoryRepository.findAll();
        LOGGER.info("Fetching categories " +categoriesList);
        //Convert entity to dto used stream api
        List<CategoryResponse> CategoryResponseList = categoriesList.stream().map(category -> {
            return (CategoryResponse) convertDtoAndEntity.convertEntityDto(category, new CategoryResponse());
        }).collect(Collectors.toList());
        return  CategoryResponseList;
    }

    public CategoryResponse getCategoryById(Long id) throws NotfoundException {
        LOGGER.info("Inside getAllCategories() ");
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> {
            LOGGER.info("Inside getAllCategories() ,this id doesn't exist => "+id);
            return new NotfoundException("This id doesn't exist =>"+id);
        });
        LOGGER.info("Fetching category for id: " +id);
        //Convert entity to dto
        CategoryResponse categoryResponse=(CategoryResponse)convertDtoAndEntity.convertEntityDto(category,new CategoryResponse());
        return categoryResponse;
    }
}
