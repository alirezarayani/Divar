import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectronicDeviceComponent } from './electronic-device.component';

describe('ElectronicDeviceComponent', () => {
  let component: ElectronicDeviceComponent;
  let fixture: ComponentFixture<ElectronicDeviceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ElectronicDeviceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ElectronicDeviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
