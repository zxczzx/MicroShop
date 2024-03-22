package org.migatotech.dal;

import io.micronaut.context.annotation.Prototype;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
import org.migatotech.create_user.UserRepository;
import org.migatotech.manage_subscription.OrderRepository;
import org.migatotech.manage_subscription.PaymentRepository;
import org.migatotech.manage_subscription.SubscriptionRepository;
import org.migatotech.prepare_subscription_plan.ProductRepository;
import org.migatotech.prepare_subscription_plan.SubscriptionPlanRepository;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Prototype
public class UnitOfWork implements IUnitOfWork {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionPlanRepository subscriptionPlanRepository;
    private final ProductRepository productRepository;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    private final DSLContext dbContext;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public UnitOfWork(DSLContext context) {
        dbContext = context;
        userRepository = new UserRepository(context);
        subscriptionRepository = new SubscriptionRepository(context);
        subscriptionPlanRepository = new SubscriptionPlanRepository(context);
        productRepository = new ProductRepository(context);
        paymentRepository = new PaymentRepository(context);
        orderRepository = new OrderRepository(context);
    }

    @Override
    public void save() {
        readWriteLock.writeLock().lock();
        try {
            dbContext.transaction((Configuration trx) -> {
                dbContext.batchInsert(fetchAllRepositoryAddCommands()).execute();
                dbContext.batchUpdate(fetchAllRepositoryUpdateCommands()).execute();
                dbContext.batchDelete(fetchAllRepositoryDeleteCommands()).execute();
            });
            clearRepositories();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public UserRepository getUserRepository() {
        readWriteLock.readLock().lock();
        try {
            return userRepository;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public SubscriptionRepository getSubscriptionRepository() {
        readWriteLock.readLock().lock();
        try {
            return subscriptionRepository;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public SubscriptionPlanRepository getSubscriptionPlanRepository() {
        readWriteLock.readLock().lock();
        try {
            return subscriptionPlanRepository;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public ProductRepository getProductRepository() {
        readWriteLock.readLock().lock();
        try {
            return productRepository;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public PaymentRepository getPaymentRepository() {
        readWriteLock.readLock().lock();
        try {
            return paymentRepository;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public OrderRepository getOrderRepository() {
        readWriteLock.readLock().lock();
        try {
            return orderRepository;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    private void clearRepositories() {
        readWriteLock.writeLock().lock();
        try {
            userRepository.clear();
            subscriptionRepository.clear();
            subscriptionPlanRepository.clear();
            productRepository.clear();
            paymentRepository.clear();
            orderRepository.clear();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    private List<TableRecord<?>> fetchAllRepositoryAddCommands() {
        return Stream.of(
                        userRepository.getAddStorageItems(),
                        subscriptionRepository.getAddStorageItems(),
                        subscriptionPlanRepository.getAddStorageItems(),
                        productRepository.getAddStorageItems(),
                        paymentRepository.getAddStorageItems(),
                        orderRepository.getAddStorageItems()
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<UpdatableRecord<?>> fetchAllRepositoryUpdateCommands() {
        return Stream.of(
                        userRepository.getUpdateStorageItems(),
                        subscriptionRepository.getUpdateStorageItems(),
                        subscriptionPlanRepository.getUpdateStorageItems(),
                        productRepository.getUpdateStorageItems(),
                        paymentRepository.getUpdateStorageItems(),
                        orderRepository.getUpdateStorageItems()
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<UpdatableRecord<?>> fetchAllRepositoryDeleteCommands() {
        return Stream.of(
                        userRepository.getDeleteStorageItems(),
                        subscriptionRepository.getDeleteStorageItems(),
                        subscriptionPlanRepository.getDeleteStorageItems(),
                        productRepository.getDeleteStorageItems(),
                        paymentRepository.getDeleteStorageItems(),
                        orderRepository.getDeleteStorageItems()
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
