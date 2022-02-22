package model;

import java.time.LocalDate;

public class Produit {

	@Override
	public String toString() {
		return "Produit [libelle=" + libelle + ", prix=" + prix + ", qte=" + qte + ", pays=" + pays
				+ ", dateFabrication=" + dateFabrication + ", remarque=" + remarque + "]";
	}
	public Produit(String libelle, double prix, int qte, String pays, String dateFabrication, String remarque) {
		this.libelle = libelle;
		this.prix = prix;
		this.qte = qte;
		this.pays = pays;
		this.dateFabrication = dateFabrication;
		this.remarque = remarque;
	}
	public Produit() {
		
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public String isPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getDateFabrication() {
		return dateFabrication;
	}
	public void setDateFabrication(String dateFabrication) {
		this.dateFabrication = dateFabrication;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	private String libelle;
	private double prix;
	private int qte;
	private String pays; 
	private String dateFabrication;
	private String remarque;
}
