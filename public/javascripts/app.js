﻿//Model
function User(email, password, mode) {
    this.email = ko.observable(email);
    this.password = ko.observable(password);
    this.mode = mode;
}
//Model
function Ship(id,   
        name, category, country, manufacturer, homeport, status, summary,
        build_start, launch_date, commissioned_in, removed_from_fleet,
        displacement, length, width, height, draft,
        power, speed, crew, arming) {    //модель корабля возврат с сервера
    this.id = ko.observable(id);
    this.name = ko.observable(name);
    this.category = ko.observable(category);
    this.country = ko.observable(country);
    this.manufacturer = ko.observable(manufacturer);
    this.homeport = ko.observable(homeport);
    this.status = ko.observable(status);
    this.summary = ko.observable(summary);
    this.build_start = ko.observable(dateFormat(build_start));
    this.launch_date = ko.observable(dateFormat(launch_date));
    this.commissioned_in = ko.observable(dateFormat(commissioned_in));
    this.removed_from_fleet = ko.observable(dateFormat(removed_from_fleet));
    this.displacement = ko.observable(displacement);
    this.length = ko.observable(length);
    this.width = ko.observable(width);
    this.height = ko.observable(height);
    this.draft = ko.observable(draft);
    this.power = ko.observable(power);
    this.speed = ko.observable(speed);
    this.crew = ko.observable(crew);
    this.arming = ko.observable(arming);
}
function Req(fleet, cat) {   //модель запроса по классу и флоту
    this.fleet = fleet;
    this.cat = cat;
}
//ViewModel
function UserShipViewModel() {      
    var self = this;
    self.email = ko.observable("");     // Email
    self.password = ko.observable("");  // Пароль
    self.authemail = ko.observable(""); // Поле для Email после входа

    self.ships = ko.observableArray([]);            // Массив кораблей
    self.name = ko.observable("");                  // Название
    self.category = ko.observable("");              // Тип
    self.country = ko.observable("");               // Страна
    self.manufacturer = ko.observable("");          // Производитель
    self.homeport = ko.observable(null);            // Порт приписки
    self.status = ko.observable("");                // Статус
    self.summary = ko.observable("");               // Описание
    self.build_start = ko.observable("");           // Начало строительства
    self.launch_date = ko.observable("");           // Дата спуска на воду
    self.commissioned_in = ko.observable("");       // Дата введения в эксплуатацию
    self.removed_from_fleet = ko.observable(null);  // Вышел из состава флота
    self.displacement = ko.observable(0);           // Водоизмещение
    self.length = ko.observable(0.0);               // Длина
    self.width = ko.observable(0.0);                // Ширина
    self.height = ko.observable(0.0);               // Высота
    self.draft = ko.observable(0.0);                // Осадка
    self.power = ko.observable(0);                  // Мощность
    self.speed = ko.observable(0);                  // Скорость
    self.crew = ko.observable(0);                   // Экипаж
    self.arming = ko.observable("");                // Вооружение
    
    self.shipselected = ko.observable(false);   // Выбран ли корабль
    self.shipsselected = ko.observable(false);  // Выбран ли тип корабля
    // Авторизация
    self.auth = function() {
        var jsonData = ko.toJSON(new User(self.email(), self.password(), "json"));  //Json запрос для сервера
        jsRoutes.controllers.Auth.auth().ajax( {    //отправка запроса
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function(data) {  //запрос успешен получаем данные
                self.authemail(data.email); //замена текстового поля
            }, error: function(data) { alert("Неверный Email или пароль!"); }
        });
    }
    // Авторизация через cookies
    self.authcookies = function() {
        var jsonData = ko.toJSON(new User("", "", "cookies"));
        jsRoutes.controllers.Auth.auth().ajax( {
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function(data) {
                self.authemail(data.email);
            }, error: function(data) { }
        });
    }
    // Регистрация
    self.register = function() {
        var jsonData = ko.toJSON(new User(self.email(), self.password()));
        jsRoutes.controllers.Auth.register().ajax( {
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function(data) {
                self.authemail(data.email);
            }, error: function(data) { alert("Этот Email уже зарегистрирован!"); }
        });
    }
    // Выход
    self.logout = function() {
        jsRoutes.controllers.Auth.logout().ajax( {
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: ko.toJSON(null),
            success: function(data) {
                self.authemail("");
                self.email("");
                self.password("");
            }, error: function(data) { alert("Произошла ошибка!\n" + data.error); }
        });
    }
    // Загрузить корабли
    self.loadships = function(fleet, cat) {
        self.ships.destroyAll();  //стираем прошлые
        self.name("");  //очищаем поле имя
        self.shipselected(false);  //корабль не выбран      
        self.shipsselected(true);  //выбрана категория
        jsRoutes.controllers.Ships.getships().ajax({  //запрос серверу
            data: new Req(fleet, cat), //отправка данных о категории и флоте
            success: function(data) {
                self.ships.valueWillMutate(); //обновление списка кораблей
                self.ships([]);
                for (i = 0; i < data.objects.length; i++) { //цикл прогон по списку кораблей
                    var o = data.objects[i];
                    self.ships.push(new Ship(i, //данные о корабле в массиве
                        o.name, o.category.name, o.country.name,
                        o.manufacturer, o.homeport, o.status, o.summary,
                        o.build_start, o.launch_date,
                        o.commissioned_in, o.removed_from_fleet,
                        o.displacement, o.length, o.width, o.height, o.draft,
                        o.power, o.speed, o.crew, o.arming));
                }
                self.ships.valueHasMutated(); //закончили обновление списка
            }, error: function(data) { alert("Произошла ошибка!\n" + data.error()); }
        });
    }
    // Загрузить корабль
    self.loadship = function(id) {  //загрузка данных о корабле
        self.shipselected(!self.shipselected());
        if (self.shipselected()) {
            var o = self.ships()[id];  //берем корабль с номером id
            self.name(o.name());
            self.category(o.category());
            self.country(o.country());
            self.manufacturer(o.manufacturer());
            self.homeport(o.homeport());
            self.status(o.status());
            self.summary(o.summary());
            self.build_start(o.build_start());
            self.launch_date(o.launch_date());
            self.commissioned_in(o.commissioned_in());
            self.removed_from_fleet(o.removed_from_fleet());
            self.displacement(o.displacement());
            self.length(o.length());
            self.width(o.width());
            self.height(o.height());
            self.draft(o.draft());
            self.power(o.power());
            self.speed(o.speed());
            self.crew(o.crew());
            self.arming(o.arming());
            replacehtml();
        }
    }
    self.authcookies();
}
ko.applyBindings(new UserShipViewModel());