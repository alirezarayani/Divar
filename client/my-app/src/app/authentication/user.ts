import { Province } from './province';

export class User {
    id:number;
    firstName:string;
    lastName:string;
    email:string;
    password:string;
    confirmPassword:string;
    province:Province;
}
