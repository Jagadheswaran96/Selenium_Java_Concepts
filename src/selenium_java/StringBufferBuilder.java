package selenium_java;

public class StringBufferBuilder {
	
    public static void main(String[] args) {
    	
    	//Both provide similar methods like append(), insert(), replace(), delete(), and reverse() 
    	//for string manipulation.
    	
        StringBuffer sb = new StringBuffer("Hello");

        // Create two threads that modify the same StringBuffer object
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append("A");
            }
            System.out.println("Thread 1: " + sb);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append("B");
            }
            System.out.println("Thread 2: " + sb);
        });

        t1.start();
        t2.start();
        
        //*********************************************
        
        StringBuilder sbb = new StringBuilder("Hello");

        // Create two threads that modify the same StringBuilder object
        Thread t11 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sbb.append("A");
            }
            System.out.println("Thread 3: " + sbb);
        });

        Thread t22 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sbb.append("B");
            }
            System.out.println("Thread 4: " + sb);
        });

        t11.start();
        t22.start();
        
        //**********************************
        
        long startTime, endTime;

        // Using StringBuffer
        StringBuffer stringBuffer = new StringBuffer("Hello");
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");

        // Using StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Hello");
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");
    }
}

