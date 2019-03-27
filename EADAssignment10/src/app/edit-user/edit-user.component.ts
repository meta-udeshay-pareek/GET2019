import { Component, OnInit } from '@angular/core';
import { Person } from '../person';
import { DataService } from '../data.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  person: Person ;
  submitted = false;        //for validation
  messageForm: FormGroup;
  
  personTobeUpdated = new Person();
  constructor(
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.getPerson();
    this.messageForm = this.formBuilder.group({
      name: [this.person.name, Validators.required],
      phone: [this.person.phone,Validators.required],
      city: [this.person.city,Validators.required]
    });
  }

  // getting the person's details to show
  private getPerson(){
    const id=+this.activatedRoute.snapshot.paramMap.get('id');// getting the id from url
    this.dataService.getPerson(id)
      .subscribe(person => this.person = person as Person);
  }

  update(){
    this.submitted =true;
    if (this.messageForm.invalid) {
        return;
    }
    let person: Person = new Person();
    //getting the values from the form
    person.id = this.person.id;
    person.name=this.messageForm.controls.name.value;
    person.phone=this.messageForm.controls.phone.value;
    person.city=this.messageForm.controls.city.value;
    // calling the update method of dataservice to update the user
    // after updating redirect to the home
    this.dataService.update(person).subscribe( data => {
      this.router.navigate(['home']);
    })    
  }
}
