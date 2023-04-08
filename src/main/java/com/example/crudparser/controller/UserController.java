package com.example.crudparser.controller;

import com.example.crudparser.dao.UserDao;
import com.example.crudparser.domain.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserDao userDao;
    @DeleteMapping(value = "/deleteAll")
    public int deleteAll() {
        return userDao.deleteAll();
    }

    @RequestMapping(value = "/delete")
    public int delete() {
        return userDao.delete("1");
    }

    @PostMapping(value="/add")
    public int add() {
        return userDao.add(new UserRequestDto("1", "chuu", "loona"));
    }

    @RequestMapping(value="/find")
    public void find() {
        userDao.findById("1");
    }

}
