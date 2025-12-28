package selenium_java;

import java.time.Instant;

public class Time {

	public static void main(String[] args) {
		Instant timestamp = Instant.now();
		System.out.println(timestamp);
		Instant specificTime=Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println(specificTime);
	}

}
