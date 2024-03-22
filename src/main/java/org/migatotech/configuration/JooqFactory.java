package org.migatotech.configuration;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.sql.DataSource;

@Factory
public class JooqFactory {

    @Singleton
    public DSLContext dslContext(DataSource dataSource) {
        return DSL.using(dataSource, SQLDialect.MYSQL);
    }
}
