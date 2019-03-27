import { Injectable } from '@angular/core';
import { Router, CanActivate} from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(
    public router: Router ,
    public auth: AuthService
  ) { }
  // this method is responsible for routers to route to a link
  // if the user is authenticated, then we can route to a link else will show some error page  
  canActivate(): boolean{
    if(this.auth.isAuthenticated()){
      return true;
    }
    this.router.navigate(['auth']);
    return false;
  }
}
