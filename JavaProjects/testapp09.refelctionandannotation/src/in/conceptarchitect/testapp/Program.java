package in.conceptarchitect.testapp;

import in.conceptarchitect.animalkingdom.Animal;
import in.conceptarchitect.animalkingdom.Camel;
import in.conceptarchitect.animalkingdom.Cow;
import in.conceptarchitect.animalkingdom.Crocodile;
import in.conceptarchitect.animalkingdom.Dog;
import in.conceptarchitect.animalkingdom.Eagle;
import in.conceptarchitect.animalkingdom.Horse;
import in.conceptarchitect.animalkingdom.Hunter;
import in.conceptarchitect.animalkingdom.Leopard;
import in.conceptarchitect.animalkingdom.Parrot;
import in.conceptarchitect.animalkingdom.Rideable;
import in.conceptarchitect.animalkingdom.Snake;
import in.conceptarchitect.animalkingdom.Tiger;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal [] animals= {
				new Tiger(),
				new Horse(),
				new Leopard(),
				new Crocodile(),
				new Parrot(),
				new Horse(),
				new Dog(),
				new Cow(),
				new Snake(),
				new Eagle(),
				new Camel()
				
		};
		
		for(Animal animal :animals) {
			
			if(animal.isDomestic())
				System.out.println("domestic");
			
			System.out.println(animal.eat());
			System.out.println(animal.move());
			System.out.println(animal.reproduce());
			
			//animal.hunt(); //animal doesn't have hunt
			//Hunter hunter=animal; //doesn't allow implicit cast
			if(animal instanceof Hunter) {
				Hunter hunter=(Hunter) animal;
				System.out.println(hunter.hunt());
			}
			
			if(animal instanceof Rideable) {
				Rideable rideable=(Rideable) animal;
				System.out.println(rideable.ride());
			}
			
			System.out.println(animal.die());
			System.out.println();

		}
			
		
		
		
	}

}
