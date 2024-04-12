public class User {

    private int userId;

    private String firstName, lastName;


    public User(int userId,String firstName, String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.userId=userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int id){this.userId=id;}
}
