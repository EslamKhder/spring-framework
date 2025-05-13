import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeAboutComponent } from './time-about.component';

describe('TimeAboutComponent', () => {
  let component: TimeAboutComponent;
  let fixture: ComponentFixture<TimeAboutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimeAboutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TimeAboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
