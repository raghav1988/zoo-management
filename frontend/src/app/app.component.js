"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var animal_model_1 = require("./animal.model");
var AppComponent = (function () {
    function AppComponent() {
        this.title = 'Welcome to the Zoo';
        this.selectedAnimal = null;
        this.hideAdd = true;
        this.addAnimalText = "Add Animal";
        this.masterAnimalList = [
            new animal_model_1.Animal("Lion", "Sher Khan", 1, "Carnivorous", "Africa", 6, "Sleeping", "People", "Male"),
            new animal_model_1.Animal("Elephant", "Motu", 4, "Herbivorous", "Africa", 3, "Bathing", "People", "Female"),
            new animal_model_1.Animal("Bear", "Baloo", 2, "Omnivorous", "Asia", 4, "Honey", "Bathing", "Male"),
            new animal_model_1.Animal("Cat", "Baghira", 5, "Omnivorous", "North America", 4, "Rats", "Dogs", "Male"),
            new animal_model_1.Animal("Snake", "Kaa", 3, "Carnivorous", "India", 4, "Rats", "Dogs", "Female")
        ];
    }
    AppComponent.prototype.editAnimal = function (clickedAnimal) {
        this.selectedAnimal = clickedAnimal;
    };
    AppComponent.prototype.finishedEditing = function () {
        this.selectedAnimal = null;
    };
    AppComponent.prototype.addAnimal = function (newAnimalFromChild) {
        this.masterAnimalList.push(newAnimalFromChild);
    };
    AppComponent.prototype.hideAddAnimal = function () {
        this.hideAdd = !this.hideAdd;
        if (this.hideAdd == false) {
            this.addAnimalText = "Hide Add Panel";
        }
        else {
            this.addAnimalText = "Add Animal";
        }
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        moduleId: module.id,
        selector: 'app-root',
        templateUrl: './app.component.html',
        styleUrls: ['app.component.css']
    })
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map