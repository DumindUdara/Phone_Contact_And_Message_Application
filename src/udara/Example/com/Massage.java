package udara.Example.com;

public class Massage {
    private String text;
    private String recipient;
    private int id;

    public Massage(String test, String recipient, int id) {
        this.text = test;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails(){
        System.out.println("Contact Name : " + recipient + "\nMassage : " + text + "\nId : " + id);
    }

    public String getTest() {
        return text;
    }

    public void setTest(String test) {
        this.text = test;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
