package com.example.crudparser.controller;

import com.example.crudparser.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PostMapping("/member3")
    public ResponseEntity<MemberDto> putMemberDto(@RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
