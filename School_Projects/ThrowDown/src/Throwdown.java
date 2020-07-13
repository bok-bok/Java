

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
public class Throwdown{
	
	// make dice
	public Dice makeDice() {
				
		String userInput = "";
		while(userInput.length() != 5) {
			System.out.print("What is your dices?: ");

			Scanner input = new Scanner(System.in);
			
			userInput = input.nextLine();
			System.out.println(userInput);
			userInput = userInput.replaceAll(" ", "");
			if(userInput.length() != 5)
				System.out.println("There should be five dices to make hands");
		}
		
		
		
		int [] userInputArray = new int[5];
		for(int i = 0;i < userInput.length(); i++) {
			userInputArray[i] =  Integer.parseInt(Character.toString(userInput.charAt(i)));
		}
		
		Dice dice = new Dice(userInputArray[0],userInputArray[1],userInputArray[2],userInputArray[3],userInputArray[4]);
		System.out.println("");
		return dice;
	}
	
	
	// classify
	public String[] classify(Dice dice) {
		int score = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		boolean largeStraight = false;
		boolean smallStraight= false;
		
		boolean	fiveK= false;
		boolean	fourK= false;
		boolean	threeK= false;
		boolean	sumTwo= false;
		
		for(int i = 0; i < dice.dice.length; i++ ) {
			switch(dice.dice[i]) {
			case 1:
				one++;
				break;
			case 2:
				two++;
				break;
			case 3:
				three ++;
				break;
			case 4:
				four ++;
				break;
			case 5:
				five ++;
				break;
			case 6:
				six++;
				break;
			}	
			
		}
		
		int[] hands = {one, two, three, four, five, six};
		int sumDice = one + two*2 + three*3 + four*4 + five*5 + six*6;
	
		// largeStraight
		for(int i = 0; i<=1;i++) {
			if(hands[i]!=0 &hands[i+1] !=0&hands[i+2]!=0&hands[i+3]!=0&hands[i+4]!=0) {
				largeStraight = true;
				
			}	
		}
		
		// smallStraight
		for(int i = 0; i<=2; i++) {
			if(hands[i]!=0 &hands[i+1] !=0&hands[i+2]!=0&hands[i+3]!=0) {
				smallStraight = true;
			}	
		}
		// sums & kinds 
		int whatSum=0;
		for(int i = 0; i < hands.length; i++) {
			switch(hands[i]) {
			case 2:
				sumTwo = true;
				whatSum = i+1;
				break;
			case 3:
				threeK = true;
				whatSum = i+1;
				break;
			case 4:
				fourK = true;
				break;
			case 5:
				fiveK = true;
				break;
			}
		}
		// result and scores
		String result = "";
		if(largeStraight) {
			result = "largeStraight";
			score += 40;
		}else if(smallStraight) {
			result = "smallStraight";
			score += 30;
		}else if(sumTwo&threeK) {
			result =  "fullHouse";
			score += 25;
		}else if(fiveK) {
			result = "Five of a kind";
			score = sumDice + 10;
		}else if(fourK) {
			result = "Four of a kind";
			score = sumDice + 50;
		}else if(threeK) {
			result = "Three of a kind";
			score = sumDice;
		}else if(sumTwo) {
			switch(whatSum) {
			case 1:
				result = "sum1's";
				score += 2;
				break;
			case 2:
				result = "sum2's";
				score += 4;
				break;
			case 3:
				result = "sum3's";
				score += 6;
				break;
			case 4:
				result = "sum4's";
				score += 8;
				break;
			case 5:
				result = "sum5's";
				score += 10;
				break;
			case 6:
				result = "sum6's";
				score += 12;
				break;
			}
		}
		String yourHand ="";
		for(int i = 0; i < dice.dice.length; i++) {
			yourHand += dice.dice[i]+" ";
		}
		String[] resultArray = new String[3];
		resultArray[0] = yourHand;
		resultArray[1] = result;
		resultArray[2] = ""+score;
		result = yourHand + " best is " + result + " with score " + score;
		return resultArray;
		
	}
	
	
	
	
	// print format for sums
	public void print(double n, int sum, double score) {
		DecimalFormat df = new DecimalFormat("00.00");
		for(int i = 0; i <= 7; i++) {
			System.out.print(" ");
		}
		System.out.print(df.format(sum/n*100)+"%");
		for(int i = 0; i <= 7; i++) {
			System.out.print(" ");
		}
		if(sum != 0) {
			System.out.println(df.format(score/sum));
		}else {
			System.out.println("00.00");
		}
	}
	
	// print format for kinds
	public void print2(double n, int sum, double score) {
		DecimalFormat df = new DecimalFormat("00.00");
		for(int i = 0; i <= 6; i++) {
			System.out.print(" ");
		}
		System.out.print(df.format(sum/n*100)+"%");
		for(int i = 0; i <= 7; i++) {
			System.out.print(" ");
		}
		if(sum != 0) {
			System.out.println(df.format(score/sum));
		}else {
			System.out.println("00.00");
		}
	}
	
	// print format for large and small straight
	public void print3(double n, int sum, double score) {
		DecimalFormat df = new DecimalFormat("00.00");
		
		System.out.print(" ");
		
		System.out.print(df.format(sum/n*100)+"%");
		for(int i = 0; i <= 7; i++) {
			System.out.print(" ");
		}
		if(sum != 0) {
			System.out.println(df.format(score/sum));
		}else {
			System.out.println("00.00");
		}
	}
	
	
	
	// simulating 
	public void simulate() {
		Scanner input = new Scanner(System.in);
		System.out.print("how many output do you want to check?: ");
		double n = input.nextInt();
		DecimalFormat df = new DecimalFormat("00.00");
		
		// variables that count occurrence 
		int sumOne = 0;
		int sumTwo = 0;
		int sumThree = 0;
		int sumFour = 0;
		int sumFive = 0;
		int sumSix = 0;
		int threeK = 0;
		int fourK = 0;
		int fiveK = 0;
		int smallStraight = 0;
		int largeStraight = 0;
		int fullHouse = 0;
		
		// variables that store cumulative score
		double sumOneScore = 0;
		double sumTwoScore = 0;
		double sumThreeScore = 0;
		double sumFourScore = 0;
		double sumFiveScore = 0;
		double sumSixScore = 0;
		double threeKScore = 0;
		double fourKScore = 0;
		double fiveKScore = 0;
		double smallStraightScore = 0;
		double largeStraightScore = 0;
		double fullHouseScore = 0;
		
		// loop that actually simulates as user want 
		for(int i = 1; i <= n; i++) {
			Random r = new Random();
			int a = r.nextInt(6)+1;
			int b = r.nextInt(6)+1;
			int c = r.nextInt(6)+1;
			int d = r.nextInt(6)+1;
			int e = r.nextInt(6)+1;
			Dice dice = new Dice(a, b, c, d, e);
			Throwdown game = new Throwdown();
			
			String[] resultArray = game.classify(dice);
			String result = resultArray[1];
			int score = Integer.parseInt(resultArray[2]);
			switch(result) {
			case "sum1's":
				sumOne += 1;
				sumOneScore += score;
				break;
			case "sum2's":
				sumTwo += 1;
				sumTwoScore += score;
				break;
			case "sum3's":
				sumThree += 1;
				sumThreeScore += score;
				break;
			case "sum4's":
				sumFour += 1;
				sumFourScore += score;
				break;
			case "sum5's":
				sumFive += 1;
				sumFiveScore += score;
				break;
			case "sum6's":
				sumSix += 1;
				sumSixScore += score;
				break;
			case "Three of a kind":
				threeK += 1;
				threeKScore += score;
				break;
			case "Four of a kind":
				fourK += 1;
				fourKScore += score;
				break;
			case "Five of a kind":
				fiveK += 1;
				fiveKScore += score;
				break;
			case "fullHouse":
				fullHouse += 1;
				fullHouseScore += score;
				break;
			case "smallStraight":
				smallStraight += 1;
				smallStraightScore += score;
				break;
			case "largeStraight":
				largeStraight += 1;
				largeStraightScore += score;
				break;
			}
		}
		
		// code that print in format
		System.out.print("Outcome       ");
		System.out.print("Frequency       ");
		System.out.println("Avg Score");
		for(int i = 0; i <= 7; i++) {
			System.out.print("-");
		}
		for(int i = 0; i <= 5; i++) {
			System.out.print(" ");
		}
		for(int i = 0; i <= 7; i++) {
			System.out.print("-");
		}
		for(int i = 0; i <= 7; i++) {
			System.out.print(" ");
		}
		for(int i = 0; i <= 7; i++) {
			System.out.print("-");
		}
		System.out.println("");
		
		
		System.out.print("sum1's");
		print(n,sumOne,sumOneScore);
		
		
		System.out.print("sum2's");
		print(n,sumTwo,sumTwoScore);
		
		System.out.print("sum3's");
		print(n,sumThree,sumThreeScore);
		
		System.out.print("sum4's");
		print(n,sumFour,sumFourScore);
		
		System.out.print("sum5's");
		print(n,sumFive,sumFiveScore);
		
		System.out.print("sum6's");
		print(n,sumSix,sumSixScore);
		
		System.out.print("3ofKind");
		print2(n,threeK,threeKScore);
		
		System.out.print("4ofKind");
		print2(n,fourK,fourKScore);
		
		System.out.print("5ofKind");
		print2(n,fiveK,fiveKScore);
		
		System.out.print("smallStraight");
		print3(n,smallStraight,smallStraightScore);
		
		System.out.print("largeStraight");
		print3(n,largeStraight,largeStraightScore);
		
		System.out.print("fullHouse");
		for(int i = 0; i <= 4; i++) {
			System.out.print(" ");
		}
		System.out.print(df.format(fullHouse/n*100)+"%");
		for(int i = 0; i <= 7; i++) {
			System.out.print(" ");
		}
		if(fullHouse != 0) {
			System.out.println(df.format(fullHouseScore/fullHouse));
		}else {
			System.out.println("00.00");
		}
		
		System.out.println("");
		
		
	}
	
	
	public static void main(String[] args) {
		Throwdown game = new Throwdown();
		if(args.length == 0) {
			System.out.println("you should type something in commandlien argument");
		}else if(args[0].equals("classify")) {
			Dice dice = game.makeDice();
			String[] classified = game.classify(dice);
			System.out.println(classified[0] + " best is " + classified[1] + " with score " + classified[2]);
		
		}else if(args[0].equals("simulation")) {
			game.simulate();
		}else {
			System.out.println("you type wrong argument");
		}
		
		
	}

}
