import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SavingService {

  constructor(private http: HttpClient) { }

  serverUrl = environment.baseUrl;


  getTotalSaving(month, year) {

    return fetch(this.serverUrl+'/api/moneymanager/savings/saving-total', {
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


  getAllSavings(month, year) {

    return fetch(`${this.serverUrl}/api/moneymanager/savings/${month}/${year}`, {
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

}
