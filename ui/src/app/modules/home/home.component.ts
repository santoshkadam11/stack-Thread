import {Component, OnInit} from '@angular/core';
import {Post} from "../../shared/models/post";
import {MatDialog} from "@angular/material/dialog";
import {PostDialogComponent} from "../post-dialog/post-dialog.component";
import {PostService} from "../../shared/services/post.service";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    // posts: Post[] = [{ title: '', content: '', codeContent: '', userName: '' ,tags:[]}];
    posts: Post[] = [{ title:'Beginner', content:'Beginner', codeContent:'Beginner', userName:'Beginner',tags:[]},
    { title:'Intermediate', content:'Intermediate', codeContent:'Intermediate', userName:'Intermediate',tags:[]},
    { title:'Advanced', content:'Advanced', codeContent:'Advanced', userName:'Advanced',tags:[]}];

    constructor(public dialog: MatDialog, private postService: PostService) {
    }

    ngOnInit(): void {
        this.postService.getAllPosts().subscribe((posts) => {
            this.posts = posts;
        });

    }

    openDialog() {
        const dialogRef = this.dialog.open(PostDialogComponent, {
            width: '60%',
            disableClose: true,
            data: {title: '', content: '', codeContent: '', userName: '',tags:[] }
        });
        dialogRef.afterClosed().subscribe(result => {
                result && this.posts.push(result.data);
            }
        );

    }
}
