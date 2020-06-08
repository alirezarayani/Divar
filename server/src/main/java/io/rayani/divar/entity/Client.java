package io.rayani.divar.entity;



import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Client implements Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 5455731108189617771L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "CLIENT_SEQ")
	private Long code ;
	private String nom ;
	private String prenom;
	private String CIN;
	private String address ;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}