import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DefaultComponent} from "./layout/default/default.component";
import {HomeComponent} from "./modules/home/home.component";
import {RegisterComponent} from "./modules/register/register.component";
import {LoginComponent} from "./modules/login/login.component";
import {FullwidthComponent} from "./layout/fullwidth/fullwidth.component";
import {LandingComponent} from "./modules/landing/landing.component";


const routes: Routes = [{
  path: '',
  component: FullwidthComponent,
  children: [
    {
      path: '',
      component: LandingComponent
    },
    {
      path: 'register',
      component: RegisterComponent,
    }, {
      path: 'login',
      component: LoginComponent
    }]
}, {
  path: '',
  component: DefaultComponent,
  children: [{
    path: 'home',
    component: HomeComponent,
    // canActivate: [AuthGuard]
  }]
}]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
