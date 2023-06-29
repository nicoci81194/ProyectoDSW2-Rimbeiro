import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class WelcomeComponent implements OnInit {

  user:any=null;

  constructor(public loginService:LoginService) { }

  ngOnInit(): void {
    //treamos los datos del usuario logeado
    this.user = this.loginService.getUser();
  }

}
