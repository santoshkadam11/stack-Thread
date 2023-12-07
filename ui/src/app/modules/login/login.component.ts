import {Component} from '@angular/core';
import {AuthService} from "../../shared/auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authService: AuthService,
              private router: Router) {
  }

  loginForm = {
    username: "",
    password: ""
  }
  errorMessage: string = "";

  onSubmit() {

    this.authService.login(this.loginForm.username, this.loginForm.password).subscribe(
      (success) => {
        if (success) {
          console.log("we are login page : " );
          this.router.navigate(['/home']);
        } else {
          this.errorMessage = "Invalid username or password";
        }
      },
      (error) => {
        console.log(error);
        this.errorMessage = "An error occurred during login";
      }
    )
  };


}
