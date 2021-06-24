package nl.ou.se.rest.sut.components.data.comment.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import nl.ou.se.rest.sut.components.data.comment.domain.Comment;

@Service
public class CommentService {

    // variable(s)
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Comment create(Comment comment) {
        jdbcTemplate.execute("INSERT INTO comments (description) values ('"+ comment.getDescription() +"');");
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
        comment.setId(id);

        return comment;
    }

    public Comment read(Long id) {
        Comment comment = new Comment();
        String sql = "SELECT * FROM comments WHERE ID = " + id + " LIMIT 1\n"; 
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
        	Long rowId = ((Integer) row.get("id")).longValue();
        	String rowDescription = ((String) row.get("description"));
        	comment = new Comment(rowId, rowDescription);
        }        
        return comment;
    }

    public Comment update(Comment comment) {
        jdbcTemplate.execute("UPDATE comments SET description = '"+ comment.getDescription() +"' WHERE id = " + comment.getId() +";");
        return comment;
    }

    public void delete(Long id) {
        jdbcTemplate.execute("DELETE FROM comments WHERE id = " + id +";");
    }
}