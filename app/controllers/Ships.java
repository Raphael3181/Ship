package controllers;

import models.Ship;
import play.data.*;
import play.libs.Json;
import play.mvc.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Ships extends Controller {
	// Получить корабли которые нужны
	public static Result getships() {
        ObjectNode result = Json.newObject();
    	result.put("status", "OK");
    	DynamicForm data = Form.form().bindFromRequest();
    	int fleet = Integer.valueOf(data.get("fleet")); //передет id флота
    	int cat = Integer.valueOf(data.get("cat")); //передает id категории
    	result.put("objects", Json.toJson(Ship.get(fleet,cat))); //возврат списка кораблей(создание поля objects в виде массива кораблей )
    	return ok(result);
	}
}
