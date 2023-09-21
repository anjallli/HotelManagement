import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customersideroomtypes',
  templateUrl: './customersideroomtypes.component.html',
  styleUrls: ['./customersideroomtypes.component.css']
})
export class CustomersideroomtypesComponent {
  constructor(public router:Router){}
  BookRoom(){
    this.router.navigateByUrl("customerdashboard/roombooking"); 
  }

  goToDashboard(){

  }

}
