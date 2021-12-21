
import java.io.*;
import java.util.Random;

public class Ex17_3 {
	public static void main(String[] args) {
		int sum=0;
		try {
			
			File f = new File("Exercise17_03.dat");
	
			Random rand = new Random();
			System.out.println("Start");
			
			
			//determine if the file exists
			if (f.exists()) {
				DataOutputStream write = new DataOutputStream(new FileOutputStream(f,true));
				for (int i=0; i<100; i++) {
					//insert a random number from 0 to 100
					int random = rand.nextInt(101);
					write.writeInt(random);
				}
				write.close();
			}else {
				f.createNewFile();
				DataOutputStream write = new DataOutputStream(new FileOutputStream(f,true));
				
				for (int i=0; i<100; i++) {
					//insert a random number from 0 to 100
					int random = rand.nextInt(101);
					write.writeInt(random);
				}
				write.close();
			}		
			
			DataInputStream input = new DataInputStream(new FileInputStream(f));
			int val;
			
			while((val=input.readInt())!=-1) {
				sum+=val;
			}
			input.close();
			System.out.println("end");
			
		}catch (EOFException e){
			System.out.println("End of File reached successfully");
			System.out.println("Sum of all the ints in the file: "+sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("something else went wrong");
		}
	}
}




