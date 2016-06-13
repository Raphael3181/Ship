package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.Expr;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;

@Entity @Table(name="ships")
public class Ship extends Model { //Поля соотв столбцам
	@Id
	public Long id;
	@NotNull @ManyToOne
	public Category category; // Класс судна
	@NotNull @ManyToOne
	public Country country; // Страна службы
	@NotNull
	public String name; // Название
	@NotNull @Column(columnDefinition = "TEXT")
	public String summary; // Описание
	@NotNull
	public Long launch_date; // Спуск на воду
	@NotNull
	public Integer displacement; // Стандартное водоизмещение в т
	@NotNull
	public Double length; // Длина в м
	@NotNull
	public Double width; // Ширина в м
	@NotNull
	public Double height; // Высота в м
	@NotNull
	public Double draft; // Осадка в м
	@NotNull
	public String engine; //Движитель
	@NotNull
	public Integer power; // Мощность в л. с.
	@NotNull
	public Integer speed; // Скорость в узлах
	@NotNull
	public Integer distance;//Дальность хода
	@NotNull
	public Integer crew; // Экипаж
	@NotNull @Column(columnDefinition = "TEXT")
	public String arming; // Вооружение
	@NotNull
	public String artillery; // Артиллерия
	@NotNull
	public String antiAir; //ПВО
	@NotNull
	public String airGroup; //Авиагруппа
	
	public Ship(){
		
	}
	
	@SuppressWarnings("deprecation")
	private static Finder<Long, Ship> find = new Finder<Long, Ship>(Long.class, Ship.class); //Формирует корабль из JSON
	public Ship(JsonNode json) {
		if (json.has("id")) id = json.findPath("id").longValue();
		category = Category.byName(json.findPath("category").textValue()) ;
		country = Country.byName(json.findPath("country").textValue());
		name = json.findPath("name").textValue();
		summary = json.findPath("summary").textValue();
		launch_date = json.findPath("launch_date").longValue();
		displacement = json.findPath("displacement").intValue();
		length = json.findPath("length").doubleValue();
		width = json.findPath("width").doubleValue();
		height = json.findPath("height").doubleValue();
		draft = json.findPath("draft").doubleValue();
		engine = json.findPath("engine").textValue();
		power = json.findPath("power").intValue();
		speed = json.findPath("speed").intValue();
		distance = json.findPath("distance").intValue();
		crew = json.findPath("crew").intValue();
		arming = json.findPath("arming").textValue();
		artillery = json.findPath("artillery").textValue();
		antiAir = json.findPath("antiAir").textValue();
		airGroup = json.findPath("airGroup").textValue();
	}
	
	public static List<Ship> get(Integer fleet, Integer cat) {    //возврат кораблей по флоту и по категории
		return find.where().and(Expr.eq("country_id", fleet), Expr.eq("category_id", cat)).findList();
	}
	
	public static List<Ship> get(Integer fleet, boolean[] cat) {    //возврат кораблей по флоту и по категории
		String where = "country_id = " + fleet + " and (";
		if(cat[0]) where += "category_id = 1";
		if(cat[1] && (cat[0] || cat[2] || cat[3])) where += " or ";
		if(cat[1]) where += "category_id = 2";
		if(cat[2] && (cat[0] || cat[1] || cat[3])) where += " or ";
		if(cat[2]) where += "category_id = 3";
		if(cat[3] && (cat[0] || cat[1] || cat[2])) where += " or ";
		if(cat[3]) where += "category_id = 5";
		where += ")";
		return find.where().raw(where).findList();
	}
	public static void delete(long id){
		find.deleteById(id);
	}
}
