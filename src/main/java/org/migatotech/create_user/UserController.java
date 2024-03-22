package org.migatotech.create_user;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/user")
public class UserController {

    @Get(uri = "/", produces = "text/plain")
    public String index() {

    }
}
