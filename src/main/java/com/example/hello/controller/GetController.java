package com.example.hello.controller;

import com.example.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j  // 로그 남기는 어노테이션
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello로 요청이 들어왔습니다."); // 로그 남김
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        log.info("name으로 요청이 들어왔습니다.");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        log.info("getVariable1으로 요청이 들어왔습니다. variable={}", variable);   // 로그에 변수도 설정할 수 있음.
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping(value = "/request")
    public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // Map 활용
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        param.entrySet().forEach(map->{
            System.out.printf("key:%s value:%s\n", map.getKey(), map.getValue());
        }); // (map ->{} 여기부터 하나의 메서드)
        return "Request2 호출완료 되었습니다.";
    }

    // MemberDto 객체 생성 후  사용
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();

    }

}
