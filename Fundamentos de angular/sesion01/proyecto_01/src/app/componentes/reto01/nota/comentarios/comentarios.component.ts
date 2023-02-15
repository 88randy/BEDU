import { Component } from '@angular/core';

@Component({
  selector: 'app-comentarios',
  templateUrl: './comentarios.component.html',
  styleUrls: ['./comentarios.component.scss']
})
export class ComentariosComponent {
  valor = "";
  comentarios: string[] = [];
  
  guardaComentario(): void{
    this.comentarios.push(this.valor);
    this.valor = "";
  }
}
