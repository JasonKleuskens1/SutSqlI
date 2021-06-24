package nl.ou.se.rest.sut.components.data.comment.domain;

public class Comment {

    // variable(s)
    private Long id;
    private String description;
    
    public Comment() {
    	this.id = 0L;
    	this.description = "";
    }
    
    public Comment (Long id, String description) {
    	this.id = id;
    	this.description = description;
    }

    // getter(s) and setter(s)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}