package ru.geekbrains.SeminarRest.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.SqlTypes;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SeminarRest.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
@Profile("prod")
public class H2UserRepository implements iUserRepository {

    private final JdbcTemplate jdbc;

    private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User rowObject = new User();
            rowObject.setName(rs.getString("name"));
            rowObject.setAge(rs.getInt("age"));
            rowObject.setEmail(rs.getString("email"));
            return rowObject;
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM userTable";
        return jdbc.query(sql, new UserRowMapper());
    }

    @Override
    public void createUser(User user) throws IllegalArgumentException {
        if (!tableContainsName(user)) {
            String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
            jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        } else {
            log.error(String.format("User with name %s already exists.", user.getName()));
            throw new IllegalArgumentException("User already exists");
        }
    }

    private boolean tableContainsName(User user) {
        String sql = "SELECT * FROM userTable WHERE name=?";
        //return jdbc.queryForObject(sql, new String[]{user.getName()}, new int[]{SqlTypes.VARCHAR}, User.class) != null;
        try {
            jdbc.queryForObject(sql, new String[]{user.getName()}, new int[]{SqlTypes.VARCHAR}, new UserRowMapper());
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

}
