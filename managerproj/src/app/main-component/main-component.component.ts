import { Component, OnInit } from '@angular/core';
import { SampleService } from './main-component.service';
@Component({
  selector: 'app-main-component',
  templateUrl: './main-component.component.html',
  styleUrls: ['./main-component.component.css'],
  providers: [ SampleService ]
})
export class MainComponentComponent implements OnInit {
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