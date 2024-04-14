package practice;

import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;

public class FindHiddenFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File[] hiddenFiles=new File("C:\\Users\\Jagadhez\\OneDrive")	
		.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				file.isHidden();
				return true;
			}
		});
		for(File file:hiddenFiles) {
			System.out.println(file.getName());
		}
	}

}
