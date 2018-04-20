package admin;

public enum BookGrade {

    K, One, Two, Three, Four, Five, Six;

    private BookGrade(){}

    public String value() {
        return name();
    }

    public static BookGrade fromvalue(String v){
        return valueOf(v);
    }

}