import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LendingService {

  constructor(private http: HttpClient) { }

  serverUrl = environment.baseUrl;


  getTotalLending(month, year) {


    return fetch(this.serverUrl+'/api/moneymanager/lending/lend-total', {
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': `Bearer ${sessionStorage.getItem('id_token')}`,
        'Access-Control-Request-Headers': '*',
        'Access-Control-Allow-Headers': '*'
      },
      method: 'POST', // GET, POST, PUT, DELETE
      body: JSON.stringify({ month, year })
    })
  }




  getAllLendings(month, year) {

    return fetch(`${this.serverUrl}/api/moneymanager/lending/${month}/${year}`, {
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': `Bearer ${sessionStorage.getItem('id_token')}`,
        'Access-Control-Request-Headers': '*',
        'Access-Control-Allow-Headers': '*'
      },
      method: 'GET',// GET, POST, PUT, DELETE,
    })
  }

  deleteLending(lendingID){
    return fetch(`${this.serverUrl}/api/moneymanager/lending/${lendingID}`, {
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': `Bearer ${sessionStorage.getItem('id_token')}`,
        'Access-Control-Request-Headers': '*',
        'Access-Control-Allow-Headers': '*'
      },
      method: 'DELETE'
    })
  }

}
