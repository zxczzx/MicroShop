package org.migatotech.prepare_subscription_plan;

import org.jooq.DSLContext;
import org.migatotech.dal.ARepository;
import org.migatotech.generated.tables.records.ProductRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.migatotech.generated.Tables.PRODUCT;

public class ProductRepository extends ARepository<ProductRecord> {

    public ProductRepository(DSLContext context) {
        super(context);
    }

    @Override
    public Optional<List<ProductRecord>> getAll() {
        return Optional.of(new ArrayList<>(dbContext.selectFrom(PRODUCT).fetch()));
    }

    @Override
    public Optional<ProductRecord> getById(int id) {
        return Optional.ofNullable(dbContext.fetchOne(PRODUCT, PRODUCT.ID.eq(id)));
    }
}
