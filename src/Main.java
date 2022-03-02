import java.io.*;
import java.util.Scanner;

public class Main {
    public class main {

        public static void main(String[] args) {
            String dogName, dogBreed;
            int dogAge, count = 0;
            Dog[] dogPound = new Dog[10];

            Scanner keyboard = new Scanner(System.in);
            File binaryFile = new File("Dog.dat");
            // check to see if the file exist, and it's none zero size
            if (binaryFile.exists() && binaryFile.length() > 1l) {
                //read from binary file
                try {
                    ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                    //Read the entire array into dogPound
                    // ReadObject return Object
                    //Dog [] = Object

                    dogPound = (Dog[]) fileReader.readObject();
                    fileReader.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                ;
            } else System.out.println("[None, please enter new dog data]");


            do {
                System.out.println(" please enter the dog's name ( or Quite to exit):");
                dogName = keyboard.nextLine();
                if (dogName.equalsIgnoreCase("quite")) break;
                System.out.println("Please enter dog's breed:");
                dogBreed = keyboard.nextLine();
                System.out.println("Please enter dog's age   : ");
                dogAge = keyboard.nextInt();

                dogPound[count++] = new Dog(dogName, dogBreed, dogAge);

            } while (true);
            try {
                ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
                fileWriter.writeObject(dogPound);
                fileWriter.close();



            } catch (IOException e) {
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }
}

