import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class TTTStatus extends JPanel{
	JButton button;
	JLabel label;
	JLabel player1Win;
	JLabel player2Win;
	JLabel draw;
	public TTTStatus() {
		setSize(480,100);
		setLayout(new FlowLayout());
		button = new JButton("New Game");
		add(button);
		label = new JLabel("P1's Turn");
		add(label);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int P1 = 0;
		int P2 = 0;
		player1Win = new JLabel("P1 Wins: "+ P1);
		player2Win = new JLabel("P2 Wins: "+ P2);
		draw = new JLabel("Draws: 0");
		panel.add(player1Win);
		panel.add(player2Win);
		panel.add(draw);
		add(panel);
		
	}
	
	
	
}
