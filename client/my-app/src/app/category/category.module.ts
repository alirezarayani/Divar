import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryComponent } from './category/category.component';
import { ElectronicDeviceComponent } from './electronic-device/electronic-device.component';
import { CategoryService } from './category.service';
import { ElectronicService } from './electronic.service';
import { RouterModule } from '@angular/router';
import { VehiclesComponent } from './vehicles/vehicles.component';
import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  declarations: [CategoryComponent,ElectronicDeviceComponent, VehiclesComponent],
  imports: [
    CommonModule,RouterModule,NgbPaginationModule
  ],
  exports: [
    CategoryComponent,
    ElectronicDeviceComponent,
    
  ],
  providers:[CategoryService,ElectronicService],


})
export class CategoryModule { }
