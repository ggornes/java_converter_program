/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converterprogram2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author 20026902
 */
public class FXMLDocumentController implements Initializable {
    
    String[] history = new String[10];
    int index = 0;
    
    @FXML
    private Label label;
    @FXML
    private TextField txtInput;
    @FXML
    private Label label1;
    @FXML
    private TextField txtOutput;
    @FXML
    private ListView<String> lstTemp;
    @FXML
    private ListView<String> lstLength;
    @FXML
    private ListView<String> lstWeight;
    @FXML
    private ListView<String> lstTime;
    @FXML
    private ListView<String> lstCurrency;
    @FXML
    private Button btnPrint;

    public double convert(double input, String operation) {
        double output = 0.0;
        //String[] history;
        //history = new String[50];
        //int index = 0;
        switch(operation) {
            case "Celsius to Farenheit":
                output = input*9/5 + 32;
                break;
            case "Celsius to Kelvin":
                output = input + 273.15;
                break;
            case "Farenheit to Celsius":
                output = (input - 32)*5/9;
                break;
            case "Farenheit to Kelvin":
                output = (input - 32)*5/9 + 273.15;
                break;
            case "Kelvin to Celsius":
                output = input - 273.15;
                break;
            case "Kelvin to Farenheit":
                output = (input - 273.15)*9/5 + 32;
                break;
            case "Kilometer to Mile":
                output = input/1.609;
                break;
            case "Mile to Kilometer":
                output = input*1.609;
                break;
            case "Meter to Yard":
                output = input*1.09361;
                break;
            case "Yard to Meter":
                output = input/1.09361;
                break;
            case "Centimeter to Inch":
                output = input/2.54;
                break;
            case "Inch to Centimeter":
                output = input*2.54;
                break;
            case "Gram to Ounce":
                output = input*28.35;
                break;
            case "Ounce to Gram":
                output = input/25.35;
                break;
            case "Day to Minute":
                output = input*1440;
                break;
            case "Minute to Day":
                output = input/1440;
                break;
            case "USD to AUD":
                output = input*1.4;
                break;
            case "AUD to USD":
                output = input/1.4;
                break;
           
            default:
                javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR,
            "Invalid operator");
                a.showAndWait();
                break;
        }
        
        // pupulate the history array
        history[index] = input + " " + operation + " = " + output;
        System.out.println(history[index]);
        index++;

        return output;
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> tempOptionsList = FXCollections.observableArrayList("Celsius to Farenheit", "Celsius to Kelvin", "Farenheit to Celsius",
                "Farenheit to Kelvin", "Kelvin to Celsius", "Kelvin to Farenheit");
        lstTemp.setItems(tempOptionsList);
        
        ObservableList<String> lengthOptionsList = FXCollections.observableArrayList("Kilometer to Mile", "Mile to Kilometer", "Meter to Yard",
                "Yard to Meter", "Centimeter to Inch", "Inch to Centimeter");
        lstLength.setItems(lengthOptionsList);
        
        ObservableList<String> weightOptionsList = FXCollections.observableArrayList("Gram to Ounce", "Ounce to Gram");
        lstWeight.setItems(weightOptionsList);
        
        ObservableList<String> timeOptionsList = FXCollections.observableArrayList("Day to Minute", "Minute to Day");
        lstTime.setItems(timeOptionsList);
        
        ObservableList<String> currencyOptionsList = FXCollections.observableArrayList("USD to AUD", "AUD to USD");
        lstCurrency.setItems(currencyOptionsList);
    }    



    @FXML
    private void handleMouseClickTemp(MouseEvent event) {
        String strInput = txtInput.getText();
        double dInput = Double.valueOf(strInput);
        double dOutput = convert(dInput, lstTemp.getSelectionModel().getSelectedItem());
        txtOutput.setText(String.valueOf(dOutput));
        //System.out.println(strInput + " " + lstTemp.getSelectionModel().getSelectedItem() + " = " + dOutput);
    }

    @FXML
    private void handleMouseClickLength(MouseEvent event) {
        String strInput = txtInput.getText();
        double dInput = Double.valueOf(strInput);
        double dOutput = convert(dInput, lstLength.getSelectionModel().getSelectedItem());
        txtOutput.setText(String.valueOf(dOutput));
        //System.out.println(strInput + " " + lstLength.getSelectionModel().getSelectedItem() + " = " + dOutput);
    }
    
    @FXML
    private void handleMouseClickWeight(MouseEvent event) {
        String strInput = txtInput.getText();
        double dInput = Double.valueOf(strInput);
        double dOutput = convert(dInput, lstWeight.getSelectionModel().getSelectedItem());
        txtOutput.setText(String.valueOf(dOutput));
        //System.out.println(strInput + " " + lstWeight.getSelectionModel().getSelectedItem() + " = " + dOutput);
    }
    
    @FXML
    private void handleMouseClickTime(MouseEvent event) {
        String strInput = txtInput.getText();
        double dInput = Double.valueOf(strInput);
        double dOutput = convert(dInput, lstTime.getSelectionModel().getSelectedItem());
        txtOutput.setText(String.valueOf(dOutput));
        //System.out.println(strInput + " " + lstWeight.getSelectionModel().getSelectedItem() + " = " + dOutput);
    }
    
    
    @FXML
    private void handleMouseClickCurrency(MouseEvent event) {
        String strInput = txtInput.getText();
        double dInput = Double.valueOf(strInput);
        double dOutput = convert(dInput, lstCurrency.getSelectionModel().getSelectedItem());
        txtOutput.setText(String.valueOf(dOutput));
        //System.out.println(strInput + " " + lstWeight.getSelectionModel().getSelectedItem() + " = " + dOutput);
    }
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //PrintWriter outfile = new PrintWriter("output.txt");
        //outfile.println("Hello");
        //outfile.close();
        for (String history1 : history) {
            System.out.println(history1);
        }
    }
    
    
}
