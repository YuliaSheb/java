package com.jsltd.corsser;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jsltd.corsser.dataBase.DatabaseHandler;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker data;

    @FXML
    private TableColumn<Art, String> col_artCount;

    @FXML
    private TableColumn<Art, String> col_artName;

    @FXML
    private TableColumn<Art, String> col_id;

    @FXML
    private TableColumn<Art, String> col_price;

    @FXML
    private TableColumn<Art, String> col_category;

    @FXML
    private TableColumn<Art, String> col_author;

    @FXML
    private TableView<Art> table_arts;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_count;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_price;

    @FXML
    private TextField txt_category;

    @FXML
    private TextField txt_author;

    @FXML
    private TextField txt_search;

    @FXML
    private Label lb;

    ObservableList<Art> dataList;

    ObservableList<Art> listM;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    public void initialize() {
        RefreshTable();
        Search();
        data.setValue(LocalDate.of(2022,06,22));
    }

    public void Add_art(){
        conn = DatabaseHandler.ConnectDB();
        String sql = "insert into arts (artName, artCount, price, category, author) values (?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_name.getText());
            pst.setString(2, txt_count.getText());
            pst.setString(3, txt_price.getText());
            pst.setString(4, txt_category.getText());
            pst.setString(5, txt_author.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Art add successful!");
            RefreshTable();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }


    //Метод по выборке
    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        index = table_arts.getSelectionModel().getSelectedIndex();

        if(index <= -1){

            return;
        }

        txt_id.setText(col_id.getCellData(index).toString());
        txt_name.setText(col_artName.getCellData(index).toString());
        txt_count.setText(col_artCount.getCellData(index).toString());
        txt_price.setText(col_price.getCellData(index).toString());
        txt_category.setText(col_category.getCellData(index).toString());
        txt_author.setText(col_author.getCellData(index).toString());
    }

    public void Edit(){

        try{
            conn = DatabaseHandler.ConnectDB();
            String value1 = txt_id.getText();
            String value2 = txt_name.getText();
            String value3 = txt_count.getText();
            String value4 = txt_price.getText();
            String value5 = txt_category.getText();
            String value6 = txt_author.getText();

            String sql = "update arts set id='"+value1+"', artName='"+value2+"', artCount='"+
                    value3+"', price='"+value4+"', category='"+value5+"', author='"+value6+"' where id='"+value1+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "The table has changed!");
            RefreshTable();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void RefreshTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Art, String>("id"));
        col_artName.setCellValueFactory(new PropertyValueFactory<Art, String>("artName"));
        col_artCount.setCellValueFactory(new PropertyValueFactory<Art, String>("artCount"));
        col_price.setCellValueFactory(new PropertyValueFactory<Art, String>("price"));
        col_category.setCellValueFactory(new PropertyValueFactory<Art, String>("category"));
        col_author.setCellValueFactory(new PropertyValueFactory<Art, String>("author"));


        listM = DatabaseHandler.getDataArt();
        table_arts.setItems(listM);
    }

    public void Delete(){
        conn = DatabaseHandler.ConnectDB();
        String sql = "delete from arts where artName = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_name.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            RefreshTable();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Buy(){
        conn = DatabaseHandler.ConnectDB();
        String sql = "delete from arts where artName = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_name.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Purchase completed");
            RefreshTable();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void Search(){
        col_id.setCellValueFactory(new PropertyValueFactory<Art, String>("id"));
        col_artName.setCellValueFactory(new PropertyValueFactory<Art, String>("artName"));
        col_artCount.setCellValueFactory(new PropertyValueFactory<Art, String>("artCount"));
        col_price.setCellValueFactory(new PropertyValueFactory<Art, String>("price"));
        col_category.setCellValueFactory(new PropertyValueFactory<Art, String>("category"));
        col_author.setCellValueFactory(new PropertyValueFactory<Art, String>("author"));



        dataList = DatabaseHandler.getDataArt();
        table_arts.setItems(dataList);
        FilteredList<Art> filteredData = new FilteredList<>(dataList, b -> true);
        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(artts -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(artts.getArtName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;//фильтр по названию
                }else if(artts.getPrice().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;//фильтр по цене
                } else if(artts.getCategory().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(artts.getAuthor().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }

                else
                    return false;
            });
        });
        SortedList<Art> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_arts.comparatorProperty());
        table_arts.setItems(sortedData);
    }

    @FXML
    void getData(javafx.event.ActionEvent event){
        System.out.println(data.getValue().toString());
    }

}
