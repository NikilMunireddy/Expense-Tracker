import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class DebtService {
  constructor(private http: HttpClient) { }

  serverUrl = environment.baseUrl;

  getTotalDebt(month, year) {


    return fetch(this.serverUrl+'/api/moneymanager/debt/debt-total', {
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




  getAllDebts(month, year) {

    return fetch(`${this.serverUrl}/api/moneymanager/debt/${month}/${year}`, {
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

  deleteDebt(expenseID){
    return fetch(`${this.serverUrl}/api/moneymanager/debt/${expenseID}`, {
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
