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
	  new Category("Линкоры","Линкор").save();
	  new Category("Крейсеры","Крейсер").save();
	  new Category("Эсминцы","Эсминец").save();
	  new Category("Авианосцы","Авианосец").save();	  
  }
  
  // Добавить все страны
  private void addAllCoutries() {
	  new Country("СССР", "Флот СССР").save();
	  new Country("Япония", "Флот Японии").save();
	  new Country("США", "Флот США").save();
	  new Country("Германия","Флот Германии").save();
  }
  
  // Добавить все корабли в базу
  private void addAllShips() {
	  Ship ship;
	  // Флот России
	  // Авианосец
	  // Адмирал флота Советского Союза Кузнецов
	  ship = new Ship();
	  ship.name = "Адмирал флота Советского Союза Кузнецов";
	  ship.country = Country.RUSSIA();
	  ship.category = Category.AIRCRAFT_CARRIER();
	  ship.summary = "<b>&laquo;Адмирал флота Советского Союза Кузнецов&raquo;</b> - "
	  		+ "тяжёлый авианесущий крейсер проекта 1143.5, единственный в составе Военно-Морского флота Российской Федерации в своём классе "
	  		+ "(по состоянию на 2014 год).<br>"
	  		+ "Предназначен для поражения крупных надводных целей, защиты морских соединений от нападений вероятного противника.<br>"
	  		+ "Относится к 1-му рангу кораблей ВМФ. Как правило, требует командира в звании капитан 1-го ранга.";
	  
	  ship.launch_date = new GregorianCalendar(1985, 11, 4).getTimeInMillis(); // 4 декабря 1985 года
	  
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
	  ship.distance = 0;
	  ship.engine = "";
	  ship.artillery = "";
	  ship.antiAir = "";
	  ship.airGroup = "";
	  ship.save();
	  
	  // Флот России
      // Авианосец
      // Варяг
      ship = new Ship();
      ship.name = "Варяг";
	  ship.country = Country.RUSSIA();
	  ship.category = Category.AIRCRAFT_CARRIER();
	  
	  ship.summary = "<b>&laquo;Варяг (авианесущий крейсер)&raquo;</b> - "
	  		+ "тяжёлый авианесущий крейсер, а после демонтажа ударного вооружения — авианосец. "
	  		+ " Принадлежал ранее СССР и Украине, а в настоящее время состоит на вооружении КНР (Военно-морской флот Народно-освободительной армии).<br>";
	 
	  ship.launch_date = new GregorianCalendar(1988, 10, 25).getTimeInMillis(); // 25 ноября 1988 года
	  
	  ship.displacement = 59500; ship.length = 304.5; ship.width = 38.1; ship.height = 64.49; ship.draft = 10.5;
	  ship.power = 200000; ship.speed = 29; ship.crew = 1980;
	  ship.arming = "<ul>"
	  		+ "<li>Зенитная артиллерия 6×6 30-мм орудий АК-630М</li>"
	  		+ "<li>Ракетное вооружение 12 ПУ 4К-80 ПКРК Гранит 4 × 6 ПУ ЗРК Кинжал (192 ракеты),8 ПУ Кортик</li>"
	  		+ "<li>Противолодочное вооружение 2 × 10 РБУ-12000)</li>"
	  		+ "<li>Авиационная группа	26 × Су-33, МиГ-29К, 24 × Ка-27, Ка-29, Ка-31</li>";
	  ship.distance = 0;
	  ship.engine = "";
	  ship.artillery = "";
	  ship.antiAir = "";
	  ship.airGroup = "";
      ship.save();
      
   	  // Флот России
	  // Авианосец
	  // Авианесущие крейсера проекта 1143
	  ship = new Ship();
	  ship.name = "Проект 1143 Кречет";
	  ship.country = Country.RUSSIA();
	  ship.category = Category.AIRCRAFT_CARRIER();
	 
	  ship.summary = "<b>&laquo;Проект 1143 Кречет&raquo;</b> - "
	  		+ " проект авианесущих противолодочных крейсеров, который создавался как продолжение серии кораблей проекта 1123 Кондор.";
	 
	  ship.launch_date = new GregorianCalendar(1972, 11, 26).getTimeInMillis(); 
	 
	  ship.displacement = 31900; ship.length = 273.0; ship.width = 31.0; ship.height = 0.0; ship.draft = 8.0;
	  ship.power = 180000; ship.speed = 30; ship.crew = 1300;
	  ship.arming = "<ul>"
	  		+ "<li>Авиационная группа 36 самолётов Як-38;вертолёты Ка-25,Ка-27</li>";
	  ship.distance = 0;
	  ship.engine = "";
	  ship.artillery = "";
	  ship.antiAir = "";
	  ship.airGroup = "";
	  ship.save();
	  
	      // Флот России
		  // Авианосец
		  // Киев (авианесущий крейсер)
		  ship = new Ship();
		  ship.name = "Киев";
		  ship.country = Country.RUSSIA();
		  ship.category = Category.AIRCRAFT_CARRIER();
		 
		  ship.summary = "<b>&laquo;Киев&raquo;</b> - "
		  		+ " тяжёлый авианесущий крейсер (ТАКР) Северного флота Военно-Морского Флота СССР (ВМФ СССР; г. Североморск). "
		  		+ "Головной корабль проекта 1143";
		 
		  ship.launch_date = new GregorianCalendar(1972, 11, 26).getTimeInMillis(); 
		  
		  ship.displacement = 30530; ship.length = 273.1; ship.width = 31.0; ship.height = 0.0; ship.draft = 8.95;
		  ship.power = 182500; ship.speed = 32; ship.crew = 1900;
		  ship.arming = "<ul>"
		  		+ "<li>Ракетное вооружение	4 × 2 ПУ ПКРК П-500 Базальт</li>"
		  		+ "<li>Авиационная группа	авиаэскадрилья: 18 самолётов(с вертикальным взлётом и посадкой),18 вертолётов</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		// Флот России
		  // Линкор
		  // Гангут (линкор)
		  ship = new Ship();
		  ship.name = "«Га́нгут» (с 1925 года Октя́брьская револю́ция)";
		  ship.country = Country.RUSSIA();
		  ship.category = Category.BATTLESHIP();
		 
		  ship.summary = "<b>&laquo;Га́нгут</b> - "
		  		+ " линкор русского и советского флота, последний из четырёх дредноутов балтийской серии типа Севастополь"
		  		+ "Линкор-дредноут «Гангут» стал четвёртым кораблём русского флота, названным в честь победы в Гангутском сражении.";
		  
		  ship.launch_date = new GregorianCalendar(1911, 8, 24).getTimeInMillis(); 
		 
		  ship.displacement = 26900; ship.length = 184.9; ship.width = 26.9; ship.height = 0.0; ship.draft = 9.1;
		  ship.power = 42000; ship.speed = 24; ship.crew = 1220;
		  ship.arming = 
		  		 "Артиллерия	4 × 3 × 305-мм орудия, 16 × 120-мм орудий"
		  		 + "Минно-торпедное вооружение 4 торпедных аппарата";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот России
		  // Линкор
		  // Петропавловск (линкор)
		  ship = new Ship();
		  ship.name = " Петропавловск ";
		  ship.country = Country.RUSSIA();
		  ship.category = Category.BATTLESHIP();
		  
		  ship.summary = "<b>&laquo; Петропавловск &raquo;</b> - "
		  		+ " линкор русского и советского Балтийского флота, третий (по дате закладки и дате спуска на воду) линейный корабль типа Севастополь";
		 
		  ship.launch_date = new GregorianCalendar(1911, 7, 27).getTimeInMillis(); 
		  
		  ship.displacement = 26900; ship.length = 184.9; ship.width = 26.9; ship.height = 0.0; ship.draft = 9.1;
		  ship.power =  32000 ; ship.speed = 25; ship.crew = 1220;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия 12 (4 × 3) × 305-мм орудия,16 (16 × 1) × 120-мм орудий</li>"
		  		+ "<li>Минно-торпедное вооружение Четыре 450-мм торпедных аппарата</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
	      // Флот России
		  // крейсер
		  // Красный Крым (крейсер)
		  ship = new Ship();
		  ship.name = "Красный Крым";
		  ship.country = Country.RUSSIA();
		  ship.category = Category.CRUISER();
		 
		  ship.summary = "<b>&laquo; Красный Крым &raquo;</b> - "
		  	   + "лёгкий крейсер ВМФ СССР"
		       + " При закладке крейсеру было присвоено наименование «Светлана», в честь одноимённого крейсера, геройски погибшего 28 мая 1905 года в Цусимском сражении.<br>"
	  		   + " Являлся головным кораблём в серии лёгких крейсеров Российского императорского флота<br>"
	  		   + "Принимал участие в боях в составе Черноморского Флота в годы Великой Отечественной войны, удостоен звания — гвардейский корабль.";
		 
		  ship.launch_date = new GregorianCalendar(1915, 10, 28).getTimeInMillis(); 
		 
		  ship.displacement = 7999; ship.length = 158.4; ship.width = 0.0; ship.height = 0.0; ship.draft = 5.77;
		  ship.power =  46300 ; ship.speed = 29; ship.crew = 852;
		  ship.arming = "<ul>"
		  		+ "<li>Навигационное вооружение	5 127-мм магнитных компасов, гирокомпас Курс-II, эхолот МС-2, механический лот Томсона, лаг типа ГО М-3.</li>"
		  		+ "<li>Артиллерия	15 × 1 — 130/55-мм АУ Б-7</li>"
		        + "<li>Зенитная артиллерия	3 × 2 — 100/47-мм ЗАУ системы Минизини4 — 45/46-мм ЗАУ 21-10 — 37/62,5-мм ЗАУ 70-К2 × 4 — 12,7-мм ЗП Виккерс 4 — 12,7-мм ЗП ДШК</li>"
		        + "<li>Противолодочное вооружение	6 совков для бомб 30 глубинных бомб</li>"
		        + "<li>Минно-торпедное вооружение	2 × 3 533-мм ТА 39-Ю</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();	
		  
		  // Флот России
		  // Эсминцы
		  // Скорый (эсминец, 1949)
		  ship = new Ship();
		  ship.name = "«Скорый» ";
		  ship.country = Country.RUSSIA();
		  ship.category = Category.DESTROYER();
		 
		  ship.summary = "<b>&laquo; советский эскадренный миноносец проекта 30-бис&raquo;</b> - "
		  	   + "После 29 июня 1958 года — передан польским ВМС, переименован в эсминец «Wicher» («Вихер»).";
		  
		  ship.launch_date = new GregorianCalendar(1949, 8, 14).getTimeInMillis(); 
		 
		  ship.displacement = 2316; ship.length = 120.5; ship.width = 12.0; ship.height = 0.0; ship.draft = 3.9;
		  ship.power =  60000 ; ship.speed = 37; ship.crew = 286;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия2x2 130-мм АУ Б2-ЛМ.</li>"
		  		+ "<li>Зенитная артиллерия	1х2 85-мм АУ 92-К и 7х1 37-мм АУ 70-К</li>"
		  		+ "<li>Минно-торпедное вооружение	2 х 5 533-мм ТА, 2 БМБ-2 и 2 бомбосбрасывателя (51 глубинная бомбы), 52 мины КБ-«Краб» или 60 мин М-26.</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот России
		  // Эсминцы
		  // Сметливый (эсминец, 1951)
		  ship = new Ship();
		  ship.name = "«Сметливый»";
		  ship.country = Country.RUSSIA();
		  ship.category = Category.DESTROYER();
		 
		  ship.summary = "<b>&laquo;советский эскадренный миноносец проекта 30-бис&raquo;</b> - "
		  	   + " После 11 июня 1956 года — египетский эсминец «Al Zaffer».";
		  
		  ship.launch_date = new GregorianCalendar(1951, 8, 14).getTimeInMillis(); 
		  
		  ship.displacement = 2316; ship.length = 120.5; ship.width = 12.0; ship.height = 0.0; ship.draft = 3.9;
		  ship.power =  60000 ; ship.speed = 37; ship.crew = 286;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия2x2 130-мм АУ Б2-ЛМ.</li>"
		  		+ "<li>Зенитная артиллерия	1х2 85-мм АУ 92-К и 7х1 37-мм АУ 70-К</li>"
		  		+ "<li>Минно-торпедное вооружение	2 х 5 533-мм ТА, 2 БМБ-2 и 2 бомбосбрасывателя (51 глубинная бомбы), 52 мины КБ-«Краб» или 60 мин М-26.</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот России
		  // Эсминцы
		  // Смышлёный (эсминец, 1939)
		  ship = new Ship();
		  ship.name = "«Смышлёный»";
		  ship.country = Country.RUSSIA();
		  ship.category = Category.DESTROYER();
		  
		  ship.summary = "<b>&laquo;Эскадренный миноносец проекта 7-У&raquo;</b> - "
		  	   + "Первый черноморский корабль данного класса";
		 
		  ship.launch_date = new GregorianCalendar(1939, 7, 26).getTimeInMillis(); 
		  
		  ship.displacement = 2404; ship.length = 112.5; ship.width = 10.2; ship.height = 0.0; ship.draft = 5.;
		  ship.power =  54000 ; ship.speed = 36; ship.crew = 271;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия 4 × 1 — 130-мм орудия Б-13-2с, 2 × 1 — 76,2-мм орудия 34-К</li>"
		  		+ "<li>ЗЗенитная артиллерия	7 × 1 — 37-мм орудий 70-К, 8 × 12,7-мм пулемётов</li>"
		  		+ "<li>Противолодочное вооружение	2 бомбомёта, 30 глубинных бомб</li>"
		        + "<li>Минно-торпедное вооружение	2 трёхтрубных 533-мм торпедных аппарата,4 комплекта параван-тралов, 58 якорных мин заграждения</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот США
		  // Авианосец
		  // USS Langley (CV-1)
		  ship = new Ship();
		  ship.name = "«Лэ́нгли»";
		  ship.country = Country.USA();
		  ship.category = Category.AIRCRAFT_CARRIER();
		 
		  ship.summary = "<b>&laquo;первый авианосец ВМС США&raquo;</b> - "
		  		+ "Переоборудован в 1920 году из угольщика «Юпитер» (AC-3)."
		  		+ "Перед Второй мировой войной переоборудован в авиатранспорт (AV-3).<br>"
		  		+ " 27 февраля 1942 года во время транспортировки самолётов на остров Ява был тяжело повреждён японскими бомбардировщиками и потоплен кораблями эскорта";
		 
		  ship.launch_date = new GregorianCalendar(1912, 8, 14).getTimeInMillis(); 
		 
		  ship.displacement = 11500; ship.length = 158.5; ship.width = 19.9; ship.height = 0.0; ship.draft = 6.27;
		  ship.power = 7150; ship.speed = 14; ship.crew = 468;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	4 × 127-мм/51</li>"
		  		+ "<li>Авиационная группа	до 55 самолётов</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот США
		  // Авианосец
		  // USS Sable (IX-81)
		  ship = new Ship();
		  ship.name = "«IX-81 Сэйбл»";
		  ship.country = Country.USA();
		  ship.category = Category.AIRCRAFT_CARRIER();
		  
		  ship.summary = "<b>&laquo;Учебный авианосец военно-морских сил США в годы Второй Мировой Войны&raquo;</b> - "
		  		+ "Вместе с аналогичным кораблем USS Wolverine (IX-64),"
		  		+ "являлся одним из двух когда-либо созданных пресноводных авианосцев и авианосцев, оснащенных гребными колесами<br>"
		  		+ "Был перестроен из колесного парома Greater Buffalo на озере Мичиган";
		
		  ship.launch_date = new GregorianCalendar(1942, 6, 20).getTimeInMillis(); 
		 
		  ship.displacement = 7739; ship.length = 158.1; ship.width = 18.0; ship.height = 6.5; ship.draft = 0.0;
		  ship.power = 0; ship.speed = 18; ship.crew = 470;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	Отсутствует</li>"
		  		+ "<li>Авиационная группа	Только временное базирование на палубе</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  
		  // Флот США
		  // Линейные корабли 
		  // USS Sable (IX-81)
		  ship = new Ship();
		  ship.name = "«IX-81 Сэйбл»";
		  ship.country = Country.USA();
		  ship.category = Category.BATTLESHIP();
		 
		  ship.summary = "<b>&laquo;Учебный авианосец военно-морских сил США в годы Второй Мировой Войны&raquo;</b> - "
		  		+ "Вместе с аналогичным кораблем USS Wolverine (IX-64),"
		  		+ "являлся одним из двух когда-либо созданных пресноводных авианосцев и авианосцев, оснащенных гребными колесами<br>"
		  		+ "Был перестроен из колесного парома Greater Buffalo на озере Мичиган";
		
		  ship.launch_date = new GregorianCalendar(1942, 6, 20).getTimeInMillis(); 
		 
		  ship.displacement = 7739; ship.length = 158.1; ship.width = 18.0; ship.height = 6.5; ship.draft = 0.0;
		  ship.power = 0; ship.speed = 18; ship.crew = 470;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	Отсутствует</li>"
		  		+ "<li>Авиационная группа	Только временное базирование на палубе</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот США
		  // Линейные корабли 
		  // USS Tennessee (BB-43)
		  ship = new Ship();
		  ship.name = "«Теннесси»";
		  ship.country = Country.USA();
		  ship.category = Category.BATTLESHIP();
		 
		  ship.summary = "<b>&laquo; головной линкор типа «Теннесси» ВМС США&raquo;</b> - "
		  		+ "Стал третьим по счёту кораблём ВМС, названным в честь 16-го штата США."
		  		+ "Линкор был повреждён во время нападения на Пёрл-Харбор в декабре 1941 года, но был отремонтирован и модернизирован";
		
		  ship.launch_date = new GregorianCalendar(1919, 4, 3).getTimeInMillis(); 
		  
		  ship.displacement = 40950; ship.length = 190.1; ship.width = 29.7; ship.height = 0.0; ship.draft = 9.2;
		  ship.power = 30908; ship.speed = 21; ship.crew = 2220;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	4 × 3 — 356-мм,14 × 127-мм</li>"
		  		+ "<li>Зенитная артиллерия	8 × 1 — 127-мм/25, 4 × 1 — 76-мм/50,8 × 1 — 12,7-мм</li>"
		  		+ "<li>Минно-торпедное вооружение	2 × 533-мм торпедных аппарата</li>"
		  		+ "<li>Авиационная группа	2 катапульты, 2 гидросамолёта OS2U «Кингфишер»</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот США
		  // крейсера
		  // Тяжёлые крейсера типа «Нью-Орлеан»
		  ship = new Ship();
		  ship.name = "«Нью-Орлеан» ";
		  ship.country = Country.USA();
		  ship.category = Category.CRUISER();
		 
		  ship.summary = "<b>&laquo;Тяжёлый крейсер флота США.&raquo;</b> - "
		  		+ "Всего построено 7 единиц";
		 
		  ship.launch_date = new GregorianCalendar(1933, 4, 12).getTimeInMillis(); 
		 
		  ship.displacement = 12463; ship.length = 176.2; ship.width = 18.8; ship.height = 0.0; ship.draft = 6.9;
		  ship.power = 107000; ship.speed = 32; ship.crew = 807;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	3 × 3 — 203-мм/55</li>"
		  		+ "<li>ЗЗенитная артиллерия	8 × 1 — 127-мм/25, 8 × 1 — 12,7-мм пулемётов</li>"
		  		+ "<li>Авиационная группа	2 катапульты,4 гидросамолёта</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот США
		  // крейсера
		  // USS Milwaukee (CL-5)
		  ship = new Ship();
		  ship.name = "USS Milwaukee (CL-5)";
		  ship.country = Country.USA();
		  ship.category = Category.CRUISER();
		 
		  ship.summary = "<b>&laquo; лёгкий крейсер типа «Омаха» ВМС США, принявший участие во Второй мировой войне.&raquo;</b> - "
		  		+ "Использовался для службы на Тихом океане, затем действовал в Атлантике"
		  		+ "Был передан СССР в счёт итальянских кораблей, которые СССР должен был получить по репарациям.<br>"
			    + "Перешел на север в составе конвоя, был принят на вооружение Северного флота ВМФ СССР под названием «Мурманск»";
		
		  ship.launch_date = new GregorianCalendar(1922, 6, 29).getTimeInMillis(); 
		  
		  ship.displacement = 10460; ship.length = 169.4; ship.width = 16.9; ship.height = 0.0; ship.draft = 6.9;
		  ship.power = 90000; ship.speed = 30; ship.crew = 805;
		  ship.arming = "<ul>"
		  		+ "<li>Радиолокационное вооружение	1 — SC (обнаружения воздушных целей)1 — SG (обнаружения надводных целей)2 — Мк.3 (орудийной наводки)</li>"
		  		+ "<li>Артиллерия	10 × 152/52-мм орудий Мк;12/1, из которых 4 в двух башнях и 6 в казематах;6 — 76/50-мм универсальных установок Мк.10</li>"
		  		+ "<li>Зенитная артиллерия	3 — 40/56-мм спаренные установки Мк.1, 12 — 20-мм установок «Эрликон»</li>"
		  		+ "<li>Минно-торпедное вооружение	Два трёхтрубных 53-см торпедных аппарата, 2 бомбомета МК-6</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		   
		  
		  
		  // Флот США
		  // Эсминец
		  // USS Laboon (DDG-58)
		  ship = new Ship();
		  ship.name = "USS Catfish (SS-339)";
		  ship.country = Country.USA();
		  ship.category = Category.DESTROYER();
		
		  ship.summary = "<b>&laquo;Эсминец УРО типа «Арли Бёрк».&raquo;</b> - "
			  		+ " Построен на верфи Bath Iron Works, включён в состав ВМС в 1995 году, приписан к морской станции Норфолк, штат Виргиния.";
		 
		  ship.launch_date = new GregorianCalendar(1993, 2, 20).getTimeInMillis(); 
		 
		  ship.displacement = 6630; ship.length = 153.92; ship.width = 20.1; ship.height = 5.5; ship.draft = 9.3;
		  ship.power =  108000; ship.speed = 32; ship.crew = 337;
		  ship.arming = "<ul>"
		  		+ "<li>Тактическое ударное вооружение	2 ПУ системы «Иджис» на 29 (носовая) и 61 (кормовая) ячейку для ракет соответственно.</li>"
		        + "<li>Артиллерия	1*1 127 мм. АУ Mark 45. Mod. 3/54 кал., 600 снарядов </li>"
		        + "<li>Зенитная артиллерия	2 6-ствольных 20 мм. ЗАУ «Фаланкс»</li>"
		        + "<li>Ракетное вооружение	2*4 ПКР Harpoon до 74 ракет RIM-66 SM-2 «Стандарт-2»</li>"
		        + "<li>Противолодочное вооружение	ПЛУР RUM-139 ASROC</li>"
		        + "<li>Минно-торпедное вооружение	2*3 324 мм. ТА Mk. 32 (торпеды Mk.46 и Mk.50)</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();	
		  
		  
		  // Флот США
		  // Эсминец
		  // USS Phelps (DD-360)
		  ship = new Ship();
		  ship.name = "USS Phelps (DD-360)";
		  ship.country = Country.USA();
		  ship.category = Category.DESTROYER();
		
		  ship.summary = "<b>&laquo; Американский эсминец типа Porter.&raquo;</b> - "
			  		+ "Продан 10 августа 1947 года фирме «Northern Metals Co.» в Филадельфию и разобран на слом";
		 
		  ship.launch_date = new GregorianCalendar(1935, 7, 18).getTimeInMillis(); 
		  
		  ship.displacement = 2600; ship.length = 116.0; ship.width = 11.2; ship.height = 0.0; ship.draft = 3.2;
		  ship.power =  50000; ship.speed = 37; ship.crew = 194;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	4 × 2 127-мм/38 Mark 12</li>"
		        + "<li>Зенитная артиллерия	2 × 4 — 28-мм (1938)</li>"
		        + "<li>Противолодочное вооружение	два бомбосбрасывателя, 14 ГБ</li>"
		        + "<li>Минно-торпедное вооружение	2 × 4 533-мм ТА</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот Японии
		  // Авианосец
		  // Дзуйкаку
		  ship = new Ship();
		  ship.name = "Дзуйкаку";
		  ship.country = Country.JAPAN();
		  ship.category = Category.AIRCRAFT_CARRIER();
		 
		  ship.summary = "<b>&laquo; японский авианосец времён Второй мировой войны типа «Сёкаку».&raquo;</b> - "
		  		+ "Принимал активное участие почти во всех крупных сражениях на Тихом океане против американского флота,"
		  		+ "в том числе атаке на Пёрл-Харбор, рейде в Индийский океан, бою в Коралловом море, бою у Восточных Соломоновых островов, бою у островов Санта-Крус, сражении у Марианских островов.<br>"
		  		+ "По количеству проведенных операций «Дзуйкаку» уступает только американскому авианосцу «Энтерпрайз»<br>"
		  		+ "Потоплен 25 октября 1944 года в бою у мыса Энганьо в ходе Филиппинской операции.";
		
		  ship.launch_date = new GregorianCalendar(1939, 10, 27).getTimeInMillis(); 
		  
		  ship.displacement = 29800; ship.length = 250.0; ship.width = 26.0; ship.height = 0.0; ship.draft = 8.9;
		  ship.power = 153000; ship.speed = 34; ship.crew = 1690;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	8 × 2 — 127-мм/40 тип 89</li>"
		  		+ "<li>Зенитная артиллерия	12 × 3 — 25-мм/60 тип 96 22 × 13,2-мм (на момент вступления в строй)</li>"
		  		+ "<li>Авиационная группа	63 самолёта (на 05.1942 г.)75 самолётов (максимально, нес в 1943-44 гг.)</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот Японии
		  // Авианосец
		  // Сорю 
		  ship = new Ship();
		  ship.name = "Сорю";
		  ship.country = Country.JAPAN();
		  ship.category = Category.AIRCRAFT_CARRIER();
		  
		  ship.summary = "<b>&laquo; японский авианосец времён Второй мировой войны&raquo;</b> - "
		  		+ "Являлся первым удачным авианосцем специальной постройки для Японского Императорского флота."
		  		+ " Был построен с водоизмещением, ограниченным рамками Лондонского морского договора.";
		 
		  ship.launch_date = new GregorianCalendar(1937, 0, 0).getTimeInMillis(); 
		 
		  ship.displacement = 18800; ship.length = 222.0; ship.width = 21.3; ship.height = 0.0; ship.draft = 8.0;
		  ship.power = 152000; ship.speed = 34; ship.crew = 1100;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	12 (6 × 2) — 127-мм/40 тип 89</li>"
		  		+ "<li>Зенитная артиллерия	28 × 25-мм/60 тип 96</li>"
		  		+ "<li>Авиационная группа	73 самолёта (1941 год)</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот Японии
		  // Линкор
		  // Ямато
		  ship = new Ship();
		  ship.name = "«Ямато»";
		  ship.country = Country.JAPAN();
		  ship.category = Category.BATTLESHIP();
		 
		  ship.summary = "<b>&laquo; линкор японского императорского флота времен Второй мировой войны типа «Ямато».&raquo;</b> - ";
	
		  ship.launch_date = new GregorianCalendar(1940, 7, 8).getTimeInMillis(); 
		 
		  ship.displacement = 72810 ; ship.length = 243.9; ship.width = 36.9; ship.height = 0.0; ship.draft = 10.4;
		  ship.power = 150000; ship.speed = 28; ship.crew = 2500;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	3 × 3 — 460-мм/45, 4 × 3 — 155-мм/60</li>"
		  		+ "<li>Зенитная артиллерия	6 × 2 — 127-мм/40 (позже увеличено до 12 × 2),8 × 3- 25-мм (позже — 52 × 3),2 × 2 — 13,2-мм пулемёта</li>"
		  		+ "<li>Авиационная группа	2 катапульты, 7 гидросамолётов</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот Японии
		  // Линкор
		  // Мусаси
		  ship = new Ship();
		  ship.name = "«Мусаси»";
		  ship.country = Country.JAPAN();
		  ship.category = Category.BATTLESHIP();
		 
		  ship.summary = "<b>&laquo;второй линкор в серии типа «Ямато» японского императорского флота времён Второй мировой войны&raquo;</b> - "
		        + " Флагман Объединённого флота Японии."
	  		    + " Получил название в честь древней японской провинции Мусаси.<br>"
		        + " «Мусаси» и его систершип «Ямато» были самыми крупными и самыми мощными линейными кораблями в мире, имели водоизмещение 74,000 тонн, главный калибр — 460 мм орудия.";
		
		  ship.launch_date = new GregorianCalendar(1940, 10, 1).getTimeInMillis(); 
		 
		  ship.displacement = 72800 ; ship.length = 256.0; ship.width = 38.9; ship.height = 0.0; ship.draft = 11.0;
		  ship.power = 150000; ship.speed = 27; ship.crew = 2399;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	3 × 3 — 460-мм/45, 4 × 3 — 155-мм/60</li>"
		  		+ "<li>Зенитная артиллерия	6 × 2 — 127-мм/40,8 × 3- 25-мм,2 × 2 — 13,2-мм пулемёта</li>"
		  		+ "<li>Авиационная группа	2 катапульты, 7 гидросамолётов</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  
		  // Флот Японии
		  // Крейсер
		  // Агано (лёгкий крейсер)
		  ship = new Ship();
		  ship.name = "«Агано»";
		  ship.country = Country.JAPAN();
		  ship.category = Category.CRUISER();
		 
		  ship.summary = "<b>&laquo;головной корабль в серии из четырёх лёгких крейсеров типа Агано Императорского флота Японии времён Второй мировой войны&raquo;</b> - "
		        + " Получил название по реке Агано в префектурах Фукусима и Ниигата в Японии.";
		
		  ship.launch_date = new GregorianCalendar(1941, 9, 22).getTimeInMillis(); 
		 
		  ship.displacement = 7590 ; ship.length = 162.0; ship.width = 15.2; ship.height = 0.0; ship.draft = 5.6;
		  ship.power = 100000; ship.speed = 35; ship.crew = 726;
		  ship.arming = "<ul>"
		  		+ "<li>Радиолокационное вооружение	Радиолокатор Тип 21</li>"
		  		+ "<li>Артиллерия	6 (3×2) — 152-мм/50 Тип 41</li>"
		  		+ "<li>Зенитная артиллерия	Изначально: 4 (2×2) — 76-мм/60 Тип 98, 6 (2×3) — 25-мм/60 Тип 96, 2 13-мм пулемёта Тип 93</li>"
		  		+ "<li>Минно-торпедное вооружение	2 четырёхтрубных 610-мм торпедных аппарата Тип 92 Модель 4</li>"
		  		+ "<li>Авиационная группа	1 катапульта,2 гидросамолёта Тип 0</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот Японии
		  // Крейсер
		  // Атаго (тяжёлый крейсер)
		  ship = new Ship();
		  ship.name = "«Атаго»";
		  ship.country = Country.JAPAN();
		  ship.category = Category.CRUISER();
		 
		  ship.summary = "<b>&laquo;японский тяжёлый крейсер, первый вступивший в строй представитель типа «Такао».&raquo;</b> - "
		        + "Построен в Курэ в 1927—1932 годах. Активно использовался в межвоенный период, в 1938—1939 годах прошёл крупную модернизацию.";
		
		  ship.launch_date = new GregorianCalendar(1930, 4, 16).getTimeInMillis(); 
		  
		  ship.displacement = 15186 ; ship.length = 201.79; ship.width = 19.0; ship.height = 0.0; ship.draft = 6.53;
		  ship.power = 130000; ship.speed = 35; ship.crew = 727;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	5 × 2 — 203-мм/50 тип 3 № 2</li>"
		  		+ "<li>Зенитная артиллерия	4 × 1 120-мм/45 тип 10,2 × 1 40-мм/39 типа «Би»,2 × 7,7-мм типа «Би»;</li>"
		  		+ "<li>Минно-торпедное вооружение	8 (4 × 2) — 610-мм ТА тип 89 (24 торпеды тип 90);</li>"
		  		+ "<li>Авиационная группа	2 катапульты, до 3 гидросамолётов</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		
		  
		  // Флот Японии
		  // Эсминец
		  // Сигурэ (эсминец)
		  ship = new Ship();
		  ship.name = "Сигурэ";
		  ship.country = Country.JAPAN();
		  ship.category = Category.DESTROYER();
		 
		  ship.summary = "<b>&laquo;Японский эскадренный миноносец времён Второй Мировой войны.&raquo;</b> - "
			  		+ "Второй корабль в серии эсминцев типа «Сирацую»";
		  
		  ship.launch_date = new GregorianCalendar(1935, 4, 8).getTimeInMillis(); 
		 
		  ship.displacement = 1980; ship.length = 107.5; ship.width = 9.9; ship.height = 0.0; ship.draft = 3.5;
		  ship.power =  42000; ship.speed = 34; ship.crew = 180;
		  ship.arming = "<ul>"
		  		+ "<li>Артиллерия	5 (2×2, 1×1) 127-мм/50 АУ Тип 3</li>"
		        + "<li>Зенитная артиллерия	2 × 13,2 мм пулемёта</li>"
		        + "<li>Противолодочное вооружение	16 глубинных бомб</li>"
		        + "<li>Минно-торпедное вооружение	2×4 610-мм ТА 16 торпед Тип 9318 мин</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
		  
		  // Флот Японии
		  // Эсминец
		  // Инадзума (эсминец, 1932)
		  ship = new Ship();
		  ship.name = "«Инадзума»";
		  ship.country = Country.JAPAN();
		  ship.category = Category.DESTROYER();
		
		  ship.summary = "<b>&laquo; японский эскадренный миноносец типа «Фубуки».&raquo;</b> - ";
		  
		  ship.launch_date = new GregorianCalendar(1932, 1, 25).getTimeInMillis(); 
		 
		  ship.displacement = 2070; ship.length = 115.3; ship.width = 10.36; ship.height = 0.0; ship.draft = 3.28;
		  ship.power =  50000; ship.speed = 38; ship.crew = 197;
		  ship.arming = "<ul>"
		  		+ "<li>Радиолокационное вооружение	РЛС Тип 13 (с 1944 года)</li>"
		        + "<li>Артиллерия	6 (3 × 2) 127-мм Тип 3, 4 (3 × 2) c 1944 года</li>"
		        + "<li>Зенитная артиллерия	Исходно: 1 × 2 13,2–мм пулемёт Тип 93,1943 год: 2 × 2 13,2–мм пулемёта Тип 93,1944 год: 14 (4 × 3, 1 × 2) 25-мм автомата Тип 96, 1 × 2 13,2–мм пулемёт Тип 93</li>"
		        + "<li>Противолодочное вооружение	до 18 (позже 36) глубинных бомб</li>"
		        + "<li>Минно-торпедное вооружение	3×3 610-мм торпедных аппарата (18 торпед Тип 8, позже заменены на Тип 90)до 18 мин</li>";
		  ship.distance = 0;
		  ship.engine = "";
		  ship.artillery = "";
		  ship.antiAir = "";
		  ship.airGroup = "";
		  ship.save();
  }
}