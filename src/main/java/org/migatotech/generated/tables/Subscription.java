/*
 * This file is generated by jOOQ.
 */
package org.migatotech.generated.tables;


import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.migatotech.generated.Keys;
import org.migatotech.generated.Test;
import org.migatotech.generated.tables.records.SubscriptionRecord;

import java.time.LocalDateTime;
import java.util.Collection;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Subscription extends TableImpl<SubscriptionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>test.subscription</code>
     */
    public static final Subscription SUBSCRIPTION = new Subscription();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SubscriptionRecord> getRecordType() {
        return SubscriptionRecord.class;
    }

    /**
     * The column <code>test.subscription.id</code>.
     */
    public final TableField<SubscriptionRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>test.subscription.user_id</code>.
     */
    public final TableField<SubscriptionRecord, Integer> USER_ID = createField(DSL.name("user_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>test.subscription.subscription_plan_id</code>.
     */
    public final TableField<SubscriptionRecord, Integer> SUBSCRIPTION_PLAN_ID = createField(DSL.name("subscription_plan_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>test.subscription.status</code>.
     */
    public final TableField<SubscriptionRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>test.subscription.start_date</code>.
     */
    public final TableField<SubscriptionRecord, LocalDateTime> START_DATE = createField(DSL.name("start_date"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "");

    /**
     * The column <code>test.subscription.end_date</code>.
     */
    public final TableField<SubscriptionRecord, LocalDateTime> END_DATE = createField(DSL.name("end_date"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "");

    /**
     * The column <code>test.subscription.order_id</code>.
     */
    public final TableField<SubscriptionRecord, Integer> ORDER_ID = createField(DSL.name("order_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private Subscription(Name alias, Table<SubscriptionRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Subscription(Name alias, Table<SubscriptionRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>test.subscription</code> table reference
     */
    public Subscription(String alias) {
        this(DSL.name(alias), SUBSCRIPTION);
    }

    /**
     * Create an aliased <code>test.subscription</code> table reference
     */
    public Subscription(Name alias) {
        this(alias, SUBSCRIPTION);
    }

    /**
     * Create a <code>test.subscription</code> table reference
     */
    public Subscription() {
        this(DSL.name("subscription"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Test.TEST;
    }

    @Override
    public Identity<SubscriptionRecord, Integer> getIdentity() {
        return (Identity<SubscriptionRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<SubscriptionRecord> getPrimaryKey() {
        return Keys.KEY_SUBSCRIPTION_PRIMARY;
    }

    @Override
    public Subscription as(String alias) {
        return new Subscription(DSL.name(alias), this);
    }

    @Override
    public Subscription as(Name alias) {
        return new Subscription(alias, this);
    }

    @Override
    public Subscription as(Table<?> alias) {
        return new Subscription(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Subscription rename(String name) {
        return new Subscription(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Subscription rename(Name name) {
        return new Subscription(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Subscription rename(Table<?> name) {
        return new Subscription(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Subscription where(Condition condition) {
        return new Subscription(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Subscription where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Subscription where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Subscription where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Subscription where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Subscription where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Subscription where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Subscription where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Subscription whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Subscription whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
