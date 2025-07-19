package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    // private final Logger log = LoggerFactory.getLogger(this.getClass()); // slf4j를 사용해야함

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name); // 로그 안썼을 때

        // 로그 썼을 때 (로그에도 레벨이 있음. 각 단계별로 어디서 쓰이는 로그인지 명확히 구별됨.)
        log.trace("trace log {}", name);
        log.debug("debug log {}", name);
        log.info("info log {}", name);
        log.warn("warn log = {} ", name);
        log.error("error log = {} ", name);

        return "ok";
    }
}
