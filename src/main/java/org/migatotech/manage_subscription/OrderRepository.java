package org.migatotech.manage_subscription;

import org.jooq.DSLContext;
import org.migatotech.dal.ARepository;
import org.migatotech.generated.tables.records.OrderRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.migatotech.generated.Tables.ORDER;

public class OrderRepository extends ARepository<OrderRecord> {

    public OrderRepository(DSLContext context) {
        super(context);
    }

    @Override
    public Optional<List<OrderRecord>> getAll() {
        return Optional.of(new ArrayList<>(dbContext.selectFrom(ORDER).fetch()));
    }

    @Override
    public Optional<OrderRecord> getById(int id) {
        return Optional.ofNullable(dbContext.fetchOne(ORDER, ORDER.ID.eq(id)));
    }
}
