package models;

import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;

import play.data.validation.Constraints.*;
import com.avaje.ebean.Model;

public class Login extends Model {
	@Id
	public Long id;
	@Required @Email
	public String email;
	@Required @Min(4)
	public String password;
	
	public Login(JsonNode json) {
		email = json.findPath("email").textValue();
		password = json.findPath("password").textValue();
	}
}
