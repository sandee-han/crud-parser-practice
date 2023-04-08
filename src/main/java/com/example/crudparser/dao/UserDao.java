package com.example.crudparser.dao;

import com.example.crudparser.domain.dto.UserRequestDto;
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

    public int add(UserRequestDto userRequestDto){
        return jdbcTemplate.update("insert into users(id, name, password) values (?, ?, ?);",
                userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword());
    }

    public int deleteAll(){
        return jdbcTemplate.update("DELETE FROM users");
    }

    public int delete(String id){
        return jdbcTemplate.update("DELETE FROM users where id = ?", id);
    }

    public UserRequestDto findById(String id) {
        String sql = "select * from users where id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    RowMapper<UserRequestDto> rowMapper = new RowMapper<UserRequestDto>() {
        @Override
        public UserRequestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserRequestDto userRequestDto = new UserRequestDto(rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("password"));
            return userRequestDto;
        }
    };

}
