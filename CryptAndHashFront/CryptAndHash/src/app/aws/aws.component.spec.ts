import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AWSComponent } from './aws.component';

describe('AWSComponent', () => {
  let component: AWSComponent;
  let fixture: ComponentFixture<AWSComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AWSComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AWSComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
