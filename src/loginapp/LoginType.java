package loginapp;

//todo remove after completion/testing
/**
 * Tutorial video for this section around 32 min
 */

public enum LoginType {

    Teacher, Admin;

    private LoginType(){}

    public String value() {
        return name();
    }

    public static LoginType fromvalue(String v){
        return valueOf(v);
    }

}
