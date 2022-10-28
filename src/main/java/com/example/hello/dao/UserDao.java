package com.example.hello.dao;

import com.example.hello.domain.dto.UserRequestDto;
import com.example.hello.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public void add(UserRequestDto userRequestDto){
        jdbcTemplate.update("insert into users(id, name, password) values (?, ?, ?);",
                userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword());
    }

    public void deleteAll(){
        jdbcTemplate.update("DELETE FROM users");
    }

}
