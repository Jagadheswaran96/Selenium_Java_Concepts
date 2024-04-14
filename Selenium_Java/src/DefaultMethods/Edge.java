package DefaultMethods;

public class Edge implements Browser{
	
	public static void main(String[] args) {
		Browser  browser=new Edge();
		browser.browse();
		browser.mediaPlayer();
	}
	
	@Override
	public void browse() {
		System.out.println("this is interface abstract method");
		
	}

}
