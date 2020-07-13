import java.util.Random;
import java.math.*;
import java.util.Scanner;
public class CatapultGame {
	
	int score = 0; // declare score variable 
	int minDistance = 50; // declare minimum distance
	int maxDistance =  1000; // declare maximum distance
	Random R = new Random(); 
	double targetDistance = minDistance +(maxDistance - minDistance)*R.nextDouble();
	
	Catapult catapult  = new Catapult();
	double result;
	static boolean condition = true;
	double distance;
	static boolean condition2 = true;
	static int highestscore;
	int shots = 5;
	
	
	
	// function to get score
	public void getScore() {
		distance = targetDistance - catapult.realvalue;
		double absdistance = Math.abs(distance);
		// if absolute distance is lower than 2 print perfect hit and add 10 to score
		if (absdistance <= 2) {
			System.out.println("bird hits middle of the target!: +10 scores");
			score += 10;
		// if absolute distance is lower than 5 print good hit and add 7 to score
		}else if(absdistance <= 5){
			System.out.println("bird hits the target!: +7 scores");
			score += 7;
		// if absolute distance is lower than 10 print hit and add 3 to score
		}else if(absdistance <= 10) {
			System.out.println("bird barely hits the target!: +3 scores");
			score += 3;
		
		}else if(absdistance <= 50 && distance > 0){
			System.out.println("bird went little bit short");
		}else if(absdistance <= 50 && distance < 0){
			System.out.println("bird went little bit far");
		}else if(absdistance <= 100 && distance > 0) {
			
			System.out.println("bird went too short!");
		}else if(absdistance <= 100 && distance < 0) {
			System.out.println("bird went too far!");
		}else if(distance > 0) {
			
			System.out.println("bird went way too short");
		}else {
			System.out.println("bird went way too far");
		}
		System.out.println("your current score is "+ score);
		catapult.trigger = false;
	}
	
	//function that counts number of words which will be used to figure out kinds of cheat
	public int wordcount(String string)  
    {  
      int count=0;  
  
        char ch[]= new char[string.length()];     
        for(int i=0;i<string.length();i++)  
        {  
            ch[i]= string.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                count++;  
        }  
        return count;  
    }
	
	/// function that get input and figure out what to do based on input
	public void getInput() {
		if(shots == 0) {
			System.out.println("you can type reset to start new round");
		}else {
			System.out.print("What is your next move?: ");
		}
		
		
		Scanner str = new Scanner(System.in);
		String n = str.nextLine();
		n = n.toLowerCase();
		// if input contains angle trigger catapult's setAngle function
		if(n.contains("angle") && shots !=0) {
			Scanner clear = new Scanner(n).useDelimiter("[^0-9]+");
			int value = clear.nextInt();
			catapult.setAngle(value);
			catapult.setvalue();
			clear.close();
			
		// if input contains velocity trigger catapult's setVelocity function
		}else if(n.contains("velocity") && shots != 0){
			
			Scanner clear = new Scanner(n).useDelimiter("[^0-9]+");
			int value = clear.nextInt();
			catapult.setVelocity(value);
			catapult.setvalue();
		
			clear.close();
		
		// if input is equal with reset 
		}else if(n.equals("reset")) {
			//start new round if shots is 0
			if(shots == 0) {
				condition = false;
				
			}else {
				// reset all variables
				catapult.setAngle(45);
				catapult.setVelocity(50);
				score = 0; System.out.println("your current score is 0");
				shots = 5; System.out.println("you have 5 shots");
			}
		// if input contains fire, trigger catapult's fire function
		}else if(n.contains("fire") && shots != 0) {
			catapult.fire();
			catapult.setvalue();
			shots -= 1;
		// if input is equal to quit, quit the game
		}else if(n.equals("quit")) {
			
			condition = false;
			condition2 = false;
			System.out.println("your best score was :" + highestscore);
			System.out.println("bye");
		// if input is equals to inspect shows current angle, velocity and target distance
		}else if(n.equals("inspect")&& shots != 0) {
			if(catapult.catapultQuality <= 3) {
				System.out.println("your catapult is bad");
			}else if(catapult.catapultQuality <= 7) {
				System.out.println("your catapult is ok");
			}else {
				System.out.println("your catapult is good");
			}
			System.out.println("Angle: "+catapult.angle);
			System.out.println("Velocity: " + catapult.velocity);
			
			if(targetDistance<333) {
				System.out.println("The target is at frontrange");
			}else if(targetDistance < 666) {
				System.out.println("The target is at midrange");
			}else {
				System.out.println("The target is at endrange");
			}
			
		// if input contains score, shows current score and best score
		}else if(n.contains("score")&& shots != 0){
			System.out.println("current score: " + score);
			System.out.println("best score: "+ highestscore);
			
		// if input contains cheat 
		// program counts number of words in input to figure out which kind of cheat user used
		}else if(n.contains("cheat")){
			Scanner cheat = new Scanner(n);
			int word = wordcount(n); 
			String ints = n.replaceAll("[a-zA-Z]", ""); 
			Scanner cheat3 = new Scanner(ints);
			// based on number of words, program will trigger different kinds of cheat
			if(word == 4) {
				System.out.println("your catapultQuality was " +catapult.catapultQuality);
				System.out.println("target distance is " +targetDistance);
				shots = Integer.parseInt(cheat3.next());
				System.out.println("you have "+ shots + " shots now");
				catapult.setCatapultQuality(Integer.parseInt(cheat3.next()));
				targetDistance = Double.parseDouble(cheat3.next());
				
			}else if(word == 3) {
				System.out.println("your catapultQuality was " +catapult.catapultQuality);
				System.out.println("target distance is " +targetDistance);
				shots = Integer.parseInt(cheat3.next());
				catapult.setCatapultQuality(Integer.parseInt(cheat3.next()));
				System.out.println("you have "+ shots + " shots now");
			}else if(word == 2) {
				System.out.println("your catapultQuality is " +catapult.catapultQuality);
				System.out.println("target distance is " +targetDistance);
				shots = Integer.parseInt(cheat3.next());
				System.out.println("you have "+ shots + " shots now");
			}else {
				System.out.println("your catapultQuality is " +catapult.catapultQuality);
				System.out.println("target distance is " +targetDistance);
				
				
			}
			
			
		}else {
			
			if(shots != 0) {
				// if user typed weird input, program will ask user to type again
				System.out.println("type again");
			}else {
				// if user used all shots, other condition will not be triggered except cheat and reset
				// so user will finally come to this stage.
				// Then program will ask user to type reset to start next round
				System.out.println("The round is over.");
				System.out.println("You can type reset to begin a new game.");
				getInput();
			}
			
		}
		
	}
	
	
	
	// function that describes the variables to user at start of the game
	public void start() {
		System.out.println("Welcome to  Catapult  Game 2020!");
		System.out.println("Launch angle  is set to 45.0");
		System.out.println("Velocity is set  to 50.0");
		System.out.println("you have  5 shots remaining.");
		if(targetDistance<300) {
			System.out.println("The target is at frontrange");
		}else if(targetDistance < 700) {
			System.out.println("The target is at midrange");
		}else {
			System.out.println("The target is at endrange");
		}
		if(catapult.catapultQuality <= 3) {
			System.out.println("your catapult is bad");
		}else if(catapult.catapultQuality <= 7) {
			System.out.println("your catapult is ok");
		}else {
			System.out.println("your catapult is good");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// while loop for game
		while(condition2) {
			condition = true;
			CatapultGame game = new CatapultGame();
			game.start();
			// while loop for each round
			while(condition) {
				System.out.println("");
				game.getInput();
				// when user type fire as input, boolean variable trigger changes to true 
				// so below code is work
				if(game.catapult.trigger && game.shots >=0) {
					game.getScore();
					// in getScore, trigger changes to false again.
					System.out.println("your remaining shots is " + game.shots);
				}
				
				// when user use all shots, update best score.
				if(game.shots == 0) {
					System.out.println("");
					if(game.highestscore < game.score) {
						game.highestscore = game.score;
					}
					
					System.out.println("This round is finished!!!");
					System.out.println("your final score this round is "+ game.score);
					System.out.println("your bests score is " + game.highestscore);
					System.out.println("");
					game.getInput();
					// there is two ways to continue the game(use cheat or reset)
					if(condition2 && !condition) {
						// case of reset
						System.out.println("New round!!");
					}else if(condition){
						// case of cheat
						System.out.println("you used cheat to continue the game!");
					}
				}
				System.out.println("");
			}
			
		}
	}
}
