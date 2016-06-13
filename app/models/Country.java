package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.Model;

@Entity
public class Country extends Model {
	
	@Id
	public Integer id;
	@NotNull
	public String name; // Название страны
	@NotNull
	public String fleet; // Название флота
	public Country(String name, String fleet) { this.name = name; this.fleet = fleet; }  //конструктор создания флота
	
	@SuppressWarnings("deprecation")
	private static Finder<Long, Country> find = new Finder<Long, Country>(Long.class, Country.class); //поиск соответсвия в базе
	
	public static List<Country> all() { return find.all(); } //все флоты
	
	public static Country byName(String name) {
		List<Country> list = find.where().ieq("name", name).findList(); //получить флот по имени
		if(list.isEmpty()) return null; else return list.get(0);
	}
	
	public static Country RUSSIA() { return byName("СССР"); } //ф-ции возврата флота
	public static Country USA() { return byName("США"); }
	public static Country JAPAN() { return byName("Япония"); }
	public static Country GERMANY() { return byName("Германия");}
}
