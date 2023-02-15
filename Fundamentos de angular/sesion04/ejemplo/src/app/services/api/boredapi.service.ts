import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ActivityModel, GenderModel } from '../../models/activity.model';

@Injectable({
  providedIn: 'root'
})
export class BoredapiService {

  constructor(private httpClient: HttpClient) { }

  getActivity(): Observable<ActivityModel> {
    return this.httpClient.get<ActivityModel>('https://www.boredapi.com/api/activity');
  }

  getGender(name: string): Observable<GenderModel> {
    return this.httpClient.get<GenderModel>(`https://api.genderize.io?name=${name}`);
  }
}
