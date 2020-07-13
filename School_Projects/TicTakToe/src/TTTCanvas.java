
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;


public class TTTCanvas extends JPanel {
	int place;
	public int[] board = new int[9];
	public int turn = 1;
	public TTTCanvas() {
		setSize(480,480);
		
	}
	public void setTurn(int a) {
		turn = a;
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawLine(190, 90, 190, 390);
		g.drawLine(90, 190, 390, 190);
		g.drawLine(290, 90, 290, 390);
		g.drawLine(90, 290, 390, 290);
	}
	// recognize which part of board is clicked
	public int where(int x, int y) {
		int a = 0;
		if(90 <= x && x <= 190) {
			if(90 <= y && y <= 190) {
				a =  1;
			}else if(190 <= y && y <= 290 ){
				a= 4;
			}else if(290 <= y && y <= 390) {
				a= 7;
			}
		}else if(190 <= x && x <= 290) {
			if(90 <= y && y <= 190) {
				a= 2;
			}else if(190 <= y && y <= 290) {
				a= 5;
			}else if(290 <= y && y <= 390) {
				a= 8;
			}
		}else if(290 <= x && x <= 390) {
			if(90 <= y && y <= 190) {
				a= 3;
			}else if(190 <= y && y <= 290) {
				a= 6;
			}else if(290 <= y && y <= 390) {
				a= 9;
			}
		}else {
			a = 0;
		}
		return a;
	}
	
	// 
	public void  paintX(int a){
		Graphics g = getGraphics();
		if(g == null) {
			
		}else {
			switch(a) {
			case 1:
				g.drawLine(130, 130, 150, 150);
				g.drawLine(150, 130, 130, 150);
				break;
			case 2:
				g.drawLine(230, 130, 250, 150);
				g.drawLine(250, 130, 230, 150);
				break;
			case 3:
				g.drawLine(330, 130, 350, 150);
				g.drawLine(350, 130, 330, 150);
				break;
				
			case 4:
				g.drawLine(130, 230, 150, 250);
				g.drawLine(150, 230, 130, 250);
				break;
			case 5:
				g.drawLine(230, 230, 250, 250);
				g.drawLine(250, 230, 230, 250);
				break;
			case 6:
				g.drawLine(330, 230, 350, 250);
				g.drawLine(350, 230, 330, 250);
				break;
			case 7:
				g.drawLine(130, 330, 150, 350);
				g.drawLine(150, 330, 130, 350);
				break;
			case 8:
				g.drawLine(230, 330, 250, 350);
				g.drawLine(250, 330, 230, 350);
				break;
			case 9:
				g.drawLine(330, 330, 350, 350);
				g.drawLine(350, 330, 330, 350);
				break;
			}
		}
		
			
	}
	public void drawCircle(Graphics g, int x, int y, int r) {
		  x = x-(r/2);
		  y = y-(r/2);
		  g.drawOval(x, y, r, r);
		}
	
	
	public void paintO(int a) {
		Graphics g = getGraphics();
		switch(a) {
		case 1:
			drawCircle(g,140,140,20);
			break;
		case 2:
			drawCircle(g,240,140,20);
			break;
		case 3:
			drawCircle(g,340,140,20);
			break;
		case 4:
			drawCircle(g,140,240,20);
			break;
		case 5:
			drawCircle(g,240,240,20);
			break;
		case 6:
			drawCircle(g,340,240,20);
			break;
		case 7:
			drawCircle(g,140,340,20);
			break;
		case 8:
			drawCircle(g,240,340,20);
			break;
		case 9:
			drawCircle(g,340,340,20);
			break;
		}
	}
	
	
	
	
}
