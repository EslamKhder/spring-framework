import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeLineDetailesComponent } from './time-line-detailes.component';

describe('TimeLineDetailesComponent', () => {
  let component: TimeLineDetailesComponent;
  let fixture: ComponentFixture<TimeLineDetailesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimeLineDetailesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TimeLineDetailesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
