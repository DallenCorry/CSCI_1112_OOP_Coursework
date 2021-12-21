package ex17_7;

/**
 * This class creates 2 loan objects and stores them in a file.
 * @author rmazorow
 * edited by Dallen Corry
 * @version 1.1
 * @since 12/20/2021
 */
import java.io.*;

public class Exercise17_07 {
	
	public static void outputData(File f) throws IOException {
		double sum = 0;
		try {	
			ObjectInputStream input = new ObjectInputStream( new FileInputStream(f));
			Loan obj = (Loan)(input.readObject());
			int count = 0;

			while(obj != null) {
				System.out.println("Loan " + ++count + ": loan amount:"+ obj.getLoanAmount());
				sum += obj.getLoanAmount();
				obj = (Loan)(input.readObject());
			}
			input.close();
			
		}catch (EOFException e) {
			System.out.println("reached end of File");
			System.out.println("total Loan amount:"+sum);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        Loan loan3 = new Loan();
        Loan loan4 = new Loan(1.8, 10, 12345);
        
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            output.writeObject(loan3);
            output.writeObject(loan4);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        try {
        	File f = new File("Exercise17_07.dat");
        	outputData(f);
        }catch(IOException e) {
        	System.out.println("File could not be opened");
        }
    }
}
