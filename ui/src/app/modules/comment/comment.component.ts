import {Component} from '@angular/core';
import {Comment} from "../../shared/models/comment";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent {
    comments: Comment[] = [{commentId: 1, content: 'test', username: 'test', postId: 1, date: new Date()}];

    addComment() {

    }

    deleteComment(comment: any) {
        
    }
}
