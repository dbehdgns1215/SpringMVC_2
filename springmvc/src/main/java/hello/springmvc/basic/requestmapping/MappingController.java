package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /*
    기본 요청
    둘 다 허용 /hello-basic, /hello-basic/
    HTTP 메서드 모두 허용 GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("hello-basic");
        return "ok";
    }

    /*
    method 특정 HTTP 메서드 요청만 허용
    GET, HEAD, POST, PUT, PATCH, DELETE
    */
    @RequestMapping(value = "/hello-basic-v1", method = RequestMethod.GET)
    public String helloBasicV1() {
        log.info("hello-basic");
        return "ok";
    }

    /*
    편리한 축약 애노테이션
    @GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
    @PatchMapping
    */
    @GetMapping(value = "/hello-basic-v2")
    public String helloBasicV2() {
        log.info("hello-basic");
        return "ok";
    }

    /*
    PathVariable(경로 변수) 사용
    변수명이 같으면 생략 가능
    @PathVariable("userId") String userId -> @PathVariable userId
    /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    /*
    PathVariable(경로 변수) 사용
    변수명이 같으면 생략 가능
    @PathVariable("userId") String userId -> @PathVariable userId
    /mapping/userA
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }
}
