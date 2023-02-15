import { Component } from '@angular/core';
import { BoredapiService } from '../../services/api/boredapi.service'

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent {
  constructor(private bordeapiService: BoredapiService) { }
  
  getActividad() {
    this.bordeapiService.getActivity().subscribe(activity => {
      console.log(activity);

    }), (err: any) => {
      window.alert('error al obtener actividad');
    };
  }
}
