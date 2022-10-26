 
class Dice {
	#verdi;
	
	
	
	
	constructor(verdi = 0) {
		this.#verdi = verdi;
	}
	
	roll() {
		this.#verdi = Math.floor(Math.random() * 6) + 1;
	}
	
	get getVerdi() {
		return this.#verdi;
	}
	
	
	
}