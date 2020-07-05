import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  password:string;
  email: string;

  constructor(private authService: AuthService,
              private router: Router
    ) {
      if(sessionStorage.getItem('id_token'))
          this.router.navigate(['/expense'])
     }

  ngOnInit(): void {
  }

  onLoginSubmit(){
    this.authService.loginUser(this.email, this.password)
    .then(res=> res.json())
    .then(data=>{
      if(data.token){
        this.authService.storeUserData(data.token)
        this.router.navigate(['/expense'])
      }
      else{
        this.router.navigate(['/login'])
      }
    }).catch(err=> console.log(err))
  }

}
