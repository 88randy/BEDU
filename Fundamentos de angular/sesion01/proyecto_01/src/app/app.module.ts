import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ContenedorFormularioComponent } from './componentes/contenedor-formulario/contenedor-formulario.component';
import { InputStringComponent } from './componentes/input-string/input-string.component';
import { HeaderComponent } from './componentes/reto01/web/header/header.component';
import { BodyComponent } from './componentes/reto01/web/body/body.component';
import { FooterComponent } from './componentes/reto01/web/footer/footer.component';
import { TituloComponent } from './componentes/reto01/nota/titulo/titulo.component';
import { AutorComponent } from './componentes/reto01/nota/autor/autor.component';
import { ContenedorNotaComponent } from './componentes/reto01/nota/contenedor-nota/contenedor-nota.component';
import { IntroduccionComponent } from './componentes/reto01/nota/introduccion/introduccion.component';
import { ImagenesComponent } from './componentes/reto01/nota/imagenes/imagenes.component';
import { ConclusionesComponent } from './componentes/reto01/nota/conclusiones/conclusiones.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { ComentariosComponent } from './componentes/reto01/nota/comentarios/comentarios.component';

@NgModule({
  declarations: [
    AppComponent,
    ContenedorFormularioComponent,
    InputStringComponent,
    HeaderComponent,
    BodyComponent,
    FooterComponent,
    TituloComponent,
    AutorComponent,
    ContenedorNotaComponent,
    IntroduccionComponent,
    ImagenesComponent,
    ConclusionesComponent,
    ComentariosComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
