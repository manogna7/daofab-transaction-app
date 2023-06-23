import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParentTransactionComponent } from './parent-transaction.component';

describe('ParentTransactionComponent', () => {
  let component: ParentTransactionComponent;
  let fixture: ComponentFixture<ParentTransactionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ParentTransactionComponent]
    });
    fixture = TestBed.createComponent(ParentTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
