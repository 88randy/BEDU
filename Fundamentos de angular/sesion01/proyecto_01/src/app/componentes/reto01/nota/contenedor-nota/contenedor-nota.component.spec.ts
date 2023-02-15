import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenedorNotaComponent } from './contenedor-nota.component';

describe('ContenedorNotaComponent', () => {
  let component: ContenedorNotaComponent;
  let fixture: ComponentFixture<ContenedorNotaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContenedorNotaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContenedorNotaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
