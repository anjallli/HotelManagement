import { Component } from '@angular/core';
import { Owner } from '../owner';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {


  constructor(public activateroute:ActivatedRoute,private route:Router) { }
  user!: Owner;
  ngOnInit(): void 
  {
   
  }
  logout() {
    if (sessionStorage.getItem("user")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Logout Successfully")
      this.route.navigateByUrl("")
    }
    else {
      alert("No user loged in")
    }
  }

}
