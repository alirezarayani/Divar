import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, ControlContainer, Validators } from '@angular/forms';
import { User } from '../user';
import { RegisterService } from '../services/register.service';
import { promise } from 'protractor';
import { Observable } from 'rxjs';
import { variable, IfStmt } from '@angular/compiler/src/output/output_ast';
import { LOADIPHLPAPI } from 'dns';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  inputForms: FormGroup;
  user: User;
  constructor(private registerService: RegisterService) { }

  ngOnInit(): void {
    this.inputForms = new FormGroup({
      'email': new FormControl(null, [Validators.required], [this.checkEmail.bind(this)]),
      "password": new FormControl(null)
    })
    console.log(this.inputForms);

  }
  login() {
    this.user = new User();
    this.user.email = this.inputForms.get('email').value;
    this.user.password = this.inputForms.get('password').value;
  }

  checkEmail(control: FormControl): Promise<any> | Observable<any> {
    return new Promise(resovle => {
      this.registerService.EmailIsExists(control.value).subscribe(user => {

        if (user.email === control.value) {
          resovle(null);
        } resovle({ "EmailIsExists": true });
      })
    })
    return null;
  }
  

  validate() {
    const password = this.inputForms.get('password').value;
    const email = this.inputForms.get('email').value;
    let checkUser: User;
    console.log(email);
    console.log(password);
    
    
    if(email != null && email !=undefined && password != null && password !=undefined){
     
    this.registerService.EmailIsExists(email).subscribe(user => {
      console.log("user.email");
      console.log(user.email);
      console.log("user.password");
      console.log(user.password);
      if (user.email === email && user.password === password) {
        console.log("here");
        
        return false;
      }
      console.log("there");
      return true
    })}

    
   }
}
