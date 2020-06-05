package in.conceptarchitect.animalkingdom;


@Speciality(name="humanSpeak")
public class Parrot extends Bird implements Domestic{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+ " is fruitarian";
	}
	
	@SpecialBehavior
	public String humanSpeak() {
		return getType()+" can speak human in human like voice ";
	}

}
