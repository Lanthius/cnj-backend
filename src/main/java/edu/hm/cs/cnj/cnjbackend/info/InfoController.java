package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hanway on 17.10.2017.
 */
@RestController
public class InfoController {

    @Autowired
    private InfoProperties infoProperties;

    @RequestMapping("/info")
    public Info greeting() {
        Info result = new Info();
        result.setMessage(infoProperties.getMessage());
        return result;
    }

}