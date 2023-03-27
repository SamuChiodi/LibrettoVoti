package it.polito.tdp.libretto;


import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Controller {
	
	private Libretto model ;

	public  void setModel(Libretto model) {
		this.model = model;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> comboPunti;

    @FXML
    private DatePicker selData;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtResult;

    @FXML
    void doInserisci(ActionEvent event) {
    	String corso = txtCorso.getText();
    	Integer Punti = comboPunti.getValue();
    	LocalDate date = selData.getValue();
    	
    	Voto v = new Voto(corso, Punti, date);
    	this.model.add(v);
    	
    	txtResult.setText(model.toString());
    }

    @FXML
    void initialize() {
        assert comboPunti != null : "fx:id=\"comboPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'main.fxml'.";

       
        for(int p = 18; p<=30; p++) {
        	  comboPunti.getItems().add(p);
        }
      
        
    }

	
}
