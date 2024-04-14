package DefaultMethods;

public class Chrome implements Browser{

	public static void main(String[] args) {
		
		Chrome chrome=new Chrome();
		chrome.browse();
		chrome.mediaPlayer();

	}

	@Override
	public void browse() {
		System.out.println("this is interface abstract method");
		
	}

}
