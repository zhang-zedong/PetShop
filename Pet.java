import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class Pet extends JPanel{  
	static Pet findOne = new Pet("null", -1, "null", "null");  // find the individual clicked
	String name, breed, imagePath;
	int age;
	ImageIcon imageIcon;
	JLabel picLabel, nameLabel, ageLabel;
	JPanel textPanel;
	ClickPet clickPet = new ClickPet();
	Pet(String name, int age, String breed, String imagePath) {
		// get the value
		Toolkit tool = this.getToolkit();
		this.imagePath = imagePath;
		this.name = name;
		this.age = age;
		this.breed = breed;
		Image image = tool.getImage(imagePath);
		imageIcon = new ImageIcon(image);
		picLabel = new JLabel();
		picLabel.setIcon(imageIcon);
		nameLabel = new JLabel(name);
		ageLabel = new JLabel(Integer.toString(age));
		// set the GUI
		textPanel = new JPanel();
		setLayout(new FlowLayout());
		textPanel.add(new JLabel("Name:"));
		textPanel.add(nameLabel);
		textPanel.add(new JLabel("Age: "));
		textPanel.add(ageLabel);
		this.breed = breed;
		setBorder(new TitledBorder(this.breed));
		add(picLabel);
		add(textPanel);
		textPanel.setBorder(new EtchedBorder());
		this.addMouseListener(clickPet);
	}
	void concealSearchBug() {
		removeMouseListener(clickPet);
	}
	void update() {
		nameLabel.setText(name);
		ageLabel.setText(Integer.toString(age));
		Toolkit tool = this.getToolkit();
		Image image = tool.getImage(imagePath);
		System.out.println(imagePath);
		imageIcon.setImage(image);
		picLabel.setIcon(imageIcon);
		this.setBorder(new TitledBorder(this.breed));
		this.updateUI();
	}
	class ClickPet implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			ShopFrame.buttonPanel.changeToIndividual();
			Pet.findOne = Pet.this;
			ShopFrame.scrollPane.setVisible(false);			
			ShopFrame.container.add(BorderLayout.CENTER, Pet.findOne);
//			System.out.println(Pet.findOne.name+ "   "+ Pet.this.name);

		}
		public void mouseEntered(MouseEvent e) {		
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
}
