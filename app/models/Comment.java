package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name = "blog_post_comment")
public class Comment extends Model {
	@Required
    public String author;
	@Required
    public Date postedAt;
    
	@Required
    @Lob
    @MaxSize(1000)
    public String content;
    
    @ManyToOne
    @Required
    public Post post;
    
    public Comment(Post post, String author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }
    
    public String toString() {
    	String stripped = content.length() > 20 ? content.substring(0, 20) + "..." : content;
    	return post.title + " - " + author + " - " + stripped;
    }
}
