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
import {ReactiveFormsModule} from '@angular/forms';
import { AuthenticationModule } from './authentication/authentication.module';

const route: Routes = [
  {
    path: "", component: HomeComponent, children: [{
      path: "electronic-devices", component: ElectronicDeviceComponent
    }]
  },

]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CategoryComponent,
    NavComponent,
    ElectronicDeviceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    AuthenticationModule,
    RouterModule.forRoot(route)
  ],
  providers: [CategoryService, ElectronicService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
