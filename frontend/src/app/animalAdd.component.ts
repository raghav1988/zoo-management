import { Component, Output, EventEmitter } from '@angular/core';
import { Animal } from './animal.model';
import {ZooserviceService} from './zooservice.service';
@Component({
  selector: 'animal-add',
  templateUrl: './animalAdd-component.html',
  styleUrls: ['app.component.css']
})

export class AnimalAddComponent {



  @Output() newAnimalSender = new EventEmitter();


  constructor(private zooService: ZooserviceService) { }
  submitForm(name: string,dislikes: string) {
  var newAnimalToAdd: Animal = new Animal(name,dislikes);
   // this.newAnimalSender.emit(newAnimalToAdd);
    this.zooService.saveAnimalInfoByZooId(newAnimalToAdd).subscribe((data)=>{
      alert("data saved successfully..");
    })
  }
}
