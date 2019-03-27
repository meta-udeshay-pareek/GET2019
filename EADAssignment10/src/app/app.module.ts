import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CardComponent } from './card/card.component';
import { ContentComponent } from './content/content.component';
import { AddUserComponent } from './add-user/add-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { AuthRequiredComponent } from './auth-required/auth-required.component';


@NgModule({
  declarations: [
    AppComponent,
    // we have to add all the components of our app here
    NavbarComponent,      
    CardComponent,
    ContentComponent,
    AddUserComponent,
    EditUserComponent,
    AuthRequiredComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    // below module is only required when using in memory api for testing 
    // no use when using list in dataService or production build
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, {dataEncapsulation:false}
    )
  ],
  providers: [],
  bootstrap: [AppComponent]       // starts with AppComponent
})
export class AppModule { }
