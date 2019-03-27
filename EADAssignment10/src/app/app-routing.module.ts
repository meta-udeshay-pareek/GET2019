import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddUserComponent } from './add-user/add-user.component';
import { ContentComponent } from './content/content.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { AuthGaurdService as AuthGaurd } from './auth-gaurd.service';
import { AuthRequiredComponent } from './auth-required/auth-required.component';


const routes: Routes = [
  {path: '',redirectTo: '/home', pathMatch: "full"},
  {path:'home',component: ContentComponent},
  {path:'add',component: AddUserComponent, canActivate: [AuthGaurd]}, // adding the canActivate check for the routed we want to lock
  {path:'edit/:id',component: EditUserComponent, canActivate: [AuthGaurd]},
  {path: 'auth',component: AuthRequiredComponent}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
