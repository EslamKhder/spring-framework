import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoolImagesComponent } from './cool-images.component';

describe('CoolImagesComponent', () => {
  let component: CoolImagesComponent;
  let fixture: ComponentFixture<CoolImagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoolImagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoolImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
