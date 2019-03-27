import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  /**
   * @returns true, if Authenticated else false
   */
  public isAuthenticated(): boolean{
    //checking for role in local storage only
    const role = localStorage.getItem('role');
    if(role == 'admin'){
      return true;
    }
    return false;
  }
}
