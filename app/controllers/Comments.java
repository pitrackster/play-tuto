package controllers;
 
import models.Comment;
import play.*;
import play.mvc.*;



@With(Secure.class)
@Check("admin")
public class Comments extends CRUD {

}
