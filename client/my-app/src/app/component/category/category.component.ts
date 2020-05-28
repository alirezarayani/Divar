import { Component, OnInit } from '@angular/core';

import { Category } from 'src/app/common/category';
import { CategoryService } from 'src/app/services/category/category.service';
import { isGeneratedFile } from '@angular/compiler/src/aot/util';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Category[];
  constructor(private categoryService:CategoryService) { }
  flagShow:boolean=false;
  ngOnInit(): void {
    this.listCategories();
  }
  listCategories(){
    this.categoryService.getCategoies().subscribe(
      (data)=> {
        
        this.categories=data;
      }
    )
  }
  changeBoolean(){
    if(this.flagShow== false){
      this.flagShow=true
    }else{
      this.flagShow=false;
    }
  }
}
