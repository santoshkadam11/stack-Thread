import {Injectable} from '@angular/core';
import {ApiService} from "../services/api.service";
import {map, Observable, of, tap} from "rxjs";
import {catchError} from "rxjs/operators";
import {User} from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl: string = "/users/login";
  private registerUrl: string = "/users";

  constructor(private apiService: ApiService) {
  }

  //login function that takes in a username and password and returns a boolean
  login(username: string, password: string): Observable<boolean> {
    const loginData = {username: username, password: password};
    return this.apiService.post<string>(this.loginUrl, loginData).pipe(
      tap(username => {
        console.log("we are auth: " + loginData.username);
        localStorage.setItem('user', JSON.stringify(loginData.username));
        JSON.parse(localStorage.getItem('user')!);
      }),
      map(() => true),
      catchError((error) => {
        console.log(error);
        localStorage.setItem('user', 'null');
        JSON.parse(localStorage.getItem('user')!);
        return of(false);
      })
    );
  }

  register(registerForm: User) {
    return this.apiService.post<string>(this.registerUrl, registerForm).pipe(
      map((user) => {
        return user;
      }),
      catchError((error) => {
        console.log(error);
        return of(false);
      })
    );
  }
}
