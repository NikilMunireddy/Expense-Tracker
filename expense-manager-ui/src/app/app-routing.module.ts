import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExpenseComponent } from './components/expense/expense.component';
import { LoginComponent } from './components/login/login.component';
import { SavingComponent } from './components/saving/saving.component';
import { AddnewdataComponent } from './components/addnewdata/addnewdata.component';
import { LendingComponent } from './components/lending/lending.component';
import { DebtComponent } from './components/debt/debt.component';


const routes: Routes = [
  {path: '', component:LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'expense', component: ExpenseComponent},
  {path: 'saving', component: SavingComponent},
  {path: 'lending', component: LendingComponent},
  {path: 'debt', component: DebtComponent},
  {path: 'addinfo', component: AddnewdataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
