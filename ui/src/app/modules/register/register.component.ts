import {Component} from '@angular/core';
import {AuthService} from "../../shared/auth/auth.service";
import {Router} from "@angular/router";
import {User} from "../../shared/models/user.model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private authService: AuthService,
              private router: Router) {
  }

  registerForm: User = {
    username: '',
    password: '',
    securityQuestion: '',
    securityAnswer: ''
  }

  errorMessage: string = "";

  onSubmit() {
    this.authService.register(this.registerForm).subscribe(
      (success) => {
        if (success) {
          console.log("we are register page : " +success);
          this.router.navigate(['/login']);
        }
      },
      (error) => {
        console.log("An error occurred during login " +error.errorMessage);
        this.errorMessage = "An error occurred during login " +error.errorMessage;
      }
    )
  }
}
