import { Component, OnInit } from '@angular/core';
import { Owner } from '../owner';
import { OwnerService } from '../Service/owner.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-owner-login',
  templateUrl: './owner-login.component.html',
  styleUrls: ['./owner-login.component.css']
})
export class OwnerLoginComponent implements OnInit{

  user: Owner = new Owner(0, "", "", "", "", "", "")
  userdetails: any
  password!: string;
  uname!: string;
  searchuser!: string;

  //users: Owner = JSON.parse(sessionStorage.getItem("user"))
  constructor(private userservices: OwnerService, private route: Router, public activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
  }
  Getlogin(): void {

    this.userservices.getlogin(this.user).subscribe(data => {
      alert("Login Successfully"),
        console.log("login response" + data)

      sessionStorage.setItem("user", JSON.stringify(data))

      this.route.navigateByUrl("/dashboard")

    },
      error => alert("Sorry Please Enter correct Username And Password"));

  }
  newregistration(){
    this.route.navigateByUrl("/register")
  }
  onSubmit() {
    this.route.navigateByUrl("/products");

  }
  goToDashboard(){
    this.route.navigateByUrl("")

  }
}
