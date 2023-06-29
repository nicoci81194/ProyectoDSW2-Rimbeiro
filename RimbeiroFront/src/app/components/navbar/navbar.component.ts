import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


  isLoggedIn = false;
  user:any = null;

  constructor(public login:LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubjec.asObservable().subscribe(
      data => {
        this.isLoggedIn = this.login.isLoggedIn();
        this.user = this.login.getUser();
      }
    )
  }

  public logout(){
    this.login.logout();
    window.location.reload();
  }

  getProfileLink(): string[] {
    if (this.login.isLoggedIn() && this.login.getUserRole() == 'ADMIN') {
      return ['admin/profile'];
    } else if (this.login.isLoggedIn() && this.login.getUserRole() == 'USUARIO') {
      return ['user-dashboard/profile'];
    } else {
      return ['vet-dashboard/profile'];
    }
  }

}
