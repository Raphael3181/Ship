package controllers;

import models.Ship;
import play.data.*;
import play.libs.Json;
import play.mvc.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Ships extends Controller {
	// Получить корабли которые нужны
	public static Result getships() {
		ObjectNode result = Json.newObject();
		result.put("status", "OK");
		DynamicForm data = Form.form().bindFromRequest();
		int fleet = Integer.valueOf(data.get("fleet")); //передет id флота
		int cat = Integer.valueOf(data.get("cat")); //передает id категории
		result.set("objects", Json.toJson(Ship.get(fleet,cat))); //возврат списка кораблей(создание поля objects в виде массива кораблей )
		return ok(result);
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result getships_api() {  // Запрос с клиента
		JsonNode json = request().body().asJson();
		boolean[] classes = new boolean[4];
		classes[0] = json.findPath("aircraft").booleanValue();
		classes[1] = json.findPath("battleship").booleanValue();
		classes[2] = json.findPath("cruiser").booleanValue();
		classes[3] = json.findPath("destroyer").booleanValue();
		ObjectNode result = Json.newObject();
		result.put("status", "OK");
		result.set("ships", Json.toJson(Ship.get(json.findPath("country").intValue(), classes)));
		return ok(result);
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result sendship_api() {
		JsonNode json = request().body().asJson();
		if (json.has("id")) new Ship(json).update();
		else new Ship(json).save();
		ObjectNode result = Json.newObject();
		result.put("status", "OK");
		return ok(result);
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result delship_api() {
		JsonNode json = request().body().asJson();
		Ship.delete(json.findPath("id").longValue());
		ObjectNode result = Json.newObject();
		result.put("status", "OK");
		return ok(result);
	}
}
