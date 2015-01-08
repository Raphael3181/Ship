package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

@Entity
public class Country extends Model {
	
	@Id
	public Integer id;
	@NotNull
	public String name; // Название страны
	@NotNull
	public String fleet; // Название флота
	public Country(String name, String fleet) { this.name = name; this.fleet = fleet; }
	
	private static Finder<Long, Country> find = new Finder<Long, Country>(Long.class, Country.class);
	
	public static List<Country> all() { return find.all(); }
	
	public static Country byName(String name) {
		List<Country> list = find.where().ieq("name", name).findList();
		if(list.isEmpty()) return null; else return list.get(0);
	}
	
	public static Country RUSSIA() { return byName("Россия"); }
	public static Country USA() { return byName("США"); }
	public static Country JAPAN() { return byName("Япония"); }
}
