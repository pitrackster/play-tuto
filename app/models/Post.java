package models;

import java.util.*;
import javax.persistence.*;

import net.sf.oval.constraint.MaxLength;
import play.db.jpa.*;
import play.data.validation.*;


@Entity
@Table(name = "blog_post")
public class Post extends Model {

	@Required
    public String title;
	@Required
    public Date postedAt;

    @Lob
    @MaxSize(10000)
    public String content;

    @Required
    @ManyToOne
    public User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment> comments;
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    public Set<Tag> tags;

    public Post(User author, String title, String content) {
        this.comments = new ArrayList<>();
        this.tags = new TreeSet<Tag>();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }

    public Post addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        this.comments.add(newComment);
        this.save();
        return this;
    }
    
    public Post tagItWith(String name) {
        tags.add(Tag.findOrCreateByName(name));
        return this;
    }
    
    public static List<Post> findTaggedWith(String... tags) {
        return Post.find(
                "select distinct p from Post p join p.tags as t where t.name in (:tags) group by p.id, p.author, p.title, p.content,p.postedAt having count(t.id) = :size"
        ).bind("tags", tags).bind("size", tags.length).fetch();
    }

    public Post previous() {
        // setParameter ou bind ?
        return Post.find("from models.Post where postedAt < :date order by postedAt desc").setParameter("date", postedAt).first();
        // DEPRECATED Legacy-style query parameters (`?`) are no longer supported
        //return Post.find("postedAt < ? order by postedAt desc", postedAt).first();
    }

    public Post next() {
        // setParameter ou bind ?
        return Post.find("from models.Post where postedAt > :date order by postedAt asc").bind("date", postedAt).first();
        // DEPRECATED Legacy-style query parameters (`?`) are no longer supported
        //return Post.find("postedAt > ? order by postedAt asc", postedAt).first();
    }
    
    public String toString() {
        return title;
    }
}
