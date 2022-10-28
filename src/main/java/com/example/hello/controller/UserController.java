package com.example.hello.controller;

import com.example.hello.dao.UserDao;
import com.example.hello.domain.dto.MemberDto;
import com.example.hello.domain.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserDao userDao;
    @RequestMapping(value = "/deleteAll")
    public int deleteAll() {
        return userDao.deleteAll();
    }

    @RequestMapping(value = "/delete")
    public int delete() {
        return userDao.delete("1");
    }

    @RequestMapping(value="/add")
    public int add() {
        return userDao.add(new UserRequestDto("1", "chuu", "loona"));
    }

    @RequestMapping(value="/find")
    public void find() {
        userDao.findById("1");
    }

}
