import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class BeersService {

  constructor(private httpClient: HttpClient) { }

  url = 'https://api.sampleapis.com/beers/ale';

  getBeers(){
    return this.httpClient.get(this.url);
  }
}
