import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private http: HttpClient) { }

  saveToken(token: string) {
    localStorage.setItem('token', token);
  }

  login(username: string, password: string) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
  
    const payload = {
      username: username,
      password: password
    };
  
    return this.http.post('http://localhost:8080/api/login', payload, { headers })
      .pipe(
        tap((response) => {
          this.saveToken(response.token);
        }),
        catchError((error) => {
          console.error(error);
          return throwError(error);
        })
      );
  }


  get(url: string) {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });

    return this.http.get(url, { headers });
  }

}

function throwError(error: any): any {
  throw new Error('Function not implemented.');
}

