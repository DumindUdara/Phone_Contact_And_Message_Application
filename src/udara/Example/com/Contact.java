package udara.Example.com;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;
    private String email;
    private ArrayList<Massage> massages;

    public Contact(String name, String number, String email, ArrayList<Massage> massages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.massages = massages;
    }

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.massages = new ArrayList<>();
    }

    public void getDetails(){
        System.out.println("Name : " + this.name + "" + "\nNumber : " + this.number + "" +"\nEmail : " + this.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Massage> getMassages() {
        return massages;
    }

    public void setMassages(ArrayList<Massage> massages) {
        this.massages = massages;
    }
}
