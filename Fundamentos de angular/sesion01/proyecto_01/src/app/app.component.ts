import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})

export class AppComponent {

  constructor() {
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
  }
  
}
