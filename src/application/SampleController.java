package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import model.Produit;

public class SampleController {
	
	
	
	@FXML
	private TextField libelle;
	
	@FXML
	private TextField prix;
	
	
	@FXML
	private TextField qte;
	
	@FXML
	private Button btn;
	
	@FXML
	private Button listeProduits;
	
	@FXML
	private Button btnRetour;
	
	@FXML
	private RadioButton rbF;
	

	@FXML
	private RadioButton rbA;
	

	@FXML
	private ToggleGroup paysFab;
	
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private TextArea txtArea;
	
	@FXML
	private TableView<Produit> tview;
	
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException
	{
		Stage stage;
        Parent root;
        
        
        // s'il s'agit du click sur le bouton 'btn' on va ajouter un nouveau produit
		if (event.getSource()==btn)
		{
			String fxlibelle = libelle.getText();
			double fxprix =Double.parseDouble(prix.getText());
			int fxqte = Integer.parseInt(qte.getText());
			String fxremarque = txtArea.getText();
			
			//Récupération du Text du Bouton Radio Séléctionné
			RadioButton rb = (RadioButton) paysFab.getSelectedToggle();
			String fxpays = rb.getText();
			//Récupération du LocalDate
			LocalDate ldPicker = datePicker.getValue();
			//Construction d'un format français
			DateTimeFormatter format_fr = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
			//Mettre en forme selon le format
			String fxld = ldPicker.format(format_fr);  // le resultat est un String
			
			Produit p = new Produit(fxlibelle,fxprix,fxqte,fxpays,fxld,fxremarque);
			
			Main.produits.add(p);
			
			libelle.clear();
			prix.clear();
			qte.clear();
			txtArea.clear();
			datePicker.setValue(null);
			//System.out.println(Main.produits);
		}
		
		
		else if (event.getSource()==listeProduits) {
			//System.out.println("Clicked");
			
			//On récupére le stage, ou bien le Window(cad le théatre)  à partir de la scène à partir de bouton
            stage = (Stage) listeProduits.getScene().getWindow();
            
            
            //root = FXMLLoader.load(getClass().getResource("ListProduit.fxml"));
            root = FXMLLoader.load(getClass().getResource("InterfaceListProduct.fxml"));
            //créer une scène à partir de root qui est notre nouveau BorderPane
            Scene scene = new Scene(root,600,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
		

	  
        
	}
	
	
}
