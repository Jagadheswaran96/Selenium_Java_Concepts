package DefaultMethods;

public class Safari implements Browser{
	
	public static void main(String[] args) {
		Browser browser=new Safari();
		browser.browse();
		browser.mediaPlayer();
	}

	@Override
	public void browse() {
		System.out.println("this is interface abstract method");
		
	}
}
