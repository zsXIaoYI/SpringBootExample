package cn.zsza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by zs on 2017/2/27.
 * 20:44
 */
@SpringBootApplication
@RestController
public class Application {
    @RequestMapping("/")
    String home(){
        return "小黑";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
