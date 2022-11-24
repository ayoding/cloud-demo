package cn.itcast.user.web;

import cn.itcast.user.config.ConfigProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;
//    @Value("${pattern.dateformat}")
//    private String dateformat;
    @Autowired
    private ConfigProperties configProperties;



    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("/now")
    public String pringf(){
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern(configProperties.getDateformat()));
        return format;
    }

    @GetMapping("/prop")
    public String propertiesP(){

          System.out.print("123456");
        return configProperties.getName();
    }
}
