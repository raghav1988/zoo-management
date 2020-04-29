import { Component, Output, EventEmitter } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'animal-add',
  templateUrl: './animalAdd-component.html',
  styleUrls: ['app.component.css']
})

export class AnimalAddComponent {
  @Output() newAnimalSender = new EventEmitter();
  submitForm(name: string, age: number, location: string, likes: string, dislikes: string, sex: string) {
    var newAnimalToAdd: Animal = new Animal(name, age, location, likes, dislikes, sex);
    this.newAnimalSender.emit(newAnimalToAdd);
  }
}
