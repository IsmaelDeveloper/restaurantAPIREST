package com.restapi.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "menus")
@Entity
public class Menu {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String identifiant;
	private String entrees;
	private String plats;
	private String desserts;

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getEntrees() {
		return entrees;
	}

	public void setEntrees(String entrees) {
		this.entrees = entrees;
	}

	public String getPlats() {
		return plats;
	}

	public void setPlats(String plats) {
		this.plats = plats;
	}

	public String getDesserts() {
		return desserts;
	}

	public void setDesserts(String desserts) {
		this.desserts = desserts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desserts == null) ? 0 : desserts.hashCode());
		result = prime * result + ((entrees == null) ? 0 : entrees.hashCode());
		result = prime * result + ((plats == null) ? 0 : plats.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (desserts == null) {
			if (other.desserts != null)
				return false;
		} else if (!desserts.equals(other.desserts))
			return false;
		if (entrees == null) {
			if (other.entrees != null)
				return false;
		} else if (!entrees.equals(other.entrees))
			return false;
		if (plats == null) {
			if (other.plats != null)
				return false;
		} else if (!plats.equals(other.plats))
			return false;
		return true;
	}
	
	
}
