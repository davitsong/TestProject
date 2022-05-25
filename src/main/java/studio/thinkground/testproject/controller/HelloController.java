package studio.thinkground.testproject.controller;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private final Logger  LOGGER = LoggerFactory.getLogger(HelloController.class);

    //@RequestMapping(value = "/hello", method = RequestMethod.GET) 고전적 방법
    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";

    }
    @PostMapping("/exception")
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<Map<String,String>> ExceptionHandler(Exception e){
//        HttpHeaders responseHeaders = new HttpHeaders();
//        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//
//        LOGGER.info(e.getLocalizedMessage());
//        LOGGER.info("Controller 내 ExceptionHandler 호출");
//
//        Map<String, String> map = new HashMap<>();
//
//        map.put("error type", httpStatus.getReasonPhrase());
//        map.put("code", "400");
//        map.put("message", "에러발생");
//
//        return new ResponseEntity<>(map,responseHeaders,httpStatus);
//    }
    public void exceptionTest() throws Exception{
        throw new Exception();
    }
//

    @PostMapping("log-test")
    public void logTest(){

        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        // 설정을 root를 INFO로 잡아두어 TRACE와 DEBUG는 로그 안찍힘
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");

    }

}
