import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
public class Dialog extends JDialog {
	JTextField name, age, breed, imagePath;
	JButton
		open = new JButton("OpenFile"),
		save = new JButton("Save"),
		search = new JButton("Search");
	public Dialog(JFrame parent) {
		super(parent, "Add the pet", true);
		name = new JTextField(20);
		age = new JTextField(20);
		breed = new JTextField(20);
		imagePath = new JTextField(15);
		setLayout(new FlowLayout());
		open.addActionListener(new ChooseFilePath());
		save.addActionListener(new AddPetListener());
		add(new JLabel("Name:  "));
		add(name);
		add(new JLabel("Age:     "));
		add(age);
		add(new JLabel("Breed: "));
		add(breed);		
		add(imagePath);
		add(open);
		add(save);
		setSize(300, 200);
		setLocation(500,300);
	} 
	public Dialog(JFrame parent, int i) {
		super(parent, "Edit the pet", true);
//		System.out.println(Pet.findOne.name+ "   ");
		this.name = new JTextField(Pet.findOne.name, 20);
		this.age = new JTextField(Integer.toString(Pet.findOne.age), 20);
		this.breed = new JTextField(Pet.findOne.breed, 20);
		this.imagePath = new JTextField(Pet.findOne.imagePath, 15);
		setLayout(new FlowLayout());
		open.addActionListener(new ChooseFilePath());
		save.addActionListener(new EditPetListener());
		add(new JLabel("Name:  "));
		add(this.name);
		add(new JLabel("Age:     "));
		add(this.age);
		add(new JLabel("Breed: "));
		add(this.breed);		
		add(this.imagePath);
		add(open);
		add(save);
		setSize(300, 200);
		setLocation(500,300);
	}
	public Dialog(JFrame parent, int i, int j) {
		super(parent, "Search pets", true);
		name = new JTextField(20);
		age = new JTextField(20);
		breed = new JTextField(20);
		setLayout(new FlowLayout());
		save.addActionListener(new SearchPetsListener());
		add(new JLabel("Name:  "));
		add(name);
		add(new JLabel("Age:     "));
		add(age);
		add(new JLabel("Breed: "));
		add(breed);		
		save.setText("Search");
		add(save);
		setSize(300, 165);
		setLocation(500,300);
	}
	class ChooseFilePath implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			JFileChooser 
				fileChooser = new JFileChooser("D:\\Eclipse\\PetShop");
			FileNameExtensionFilter 
				filter = new FileNameExtensionFilter("Choose:(JPG/GIF/BMP)",
						"JPG","GIF","BMP");
			fileChooser.setFileFilter(filter);
			int i = fileChooser.showOpenDialog(null);
			if(i == JFileChooser.APPROVE_OPTION) {
				File imageFile = fileChooser.getSelectedFile();
				imagePath.setText(imageFile.getPath());
			}				
		}			
	}
	class AddPetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {	
			Pet pet = new Pet(name.getText(), Integer.valueOf(age.getText()),
					breed.getText(), imagePath.getText());
			PetShop.add(pet);
			ShopFrame.shopPanel.addUpdate(pet);
			dispose();
		}
	}
	class EditPetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Pet.findOne.name = name.getText();
			Pet.findOne.age = Integer.valueOf(age.getText());
			Pet.findOne.breed = breed.getText();
			Pet.findOne.imagePath = imagePath.getText();
			Pet.findOne.update();
			dispose();
		}
	}
	class SearchPetsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			PetShop.searchPets(name.getText(), age.getText(),breed.getText());
			ShopPanel searchPanel = new ShopPanel(1);
			ShopFrame.container.add(BorderLayout.CENTER, ShopFrame.scrollPane);
			ShopFrame.scrollPane.setViewportView(searchPanel);
			ShopFrame.buttonPanel.changeForSearch();
			dispose();
		}
	}
}