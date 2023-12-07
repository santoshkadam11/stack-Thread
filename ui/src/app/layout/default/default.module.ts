import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DefaultComponent} from "./default.component";
import {HomeComponent} from "../../modules/home/home.component";
import {RouterModule} from "@angular/router";
import {FlexLayoutModule} from "@angular/flex-layout";
import {SharedModule} from "../../shared/shared.module";
import {MatCardModule} from "@angular/material/card";
import {SearchPostComponent} from "../../modules/search-post/search-post.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {PostComponent} from "../../modules/post/post.component";
import {CommentComponent} from "../../modules/comment/comment.component";
import {MatButtonModule} from "@angular/material/button";
import {PostDialogComponent} from "../../modules/post-dialog/post-dialog.component";
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";


@NgModule({
    declarations: [DefaultComponent,
        HomeComponent,
        PostComponent,
        CommentComponent,
        PostDialogComponent,
        SearchPostComponent
    ],
    imports: [
        CommonModule,
        RouterModule,
        FlexLayoutModule,
        SharedModule,
        MatCardModule,
        ReactiveFormsModule,
        MatButtonModule,
        MatDialogModule,
        MatFormFieldModule,
        MatInputModule,
        FormsModule
    ],
    exports: [SearchPostComponent]
})
export class DefaultModule {
}
