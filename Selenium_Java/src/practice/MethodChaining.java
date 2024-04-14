package practice;

public class MethodChaining {
	
	String place;
	String travel;
	
	public String getPlace() {
		return place;
	}

	public MethodChaining setPlace(String place) {
		this.place = place;
		return this;
	}

	public String getTravel() {
		return travel;
	}

	public MethodChaining setTravel(String travel) {
		this.travel = travel;
		return this;
	}
	
	public MethodChaining print() {
		System.out.println(getPlace() + " ku " + getTravel() + " la porom");
		return this;
	}

	public static void main(String[] args) {
		
		MethodChaining methodChaining=new MethodChaining();
		methodChaining.setPlace("Ooty");
		methodChaining.setTravel("Car");
		methodChaining.print();
		
		methodChaining.setPlace("Ooty").setTravel("Car").print();

	}

}
