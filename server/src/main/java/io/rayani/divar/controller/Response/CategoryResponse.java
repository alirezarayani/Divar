package io.rayani.divar.controller.Response;

import io.rayani.divar.entity.Category;

public class CategoryResponse {
    private Long id;
    private String categoryName;
    private String pic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
