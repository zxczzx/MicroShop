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
import org.migatotech.generated.tables.records.UserRecord;

import java.util.Collection;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>test.user</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>test.user.id</code>.
     */
    public final TableField<UserRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>test.user.name</code>.
     */
    public final TableField<UserRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>test.user</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>test.user</code> table reference
     */
    public User(Name alias) {
        this(alias, USER);
    }

    /**
     * Create a <code>test.user</code> table reference
     */
    public User() {
        this(DSL.name("user"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Test.TEST;
    }

    @Override
    public Identity<UserRecord, Integer> getIdentity() {
        return (Identity<UserRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.KEY_USER_PRIMARY;
    }

    @Override
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    @Override
    public User as(Name alias) {
        return new User(alias, this);
    }

    @Override
    public User as(Table<?> alias) {
        return new User(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name) {
        return new User(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Table<?> name) {
        return new User(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public User where(Condition condition) {
        return new User(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public User where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public User where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public User where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public User where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public User where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public User where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public User where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public User whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public User whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
