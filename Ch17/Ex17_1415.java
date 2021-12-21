package ex17;

import java.io.*;
import java.util.*;

public class Ex17_1415 {
	
	public static void encrypt(File f1, File f2) {
		try {
			try {
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(f1));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f2));
				int n = in.read();
				//read all the bytes
				while(n != -1) {
					//Encrypt the bytes
					out.write(n+5);
					n = in.read();
				}
				//close the streams
				in.close();
				out.close();
			}catch(EOFException e) {
				System.out.println("Reached end of file");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void decrypt(File f1, File f2){
		try {
			try {
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(f1));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f2));
				int n = in.read();
				//read all the bytes
				while(n != -1) {
					//Decrypt the bytes
					out.write(n-5);
					n = in.read();
				}
				//close the streams
				in.close();
				out.close();
			}catch(EOFException e) {
				System.out.println("Reached end of file");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void myRead(File f) {
		try(FileInputStream input = new FileInputStream(f); ) {
			// Read values from the file 
			int value;
			while ((value = input.read()) != -1)
				System.out.print(value + " ");
			System.out.println();
			}catch(IOException e) {
				System.out.println("Unable to access file "+e.getMessage());
			}
	}
	
	public static void main(String[] args) {
		//Get input from the Console rather than the command line args.
		Scanner userIn = new Scanner(System.in);
		
		while(1>0) {
			System.out.println("What would you like to do?");
			System.out.println("\t1. Encrypt a file");
			System.out.println("\t2. Decrypt a file");
			System.out.println("\t3. read contents of a file");
			System.out.println("\t0. Exit");
			switch(userIn.nextInt()) {
				//Encrypt file
				case(1):
					System.out.println("Enter file to be encrypted");
					File file1 = new File(userIn.next());
					
					System.out.println("Enter file to save the encryption");
					File file2 = new File(userIn.next());
					
					encrypt(file1,file2);
					break;
				//Decrypt file
				case(2):
					System.out.println("Enter file to be decrypted");
					File file3 = new File(userIn.next());
				
					System.out.println("Enter file to save the decryption");
					File file4 = new File(userIn.next());
				
					decrypt(file3,file4);
					break;
				//Read file
				case(3):
					System.out.println("Enter file to be read");
					myRead(new File(userIn.next()));
					break;
				//Exit program
				case(0):
					userIn.close();
					System.out.println("Goodbye");
					System.exit(0);
				//Default
				default:
					System.out.println("Enter a number 0-3");
			}
		}
	}

}
