package com.example.hello.controller;

import com.example.hello.dao.HospitalDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1/hospital")
public class HospitalController {
    private final HospitalDao hospitalDao;

    @RequestMapping(value = "/find")
    public void find() {
        hospitalDao.findById(1);
    }
}
