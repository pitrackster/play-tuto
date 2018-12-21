package controllers;
 
import models.Tag;
import play.*;
import play.mvc.*;

@With(Secure.class)
@CRUD.For(Tag.class)
@Check("admin")
public class Tags extends CRUD {

}
