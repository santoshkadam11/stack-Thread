export class Comment {
    commentId: number;
    postId: number;
    username: string;
    content: string;
    date: Date;
    constructor(param: {
        commentId: number,
        postId: number,
        username: string,
        content: string,
        date: Date
    }) {
        this.commentId = param.commentId;
        this.postId = param.postId;
        this.username = param.username;
        this.content = param.content;
        this.date = param.date;
    }
}
