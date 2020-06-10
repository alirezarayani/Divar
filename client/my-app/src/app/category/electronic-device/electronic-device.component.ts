import { Component, OnInit } from '@angular/core';
import { ElectronicDevice } from 'src/app/common/electronic-device';
import { CategoryService } from '../category.service'
import { PageClient } from 'src/app/common/PageClient';
import { ElectronicService } from '../electronic.service';




@Component({
  selector: 'app-electronic-device',
  templateUrl: './electronic-device.component.html',
  styleUrls: ['./electronic-device.component.css']
})
export class ElectronicDeviceComponent implements OnInit {
  electronics: ElectronicDevice[] = [];
  // pageClient:PageClient;
  // selectedPage:number = 0;
  thePageNumber: number=1;
  thePageSize: number =5;
  theTotalElements: number
  theFirst: boolean = true;
  theLast: boolean = false;
  totalPages: number;
  page = 4;
  constructor(private electronicService: ElectronicService) { }

  ngOnInit(): void {
    this.getElectronic();
  }
  // getElectronic(page:number){
  //   this.electronicService.getElectronicDevices(page).subscribe(
  //     (page)=>{
  //       this.pageClient = page;
  //     }
  //   )
  // }
  // onSelect(page: number): void {
  //   this.selectedPage = page;
  //   this.getElectronic(page);
  // }
  getElectronic() {
    this.electronicService.getElectronicListPaginate(this.thePageNumber - 1, this.thePageSize).subscribe(this.processResult());
  }
  processResult() {
    return data => {
      console.log(data);
      
      this.electronics = data.content;
      this.thePageNumber = data.number + 1;
      this.thePageSize = data.size;
      this.theTotalElements=data.totalElements;
      this.totalPages=data.totalPages;
      this.theFirst=data.first;
      this.theLast=data.last;
    }
  }
  updatePageSize(pageSize:number){
    this.thePageSize=pageSize;
    this.getElectronic();
  }
}
