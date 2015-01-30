package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.Routes;
import play.libs.Json;
import play.mvc.*;
import views.html.index;

public class Application extends Controller {

	public static Result index() { return ok(index.render()); }  //возврат главной страницы
	
	public static Result badRequestJSON() {   //возврат плохого запроса
		ObjectNode result = Json.newObject();
		result.put("status", "KO");
		result.put("error", 400);
		return badRequest(result);
	}

	public static Result jsRoutes() {  //пути javascript 
        response().setContentType("text/javascript");
        return ok(Routes.javascriptRouter("jsRoutes",
        		controllers.routes.javascript.Auth.auth(),
                controllers.routes.javascript.Auth.register(),
                controllers.routes.javascript.Auth.logout(),
                controllers.routes.javascript.Ships.getships())
        );
    }
}
