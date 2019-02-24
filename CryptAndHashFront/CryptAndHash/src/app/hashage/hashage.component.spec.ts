import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HashageComponent } from './hashage.component';

describe('HashageComponent', () => {
  let component: HashageComponent;
  let fixture: ComponentFixture<HashageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HashageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HashageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
