import { Component, OnInit } from '@angular/core';
import { ProvinceService } from '../services/province.service';
import { Province } from '../province';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from '../user';
import { RegisterService } from '../services/register.service';
import { promise } from 'protractor';
import { Observable, of } from 'rxjs';
import { strict, rejects } from 'assert';
import { resolve } from 'dns';
import { variable } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  provinces: Array<Province> = new Array<Province>();
  inputForms: FormGroup;
  user: User;
  constructor(private provinceService: ProvinceService,
    private registerService: RegisterService) { }

  ngOnInit(): void {
    this.getProvince();
    this.inputForms = new FormGroup({
      'firstName': new FormControl(null, [Validators.required]),
      'lastName': new FormControl(null, [Validators.required]),
      'email': new FormControl(null, [Validators.email, Validators.required], [this.checkEmail.bind(this)]),
      passwordGroup: new FormGroup({
        'password': new FormControl(null,Validators.required),
        'confirmPassword': new FormControl(null,Validators.required)
      },{validators:this.checkPassword}),
      'province': new FormControl(null, [Validators.required])
    })


  }
  getProvince() {
    this.provinceService.getAllProvinces().subscribe(
      (data) => {
        this.provinces = data;
      }
    )
  }

  //get user
  onSubmit() {
    this.user = new User();
    let province: Province = new Province();
    this.user.firstName = this.inputForms.get('firstName').value;
    this.user.lastName = this.inputForms.get('lastName').value;
    this.user.email = this.inputForms.get('email').value;
    this.user.password = this.inputForms.controls.passwordGroup.get('password').value
    this.user.confirmPassword = this.inputForms.controls.passwordGroup.get('confirmPassword').value;
    this.user.email = this.inputForms.get('email').value;
    province.name = this.inputForms.get('province').value.name;
    province.id = this.inputForms.get('province').value.id;
    this.user.province = province;
    console.log(this.inputForms);
    this.postUser(this.user)
  }
  checkEmail(contorl: FormControl): Promise<any> | Observable<any> {
   
    return new Promise(resolve => {
      this.registerService.EmailIsExists(contorl.value).subscribe(
        user => {
          if (contorl.value.trim() === user.email) {
            resolve ({'emailIsExists': true})
          } else {
            resolve(null);
          }
        }
      );
    })
  }


  checkPassword(contorl:FormControl) : {[key: string]: any} | null {
      const password=contorl.value.password;
      const confirmPassword=contorl.value.confirmPassword;
    
      if(password!==confirmPassword){
        return {"notMatch":true};
      }
    return null;
  }
  postUser(user: User) {
    this.registerService.postUser(this.user)
  }



}
