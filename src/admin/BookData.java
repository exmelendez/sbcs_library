package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookData {

    private final StringProperty ID;
    private final StringProperty TITLE;
    private final StringProperty AUTHOR;
    private final StringProperty ISBN;
    private final StringProperty GENRE;
    private final StringProperty PRICE;
    private final StringProperty START_GRADE;
    private final StringProperty END_GRADE;
    private final StringProperty DISTRIBUTION_STATUS;

    public BookData(String bookID, String bookTitle, String bookAuthor, String bookISBN, String bookGenre,
                    String bookPrice, String bookStartGrade, String bookEndGrade, String bookStatus) {

        this.ID = new SimpleStringProperty(bookID);
        this.TITLE = new SimpleStringProperty(bookTitle);
        this.AUTHOR = new SimpleStringProperty(bookAuthor);
        this.ISBN = new SimpleStringProperty(bookISBN);
        this.GENRE = new SimpleStringProperty(bookGenre);
        this.PRICE = new SimpleStringProperty(bookPrice);
        this.START_GRADE = new SimpleStringProperty(bookStartGrade);
        this.END_GRADE = new SimpleStringProperty(bookEndGrade);
        this.DISTRIBUTION_STATUS = new SimpleStringProperty(bookStatus);

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

    public String getTITLE() {
        return TITLE.get();
    }

    public StringProperty TITLEProperty() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE.set(TITLE);
    }

    public String getAUTHOR() {
        return AUTHOR.get();
    }

    public StringProperty AUTHORProperty() {
        return AUTHOR;
    }

    public void setAUTHOR(String AUTHOR) {
        this.AUTHOR.set(AUTHOR);
    }

    public String getISBN() {
        return ISBN.get();
    }

    public StringProperty ISBNProperty() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public String getGENRE() {
        return GENRE.get();
    }

    public StringProperty GENREProperty() {
        return GENRE;
    }

    public void setGENRE(String GENRE) {
        this.GENRE.set(GENRE);
    }

    public String getPRICE() {
        return PRICE.get();
    }

    public StringProperty PRICEProperty() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE.set(PRICE);
    }

    public String getSTART_GRADE() {
        return START_GRADE.get();
    }

    public StringProperty START_GRADEProperty() {
        return START_GRADE;
    }

    public void setSTART_GRADE(String START_GRADE) {
        this.START_GRADE.set(START_GRADE);
    }

    public String getEND_GRADE() {
        return END_GRADE.get();
    }

    public StringProperty END_GRADEProperty() {
        return END_GRADE;
    }

    public void setEND_GRADE(String END_GRADE) {
        this.END_GRADE.set(END_GRADE);
    }

    public String getDISTRIBUTION_STATUS() {
        return DISTRIBUTION_STATUS.get();
    }

    public StringProperty DISTRIBUTION_STATUSProperty() {
        return DISTRIBUTION_STATUS;
    }

    public void setDISTRIBUTION_STATUS(String DISTRIBUTION_STATUS) {
        this.DISTRIBUTION_STATUS.set(DISTRIBUTION_STATUS);
    }
}