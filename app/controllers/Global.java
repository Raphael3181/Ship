package controllers;

import java.util.GregorianCalendar;

import models.*;
import play.GlobalSettings;

public class Global extends GlobalSettings {
  public void onStart(play.Application app) {
	  if(Category.all().isEmpty()) {
		  addAllCategories();
		  addAllCoutries();
		  addAllShips();
	  }
  }
  
  // Добавить все классы кораблей
  private void addAllCategories() {
	  new Category("Авианосцы", "Авианосец").save();
	  new Category("Линкоры", "Линкор").save();
	  new Category("Крейсеры", "Крейсер").save();
	  new Category("Подводные лодки", "Подводная лодка").save();
	  new Category("Эсминцы", "Эсминец").save();
  }
  
  // Добавить все страны
  private void addAllCoutries() {
	  new Country("Россия", "Флот России").save();
	  new Country("США", "Флот США").save();
	  new Country("Япония", "Флот Японии").save();
  }
  
  // Добавить все корабли в базу
  private void addAllShips() {
	  Ship ship;
	  // Флот России
	  // Адмирал флота Советского Союза Кузнецов
	  ship = new Ship();
	  ship.name = "Адмирал флота Советского Союза Кузнецов";
	  ship.country = Country.RUSSIA();
	  ship.category = Category.AIRCRAFT_CARRIER();
	  ship.manufacturer = "Черноморский судостроительный завод";
	  ship.homeport = "Мурманск-35";
	  ship.status = "В составе флота";
	  ship.summary = "<b>&laquo;Адмирал флота Советского Союза Кузнецов&raquo;</b> - "
	  		+ "тяжёлый авианесущий крейсер проекта 1143.5, единственный в составе Военно-Морского флота Российской Федерации в своём классе "
	  		+ "(по состоянию на 2014 год).<br>"
	  		+ "Предназначен для поражения крупных надводных целей, защиты морских соединений от нападений вероятного противника.<br>"
	  		+ "Относится к 1-му рангу кораблей ВМФ. Как правило, требует командира в звании капитан 1-го ранга.";
	  ship.build_start = new GregorianCalendar(1982, 8, 1).getTimeInMillis(); // 1 сентября 1982 года
	  ship.launch_date = new GregorianCalendar(1985, 11, 4).getTimeInMillis(); // 4 декабря 1985 года
	  ship.commissioned_in = new GregorianCalendar(1991, 0, 20).getTimeInMillis(); // 20 января 1991 года
	  ship.displacement = 46540; ship.length = 306.45; ship.width = 71.96; ship.height = 64.49; ship.draft = 8.97;
	  ship.power = 200000; ship.speed = 29; ship.crew = 1960;
	  ship.arming = "На 2014 год в составе авиакрыла находятся 20 самолётов и 17 вертолётов:<ul>"
	  		+ "<li>14 палубных истребителей Су-33</li>"
	  		+ "<li>2 палубных истребителя МиГ-29К</li>"
	  		+ "<li>2 палубных учебно-боевых истребителя МиГ-29КУБ</li>"
	  		+ "<li>2 учебно-тренировочных самолета Су-25УТГ</li>"
	  		+ "<li>15 многоцелевых корабельных вертолётов Ка-27</li>"
	  		+ "<li>2 вертолёта радиолокационного дозора Ка-31</li></ul>"
	  		+ "Также авианесущий крейсер вооружен:<ul>"
	  		+ "<li>12 ПКРК 4К80 &laquo;Гранит&raquo;</li>"
	  		+ "<li>24 ПУ ЗРК &laquo;Кинжал&raquo; (192 ракеты)</li>"
	  		+ "<li>8 ЗРАК 3М87 &laquo;Кортик&raquo; (256 ракет)</li>"
	  		+ "<li>2 РБУ-12000 &laquo;Удав&raquo; (60 глубинных бомб)</li>"
	  		+ "<li>6 АК-630</li>";
	  ship.save();
	  
	  // Название корабля
//	  ship = new Ship();
	  // Характеристики
//	  ship.save();
  }
}