import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AddinfoService {

  constructor() { }

  serverUrl = environment.baseUrl;

  /** Expense */

    //Add expense
  
  addExpense(title, description, date, amount, month, year){
    

    return fetch(`${this.serverUrl}/api/moneymanager/expense`, {
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': `Bearer ${sessionStorage.getItem('id_token')}`,
        'Access-Control-Request-Headers': '*',
        'Access-Control-Allow-Headers': '*'
      },
      method: 'POST',
      body: JSON.stringify({
        "title": title,
        "description": description,
        "date": date,
        "amount": amount,
        "month": month,
        "year": year
      })
    });
  }


  addSaving(title, description, date, amount, month, year){

    return fetch(`${this.serverUrl}/api/moneymanager/savings`, {
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': `Bearer ${sessionStorage.getItem('id_token')}`,
        'Access-Control-Request-Headers': '*',
        'Access-Control-Allow-Headers': '*'
      },
      method: 'POST',
      body: JSON.stringify({
        "title": title,
        "description": description,
        "date": date,
        "amount": amount,
        "month": month,
        "year": year
      })
    });
  }


}
