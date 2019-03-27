import { Component, OnInit, DoCheck } from '@angular/core';

import { DataService } from '../data.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  persons$: object;

  constructor(private data:DataService) { }
  // calls the DataService for the list of users
  ngOnInit() {
    this.fetch();
  }
  private fetch(){
    this.data.getPersons().subscribe(
      data => this.persons$ = data
    )
  }
  rock(){
    localStorage.setItem('role','admin');
  }
}
