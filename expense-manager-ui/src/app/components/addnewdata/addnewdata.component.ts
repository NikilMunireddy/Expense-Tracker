import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addnewdata',
  templateUrl: './addnewdata.component.html',
  styleUrls: ['./addnewdata.component.css']
})
export class AddnewdataComponent implements OnInit {

  constructor() { }

  month: string;
  year: number;
  type: string;
  amount: number ;
  title: string = "";
  description: string = "";
  date: number;
  selectedType: string = "Choose Type";

  dateMonthMap = {
    1: 'JAN', 2: 'FEB', 3: 'MAR', 4: 'APR', 5: 'MAY', 6: 'JUN', 7: 'JUL', 8: 'AUG', 9: 'SEP', 10: 'OCT',
    11: 'NOV', 12: 'DEC',
  }

  types = [
    { value: 'expense', viewValue: 'Expense' },
    { value: 'saving', viewValue: 'Saving' },
    { value: 'debt', viewValue: 'Debt' },
    { value: 'lending', viewValue: 'Lending' }
  ]

  ngOnInit(): void {
    var d = new Date();
    this.month = this.dateMonthMap[d.getUTCMonth() + 1];
    this.year = d.getUTCFullYear();
    this.date = Date.now();
    console.log(this.month, this.year, this.date)
  }

  submitData() {
    if (this.selectedType != "" && this.selectedType != "Choose Type" && this.amount != undefined && this.title != "" && this.description != "") {
      if (this.selectedType == "expense") {
        console.log(this.amount, this.title, this.description,this.selectedType)
      }
      else if (this.selectedType == "saving") {
        console.log(this.amount, this.title, this.description,this.selectedType)
      }
      else if (this.selectedType == "debt") {
        console.log(this.amount, this.title, this.description,this.selectedType)
      }
      else {
        console.log(this.amount, this.title, this.description,this.selectedType)
      }
    }
  }

}
