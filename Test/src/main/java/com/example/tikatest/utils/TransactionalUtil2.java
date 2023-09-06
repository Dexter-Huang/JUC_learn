package com.example.tikatest.utils;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TransactionalUtil2 {
    public static void executeInTransaction(DoTransactionCompletion doTransactionCompletion) {
        if(TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(doTransactionCompletion);
        }
    }

    @Transactional
    public void doTx() {
        // start tx
        TransactionalUtil2.executeInTransaction(new DoTransactionCompletion(() -> {
            // send MQ...RPC...HTTP...
        }));
        // end tx
    }

}

class DoTransactionCompletion implements TransactionSynchronization {
    private Runnable runnable;

    public DoTransactionCompletion(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void afterCompletion(int status) {
        if (status == STATUS_COMMITTED) {
            runnable.run();
        }
    }


}
