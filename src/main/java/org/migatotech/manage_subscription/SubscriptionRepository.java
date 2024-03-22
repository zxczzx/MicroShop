package org.migatotech.manage_subscription;

import org.jooq.DSLContext;
import org.migatotech.dal.ARepository;
import org.migatotech.generated.tables.records.SubscriptionRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.migatotech.generated.Tables.SUBSCRIPTION;

public class SubscriptionRepository extends ARepository<SubscriptionRecord> {
    public SubscriptionRepository(DSLContext context) {
        super(context);
    }

    @Override
    public Optional<List<SubscriptionRecord>> getAll() {
        return Optional.of(new ArrayList<>(dbContext.selectFrom(SUBSCRIPTION).fetch()));
    }

    @Override
    public Optional<SubscriptionRecord> getById(int id) {
        return Optional.ofNullable(dbContext.fetchOne(SUBSCRIPTION, SUBSCRIPTION.ID.eq(id)));
    }
}
