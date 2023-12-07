import {Component} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private router : Router) {
  }

  get isUserLoggedIn(): boolean {
    return JSON.parse(localStorage.getItem('user')!) != null;
  }

  logout() {
    localStorage.removeItem('user');
    this.router.navigate(['']);
  }
}
