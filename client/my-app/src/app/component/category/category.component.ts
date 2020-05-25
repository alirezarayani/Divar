import { Component, OnInit } from '@angular/core';

import { Category } from 'src/app/common/category';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Category[];
  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.listCategories();
  }
  listCategories(){
    this.categoryService.getCategoies().subscribe(
      (data)=> {
         console.log(data);
        this.categories=data;
      }
    )
  }
  
}
