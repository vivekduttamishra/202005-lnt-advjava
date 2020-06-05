package in.conceptarchitect.animalkingdom;


//@SpecialBehavior
public  abstract class Bird extends Animal {

//	@Override
//	public String getType() {
//		// TODO Auto-generated method stub
//		return "Bird";
//	}
	
	
	@Override
	public String reproduce() {
		// TODO Auto-generated method stub
		return getType()+" Lays Eggs";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return fly();
	}
	
	@SpecialBehavior
	public String fly() {
		return getType()+" Fly";
	}

}
