import java.io.*;
import java.util.*;
class PetShop {
	static ArrayList<Pet> petsList;
	static ArrayList<Pet> searchList;
	String name;
	String preed;
	int age;
	String imagePath;
	Pet pet;
	static void add(Pet pet) {
		petsList.add(pet);
	}
	static void delete(int index) {
		petsList.remove(index);
	}
	PetShop() {		
		String fileName = "pets.txt";
		String line = null;
		BufferedReader bufferedReader = null;
		petsList = new ArrayList<Pet>();		//initialize
		try {
			FileReader fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine())!=null) {
				name = line;
				preed = bufferedReader.readLine();
				age = Integer.valueOf(bufferedReader.readLine());
				imagePath = bufferedReader.readLine();
				petsList.add(new Pet(name, age, preed, imagePath));
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		}
		  catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");	
		} finally {
			try {
				if(bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
	
			}
		}
	}
	static ArrayList<Pet> searchPets(String name, String age, String breed) {
		searchList = new ArrayList<Pet>();
		for(Pet pet: petsList){
			if(name.isEmpty() || name == pet.name) {	 // To String, null doesn's means isEmpty().
				if(age.isEmpty() || (Integer.valueOf(age) == pet.age)) {
					if (breed.isEmpty() || breed == pet.breed) 
						searchList.add(pet);
						pet.concealSearchBug();
				}
			}
		}
		return searchList;
	}
}