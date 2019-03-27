import { Component, OnInit } from '@angular/core';
import { Person } from '../person';
import { DataService } from '../data.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  messageForm: FormGroup;
  
  submitted = false;
  
  
  constructor(
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private router: Router) { }

  ngOnInit() {
    this.messageForm = this.formBuilder.group({
      name: ['', Validators.required],
      phone: ['',Validators.required],
      city: ['',Validators.required]
    });
  }

  add(){
    this.submitted = true;
    // validates the input
    if (this.messageForm.invalid) {
        return;
    }
    let person: Person = new Person();
    person.name=this.messageForm.controls.name.value;
    person.phone=this.messageForm.controls.phone.value;
    person.city=this.messageForm.controls.city.value;
    // calls the dataservice add method to add the new user and then navigates to home
    this.dataService.add(person).subscribe( data => {
      this.router.navigate(['home']);
    })
    
    
  }

}
