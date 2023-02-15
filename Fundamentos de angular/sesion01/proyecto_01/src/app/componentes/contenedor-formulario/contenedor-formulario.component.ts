import { Component, OnInit, AfterViewInit} from '@angular/core';

@Component({
  selector: 'app-contenedor-formulario',
  templateUrl: './contenedor-formulario.component.html',
  styleUrls: ['./contenedor-formulario.component.scss']
})
export class ContenedorFormularioComponent implements OnInit, AfterViewInit{
  
  ngOnInit() : void{
    console.log("hola formulario");
  }

  ngAfterViewInit(): void {
      console.log("Ya estoy visible");
  }
}
