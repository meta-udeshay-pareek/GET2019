/**
 * DataService class provides the service to access the data from server or from http/json etc.
 */
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';


import { Person } from './person';
import { Observable , of} from 'rxjs';

//for http requests
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class DataService {
  private personsUrl = 'api/persons';
  // fake data for our app 
  // we can manipulate the list
  persons: Person[]=[
    { id: 1, name: 'Mr. Nice',phone:"456783929",city:'jaipur' },
  { id: 2, name: 'Narco' ,phone:"456783929",city:'jaipur'},
  { id: 3, name: 'Bombasto' ,phone:"456783929",city:'jaipur'},
  { id: 4, name: 'Celeritas' ,phone:"456783929",city:'jaipur'},
  { id: 5, name: 'Magneta' ,phone:"456783929",city:'jaipur'},
  { id: 6, name: 'RubberMan' ,phone:"456783929",city:'jaipur'},
  { id: 7, name: 'Dynama' ,phone:"456783929",city:'jaipur'},
  { id: 8, name: 'Dr IQ' ,phone:"456783929",city:'jaipur'},
  { id: 9, name: 'Magma' ,phone:"456783929",city:'jaipur'},
  { id: 10, name: 'Tornado' ,phone:"456783929",city:'jaipur'}
  ];
  
  counter = 10;
  constructor(private http: HttpClient) { }   // httpClient dependency is injected when dealing with http 
  
  /**
   * get all the persons
   * @returns an Observable of Person[]
   */
  getPersons(): Observable<Person[]> {
    return of(this.persons);
  }








  //---------------  for using the array in dataService-----------
  
  /**
   * get a single person 
   * @param id  id of the person
   */
  getPerson(id: number): Observable<Person>{
    for(let person of this.persons){
      if(person.id == id){
        return of(person);
      }
    }
  }

  /**
   * adds a new person to the list
   * @param person person to be added
   */
  add(person: Person): Observable<any> {
    person.id = ++this.counter; // some logic for id
    return of(this.persons.push({id:person.id,name:person.name,phone:person.phone,city:person.city}));
  }

  /**
   * updates the person data/information
   * @param updatedPerson   updated data 
   */
  update(updatedPerson: Person): Observable<any> {
    let id = updatedPerson.id;
    let person;
    this.getPerson(id).subscribe(
      data => person = data
    );
    // updating the person data
    person.city=updatedPerson.city;
    person.name=updatedPerson.name;
    person.phone=updatedPerson.phone;
    return of(person);
  }


  //------------------    http api methods  fully working just remove comments! --------------------
  
  //   /** GET Persons from the server */
  //   getPersons (): Observable<Person[]> {
  //   return this.http.get<Person[]>(this.personsUrl).pipe(
  //     catchError(this.handleError('getPersons', []))
  //   );
  // }


// /** GET hero by id. Return `undefined` when id not found */
// getPerson<Person>(id: number): Observable<Person> {
//   const url = `${this.personsUrl}/?id=${id}`;
//   return this.http.get<Person[]>(url)
//     .pipe(
//       map(person => person[0]), // returns a {0|1} element array
//       catchError(this.handleError<Person>(`getPerson id=${id}`))
//     );
// }
  
  // add(person: Person): Observable<Person> { 
  //   console.log("add called");
  //   return this.http.post<Person>(this.personsUrl, person, httpOptions).pipe(
  //     catchError(this.handleError<Person>('add'))
  //   );
  // }

  // update(person: Person): Observable<Person> {
    
  //   return this.http.put(this.personsUrl, person, httpOptions).pipe(
  //     catchError(this.handleError<any>('update'))
  //   );
  // }

// /**
//  * Handle Http operation that failed.
//  * Let the app continue.
//  * @param operation - name of the operation that failed
//  * @param result - optional value to return as the observable result
//  */
// private handleError<T> (operation = 'operation', result?: T) {
//   return (error: any): Observable<T> => {

//     // TODO: send the error to remote logging infrastructure
//     console.error(error); // log to console instead

//     // TODO: better job of transforming error for user consumption
//     console.log(`${operation} failed: ${error.message}`);

//     // Let the app keep running by returning an empty result.
//     return of(result as T);
//   };
// }


}
