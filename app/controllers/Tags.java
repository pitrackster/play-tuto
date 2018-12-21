package controllers;
 
import models.Tag;
import play.*;
import play.mvc.*;

@With(Secure.class)
@Check("admin")
public class Tags extends CRUD {

}
