import { Component } from '@angular/core';

@Component({
  selector: 'app-imagenes',
  templateUrl: './imagenes.component.html',
  styleUrls: ['./imagenes.component.scss']
})
export class ImagenesComponent {
  img1 = "https://cdn.forbes.com.mx/2015/05/fuentes-reuters22.jpg";
  img2 = "https://www.biografiasyvidas.com/biografia/f/fotos/fuentes_carlos.jpg";
  src = this.img1;
  alt = "Carlos Fuentes";
  
  

  cambiarImagen():void{
    if (this.src == this.img1) {
      this.src = this.img2;
    }else{
      this.src = this.img1;
    }
  }
  
}
