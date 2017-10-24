package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hanway on 17.10.2017.
 */
@RestController
public class InfoController {

    @Value("${greeting.message}")
    private String message;

    @RequestMapping("/info")
    public Info greeting() {
        Info result = new Info();
        result.setMessage(message);
        return result;
    }

}