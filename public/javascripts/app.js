//Model
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
        power, speed, crew, arming) {
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
function Req(fleet, cat) {
    this.fleet = fleet;
    this.cat = cat;
}
//ViewModel
function UserShipViewModel() {
    var self = this;
    self.email = ko.observable(""); // Email
    self.password = ko.observable(""); // Пароль
    self.authemail = ko.observable(""); // Поле для Email после входа
    
    self.ships = ko.observableArray([]);
    self.name = ko.observable("");
    self.category = ko.observable("");
    self.country = ko.observable("");
    self.manufacturer = ko.observable("");
    self.homeport = ko.observable(null);
    self.status = ko.observable("");
    self.summary = ko.observable("");
    self.build_start = ko.observable("");
    self.launch_date = ko.observable("");
    self.commissioned_in = ko.observable("");
    self.removed_from_fleet = ko.observable(null);
    self.displacement = ko.observable(0);
    self.length = ko.observable(0.0);
    self.width = ko.observable(0.0);
    self.height = ko.observable(0.0);
    self.draft = ko.observable(0.0);
    self.power = ko.observable(0);
    self.speed = ko.observable(0);
    self.crew = ko.observable(0);
    self.arming = ko.observable("");
    
    self.auth = function() {
        var jsonData = ko.toJSON(new User(self.email(), self.password(), "json"));
        jsRoutes.controllers.Auth.auth().ajax( {
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function(data) {
                self.email(data.email);
                self.authemail(data.email);
            }, error: function(data) { alert("Неверный Email или пароль!"); }
        });
    }
    self.authcookies = function() {
        var jsonData = ko.toJSON(new User("", "", "cookies"));
        jsRoutes.controllers.Auth.auth().ajax( {
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function(data) {
                self.email(data.email);
                self.authemail(data.email);
            }, error: function(data) { }
        });
    }
    self.register = function() {
        var jsonData = ko.toJSON(new User(self.email(), self.password()));
        jsRoutes.controllers.Auth.register().ajax( {
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function(data) {
                self.email(data.email);
                self.authemail(data.email);
            }, error: function(data) { alert("Этот Email уже зарегистрирован!"); }
        });
    }
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
    
    self.loadships = function(fleet, cat) {
        self.ships.destroyAll();
        self.name("");
        var jsonData = ko.toJSON(new Req(fleet, cat));
        jsRoutes.controllers.Ships.getships().ajax({
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function(data) {
                for (i = 0; i < data.objects.length; i++) {
                    var o = data.objects[i];
                    self.ships.push(new Ship(i,
                            o.name, o.category.name, o.country.name,
                            o.manufacturer, o.homeport, o.status, o.summary,
                            o.build_start, o.launch_date,
                            o.commissioned_in, o.removed_from_fleet,
                            o.displacement, o.length, o.width, o.height, o.draft,
                            o.power, o.speed, o.crew, o.arming));
                }
            }, error: function(data) { alert("Произошла ошибка!\n" + data.error()); }
        });
    }
    self.loadship = function(id) {
        var o = self.ships()[id];
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
    }
    self.authcookies();
}
ko.applyBindings(new UserShipViewModel());