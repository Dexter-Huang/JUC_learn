package com.example.tikatest.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

@Component
@Slf4j
public class TransactionalUtil {

    private final PlatformTransactionManager transactionManager;

    @Autowired
    public TransactionalUtil(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public <T> T executeInTransaction(TransactionCallback<T> action) throws TransactionalException {
        Assert.state(transactionManager!=null, "transactionManager is null");

        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            T result = action.execute();
            transactionManager.commit(transactionStatus);
            return result;
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw new TransactionalException("Transaction failed.", e);
        }
    }

    public interface TransactionCallback<T> {
        T execute() throws Exception;
    }

    public static class TransactionalException extends RuntimeException {
        public TransactionalException(String message, Throwable cause) {
            super(message, cause);
            log.error(message);
        }
    }
}
