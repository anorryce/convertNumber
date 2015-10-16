/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversionfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author anorryce
 */
public class ConversionFx extends Application {
    Label ipL, ipTypeL, opL, opTypeL, titleL, descL;
    TextField ipTF, opTF;
    ChoiceBox ipCB, opCB;
    Button convertBtn, exitBtn;
    
    @Override
    public void start(Stage primaryStage) {
        DEC dc = new DEC();
        
        titleL = new Label("Welcome to Number Converter App!");
        titleL.setStyle("-fx-font: 22 arial;");
        descL = new Label("Please enter a number in the Input field and select the"
                + " input type, then select the type you wish to convert it to, and "
                + "finally press convert.");
        ipL = new Label("Input");
        ipTypeL = new Label("Input Type");
        opL = new Label("Converted Number");
        opTypeL = new Label("Output Type");
        
        ipTF = new TextField();
        opTF = new TextField();
        opTF.setEditable(false);
        
        ipCB = new ChoiceBox();
        ipCB.getItems().addAll("Binary","Octal","Decimal","Hex");
        opCB = new ChoiceBox();
        opCB.getItems().addAll("Binary","Octal","Decimal","Hex");
        
        Button convertBtn = new Button();
        convertBtn.setText("=> Convert");
        convertBtn.setStyle("-fx-font: 12 arial; -fx-base: LIGHTGREEN;");
        convertBtn.setOnAction(e->{
            
            try{
                //Decimal Inputs:
                if(ipCB.getValue()=="Decimal" && opCB.getValue()=="Binary"){
                    String bin = dc.toBin(ipTF.getText());
                    opTF.setText(bin);
                }
                else if(ipCB.getValue()=="Decimal" && opCB.getValue()=="Octal"){
                    String oct = dc.toOct(ipTF.getText());
                    opTF.setText(oct);
                }
                else if(ipCB.getValue()=="Decimal" && opCB.getValue()=="Hex"){
                    String hex = dc.toHex(ipTF.getText());
                    opTF.setText(hex);
                }
                else if(ipCB.getValue()=="Decimal" && opCB.getValue()=="Decimal"){
                    String dec = Integer.toString(dc.toDec(ipTF.getText()));
                    opTF.setText(dec);
                }

                //Binary Inputs:
                if(ipCB.getValue()=="Binary" && opCB.getValue()=="Binary"){
                    String bin = ipTF.getText();
                    String dec = dc.binToD(bin);
                    bin = dc.toBin(dec);
                    opTF.setText(bin);
                }
                else if(ipCB.getValue()=="Binary" && opCB.getValue()=="Octal"){
                    String bin = ipTF.getText();
                    String dec = dc.binToD(bin);
                    String oct = dc.toOct(dec);
                    opTF.setText(oct);
                }
                else if(ipCB.getValue()=="Binary" && opCB.getValue()=="Decimal"){
                    String bin = ipTF.getText();
                    String dec = dc.binToD(bin);
                    opTF.setText(dec);
                }
                else if(ipCB.getValue()=="Binary" && opCB.getValue()=="Hex"){
                    String bin = ipTF.getText();
                    String dec = dc.binToD(bin);
                    String hex = dc.toHex(dec);
                    opTF.setText(hex);
                }

                //Octal Inputs:
                if(ipCB.getValue()=="Octal" && opCB.getValue()=="Binary"){
                    String oct = ipTF.getText();
                    String dec = dc.octToD(oct);
                    String bin = dc.toBin(dec);
                    opTF.setText(bin);
                }
                else if(ipCB.getValue()=="Octal" && opCB.getValue()=="Octal"){
                    String oct = ipTF.getText();
                    String dec = dc.octToD(oct);
                    oct = dc.toOct(dec);
                    opTF.setText(oct);
                }
                else if(ipCB.getValue()=="Octal" && opCB.getValue()=="Decimal"){
                    String oct = ipTF.getText();
                    String dec = dc.octToD(oct);
                    opTF.setText(dec);
                }
                else if(ipCB.getValue()=="Octal" && opCB.getValue()=="Hex"){
                    String oct = ipTF.getText();
                    String dec = dc.octToD(oct);
                    String hex = dc.toHex(dec);
                    opTF.setText(hex);
                }

                //Hex Inputs:
                if(ipCB.getValue()=="Hex" && opCB.getValue()=="Binary"){
                    String hex = ipTF.getText();
                    String dec = dc.hexToD(hex);
                    String bin = dc.toBin(dec);
                    opTF.setText(bin);
                }
                else if(ipCB.getValue()=="Hex" && opCB.getValue()=="Octal"){
                    String hex = ipTF.getText();
                    String dec = dc.hexToD(hex);
                    String oct = dc.toOct(dec);
                    opTF.setText(oct);
                }
                else if(ipCB.getValue()=="Hex" && opCB.getValue()=="Decimal"){
                    String hex = ipTF.getText();
                    String dec = dc.hexToD(hex);
                    opTF.setText(dec);
                }
                else if(ipCB.getValue()=="Hex" && opCB.getValue()=="Hex"){
                    String hex = ipTF.getText();
                    String dec = dc.hexToD(hex);
                    hex = dc.toHex(dec);
                    opTF.setText(hex);
                }
            }
            catch(Exception f){
                opTF.setText("Value not allowed!");
            }
        });
        
        Button exitBtn = new Button();
        exitBtn.setText("Exit");
        exitBtn.setStyle("-fx-font: 12 arial; -fx-base: RED;");
        exitBtn.setOnAction(e->{
            System.exit(1);
        });
        
        StackPane titleSP = new StackPane();
        titleSP.getChildren().add(titleL);
        
        StackPane descSP = new StackPane();
        descSP.getChildren().add(descL);
        
        GridPane topGP = new GridPane();
        topGP.add(titleSP, 0, 0);
        topGP.add(new Label(""),0,1);
        topGP.add(descSP, 0, 2);
        topGP.add(new Label(""), 0, 3);
       
        GridPane leftGP = new GridPane();
        leftGP.add(ipL,0,0);
        leftGP.add(ipTypeL,0,1);
        leftGP.add(ipTF,1,0);
        leftGP.add(ipCB,1,1);
        
        GridPane rightGP = new GridPane();
        rightGP.add(opL,0,0);
        rightGP.add(opTypeL,0,1);
        rightGP.add(opTF, 1,0);
        rightGP.add(opCB, 1,1);
        
        GridPane bottomGP = new GridPane();
        bottomGP.getChildren().add(exitBtn);
        
        GridPane centerGP = new GridPane();
        centerGP.add(convertBtn,0,0);
        GridPane.setMargin(centerGP, new Insets(5, 10, 5, 10));
        centerGP.add(exitBtn,0,1);
        centerGP.setAlignment(Pos.CENTER);
        centerGP.setHgap(10);
        centerGP.setVgap(12);
        
        BorderPane bp = new BorderPane();
        bp.setTop(topGP);
        bp.setLeft(leftGP);
        bp.setRight(rightGP);
        bp.setCenter(centerGP);
        bp.setBottom(bottomGP);
        bp.setPadding(new Insets(10, 20, 10, 20));
        
        Scene scene = new Scene(bp, 800, 200);
        
        primaryStage.setTitle("NumberConvertDlg");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
