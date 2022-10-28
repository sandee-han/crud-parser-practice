package com.example.hello.controller;

import com.example.hello.dao.UserDao;
import com.example.hello.domain.dto.MemberDto;
import com.example.hello.domain.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserDao userDao;
    @RequestMapping(value = "/delete")
    public void deleteAll() {
        userDao.deleteAll();
    }

    @RequestMapping(value="/add")
    public void add() {
        userDao.add(new UserRequestDto("id", "name", "password"));
    }
}
