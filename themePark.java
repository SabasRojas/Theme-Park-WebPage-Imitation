/*
	Sabas Rojas
	May 1, 2022
	
	This project is meant to simulate a theme park's online menu/webpage, 
	where the user would be asked to sign in or sign up to reveal the 
	menu where they will be given different options, these being: buy a ticket, 
	reserve a ride, buy food, show the order(s), check out, 
	clear the cart, and/or exit the menu/program. 
*/

import java.util.Scanner;
import java.io.*;

public class themePark {
	public static void main (String [] args) throws IOException{

		boolean signIn = false;
		boolean card = true;
		int finalOption = 0;
		boolean signUpEmail = false;
		int firstTicket = 0;
		String time = "";
		double priceForEach = 0.0;
		String date = "";
		int ticketDecision = 0;
		String sak = "";
		double sakSAK = 0.0;
		int howManyT = 0;
		double firstFinalPrice = 0.0;
		double sakPFE = 0.0;
		double finalPriceSak = 0.0;
		double neededSakPFE = 0.0;
		String time2 = "";
		double priceForEach2 = 0.0;
		String date2 = "";
		String foodItem = "";
		double foodPrice = 0.0;
		String foodDecision = "";
		double foodPrice2 = 0.0;
		double preFinal = 0.0;
		String typeOfPerson = "";
		double secondFinalPrice = 0.0;
		double firstFinalPrice2 = 0.0;
		double actualFinalPrice = 0.0;
		String stateDecision = "";
		String state = "";
		double stateTaxRate = 0.0;
		double stateTaxRateFinale = 0.0;
		double stateTaxRateFinal2 = 0.0;


		welcomingMessage();

		Scanner option_Selected = new Scanner(System.in);
	    System.out.println("Already signed up? [y/n]");
	    String yesNo = option_Selected.next();

	    File authentication = new File("authenticateFile.txt");
	    Scanner myFile1 = new Scanner(authentication);

	   	File ticketsFinal = new File("tickets.txt");
	    Scanner ticketsFile = new Scanner(ticketsFinal);

	    File menuFood = new File("Foodmenu.txt");
	    Scanner foodOfMenu = new Scanner(menuFood);

	    File taxRatesS = new File("StatesTaxRate.txt");
	    Scanner taxRateofStates = new Scanner(taxRatesS);

	    if (yesNo.equals("y")){
	    	myFile1 = new Scanner(authentication);
		    System.out.println("Enter your email address: ");
		    String userEmail = option_Selected.next();
		    	
		    myFile1 = new Scanner(authentication);
		    System.out.println("Enter your password: ");
		    String userPassword = option_Selected.next();
	    	yesSignIn(card, signIn, userEmail, userPassword);
	    	System.out.println("Signed in successfully!");
	    }

	    else if (yesNo.equals("n")){
	    	noSignUp(card, signIn, signUpEmail);
	    }

	    while (card == true){
	    	System.out.println("");
	    	System.out.print("Choose an item [1 - 7]\n1 - Buy a Ticket\n2 - Reserve a Ride\n3 - Buy Food\n4 - Show The Orders\n5 - Check Out\n6 - Clear The Cart\n7 - Exit\n");
	    	System.out.print(">> ");
	        finalOption = option_Selected.nextInt();

	        if (finalOption == 1){
	        	ticketsFile.nextLine();
		        System.out.printf("+-------------------------------------------------+%n");
		        System.out.printf("|              -- // Theme Park // --             |%n");
		        System.out.printf("+-------------------------------------------------+%n");
		        System.out.printf("| %-2s | %-4s | %-5s | %-5s |\n", "Ticket", "Time     ", "Price For Each", "Date     ");
		        System.out.printf("+--------+-----------+----------------+-----------+%n");

		        while(ticketsFile.hasNextLine()){
		        	firstTicket = ticketsFile.nextInt();
	          		time = ticketsFile.next();
	          		priceForEach = ticketsFile.nextDouble();
	          		date = ticketsFile.next();
	          
	          		System.out.printf("| %-3d    | %-9s | $ %-7.2f      |  %-5s |\n", firstTicket, time, priceForEach, date);
	          		System.out.printf("+--------+-----------+----------------+-----------+%n");
	        	}

	        		File ticketsFinal2 = new File("tickets.txt");
	    			Scanner ticketsFile2 = new Scanner(ticketsFinal2);
	    			ticketsFile2.nextLine();

	    			System.out.println("Select a ticket from the list [1 - 8]");
		        	ticketsFile = new Scanner(ticketsFinal);
		       		System.out.print(">> ");
		        	ticketDecision = option_Selected.nextInt();

	    			while(ticketsFile2.hasNextLine()){
		        		firstTicket = ticketsFile2.nextInt();
	          			time = ticketsFile2.next();
	          			priceForEach = ticketsFile2.nextDouble();
	          			date = ticketsFile2.next();

	          			if (ticketDecision == firstTicket){
	          				time2 = time;
	          				priceForEach2 = priceForEach;
	          				date2 = date;
	          			}
	          		}
		        	
		       		System.out.println("Are you a student(s), an adult(a), or a kid(k)? [s/a/k]");
		      		System.out.print(">> ");
		       		sak = option_Selected.next();
		       		System.out.println("How many tickets do you want? ");
		        	System.out.print(">> ");
		        	howManyT = option_Selected.nextInt();
		        	sakPFE = priceForEach2 * howManyT;



		        	System.out.printf("The tickets have been added to your cart, your balance is $%.2f", sakPFE);
	        }

	        else if (finalOption == 2){
	        	if (sak.equals("s")){
	        		sakSAK = 20.00;
	        		typeOfPerson = "student";
	        	}
	        	else if (sak.equals("a")){
	        		sakSAK = 30.00;
	        		typeOfPerson = "adult";
	        	}	
	        	else if (sak.equals("k")){
	        		sakSAK = 0.0;
	        		typeOfPerson = "kid";
	        	}
	        	
	        	//firstFinalPrice = sakPFE + sakSAK; 
	        	firstFinalPrice2 = howManyT * sakSAK;
	        	secondFinalPrice = sakPFE + firstFinalPrice2;

	        	System.out.println("Your ride cost is $" + sakSAK + " per " + typeOfPerson + ", for " + time2);
	        	System.out.printf("The ride reservations have been added to your cart, your balance is $%.2f", secondFinalPrice);
	        	System.out.println("");
	        }

	        else if (finalOption == 3){
	        	foodOfMenu.nextLine();
	        	System.out.printf("+-----------------------------+%n");
		        System.out.printf("|    -- // Food Menu // --    |%n");
		        System.out.printf("+-----------------------------+%n");
		        System.out.printf("| %-5s | %-5s |\n", " Item        ", " Price     ");
		        System.out.printf("+---------------+-------------+%n");

		        while(foodOfMenu.hasNextLine()){
		        	foodItem = foodOfMenu.next();
	          		foodPrice = foodOfMenu.nextDouble();
	          
	          		System.out.printf("| %-13s |  $ %-5.2f    |\n", foodItem, foodPrice);
	          		System.out.printf("+---------------+-------------+%n");
	        	}

	        	File menuFood2 = new File("Foodmenu.txt");
	    		Scanner foodOfMenu2 = new Scanner(menuFood2);

	        	System.out.println("What do you want to order? (type the menu item)");
	        	foodOfMenu = new Scanner(menuFood);
		       	System.out.print(">> ");
		        foodDecision = option_Selected.next();

		        while(foodOfMenu2.hasNextLine()){
		        		foodItem = foodOfMenu2.next();
	          			foodPrice = foodOfMenu2.nextDouble();

	          			if (foodDecision.equals(foodItem)){
	          				foodPrice2 = foodPrice;	          				
	          			}
	          	}

	          	preFinal = foodPrice2 + firstFinalPrice;

	          	System.out.println("A " + foodDecision + " is added to your order.");
	          	System.out.printf("Your balance is $%.2f", (preFinal + secondFinalPrice));
	          	System.out.println("");

	        }

	        else if (finalOption == 4){
	        	System.out.println("");
	        	System.out.print(howManyT + " tickets were acquired for Theme Park at " + time2 + " : " + date2);
	        	System.out.printf(" costing $%.2f\n", sakPFE);
	        	System.out.println("A ride was also reserved costing $" + firstFinalPrice2);
	        	System.out.println("Lastly, you also acquired a " + foodDecision + " costing $" + foodPrice2);
	        }

	        else if (finalOption == 5){
	        	taxRateofStates.nextLine();

	        	while (taxRateofStates.hasNextLine()){
	        		state = taxRateofStates.next();
	        		stateTaxRateFinale = taxRateofStates.nextDouble();
	        	}

	        	System.out.println("");
	        	System.out.println(howManyT + " tickets were acquired for Theme Park at " + time2 + " : " + date2 + " costing $" + sakPFE);
	        	System.out.println("A ride was also reserved costing $" + firstFinalPrice2);
	        	System.out.println("Lastly, you also acquired a " + foodDecision + " costing $" + foodPrice2);

	        	actualFinalPrice = secondFinalPrice + preFinal;

	        	System.out.println("");
	        	System.out.printf("Your total cost before tax is $%.2f", actualFinalPrice);
	        	System.out.println("");

	        	File taxRatesS2 = new File("StatesTaxRate.txt");
	    		Scanner taxRateofStates2 = new Scanner(taxRatesS2);

	    		System.out.println("Please enter your state [Texas, New-York, ..]");
	        	taxRateofStates = new Scanner(taxRatesS);
		       	System.out.print(">> ");
		        stateDecision = option_Selected.next();

		        while(taxRateofStates2.hasNextLine()){
		        	state = taxRateofStates2.next();
		        	stateTaxRateFinale = taxRateofStates2.nextDouble();

		        	if (stateDecision.equals(state)){
		        		stateTaxRateFinal2 = stateTaxRateFinale;
		        	}
		        }

		        System.out.println("Your tax rate is: " + stateTaxRateFinal2);
		        System.out.println("Your total cost after tax is $" + (actualFinalPrice + stateTaxRateFinal2));

		        System.out.println("Please enter your card number [16 digits]:");
	       		System.out.print(">> ");
	       		String cardNumber = option_Selected.next();
	       		boolean trueFalse = true;

	        	while (trueFalse) {
	        		int cardNumber_Size = cardNumber.length();
		        	if (cardNumber_Size < 16 || cardNumber_Size > 16) {
		            	System.out.println("Enter a valid card number: ");
		            	cardNumber = option_Selected.next();
		        	} 
		        	else if (cardNumber_Size == 16) {
		            	System.out.println("The transaction has been approved! Thank you for your purchase.");
		            	System.out.println("Your cart is now empty!");
		            	time2 = "";
		        		secondFinalPrice = 0.0;
		        		date2 = "";
		        		firstFinalPrice2 = 0.0;
		        		foodDecision = "";
		        		foodPrice2 = 0.0;
		        		sakPFE = 0.0;
		        		howManyT = 0;
		            	trueFalse = false;
		            	
		        	}
	        	}
	        }

	        else if (finalOption == 6){
	        	System.out.println("Are you sure? [y/n]");
	        	System.out.print(">> ");
	        	String option6decision = option_Selected.next();
	        	if (option6decision.equals("y")){
	        		time2 = "";
	        		secondFinalPrice = 0.0;
	        		date2 = "";
	        		firstFinalPrice2 = 0.0;
	        		foodDecision = "";
	        		foodPrice2 = 0.0;
	        		sakPFE = 0.0;
	        		howManyT = 0;
	        		System.out.println("Items from the cart have been removed!");
	        	}
	        	else if (option6decision.equals("n")){
	        		System.out.print("Cart not cleared!");
	        		System.out.println("");
	        	}
	        }

	        else if (finalOption == 7){
	        	System.out.println("Have a great day, see you soon!");
	        	System.exit(0);
	        }

	        else if (finalOption < 1 || finalOption > 7) {
	        	System.out.println("Not a valid option try again!");
	    	}
	    }
	}  

	public static void welcomingMessage(){
		System.out.println("");
		System.out.println("*************************************");
		System.out.println("******* Welcome to Theme Park *******");
		System.out.println("*************************************");
	}

	public static boolean yesSignIn (boolean card, boolean signIn, String userEmail, String userPassword) throws FileNotFoundException{ 

		File authentication = new File("authenticateFile.txt");
		Scanner fileScnr = new Scanner(authentication);
		
		Scanner user_input = new Scanner(System.in);
		
		while (fileScnr.hasNext()) {
			String line = fileScnr.nextLine();
			String [] content = line.split(" ");
			
			if((userEmail.equals(content[0])) && (userPassword.equals(content[1]))) {
				signIn = true;
				card = false;
				return true;
			}
		}
	return false;
	}

	public static boolean noSignUp (boolean card, boolean signIn, boolean signUpEmail){

		Scanner user_input = new Scanner(System.in);
		
		boolean checkEmail = true;
		while (checkEmail) {
			System.out.println("Enter your email address..."); 
			String email = user_input.next();
			boolean checkForAt = emailChecker(email);
			if (checkForAt) {
				checkEmail = false;
			}
		}
		
		boolean checkPassword = true;
		while(checkPassword) {
			System.out.println("Enter your password: ");
			String password1 = user_input.next();
			
			System.out.println("Enter your password again: ");
			String password2 = user_input.next();
			if (password1.equals(password2)) {
				// User password checker to check the password
				passwordChecker(password1);
				checkPassword = false;
			} else {
				System.out.println("The passwords did not matched enter the password again");
			}
		}
	return card;
	}

	public static void passwordChecker (String password) {
		int upperCase = 0;
		int lowerCase = 0;
		int number = 0;
		int chars = 0;
		int password_length = password.length();
		
		if(password_length >= 8) {
			for(int index = 0; index < password_length; index++) {
				if(Character.isLowerCase(password.charAt(index))) {
					lowerCase++;
				} else if (Character.isUpperCase(password.charAt(index))) {
					upperCase++;
				} else if (Character.isDigit(password.charAt(index))) {
					number++;
				} else if (password.charAt(index) == '!' || password.charAt(index) == '@' || password.charAt(index) == '&' || password.charAt(index) == '$') {
					chars++;
				}
			}
		}
		if(lowerCase >= 1 && upperCase >= 1 && number >= 1 && chars >= 1) {
			System.out.println("Signed up successfully!");
		}
	}
	
	public static boolean emailChecker (String email) {
		boolean check = false;
		for(int index = 0; index < email.length(); index++) {
			if(email.charAt(index) == '@') {
				check = true;
				return true;
			}
		}
		return false;
	}
}