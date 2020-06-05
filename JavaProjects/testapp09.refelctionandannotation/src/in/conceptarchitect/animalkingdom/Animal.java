package in.conceptarchitect.animalkingdom;

public abstract class Animal {

	public abstract String eat();
	public abstract String reproduce();
	public abstract String move();
	public String die() {
		return getType()+" is dead";
	}
	
	public String getType() {
		//return "Animal";
		return this.getClass().getSimpleName();
	}
	
	public boolean isDomestic() {
		return this instanceof Domestic;
	}
}
