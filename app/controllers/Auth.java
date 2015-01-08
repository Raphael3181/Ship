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
		JsonNode json = request().body().asJson();
        ObjectNode result = Json.newObject();
    	if(json.findPath("mode").textValue().equals("json")) {
        	if(!Form.form(Login.class).fill(new Login(json)).hasErrors()) {
	        	if(User.authJSON(json.findPath("email").textValue(), json.findPath("password").textValue())) {
		        	result.put("status", "OK");
		            result.put("email", json.findPath("email").textValue());
		            return ok(result);
		        } else {
		        	result.put("status", "KO");
		            result.put("error", 401); // Unauthorized
		            return badRequest(result);
		        }
	        } else return Application.badRequestJSON();
    	}
    	if(json.findPath("mode").textValue().equals("cookies")) {
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
    	session().clear();
		result.put("status", "OK");
        return ok(result);
	}
	
	// Регистрация
	@BodyParser.Of(BodyParser.Json.class)
	public static Result register() {
		JsonNode json = request().body().asJson();
    	ObjectNode result = Json.newObject();
    	boolean exists = User.exists(new Login(json));
		if(!exists) {
    		new User(json).save();
    		result.put("status", "OK");
    		result.put("email", json.findPath("email").textValue());
            return ok(result);
		} else return Application.badRequestJSON();
    }
}
