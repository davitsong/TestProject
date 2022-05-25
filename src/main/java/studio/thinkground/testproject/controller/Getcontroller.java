package studio.thinkground.testproject.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.data.dto.MemberDTO;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/get-api")
public class Getcontroller {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Helloworld";
    }

    @GetMapping(value = "/name")
    public String getNmae() {
        return "Dave";
    }

    @GetMapping(value = "/variable1/{var}")
    public String getVar1(@PathVariable String var) {
        return var;
    }

    @GetMapping(value = "/variable2/{var}")
    public String getvar2(@PathVariable("var") String st) {
        return st;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {

        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(
            @RequestParam Map<String, String> param){

        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach((map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        }));

        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }
}


