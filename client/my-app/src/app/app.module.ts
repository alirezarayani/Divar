import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { NavComponent } from './component/nav/nav.component';
import { ElectronicDeviceComponent } from './category/electronic-device/electronic-device.component';
import { AuthenticationModule } from './authentication/authentication.module';
import { ClientsComponent } from './component/clients/clients.component';
import { CategoryModule } from './category/category.module';

const route: Routes = [
  {
    path: "", component: HomeComponent, children: [{
      path: "electronic-devices", component: ElectronicDeviceComponent
    },
      //  {path: "vehicles", component: VehiclesComponent},
    ]
  },

]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    ClientsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CategoryModule,
    AuthenticationModule,
    RouterModule.forRoot(route),
  ],
  providers: [,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
