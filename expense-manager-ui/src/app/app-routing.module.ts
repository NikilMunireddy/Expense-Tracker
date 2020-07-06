import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExpenseComponent } from './components/expense/expense.component';
import { LoginComponent } from './components/login/login.component';
import { AddnewdataComponent } from './components/addnewdata/addnewdata.component';


const routes: Routes = [
  {path: '', component:LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'expense', component: ExpenseComponent},
  {path: 'addinfo', component: AddnewdataComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
