import { Component, OnInit } from '@angular/core';

import { Category } from 'src/app/common/category';

import { isGeneratedFile } from '@angular/compiler/src/aot/util';
import { CategoryService } from '../category.service';
import { ActivatedRoute } from '@angular/router';
import { promise } from 'protractor';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Category[];
  url:string;
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
  
}
