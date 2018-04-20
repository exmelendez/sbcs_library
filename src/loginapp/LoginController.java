package loginapp;

import admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import teachers.TeacherController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private ComboBox<LoginType> logintype;
    @FXML
    private Button loginbtn;
    @FXML
    private Label loginerror;

    public void initialize(URL url, ResourceBundle rb) {
        if (this.loginModel.isDatabaseConnected()) {
            this.dbstatus.setText("Online");
            this.dbstatus.setTextFill(Color.web("#006400"));
            this.dbstatus.setStyle("-fx-font-weight: bold");
        } else {
            this.dbstatus.setText("Offline");
            this.dbstatus.setTextFill(Color.web("#FF0000"));
        }

        this.logintype.setItems(FXCollections.observableArrayList(LoginType.values()));
    }

    @FXML
    public void Login(ActionEvent event) {

        try {

            if (this.loginModel.isLogin(this.email.getText(), this.password.getText(), this.logintype.getValue().toString())) {
                Stage stage = (Stage) this.loginbtn.getScene().getWindow();
                stage.close();

                switch (this.logintype.getValue().toString()) {
                    case "Teacher":
                        teacherLogin();
                        break;
                    case "Admin":
                        adminLogin();
                        break;
                }
            } else {
                this.loginerror.setText("Inaccessible Account");
            }

        } catch (Exception localException) {

        }

    }
    /*
    //todo Go over block below with charlie, may not be neat
    @FXML
    public void Login(ActionEvent event) {

        try {

            if (this.loginModel.hasUserAcct(this.email.getText(), this.logintype.getValue().toString())) {
                if (this.loginModel.hasCorrectPassword(this.email.getText(), this.password.getText(), this.logintype.getValue().toString())) {
                    if (this.loginModel.hasActiveAcct(this.email.getText(), this.password.getText(), this.logintype.getValue().toString())) {
                        Stage stage = (Stage) this.loginbtn.getScene().getWindow();
                        stage.close();

                        switch (this.logintype.getValue().toString()) {
                            case "Teacher":
                                teacherLogin();
                                break;
                            case "Admin":
                                adminLogin();
                                break;
                        }
                    } else {
                        this.loginerror.setText("Expired Account");
                    }
                } else {
                    this.loginerror.setText("Incorrect Password");
                }
            } else {
                this.loginerror.setText("No Account Found");
            }

        } catch (Exception localException) {

        }

    }
    */

    public void teacherLogin() {

        try {
            Stage userstage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/teachers/teacher.fxml").openStream());

            TeacherController teacherController = (TeacherController) loader.getController();

            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Teacher Page");
            userstage.setResizable(false);
            userstage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void adminLogin() {

        try {
            Stage adminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane adminRoot = (Pane) adminLoader.load(getClass().getResource("/admin/admin.fxml").openStream());

            AdminController adminController = (AdminController) adminLoader.getController();

            Scene adminScene = new Scene(adminRoot);
            adminStage.setScene(adminScene);
            adminStage.setTitle("Admin Page");
            adminStage.setResizable(false);
            adminStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
