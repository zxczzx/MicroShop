package org.migatotech.create_user;

import org.jooq.DSLContext;
import org.migatotech.dal.ARepository;
import org.migatotech.generated.tables.records.UserRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.migatotech.generated.Tables.USER;

public class UserRepository extends ARepository<UserRecord> {

    public UserRepository(DSLContext context) {
        super(context);
    }


    @Override
    public Optional<List<UserRecord>> getAll() {
        return Optional.of(new ArrayList<>(dbContext.selectFrom(USER).fetch()));
    }

    @Override
    public Optional<UserRecord> getById(int id) {
        return Optional.ofNullable(dbContext.fetchOne(USER, USER.ID.eq(id)));
    }
}
