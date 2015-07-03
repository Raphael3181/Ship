package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.Expr;

import play.db.ebean.Model;

@Entity
public class Ship extends Model {
	@Id
	public Long id;
	@NotNull @ManyToOne
	public Category category; // Класс судна
	@NotNull @ManyToOne
	public Country country; // Страна службы
	@NotNull
	public String name; // Название
	@NotNull
	public String manufacturer; // Производитель
	public String homeport; // Порт приписки
	@NotNull
	public String status;
	@NotNull @Column(columnDefinition = "TEXT")
	public String summary; // Описание
	
	@NotNull
	public Long build_start; // Начало строительства
	@NotNull
	public Long launch_date; // Спуск на воду
	@NotNull
	public Long commissioned_in; // Введен в эксплуатацию
	public Long removed_from_fleet; // Вышел из состава флота
	
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
	public Integer power; // Мощность в л. с.
	@NotNull
	public Integer speed; // Скорость в узлах
	@NotNull
	public Integer crew; // Экипаж
	@NotNull @Column(columnDefinition = "TEXT")
	public String arming; // Вооружение
	
	private static Finder<Long, Ship> find = new Finder<Long, Ship>(Long.class, Ship.class);
	
	public static List<Ship> get(Integer fleet, Integer cat) {    //возврат кораблей по флоту и по категории
		return find.where(Expr.and(Expr.eq("country_id", fleet), Expr.eq("category_id", cat))).findList();
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
		return find.where(where).findList();
	}
}
