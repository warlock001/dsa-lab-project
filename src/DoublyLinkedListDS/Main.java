package DoublyLinkedListDS;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

import static java.nio.file.Files.write;

public class Main {

    public static void main(String[] args) {

        int id;
        boolean exit=false;
        DoublyLinkedList doublyLinkedList = DoublyLinkedList.getInstance();
        cart cart = new cart(10);
        Scanner sc = new Scanner(System.in);
        try {
            File myObj = new File("Pet Data.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //new pet(1, "Dog1", "Russian", "Mud-White");
        //pet brudo = new pet(2, "Dog2", "Golden retriever", "Light Brown");
        //pet mithu = new pet(4, "Parrot1", "Macaw", "red,blue & yellow");
       //pet billi = new pet(3, "Cat1", "Persian", "perl white");

/*
        doublyLinkedList.insertAtFirst(new pet(2, "asma", "nabeel", "kala"));
        doublyLinkedList.insertAtFirst(new pet(1, "Dog1", "Russian", "Mud-White"));*/
        doublyLinkedList.insertAtLast(new pet(3, "Cat1", "Persian", "perl white"));
        //doublyLinkedList.insertAfter(3, new pet(4, "Parrot1", "Macaw", "red,blue & yellow"));

        System.out.println("************************\nWELCOME TO THE PET SHOP\n************************");
        do {
        System.out.println("Select any option and press Enter Key...\n1.  MART\n2.  YOUR CART\n3.  CHECK OUT\n4.  ADD NEW PET\n5.  Delete pet from data\n6.  EXIT");
        int option = sc.nextInt();
        switch (option) {
            case 1 -> {
                System.out.println("Pet List..");
                //doublyLinkedList.printForward();
               // ReadFile readFile=new ReadFile();
                //ReadFile Read = new ReadFile();
               // doublyLinkedList.insertAtLast(readFile.ReadFile());
                try {
                    File myObj = new File("Pet Data.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        pet pet1 = myReader.nextLine();
                        doublyLinkedList.insertAtLast(myReader.next());
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                System.out.println("Select id and press enter key");
                id = sc.nextInt();
                cart.push(id);
                System.out.println("added to cart");
                doublyLinkedList.printPetId(id);
                exit=false;

            }

            case 2 -> {
                System.out.println("***********\nYour Cart\n***********");
                cart.insertionSort(cart.items,cart.pointer+1);
                cart.print();
                exit= false;
            }
            case  3 -> {
                System.out.println("Thanks for visiting pet shop");
                if (cart.pointer == -1) {
                    System.out.println("Cart is Empty");
                } else {
                    if (cart.pointer + 1 > 1) {
                        for (int k = 0; k <= cart.pointer + 1; k++) {
                            System.out.print("YOU BOUGHT  ->");
                           doublyLinkedList.printPetId(cart.items[k]);
                            doublyLinkedList.deleteNodeAtKey(cart.items[k]);
                            cart.pop();
                            exit = false;
                        }
                    } else {
                        System.out.print("YOU BOUGHT  ->");
                       doublyLinkedList.printPetId(cart.items[0]);
                        doublyLinkedList.deleteNodeAtKey(cart.items[0]);
                        cart.pop();
                        exit = false;
                    }
                }
            }
            case  4 ->{

                System.out.println("Enter Type");
                sc.nextLine();
                String type = sc.nextLine();
                //sc.nextLine();
                System.out.println("Breed");
                String breed = sc.nextLine();
                System.out.println("Enter Color");
                String color = sc.nextLine();
                doublyLinkedList.insertAtLast(new pet(doublyLinkedList.last.data.id+1,type,breed,color));
               //write.file(new pet(doublyLinkedList.last.data.id+1,type,breed,color));
               try{
                FileWriter myWriter = new FileWriter("Pet Data.txt",true);
                   myWriter.write(String.valueOf(new  pet(doublyLinkedList.last.data.id+1,type,breed,color)));
                myWriter.close();
               } catch (IOException e) {
                   System.out.println("An error occurred.");
                   e.printStackTrace();
               }



                //cart.push(doublyLinkedList.last.data.id+1);
            }
            case 5->{
                System.out.println("Enter pet id to delete");
                doublyLinkedList.printForward();
                doublyLinkedList.deleteNodeAtKey(id=sc.nextInt());
            }
            case  6-> exit=true;

        }





    }while (!exit);
    }
}

