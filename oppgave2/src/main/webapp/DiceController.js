"use strict";


 
class DiceController {
	#terning
	#select
	#diceoutputElement
	constructor(rootElement) {
		this.#terning = new Dice();
 		this.root = rootElement;
 		this.#select = rootElement.querySelector("*[data-dicebutton]");
 		this.#select.addEventListener("click",this.roll.bind(this));
 		this.#diceoutputElement = rootElement.querySelector("*[data-diceoutput]");
 		console.log("ait");
 	}
 	
 	roll() {
		this.#terning.roll();
		this.#diceoutputElement.innerText = this.#terning.getVerdi;
}
 	
}

 function init() {
	const rootElement = document.getElementById("root");
 	new DiceController(rootElement);
 	console.log("Hei");
}
document.addEventListener('DOMContentLoaded', init());
 
 