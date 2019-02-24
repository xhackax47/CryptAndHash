import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CryptageComponent } from './cryptage.component';

describe('CryptageComponent', () => {
  let component: CryptageComponent;
  let fixture: ComponentFixture<CryptageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CryptageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CryptageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
