import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})


export class AuthService {
  
  authToken: any;
  user: any;
  
  constructor(private http: HttpClient) { }

  serverUrl = environment.baseUrl;

  loginUser(email, password) {

      let data ={email, password}
    return     fetch(
      `${this.serverUrl}/api/users/login`, // the url you are trying to access
      {
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json'
          },
        method: 'POST',
        body: JSON.stringify(data), // GET, POST, PUT, DELETE
      }
    )}

  storeUserData(token) {
    sessionStorage.setItem('id_token', token);
    //localStorage.setItem('user', JSON.stringify(user));
    this.authToken = token;
  }
}
