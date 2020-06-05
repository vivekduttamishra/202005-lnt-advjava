package in.conceptarchitect.animalkingdom;

public class Tiger extends Cat {

	
	@Override
	public String hunt() {
		// TODO Auto-generated method stub
		System.out.println("hunt invoked for "+getType());
		return super.hunt();
	}
}
