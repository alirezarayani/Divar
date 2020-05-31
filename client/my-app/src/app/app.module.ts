import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { NavComponent } from './component/nav/nav.component';
import { ElectronicDeviceComponent } from './component/category/electronic-device/electronic-device.component';
import { CategoryComponent } from './component/category/category.component';
import { CategoryService } from './services/category/category.service';
import { ElectronicService } from './services/electronic/electronic.service';
import { RegisterComponent } from './component/register/register.component';
import { ProvinceService } from './services/province.service';
import {ReactiveFormsModule} from '@angular/forms';
import { UserComponent } from './component/user/user.component';
import { UserService } from './services/user.service';
const route: Routes = [
  {
    path: "", component: HomeComponent, children: [{
      path: "electronic-devices", component: ElectronicDeviceComponent
    }]
  },
  { path: "register", component: RegisterComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CategoryComponent,
    NavComponent,
    ElectronicDeviceComponent,
    RegisterComponent,
    UserComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(route)
  ],
  providers: [CategoryService, ElectronicService, ProvinceService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
