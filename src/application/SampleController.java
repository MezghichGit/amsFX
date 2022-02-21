package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Produit;

public class SampleController {
	
	List<Produit> produits = new ArrayList<>();
	
	@FXML
	private TextField libelle;
	
	@FXML
	private TextField prix;
	
	
	@FXML
	private TextField qte;
	
	@FXML
	private Button btn;
	
	@FXML
	private void handleButtonAction(ActionEvent event)
	{
		if (event.getSource()==btn)
		{
			String fxlibelle = libelle.getText();
			double fxprix =Double.parseDouble(prix.getText());
			int fxqte = Integer.parseInt(qte.getText());
			
			//Cela doit être récupérer du formulaire
			boolean fxpays = true;
			LocalDate fxld = LocalDate.now();
			String fxremarque = "Produit pour la grippe";
			
			Produit p = new Produit(fxlibelle,fxprix,fxqte,fxpays,fxld,fxremarque);
			
			produits.add(p);
			System.out.println(produits);
			
		}
	}
	
	
}
