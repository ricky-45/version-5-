
import { Component, OnInit } from '@angular/core';

import { Candidate } from '../candidate';
import { KanbanServiceService } from '../kanban-service.service';
import { Search } from '../search';

@Component({
  selector: 'app-search-modal',
  templateUrl: './search-modal.component.html',
  styleUrls: ['./search-modal.component.css']
})
export class SearchModalComponent implements OnInit {

  searchObj!:Search;
  searchData:Candidate[]=[];
  constructor(private _service:KanbanServiceService) { }

  ngOnInit(): void {
    this._service.searchData(this.searchObj).subscribe(
      response=>{this.searchData=response},
      error=>{console.log("error happend")}
    );
  }

}

