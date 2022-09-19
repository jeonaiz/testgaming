package com.example.testgaming;

import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
     private int counter = 0, answer;
     private int maxQuestionNumber = 8, correctAnswerCounter = 0;

     private Date startDate;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtQuestion;

    @FXML
    private TextField txtAnswer;

    @FXML
    private Button buttonResult;

    @FXML
    private Label lblResult;

    @FXML
    private Button buttonNewGame;

    @FXML
    void buttonOnClicked(ActionEvent event) {
        counter++;
        int userAnswer = Integer.parseInt(txtAnswer.getText());
         if (userAnswer == answer){
             correctAnswerCounter++;
         }
         if(counter == maxQuestionNumber){
             lblResult.setVisible(true);

             lblResult.setText(lblResult.getText()+correctAnswerCounter*100/maxQuestionNumber+"%\n"+(new Date().getTime()-startDate.getTime()));

             setNewGame();

             }else{

             setNewQuestion();
         }

    }
    @FXML
    void onButtonClickedNewGame(ActionEvent event) {
        setNewGame();
        lblResult.setText("Результат: "+"");
    }
    private void setNewGame(){
        setNewQuestion();
        startDate = new Date();
        counter = 0;
        correctAnswerCounter = 0;

    }

    @FXML
    void initialize() {
        setNewGame();

    }

    private void setNewQuestion(){
        txtAnswer.setText(null);

        Random random = new Random();
        int firstNumber = random.nextInt(9-2+1)+2;
        int secondNumber = random.nextInt(9-2+1)+2;

        answer = firstNumber * secondNumber;
        txtQuestion.setText(firstNumber+ " * "+secondNumber);
        txtAnswer.requestFocus();
    }
}
