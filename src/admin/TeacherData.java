package admin;

import date.CurrentDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TeacherData {

    private final StringProperty ID;
    private final StringProperty FIRST_NAME;
    private final StringProperty LAST_NAME;
    private final StringProperty EMAIL;
    private final StringProperty PASSWORD;
    private final StringProperty GRADE;
    private final StringProperty CLASS;
    private final StringProperty ROOM;
    private final StringProperty EXP_DATE;
    private final StringProperty UPDATE_DATE;

    public TeacherData(String ID, String FIRST_NAME, String LAST_NAME, String EMAIL, String PASSWORD, String GRADE,
                       String CLASS, String ROOM, String EXP_DATE, String updateDate) {

        this.ID = new SimpleStringProperty(ID);
        this.FIRST_NAME = new SimpleStringProperty(FIRST_NAME);
        this.LAST_NAME = new SimpleStringProperty(LAST_NAME);
        this.EMAIL = new SimpleStringProperty(EMAIL);
        this.PASSWORD = new SimpleStringProperty(PASSWORD);
        this.GRADE = new SimpleStringProperty(GRADE);
        this.CLASS = new SimpleStringProperty(CLASS);
        this.ROOM = new SimpleStringProperty(ROOM);
        this.EXP_DATE = new SimpleStringProperty(EXP_DATE);
        this.UPDATE_DATE = new SimpleStringProperty(updateDate);
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getFIRST_NAME() {
        return FIRST_NAME.get();
    }

    public StringProperty FIRST_NAMEProperty() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME.set(FIRST_NAME);
    }

    public String getLAST_NAME() {
        return LAST_NAME.get();
    }

    public StringProperty LAST_NAMEProperty() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME.set(LAST_NAME);
    }

    public String getEMAIL() {
        return EMAIL.get();
    }

    public StringProperty EMAILProperty() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL.set(EMAIL);
    }

    public String getPASSWORD() {
        return PASSWORD.get();
    }

    public StringProperty PASSWORDProperty() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD.set(PASSWORD);
    }

    public String getGRADE() {
        return GRADE.get();
    }

    public StringProperty GRADEProperty() {
        return GRADE;
    }

    public void setGRADE(String GRADE) {
        this.GRADE.set(GRADE);
    }

    public String getCLASS() {
        return CLASS.get();
    }

    public StringProperty CLASSProperty() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS.set(CLASS);
    }

    public String getROOM() {
        return ROOM.get();
    }

    public StringProperty ROOMProperty() {
        return ROOM;
    }

    public void setROOM(String ROOM) {
        this.ROOM.set(ROOM);
    }

    public String getEXP_DATE() {
        return EXP_DATE.get();
    }

    public StringProperty EXP_DATEProperty() {
        return EXP_DATE;
    }

    public void setEXP_DATE(String EXP_DATE) {
        this.EXP_DATE.set(EXP_DATE);
    }

    public String getUPDATE_DATE() {
        return UPDATE_DATE.get();
    }

    public StringProperty UPDATE_DATEProperty() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(String UPDATE_DATE) {
        this.UPDATE_DATE.set(UPDATE_DATE);
    }
}
