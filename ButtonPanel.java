import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonPanel extends JPanel {
	JButton 
		add = new JButton("Add"),
		delete = new JButton("Delete"),
		edit = new JButton("Edit"),
		search = new JButton("Search"),
		home = new JButton("Home"),
		back = new JButton("Back");
/*	Initialization sequence
 * 	Dialog dialogAdd = new Dialog(null);
 *	Dialog dialogEdit = new Dialog(null, 1);
 *	Dialog dialogSearch = new Dialog(null, 1, 1);
*/
	ButtonPanel() {
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialog dialogAdd = new Dialog(null);
				dialogAdd.setVisible(true);
			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeToHome();
				PetShop.petsList.remove(Pet.findOne);
				ShopFrame.shopPanel.updateUI();
				ShopFrame.scrollPane.setVisible(true);
			}
		});		
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeToHome();
				ShopFrame.shopPanel.add(Pet.findOne, PetShop.petsList.indexOf(Pet.findOne)); // bravo!
				ShopFrame.scrollPane.setVisible(true);
			}
		});
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialog dialogEdit = new Dialog(null, 1);
				dialogEdit.setVisible(true);
				Pet.findOne.updateUI();
			}
		});
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialog dialogSearch = new Dialog(null, 1, 1);
				dialogSearch.setVisible(true);
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopFrame.container.add(BorderLayout.CENTER, ShopFrame.scrollPane);
				ShopFrame.scrollPane.setViewportView(ShopFrame.shopPanel);
				ShopFrame.shopPanel.reload();
				changeToHome();
			}
		});
		setLayout(new FlowLayout());
		setBorder(new EtchedBorder());
		add(add);
		add(delete);
		add(edit);
		add(search);
		add(home);
		add(back);
		changeToHome();
	}
	void changeToIndividual() {
		add.setVisible(false);
		search.setVisible(false);
		delete.setVisible(true);
		edit.setVisible(true);
		home.setVisible(true);
		back.setVisible(false);
	}
	void changeToHome(){
		add.setVisible(true);
		search.setVisible(true);
		delete.setVisible(false);
		edit.setVisible(false);
		home.setVisible(false);
		back.setVisible(false);
	}
	void changeForSearch(){
		add.setVisible(false);
		search.setVisible(false);
		delete.setVisible(false);
		edit.setVisible(false);
		home.setVisible(false);
		back.setVisible(true);
	}
}
