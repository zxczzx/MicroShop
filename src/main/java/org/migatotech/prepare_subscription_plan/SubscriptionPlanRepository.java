package org.migatotech.prepare_subscription_plan;

import org.jooq.DSLContext;
import org.migatotech.dal.ARepository;
import org.migatotech.generated.tables.records.SubscriptionPlanRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.migatotech.generated.Tables.SUBSCRIPTION_PLAN;

public class SubscriptionPlanRepository extends ARepository<SubscriptionPlanRecord> {

    public SubscriptionPlanRepository(DSLContext context) {
        super(context);
    }

    @Override
    public Optional<List<SubscriptionPlanRecord>> getAll() {
        return Optional.of(new ArrayList<>(dbContext.selectFrom(SUBSCRIPTION_PLAN).fetch()));
    }

    @Override
    public Optional<SubscriptionPlanRecord> getById(int id) {
        return Optional.ofNullable(dbContext.selectFrom(SUBSCRIPTION_PLAN).where(SUBSCRIPTION_PLAN.ID.eq(id)).fetchAny());
    }
}
