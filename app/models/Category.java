package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.Model;

@Entity
public class Category extends Model {
	
	@Id
	public Integer id;
	@NotNull
	public String cat; // Мн. ч.
	@NotNull
	public String name; // Ед. ч.
	public Category(String cat, String name) { this.cat = cat; this.name = name; }
	
	@SuppressWarnings("deprecation")
	private static Finder<Long, Category> find = new Finder<Long, Category>(Long.class, Category.class);
	
	public static List<Category> all() { return find.all(); }
	
	public static Category byName(String name) {
		List<Category> cat = find.where().ieq("name", name).findList();
		if(cat.isEmpty()) return null; else return cat.get(0);
	}
	
	public static Category AIRCRAFT_CARRIER() { return byName("Авианосец"); }
	public static Category BATTLESHIP() { return byName("Линкор"); }
	public static Category CRUISER() { return byName("Крейсер"); }
	public static Category DESTROYER() { return byName("Эсминец"); }
}
