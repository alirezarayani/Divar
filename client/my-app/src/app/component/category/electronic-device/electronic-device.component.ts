import { Component, OnInit } from '@angular/core';
import { ElectronicDevice } from 'src/app/common/electronic-device';
import {CategoryService} from  'src/app/services/category/category.service';



@Component({
  selector: 'app-electronic-device',
  templateUrl: './electronic-device.component.html',
  styleUrls: ['./electronic-device.component.css']
})
export class ElectronicDeviceComponent implements OnInit {
  electronics:ElectronicDevice[];
  constructor(private CategoryService:CategoryService) { }

  ngOnInit(): void {
    this.getElectronic();
  }
  getElectronic(){
    this.CategoryService.getEelectronicDevive().subscribe(
      (data)=>{
        this.electronics = data;
        console.log(this.electronics);
      }
    )
  }
}
