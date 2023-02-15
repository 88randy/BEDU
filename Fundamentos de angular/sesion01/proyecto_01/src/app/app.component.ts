import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})

export class AppComponent {

  mensaje = 'Hola mundo';

  num1 = 5;

  num2 = 3;

  bool = false;

  foo(){
    return 'Hola mundo';
  }

  src = ''
  alt = ''

  efecto(): void{
    console.log("se dio click al botón");
  }

  valor = "Hola"

  super = true;

  lista = ["arroz", "pan", "tortillas", "leche", "atún"]

  condicion1 = true;

  condicion2 = false;

  /* constructor() {
    this.saludo();
    this.imprimeIMC(this.calculaIMC(80, 1.84));
  }

  title = 'proyecto_01';

  foo(par1: string, par2: string): string {
    // Alcance global y reasignable
    var x: number = 20;

    // Alcance de bloque y reasignable
    let y = 'hola';

    // Alcance de bloque y no reasignable
    const z = true;

    x = 95;
    y = 'adios';

    return par1 + par2;
  }

  saludo(): void {
    console.log('Bienvenido!!');
  }

  calculaIMC(peso: number, altura: number) {
    return peso / (altura ^ 2);
  }

  imprimeIMC(imc: number) {
    console.log('tu IMC es: ' + imc);
  } */
  
}
