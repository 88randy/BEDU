import { Component, OnInit } from '@angular/core';
import { UsuarioService } from './services/usuario.service';
import { UsuarioModelo } from './models/usuario.modelo';
import { LocalStorageServiceService } from './services/local-storage.service';
import { BeersService } from './services/api/beers.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'ejemplo';
  
  public usuario!: UsuarioModelo;
  public beerData: any;

  constructor(private usuarioService: UsuarioService,
    private localStorageService: LocalStorageServiceService,
    private beerService: BeersService){

  }

  ngOnInit(): void {
    /* Ejemplo 1 */
    /* this.usuarioService.setUsuario({nombre:"pepito", edad:18, curso:"Java"});
    this.usuario = this.usuarioService.getUsuario(); */
    
    /* Reto 1 */
    /* this.localStorageService.almacenar("Nombre", "Juan");
    this.localStorageService.almacenar("Edad", 25);
    this.localStorageService.almacenar("Curso", "React");
    
    console.log(this.localStorageService.consultarTodo());
    
    console.log(this.localStorageService.consultar("Nombre"),
    this.localStorageService.consultar("Edad"),
    this.localStorageService.consultar("Curso"));

    this.localStorageService.borrar("Edad");
    
    console.log(this.localStorageService.consultarTodo());
    
    this.localStorageService.limpiarTodo();

    console.log(this.localStorageService.consultarTodo()); */
    
    /* Ejemplo 2 */
    this.consulta();
  }

  consulta(): void{
    this.beerService.getBeers().subscribe(res => {
      console.log(res);
      this.beerData = res;
    }, (error: any) =>{
      console.log(error);
    });
  }
  
}
