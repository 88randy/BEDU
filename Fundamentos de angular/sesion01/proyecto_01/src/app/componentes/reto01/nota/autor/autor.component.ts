import { Component } from '@angular/core';

@Component({
  selector: 'app-autor',
  templateUrl: './autor.component.html',
  styleUrls: ['./autor.component.scss']
})
export class AutorComponent {
  autor = "Pepito"
  autores : string[] = [" Pepito,", "Juan,", "Pedro"];
}
