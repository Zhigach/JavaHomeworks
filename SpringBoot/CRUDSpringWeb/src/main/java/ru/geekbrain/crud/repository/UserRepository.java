package ru.geekbrain.crud.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;
import ru.geekbrain.crud.model.User;

import java.sql.ResultSet;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    public User findUser(int id) {
        //String sql = "SELECT * FROM userTable WHERE id=?";
        List<User> allUsers = getAllUsers();
        return allUsers.stream().filter(user -> user.getId() == id).findFirst().orElse(new User());
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteUserById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    public void updateUserById(User user) {
        String sql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
}
