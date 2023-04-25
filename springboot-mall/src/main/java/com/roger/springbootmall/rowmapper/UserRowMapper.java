package com.roger.springbootmall.rowmapper;

import com.roger.springbootmall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt("user_id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        user.setCreatedDate(resultSet.getTimestamp("created_date"));

        return user;

    }
}
