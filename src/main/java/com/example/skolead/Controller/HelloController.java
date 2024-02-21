package com.example.skolead.Controller;

import com.example.skolead.Utils.SqlConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    private SqlConnection sqlConnectionq;

    @FXML
    TextField LoginStudieID;
    @FXML
    PasswordField LoginKodeord;
    @FXML
    Button LoginButton;

    @FXML
    private void initialize() {
        sqlConnectionq = new SqlConnection();


    }

    @FXML
    private void LoginButtonAction(ActionEvent event){
        String studieId = LoginStudieID.getText();
        String kodeOrd = LoginKodeord.getText();

        try {
            Connection connection = sqlConnectionq.getConnection();
            if (isValidUser(studieId,kodeOrd,connection)) {
                System.out.println("Det virker");

            } else {
                System.out.println("Id eller kode forkert ");
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            sqlConnectionq.closeConnection();
        }

    }

    private boolean isValidUser (String fnavn, String kodeOrd, Connection connection) throws SQLException {
        System.out.println("Chekker om brugeren findes" + fnavn);

        String sql = "SELECT * FROM studentad WHERE fnavn = ? AND password = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, fnavn);
            // Konverterer kodeOrd til String
            String kodeOrdString = String.valueOf(kodeOrd);
            pstmt.setString(2, kodeOrdString);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }


}