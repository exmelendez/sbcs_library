package admin;

public enum BookStatus {

    Active, Damaged, Unreturned, Inactive;

    private BookStatus(){}

    public String value() {
        return name();
    }

    public static BookStatus fromvalue(String v){
        return valueOf(v);
    }

}