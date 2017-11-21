package edu.hm.cs.cnj.cnjbackend.info;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Hanway on 17.10.2017.
 */
@ApiModel("Server-Info")
public class Info {

    @ApiModelProperty(example="Allet super!", readOnly=true)
    String message;

    public Info() {
    // Default constructor.
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
