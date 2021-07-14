package cn.sam.template.controller;

import cn.sam.template.annotation.MyPermission;
import cn.sam.template.commons.MyReturn;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api(tags = "Test Controller")
public class TestController {

    @GetMapping("/test")
    public String getTest() {
        return MyReturn.ok("Hello World");
    }

    @GetMapping("/permission")
    @MyPermission
    public String permissionTest() {
        return MyReturn.warning("Permission Test");
    }

}
