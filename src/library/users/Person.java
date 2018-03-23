package library.users;

public class Person {
    private String name, email, userType;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    //todo Figure out how to read values from a DB
    public void checkDuplicateEmails(){

    }
}
