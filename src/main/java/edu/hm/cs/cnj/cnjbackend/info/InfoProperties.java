package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Hanway on 07.11.2017.
 */
@Component
@ConfigurationProperties(prefix="cnj.info")
public class InfoProperties {

    String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
