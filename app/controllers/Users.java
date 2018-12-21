package controllers;
 
import models.User;
import play.*;
import play.mvc.*;

@With(Secure.class)
@CRUD.For(User.class)
@Check("admin")
public class Users extends CRUD {
	
}
