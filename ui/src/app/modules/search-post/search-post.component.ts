import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-search-post',
  templateUrl: './search-post.component.html',
  styleUrls: ['./search-post.component.css']
})
export class SearchPostComponent {
  @Output() search: EventEmitter<string> = new EventEmitter();
  searchForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.searchForm = this.formBuilder.group({
      searchQuery: ['', Validators.required],
    });
  }

  onSearch() {
    const searchQuery = this.searchForm.get('searchQuery')?.value;
    this.search.emit(searchQuery);
  }
}
