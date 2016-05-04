package application;


import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.Ruzzle.model.*;
import it.polito.tdp.Ruzzle.model.Quadrato;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class RuzzleController {
	
	private Model m;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private GridPane griglia;

    @FXML
    private Button btnGenera;

    @FXML
    private TextArea txtParole;
    
    @FXML
    private ListView<String> listaParole = new ListView<>();
    
    
    public void setModel(Model model) {
		m=model;
	}

    @FXML
    void DoGenera(ActionEvent event) {
    	String s[] = m.vettoreLettere();
    	int n=0;
    	
    	for(int i=0; i<4; i++){
    		for(int j=0; j<4; j++){
    			Label l = new Label();
    			l.setText(s[n]);
    			l.setAlignment(Pos.CENTER);
    			l.setMaxSize(40, 40);
    			griglia.add(l, j, i);	
    			n++;
    		}
    	}
    	m.parolepossibili();
    	ObservableList<String> items = FXCollections.observableArrayList(m.getParoleDaCercare());
    	listaParole.setItems(items);
    	
    }
    
    @FXML
    void doSeleziona(MouseEvent event) {
    	
    	for(Node n : griglia.getChildren()){
			((Region)n).setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY,Insets.EMPTY)));
		}
    	

    	String s = listaParole.getSelectionModel().getSelectedItem();
    	List<Posizione> pos = m.listaPosizioniParola(s);
    	System.out.println(s+pos);
    	for(Posizione p:pos){
    		for(Node n : griglia.getChildren()){
    			if(griglia.getColumnIndex(n)==p.getColonna()-1 && griglia.getRowIndex(n)==p.getRiga()-1){
    				((Region)n).setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY,Insets.EMPTY)));
    			}
    		}
    		
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert listaParole != null : "fx:id=\"listaParole\" was not injected: check your FXML file 'Ruzzle.fxml'.";

        for(Node n : griglia.getChildren()){
			((Region)n).setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY,Insets.EMPTY)));
		}
    }

	
}
