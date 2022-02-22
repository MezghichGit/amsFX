package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Produit;

public class InterfaceListProductController implements Initializable{

	
	@FXML
	private Button btnRetour;
	

	@FXML
    private TableColumn<Produit, String> libelle;
	@FXML
    private TableColumn<Produit, Double> prix;
	@FXML
    private TableColumn<Produit, Integer> qte;
	@FXML
    private TableColumn<Produit, String> pays;
	@FXML
    private TableColumn<Produit, String> date;
	@FXML
    private TableColumn<Produit, String> remarque;
	
	@FXML
	private TableView<Produit> tview;
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException
	{
		Stage stage;
        Parent root;
        
		 if (event.getSource()==btnRetour) {
			
			 //System.out.println("Return Button is Clicked ");
			
			stage = (Stage) btnRetour.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
            Scene scene = new Scene(root,700,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
	}
	
	@Override  // redefinition
	public void initialize(URL arg0, ResourceBundle arg1) {
	// On créer une liste Observable	
	ObservableList<Produit> ProduitList = FXCollections.observableArrayList();
	
	
	//On remplis notre liste Observable
	for (Produit p : Main.produits){
		        	ProduitList.add(p);
     }
	
    //System.out.println(ProduitList);
    
    
    libelle.setCellValueFactory(new PropertyValueFactory<Produit,String>("libelle"));
    prix.setCellValueFactory(new PropertyValueFactory<Produit,Double>("prix"));
    qte.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("qte"));
    pays.setCellValueFactory(new PropertyValueFactory<Produit,String>("pays"));
    date.setCellValueFactory(new PropertyValueFactory<Produit,String>("dateFabrication"));
    remarque.setCellValueFactory(new PropertyValueFactory<Produit,String>("remarque"));
    
    tview.setItems(ProduitList);
		        	
	}
}
