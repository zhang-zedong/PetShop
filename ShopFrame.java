import javax.swing.*;
import java.awt.*;
public class ShopFrame extends JFrame {
	static Container container;
	static ShopPanel shopPanel = new ShopPanel();
	static ButtonPanel buttonPanel = new ButtonPanel();
	static JScrollPane scrollPane = new JScrollPane();
	ShopFrame() {
		super("PetShop");
		container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(BorderLayout.SOUTH, buttonPanel);
		scrollPane.setViewportView(shopPanel);
		container.add(BorderLayout.CENTER, scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocation(220, 80);
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ShopFrame();
			}
		});
	}
	
}
