import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Post} from "../../shared/models/post";
import {PostService} from "../../shared/services/post.service";

@Component({
    selector: 'app-post-dialog',
    templateUrl: './post-dialog.component.html',
    styleUrls: ['./post-dialog.component.css']
})
export class PostDialogComponent {
    newPost: Post = new Post({title: '', content: '', codeContent: '', userName: ''});

    constructor(public dialogRef: MatDialogRef<PostDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: Post, public postService: PostService) {
    }

    onNoClick() {
        this.dialogRef.close();
    }

    onSave() {
        this.postService.createPost(this.newPost).subscribe(
            (success) => {
                if (success) {
                    this.dialogRef.close({data: this.newPost});
                }
            },
            (error) => {

            }
        )
    }
}
