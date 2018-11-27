import { Component, OnInit } from '@angular/core';
import { SampleService } from './user-component.service';

@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css'],
  providers: [ SampleService ]
})
export class UserComponentComponent implements OnInit {
smpls:string[];
inputtext=null;
sample=null

clickAction()
{
	this.sample=this.inputtext
}
  constructor(private sm: SampleService) {
	this.smpls=this.sm.smpls
	  }

  ngOnInit() {
  }
  addMore()
  {
	  this.smpls.push(this.inputtext)
		this.inputtext=null;
}
}
