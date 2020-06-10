
import { Client } from './Client';
import { ElectronicService } from '../category/electronic.service';
import { ElectronicDevice } from './electronic-device';

export class PageClient {
    content : ElectronicDevice[];
    totalPages : number;
    totalElements : number;
    last : boolean;
    size : number ;
    first : boolean ;
    sort : string ;
    numberOfElements : number ;
    number:number;
}