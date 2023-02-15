import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenedorFormularioComponent } from './contenedor-formulario.component';

describe('ContenedorFormularioComponent', () => {
  let component: ContenedorFormularioComponent;
  let fixture: ComponentFixture<ContenedorFormularioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContenedorFormularioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContenedorFormularioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
