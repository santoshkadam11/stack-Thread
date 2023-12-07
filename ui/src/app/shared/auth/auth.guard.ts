import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree,} from '@angular/router';

import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard {
  constructor(public router: Router) {}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | UrlTree | boolean {
    const user = JSON.parse(localStorage.getItem('user')!);
    if (user == null) {
      console.log('Access Denied, Login is Required to Access This Page!' + user);
     this. router.navigate(['/login']);
    }
    return true;
  }
}
