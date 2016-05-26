import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
public class ShopPanel extends JPanel {  
	PetShop petShop = new PetShop();
	ShopPanel() {
		setLayout(new FlowLayout());
		for( Pet pet : PetShop.petsList){
			add(pet);
		}
	}
	ShopPanel(int i) {
		setLayout(new FlowLayout());
		for( Pet pet : PetShop.searchList){
			add(pet);
		}
	}
	void addUpdate(Pet pet) {
		add(pet);
		updateUI();
	}
	void reload() {
		ShopFrame.shopPanel.removeAll();
		for(Pet pet : PetShop.petsList) {
			add(pet);
		}
		updateUI();
	}
}


