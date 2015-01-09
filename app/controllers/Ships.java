package controllers;

import models.Ship;
import play.data.*;
import play.libs.Json;
import play.mvc.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Ships extends Controller {
	// Получить корабли
	public static Result getships() {
        ObjectNode result = Json.newObject();
    	result.put("status", "OK");
    	DynamicForm data = Form.form().bindFromRequest();
    	int fleet = Integer.valueOf(data.get("fleet"));
    	int cat = Integer.valueOf(data.get("cat"));
    	result.put("objects", Json.toJson(Ship.get(fleet,cat)));
    	return ok(result);
	}
}
