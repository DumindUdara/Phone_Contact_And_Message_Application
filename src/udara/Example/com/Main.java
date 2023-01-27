package udara.Example.com;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println(" Well Come To My Mobile Phone Contact Menu . ");

        showInitialOptions();

    }

    private static void showInitialOptions(){
        System.out.println("Please Select one Option : " + "\n\t1. Manage Contacts" + "\n\t2. Message"+ "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                manageContact();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please select one : " +
                "\n\t1. Show all massages" +
                "\n\t2. Send a new massage" +
                "\n\t3. Go Back");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllMassages();
                break;
            case 2:
                sendNewMassag();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void sendNewMassag() {
        System.out.println("Who are you going to send a massage?");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name of the contact");
            sendNewMassag();
        }else{
            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                }
            }
            if(doesExist){
                System.out.println("What are you going to say");
                String text = scanner.next();
                if(text.equals("")){
                    System.out.println("Please enter some message");
                    sendNewMassag();
                }else{
                    id++;
                    Massage newMassage = new Massage(text,name,id);
                    for(Contact c: contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Massage> newMassages = c.getMassages();
                            newMassages.add(newMassage);
                            c.setMassages(newMassages);

                        }
                    }
                    showInitialOptions();
                }

            }else {
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void showAllMassages() {
        ArrayList<Massage> allMassages = new ArrayList<>();
        for(Contact c: contacts){
            allMassages.addAll(c.getMassages());
        }
        if(allMassages.size() > 0){
            for(Massage m: allMassages){
                m.getDetails();
                System.out.println("*************");
            }

        }else{
            System.out.println("You do not have any massage ");
        }
        showInitialOptions();
    }

    private static void manageContact(){
        System.out.println("Please select one : " +
                "\n\t1. Show all contacts" +
                "\n\t2. Add the new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact"  +
                "\n\t5. Go Back");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllContact();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                serchForContact();
                break;
            case 4:
                deteleContact();
                break;
            default:
                showInitialOptions();
                break;

        }
    }

    private static void deteleContact() {
        System.out.println("Please Enter the contact's name : ");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name : ");
            deteleContact();
        }else {
            boolean doesExit = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExit = true;
                    contacts.remove(c);
                }
            }
            if(!doesExit){
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void serchForContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name");
            serchForContact();
        }else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist){
                System.out.println("There is no such contact in your phone");
            }
        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding any Contact " +
                "\nPlease enter the any contact's name : ");
        String name = scanner.next();
        System.out.println("Please enter Contact' number: ");
        String number = scanner.next();
        System.out.println("Please enter the email : ");
        String email = scanner.next();

        if(name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please enter all of the information .");
            addNewContact();
        }else{
            boolean doesExit = false;
            for (Contact c: contacts){
                if (c.getName().equals(name)){
                    doesExit = true;
                }
            }
            if(doesExit){
                System.out.println("We have a contact named " + name + " saved on this device");
                addNewContact();
            }else{
                Contact contact = new Contact(name , number ,email);
                contacts.add(contact);
                System.out.println(name + " adding successfully ");
            }
        }
        showInitialOptions();
    }

    private static void showAllContact() {
        if(contacts.size()>0){
            for (Contact c: contacts){
                c.getDetails();
                System.out.println("***************");
            }
            showInitialOptions();

        }else {
            System.out.println("You do not have a contact");
            showInitialOptions();
        }

    }

}
