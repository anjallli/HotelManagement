import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logindashboard',
  templateUrl: './logindashboard.component.html',
  styleUrls: ['./logindashboard.component.css']
})
export class LogindashboardComponent {
  constructor(private route: Router) { }

  loginAsOwner(){

    this.route.navigateByUrl("/ownerlogin")

  }

  loginAsCustomer(){
    this.route.navigateByUrl("/customerlogin")

  }

}
