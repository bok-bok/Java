

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TTTGame extends JFrame implements MouseListener, ActionListener{
	public static final int playerOne = 1;
	public static final int playerTwo = 2;
	boolean gameFinished = false;
	int turn = playerOne;
	int[] board = new int[9];
	TTTCanvas canvas = null;
	TTTStatus status = null;
	int place = 0;
	Graphics g;
	int p1Win = 0;
	int p2Win = 0;
	int draw = 0;
	
	public TTTGame() {
		setSize(480,580);
		TTTCanvas canvas = new TTTCanvas();
		canvas.addMouseListener(this);
		this.canvas = canvas;
		
		g = this.canvas.getGraphics();
		//add(this.canvas);
		TTTStatus status = new TTTStatus();
		
		this.status = status;
		this.status.button.addActionListener(this);
		//add(this.status);
		this.setLayout(new BorderLayout());
	    this.add(this.status, BorderLayout.NORTH);
	    this.add(this.canvas, BorderLayout.CENTER);
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public boolean check(int x) {
		boolean wincheck = false;
		for(int i = 0; i < 3; i++) {
			if(board[i] == x && board[i+3] == x &&  board[i+6]==x) {
				wincheck = true;
			}
		}
		
		for(int i = 0; i <= 6; i += 3) {
			if(board[i]==x && board[i+1] == x && board[i+2] == x) {
				wincheck = true;
			}
		}
		if(board[0]==x && board[4] == x && board[8] == x) {
			wincheck = true;
		}
		if(board[2]==x && board[4] == x && board[6] == x) {
			wincheck = true;
		}
		return wincheck;
		
	}
	
	public boolean drawcheck() {
		boolean draw = true;
		for(int i = 0; i < 9; i++) {
			if(board[i] == 0) {
				draw = false;
			}
		}
		return draw;
	}
	
	public void game() {

		
		gameFinished = check(turn) || drawcheck();
		if(gameFinished) {
			if(drawcheck()&& !check(turn)){
				draw += 1;
				if(turn == playerOne) {
					canvas.paintX(place);
				}else if(turn == playerTwo) {
					canvas.paintO(place);
				}
				status.draw.setText("Draws: " + draw);
			}else if(turn==playerOne) {
				canvas.paintX(place);
				p1Win += 1;
				status.player1Win.setText("P1 Wins: " + p1Win);
				
			}else {
				canvas.paintO(place);
				p2Win += 1;
				status.player2Win.setText("P2 Wins: " + p2Win);
			}
			
			
		}else if(turn == playerOne) {
			turn = playerTwo;
			status.label.setText("P2's Turn");
			canvas.paintX(place);
		}else if(turn == playerTwo) {
			canvas.paintO(place);
			turn = playerOne;
			status.label.setText("P1's Turn");
			
		}
		
		
			
	}
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (gameFinished) {
			System.out.println("Game is finisehd");
			
		}else{
			int x = e.getX();
			int y = e.getY();
			place = canvas.where(x, y);
			if(place == 0) {
				
			}else if(board[place-1] != 0){ 
				System.out.println("That place is already occupied");
			}else {
				board[place-1] = turn;
				game();
			}
			
			
			
		}
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		canvas.repaint();
		gameFinished = false;
		board = new int[9];
		
	}
	
	public static void main(String[] args) {
		TTTGame game = new TTTGame();
		game.setVisible(true);
		
	}

	

}
