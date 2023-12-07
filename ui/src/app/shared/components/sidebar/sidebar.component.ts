import {Component, OnInit} from '@angular/core';
import {Tag} from "../../models/tag";
import {TagService} from "../../services/tag.service";

@Component({
    selector: 'app-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

    tags: Tag[] = [];

    constructor(private tagService: TagService) {
        this.tagService.getAllTags().subscribe((tags) => {
            this.tags = tags;
        });
    }

    ngOnInit(): void {

    }


}
