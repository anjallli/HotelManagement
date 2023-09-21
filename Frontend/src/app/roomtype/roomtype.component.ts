import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';

@Component({
  selector: 'app-roomtype',
  templateUrl: './roomtype.component.html',
  styleUrls: ['./roomtype.component.css']
})
export class RoomtypeComponent {
  customers!: Customer[]; 
  constructor(public router:Router){}

  goToDashboard(){
    this.router.navigateByUrl("/dashboard");    
  }
  BookRoom(){
    this.router.navigateByUrl(""); 

  }
}
