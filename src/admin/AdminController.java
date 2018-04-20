package admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.dbConnection;

public class AdminController implements Initializable {

    /**
     * Admin Book Section
     */
    @FXML
    private TextField book_id;
    @FXML
    private TextField book_title;
    @FXML
    private TextField book_author;
    @FXML
    private TextField book_isbn;
    @FXML
    private TextField book_genre;
    @FXML
    private TextField book_price;
    @FXML
    private ComboBox<BookGrade> book_start_grade;
    @FXML
    private ComboBox<BookGrade> book_end_grade;
    @FXML
    private ComboBox<BookStatus> book_status;

    @FXML
    private TableView<BookData> booktable;
    @FXML
    private TableColumn<BookData, String> bookIDCol;
    @FXML
    private TableColumn<BookData, String> bookTitleCol;
    @FXML
    private TableColumn<BookData, String> bookAuthorCol;
    @FXML
    private TableColumn<BookData, String> bookISBNCol;
    @FXML
    private TableColumn<BookData, String> bookGenreCol;
    @FXML
    private TableColumn<BookData, String> bookPriceCol;
    @FXML
    private TableColumn<BookData, String> bookSGradeCol;
    @FXML
    private TableColumn<BookData, String> bookEGradeCol;
    @FXML
    private TableColumn<BookData, String> bookStatusCol;

    /**
     * Admin Teacher Section
     */
    @FXML
    private TextField teacher_id;
    @FXML
    private TextField teacher_fname;
    @FXML
    private TextField teacher_lname;
    @FXML
    private TextField teacher_email;
    @FXML
    private TextField teacher_password;
    @FXML
    private ComboBox<BookGrade> teacher_grade;
    @FXML
    private ComboBox teacher_class;
    @FXML
    private ComboBox teacher_room;
    @FXML
    private DatePicker teacher_expdate;

    @FXML
    private TableView<TeacherData> teachertable;
    @FXML
    private TableColumn<TeacherData, String> teacherIDCol;
    @FXML
    private TableColumn<TeacherData, String> teacherFNameCol;
    @FXML
    private TableColumn<TeacherData, String> teacherLNameCol;
    @FXML
    private TableColumn<TeacherData, String> teacherEmailCol;
    @FXML
    private TableColumn<TeacherData, String> teacherPasswordCol;
    @FXML
    private TableColumn<TeacherData, String> teacherGradeCol;
    @FXML
    private TableColumn<TeacherData, String> teacherClassCol;
    @FXML
    private TableColumn<TeacherData, String> teacherRoomCol;
    @FXML
    private TableColumn<TeacherData, String> teacherExpCol;
    @FXML
    private TableColumn<TeacherData, String> teacherLastUpdateCol;

    private ObservableList<BookData> bookData;
    private ObservableList<TeacherData> teacherData;
    ObservableList<String> teacherClasses =
            FXCollections.observableArrayList("K01", "K02", "K03", "K04", "101", "102", "103", "104", "201",
                    "202", "301", "302", "401", "402", "501", "502");

    ObservableList<String> classRooms =
            FXCollections.observableArrayList("301", "302", "303", "304", "305", "306", "307", "308", "309",
                    "401", "402", "403", "404", "405", "406", "407", "408", "409", "501", "502", "503", "504", "505",
                    "506", "507", "508", "509");

    private String allBooksSQL = "SELECT * FROM books";
    private String allTeachersSQL = "SELECT * FROM Teacher";

    public void initialize(URL url, ResourceBundle rb) {

        try {
            Connection conn = dbConnection.getConnection();
            bookInitialize(conn);
            teacherInitialize(conn);
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * The original working method
     */
    /*
    public void initialize(URL url, ResourceBundle rb) {

        this.book_start_grade.setItems(FXCollections.observableArrayList(BookGrade.values()));
        this.book_end_grade.setItems(FXCollections.observableArrayList(BookGrade.values()));
        this.book_status.setItems(FXCollections.observableArrayList(BookStatus.values()));
        this.teacher_grade.setItems(FXCollections.observableArrayList(BookGrade.values()));
        this.teacher_class.setItems(teacherClasses);
        this.teacher_room.setItems(classRooms);

        try {
            Connection conn = dbConnection.getConnection();
            this.bookData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(allBooksSQL);

            while (rs.next()) {
                this.bookData.add(new BookData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.bookIDCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ID"));
        this.bookTitleCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("TITLE"));
        this.bookAuthorCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("AUTHOR"));
        this.bookISBNCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ISBN"));
        this.bookGenreCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("GENRE"));
        this.bookPriceCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("PRICE"));
        this.bookSGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("START_GRADE"));
        this.bookEGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("END_GRADE"));
        this.bookStatusCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("DISTRIBUTION_STATUS"));

        this.booktable.setItems(null);
        this.booktable.setItems(this.bookData);

    }
    */
    private void bookInitialize(Connection conn) {

        this.book_start_grade.setItems(FXCollections.observableArrayList(BookGrade.values()));
        this.book_end_grade.setItems(FXCollections.observableArrayList(BookGrade.values()));
        this.book_status.setItems(FXCollections.observableArrayList(BookStatus.values()));

        try {
            this.bookData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(allBooksSQL);

            while (rs.next()) {
                this.bookData.add(new BookData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }

            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.bookIDCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ID"));
        this.bookTitleCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("TITLE"));
        this.bookAuthorCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("AUTHOR"));
        this.bookISBNCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ISBN"));
        this.bookGenreCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("GENRE"));
        this.bookPriceCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("PRICE"));
        this.bookSGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("START_GRADE"));
        this.bookEGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("END_GRADE"));
        this.bookStatusCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("DISTRIBUTION_STATUS"));

        this.booktable.setItems(null);
        this.booktable.setItems(this.bookData);

    }

    private void teacherInitialize(Connection conn) {

        this.teacher_grade.setItems(FXCollections.observableArrayList(BookGrade.values()));
        this.teacher_class.setItems(teacherClasses);
        this.teacher_room.setItems(classRooms);

        try {

            this.teacherData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(allTeachersSQL);

            while (rs.next()) {
                this.teacherData.add(new TeacherData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }

            rs.close();

        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }

        this.teacherIDCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("ID"));
        this.teacherFNameCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("FIRST_NAME"));
        this.teacherLNameCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("LAST_NAME"));
        this.teacherEmailCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("EMAIL"));
        this.teacherPasswordCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("PASSWORD"));
        this.teacherGradeCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("GRADE"));
        this.teacherClassCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("CLASS"));
        this.teacherRoomCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("ROOM"));
        this.teacherExpCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("EXP_DATE"));
        this.teacherLastUpdateCol.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("UPDATE_DATE"));

        this.teachertable.setItems(null);
        this.teachertable.setItems(this.teacherData);

    }

    @FXML
    private void loadBookData(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getConnection();
            this.bookData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(allBooksSQL);

            while (rs.next()) {
                this.bookData.add(new BookData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }

        } catch (SQLException e) {

            System.err.println("Error: " + e);
        }

        this.bookIDCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ID"));
        this.bookTitleCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("TITLE"));
        this.bookAuthorCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("AUTHOR"));
        this.bookISBNCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ISBN"));
        this.bookGenreCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("GENRE"));
        this.bookPriceCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("PRICE"));
        this.bookSGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("START_GRADE"));
        this.bookEGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("END_GRADE"));
        this.bookStatusCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("DISTRIBUTION_STATUS"));

        this.booktable.setItems(null);
        this.booktable.setItems(this.bookData);
    }

    @FXML
    private void addBook(ActionEvent event) throws SQLException {
        String SQLInsert = "INSERT INTO books (book_id, title, author, ISBN, genre, price, starting_grade, ending_grade, distribution_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        Connection conn = dbConnection.getConnection();
        this.bookData = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery(allBooksSQL);

        try {
            PreparedStatement stmt = conn.prepareStatement(SQLInsert);

            stmt.setString(1, this.book_id.getText());
            stmt.setString(2, this.book_title.getText());
            stmt.setString(3, this.book_author.getText());
            stmt.setString(4, this.book_isbn.getText());
            stmt.setString(5, this.book_genre.getText());
            stmt.setString(6, this.book_price.getText());
            stmt.setString(7, String.valueOf(this.book_start_grade.getValue()));
            stmt.setString(8, String.valueOf(this.book_end_grade.getValue()));
            stmt.setString(9, String.valueOf(this.book_status.getValue()));

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

//      Load data to table again
        while (rs.next()) {
            this.bookData.add(new BookData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
        }

        this.bookIDCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ID"));
        this.bookTitleCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("TITLE"));
        this.bookAuthorCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("AUTHOR"));
        this.bookISBNCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("ISBN"));
        this.bookGenreCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("GENRE"));
        this.bookPriceCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("PRICE"));
        this.bookSGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("START_GRADE"));
        this.bookEGradeCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("END_GRADE"));
        this.bookStatusCol.setCellValueFactory(new PropertyValueFactory<BookData, String>("DISTRIBUTION_STATUS"));

        this.booktable.setItems(null);
        this.booktable.setItems(this.bookData);

        conn.close();

//      Clears form upon submitting
        this.book_id.setText("");
        this.book_title.setText("");
        this.book_author.setText("");
        this.book_isbn.setText("");
        this.book_genre.setText("");
        this.book_price.setText("");
        this.book_start_grade.setValue(null);
        this.book_end_grade.setValue(null);
        this.book_status.setValue(null);
    }

}