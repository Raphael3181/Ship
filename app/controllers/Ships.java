package controllers;

import models.Ship;
import play.libs.Json;
import play.mvc.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Ships extends Controller {
	// Получить корабли
	@BodyParser.Of(BodyParser.Json.class)
	public static Result getships() {
		JsonNode json = request().body().asJson();
        ObjectNode result = Json.newObject();
    	result.put("status", "OK");
    	result.put("objects", Json.toJson(Ship.get(json.findPath("fleet").intValue(), 
    			json.findPath("cat").intValue())));
    	return ok(result);
	}
}
