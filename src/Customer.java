public class Customer extends User {

    private String email;
    private String address;



    public Customer(int userId,String firstName, String lastName ,String email, String address)
    {
        super(userId,firstName,lastName);
        this.email=email;
        this.address=address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdress() {
        return address;
    }
    public void setAdress(String address) {
        this.address = address;
    }




}