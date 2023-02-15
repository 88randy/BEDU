import { Component } from '@angular/core';
import { BoredapiService } from '../../services/api/boredapi.service'

@Component({
  selector: 'app-gender',
  templateUrl: './gender.component.html',
  styleUrls: ['./gender.component.css']
})
export class GenderComponent {
  nombre: string = '';
  constructor(private boredapiService:BoredapiService) { }

  getTipoGenero() {
    this.boredapiService.getGender(this.nombre).subscribe(gender => {
      console.log(gender);
    }), (err: any) => {
      window.alert('error al consultar datos');
    };
  }
}
