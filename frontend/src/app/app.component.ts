import { Component } from '@angular/core';
import { Animal } from './animal.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['app.component.css']
})

export class AppComponent {
  title = 'Welcome to the Zoo';
  selectedAnimal = null;
  hideAdd: boolean = true;
  addAnimalText: string = "Add Animal";


  editAnimal(clickedAnimal) {
    this.selectedAnimal = clickedAnimal;
  }

  finishedEditing() {
    this.selectedAnimal = null;
  }

  addAnimal(newAnimalFromChild: Animal) {
   // this.masterAnimalList.push(newAnimalFromChild);
  }
  hideAddAnimal()
  {
    this.hideAdd = !this.hideAdd;
    if(this.hideAdd == false)
    {
      this.addAnimalText = "Hide Add Panel";
    }
    else
    {
      this.addAnimalText = "Add Animal";
    }
  }

}
