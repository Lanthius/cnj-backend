package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hanway on 17.10.2017.
 */
@RestController
public class InfoController {

    @RequestMapping("/info")
    public Info greeting() {
        Info result = new Info();
        result.setMessage("OK");
        return result;
    }

}