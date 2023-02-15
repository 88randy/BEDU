import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InfoUsuarioComponent } from './info-usuario/info-usuario.component';



@NgModule({
  declarations: [
    InfoUsuarioComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    InfoUsuarioComponent
  ]
})
export class UsuariosModule { }
