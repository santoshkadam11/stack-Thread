import {Injectable} from '@angular/core';
import {ApiService} from "./api.service";
import {Post} from "../models/post";
import {map, of} from "rxjs";
import {catchError} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class PostService {

    constructor(private apiService: ApiService) {
    }

    createPost(post: Post) {
        post.userName = JSON.parse(localStorage.getItem('user')!);
        return this.apiService.post<Post>('/posts', post).pipe(
            map((post) => {
                return post;
            }),
            catchError((error) => {
                console.log(error);
                return of(false);
            })
        );

    }

    getAllPosts() {
        return this.apiService.getList<Post>('/posts');
    }


}
