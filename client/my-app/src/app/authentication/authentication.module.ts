import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { ProvinceService } from './services/province.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


const route:Routes=[
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent}
]

@NgModule({
  declarations: [LoginComponent, RegisterComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(route)
  ],
  exports:[LoginComponent,
    RouterModule
  ],
  providers:[ProvinceService]
})
export class AuthenticationModule { }
