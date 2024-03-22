package org.migatotech.manage_subscription;

import org.jooq.DSLContext;
import org.migatotech.dal.ARepository;
import org.migatotech.generated.tables.records.PaymentRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.migatotech.generated.Tables.PAYMENT;

public class PaymentRepository extends ARepository<PaymentRecord> {

    public PaymentRepository(DSLContext context) {
        super(context);
    }

    @Override
    public Optional<List<PaymentRecord>> getAll() {
        return Optional.of(new ArrayList<>(dbContext.selectFrom(PAYMENT).fetch()));
    }

    @Override
    public Optional<PaymentRecord> getById(int id) {
        return Optional.ofNullable(dbContext.fetchOne(PAYMENT, PAYMENT.ID.eq(id)));
    }
}
