import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'animal-edit-detail',
  templateUrl: './animalEdit-Component.html',
      styleUrls: ['app.component.css']
})

export class AnimalEditDetailComponent {
  @Input() selectedAnimal: Animal;
  @Output() doneButtonClickedSender = new EventEmitter();
  diets = ["Carnivorous", "Omnivorous", "Herbivorous"];
  sexes = ["Male", "Female"];
  finishedEditing()  {
    this.doneButtonClickedSender.emit();
  }
}
