// this is used for in memory data service for checking purpose 
// the http requests will be intercepted and sent here 
// and simulates the get, post, put

import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

import { Person } from './person';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{
  createDb(){
    const persons = [
      {id:1, name: 'Vijay', phone: '1111111111', city: 'Jaipur'},
      {id:2, name: 'Prabhav', phone: '2222222222', city: 'Kota'},
      {id:3, name: 'Chintu', phone: '3333333333', city: 'Bhiwadi'},
      {id:4, name: 'Amit', phone: '4444444444', city: 'Surat'},
      {id:5, name: 'Akshat', phone: '5555555555', city: 'Jaipur'}
      
    ];
    console.log("in side dataservice");
    return {persons};
  }

  genId(Persons: Person[]): number {
    return Persons.length > 0 ? Math.max(...Persons.map(Person => Person .id)) + 1 : 1;
  }

  constructor() { }
}
