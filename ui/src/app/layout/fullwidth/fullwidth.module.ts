import {NgModule} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {FullwidthComponent} from "./fullwidth.component";
import {RouterModule} from "@angular/router";
import {FlexLayoutModule} from "@angular/flex-layout";
import {SharedModule} from "../../shared/shared.module";
import {LoginComponent} from "../../modules/login/login.component";
import {RegisterComponent} from "../../modules/register/register.component";
import {LandingComponent} from "../../modules/landing/landing.component";
import {MatCardModule} from "@angular/material/card";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    FullwidthComponent,
    LandingComponent,
    LoginComponent,
    RegisterComponent
  ],
    imports: [
        CommonModule,
        RouterModule,
        FlexLayoutModule,
        SharedModule,
        NgOptimizedImage,
        MatCardModule,
        FormsModule
    ]
})
export class FullwidthModule { }
