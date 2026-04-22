package com.swelms.java.common.result;

import java.util.function.Function;
import java.util.function.Supplier;

public sealed interface Result<T> permits Result.Success, Result.Fail {
    static <T> Result<T> of(Supplier<T> block) {
        try {
            return new Success<>(block.get());
        } catch (Throwable e) {
            return new Fail<>(e);
        }
    }

    T value();

    Throwable error();

    default Result<T> orElse(Function<Fail<T>, T> fallback) {
        return switch (this) {
            case Success<T> s -> s;
            case Fail<T> f -> of(() -> fallback.apply(f));
        };
    }

    record Success<T>(T value) implements Result<T> {
        public Throwable error() { return null; }
    }

    record Fail<T>(Throwable error) implements Result<T> {
        public T value() { return null; }
    }


}