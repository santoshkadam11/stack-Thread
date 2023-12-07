import {Injectable} from '@angular/core';
import {ApiService} from "./api.service";
import {Tag} from "../models/tag";
import {map, of} from "rxjs";
import {catchError} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class TagService {

    constructor(private apiService: ApiService) {
    }

    getAllTags() {
        return this.apiService.getList<Tag>('/tags');
    }
}
