package controllers;
 
import play.*;
import play.mvc.*;

import models.Post;


@With(Secure.class)
@Check("admin")
public class Posts extends CRUD {

}
