package controllers;

import models.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Auth extends Controller {
	// Авторизация 
	@BodyParser.Of(BodyParser.Json.class)
	public static Result auth() {
		JsonNode json = request().body().asJson(); //Json из запроса клиента серверу
        ObjectNode result = Json.newObject();  //созд объект которы вернется к клиенту
    	if(json.findPath("mode").textValue().equals("json")) {   //вход при нажатии
        	if(!Form.form(Login.class).fill(new Login(json)).hasErrors()) { //проверка на наличие ошибок
	        	if(User.authJSON(json.findPath("email").textValue(), json.findPath("password").textValue())) { // из json берем эмеил и пароль
		        	result.put("status", "OK");
		            result.put("email", json.findPath("email").textValue()); //возвращаем эмеил 
		            return ok(result);
		        } else {
		        	result.put("status", "KO");  //неверный логин пароль
		            result.put("error", 401); // Unauthorized
		            return badRequest(result);
		        }
	        } else return Application.badRequestJSON();
    	}
    	if(json.findPath("mode").textValue().equals("cookies")) {    //вход при загрузке страницы
    		String email = session("email") == null ? null : User.authcookies();
        	if(email != null) {
	        	result.put("status", "OK");
	            result.put("email", email);
	            return ok(result);
	        } else {
	        	result.put("status", "KO");
	            result.put("error", 401); // Unauthorized
	            return badRequest(result);
	        }
    	}
        return Application.badRequestJSON();
	}
	
	// Выход
	public static Result logout() {
		ObjectNode result = Json.newObject();
    	session().clear();  //очищаем cookies
		result.put("status", "OK");
        return ok(result);
	}
	
	// Регистрация
	@BodyParser.Of(BodyParser.Json.class)
	public static Result register() {
		JsonNode json = request().body().asJson();
    	ObjectNode result = Json.newObject();
    	boolean exists = User.exists(new Login(json));  //проверка на уже сущ пользователя 
		if(!exists) {
    		new User(json).save();  //соз нов пользователя
    		result.put("status", "OK");
    		result.put("email", json.findPath("email").textValue()); 
            return ok(result);
		} else return Application.badRequestJSON();
    }
}
