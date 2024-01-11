package com.bo.core;

import java.util.concurrent.CompletableFuture;

public interface IUnitOfWork {
    CompletableFuture<Void> commit();
}
