import { Component, OnInit } from '@angular/core';
import { Saving } from 'src/app/model/Saving';
import { SavingService } from 'src/app/services/saving.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-saving',
  templateUrl: './saving.component.html',
  styleUrls: ['./saving.component.css']
})
export class SavingComponent implements OnInit {

  savings : Saving [];

  monthlySaving: number = 0;
  dateMonthMap = {
    1: 'JAN', 2: 'FEB', 3: 'MAR', 4: 'APR', 5: 'MAY', 6: 'JUN', 7: 'JUL', 8: 'AUG', 9: 'SEP', 10: 'OCT',
    11: 'NOV', 12: 'DEC',
  }
  monthyear: string
  selectedYear: number
  selectedMonth: number


  constructor(private savingService: SavingService,
    private router: Router) {
    if (!sessionStorage.getItem('id_token'))
      this.router.navigate(['/login'])
  }

  ngOnInit(): void {
    var d = new Date();
    var month = d.getUTCMonth() + 1; // Since getUTCMonth() returns month from 0-11 not 1-12
    var year = d.getUTCFullYear();
    console.log(month, year)
    this.selectedMonth = this.dateMonthMap[month]
    this.getTotalSaving(this.dateMonthMap[month], year)
    this.getAllSavings(this.dateMonthMap[month], year)
  }

  logout() {
    sessionStorage.removeItem('id_token')
    this.router.navigate(['/login'])
  }

  getMonthAndYear() {
    console.log(this.monthyear)
    this.selectedMonth = Number(this.monthyear.split('-')[1])
    this.selectedYear = Number(this.monthyear.split('-')[0])
    console.log(this.selectedMonth, this.selectedYear)
    this.getTotalSaving(this.dateMonthMap[this.selectedMonth], this.selectedYear)
  }

  getTotalSaving(month, year) {
    this.getAllSavings(month, year)
    this.savingService.getTotalSaving(month, year)
      .then(res => (res.status !== 403 && res.status !== 401 && res.status !== 408) ? res.json() : this.logout())
      .then(data => {
        this.monthlySaving = data.total
      }).catch(err => console.log(err))
  }

  getAllSavings(month, year) {
    this.savingService.getAllSavings(month, year)
      .then(res => (res.status !== 403 && res.status !== 401 && res.status !== 408) ? res.json() : this.logout())
      .then(data => {
        this.savings = data;
      }).catch(err => console.log(err))
  }
}
