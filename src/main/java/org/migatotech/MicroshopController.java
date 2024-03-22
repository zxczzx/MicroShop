package org.migatotech;

import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.migatotech.dal.UnitOfWork;
import org.migatotech.generated.tables.records.UserRecord;

@Controller("/microshop")
public class MicroshopController {

    @Inject
    private UnitOfWork unit;

    @Get(uri = "/", produces = "text/plain")
    public String index() {

        var user = new UserRecord();
        user.setName("Krzysiek");
        unit.getUserRepository().add(user);
        unit.save();


        return "Example Response";
    }
}