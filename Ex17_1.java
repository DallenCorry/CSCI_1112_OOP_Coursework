import java.io.*;
import java.util.*;

public class Ex17_1 {

	public static void main(String[] args) {
		try {
			
			File f = new File("Exercise17_01.txt");

			Random rand = new Random();
;
			if (f.exists()) {
				PrintWriter write = new PrintWriter(new FileOutputStream(f,true));
				for (int i=0; i<100; i++) {
					write.append(rand.nextInt(101)+" ");
//					write.append(' ');
				}
				write.close();
			}else {
				f.createNewFile();
				PrintWriter write = new PrintWriter(f);
				for (int i=0; i<100; i++) {
					write.print(rand.nextInt(101)+ " ");
				}
				write.close();
			}		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("something else went wrong");
		}
	}

}
