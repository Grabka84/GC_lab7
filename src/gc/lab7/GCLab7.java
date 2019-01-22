package gc.lab7;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GCLab7 {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		System.out.println("GC Lab 7 - Input Validator");
		String name = isName(scnr);
		System.out.println("Your name is: " + name);
		String email = isEmail(scnr);
		System.out.println("Your email address is: " + email);
		String phone = isPhoneNumber(scnr);
		System.out.println("Your phone number is: " + phone);
		String date = isDate(scnr);
		System.out.println("The date is: " + date);
		System.out.println("Goodbye!");
	}

	// method to validate if it is a name, maximum length 30, must start with capital letter, and only contain alphabetical chars
	public static String isName(Scanner scnr) {
		boolean isValid = false;
		String name;
		do {
			System.out.print("Please input your name: ");
			name = scnr.nextLine();
			if(name.matches("([A-Z][a-z]+\\s*([A-Z][a-z]+)*){1,30}")) {
				isValid = true;
			} else {
				System.out.println("You have entered an invalid name format. (ex: Mariah Hall) ");
			}
		} while(!isValid);
		return name;
	}
	
	// method to validate if it is an email address, alpha{5-30}@alpha{5-10}.alpha{2-3}, no special characters
	public static String isEmail(Scanner scnr) {
		boolean isValid = false;
		String email;
		do {
			System.out.print("Please enter your email address: ");
			email = scnr.nextLine();
			if(email.matches("[A-z\\d._]{5,30}@[A-z\\d]{5,10}.[A-z\\d]{2,3}")) {
				isValid = true;
			} else {
				System.out.println("You have entered an invalid email format. (ex: Mariah.Hall@gmail.com) ");
			}
		} while(!isValid);
		return email;
	}
	
	// method to validate if it is a phone number 333-333-4444
	public static String isPhoneNumber(Scanner scnr) {
		boolean isValid = false;
		String phone;
		do {
			System.out.print("Please enter your phone number: ");
			phone = scnr.nextLine();
			if(phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
				isValid = true;
			} else {
				System.out.println("You have entered an invalid phone number format. (ex: 333-333-4444");
			}
		} while(!isValid);
		return phone;
	}
	
	// method to validate if it is a date in format dd/mm/yyyy - stolen directly from validator and updated for my purposes
	public static String isDate(Scanner scnr) {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		format.setLenient(false); // <-- date format must match
		boolean isValid = false;
		Date date = null;
		String input;
		do {
			// Step 1: get the raw string
			System.out.println("Please enter the date: ");
			input = scnr.nextLine();
			// Step 2: convert it to a date
			try {
				// format.parse throws a ParseException, which is a checked exception and MUST be caught.
				date = format.parse(input);
				// If exception doesn't occur, it's valid.
				isValid = true;
			} catch (ParseException ex) {
				// If exception occurs, it's invalid.
				isValid = false;
				System.out.println("Enter a valid date in format dd/mm/yyyy.");
			}
		} while (!isValid);
	        String formattedDate = format.format(date); // had to add this to get rid of extra info in the format date originally returned
		return formattedDate;
	}
}
