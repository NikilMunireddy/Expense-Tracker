import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ExpenseComponent } from './components/expense/expense.component';
import { LoginComponent } from './components/login/login.component';
import { AuthService } from './services/auth.service';
import { AddnewdataComponent } from './components/addnewdata/addnewdata.component';
import { LendingComponent } from './components/lending/lending.component';
import { SavingComponent } from './components/saving/saving.component';
import { DebtComponent } from './components/debt/debt.component'

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ExpenseComponent,
    LoginComponent,
    AddnewdataComponent,
    LendingComponent,
    SavingComponent,
    DebtComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
