package egovframework.lab.controller;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "Hello Controller")
@RestController
@RequestMapping("/api")
public class HelloController {

    @ApiOperation(value = "Hello 메시지 반환", notes = "단순한 Hello 메시지를 반환합니다.")
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Swagger!";
    }

    @GetMapping("users")
    @ApiOperation(value = "사용자 목록 조회", notes = "전체 사용자 목록을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "정상 응답"),
            @ApiResponse(code = 400, message = "잘못된 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public UsersResponseDto getUsers(
            @ApiParam(value = "페이지 번호", required = false) int page, 
            @ApiParam(value = "페이지 사이즈", required = false) int size) {
        UsersResponseDto response = new UsersResponseDto();
        response.add("users", dummyUsers());

        return response;
    }

    private Object dummyUser() {
        return new UserDto("kjh", "김종현", "010-1111-2222", "서울");
    }

    private Object dummyUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto("kjh", "김종현", "010-1111-2222", "서울"));
        userDtos.add(new UserDto("hgd", "홍길동", "010-3333-4444", "경기"));
        return userDtos;
    }
}
