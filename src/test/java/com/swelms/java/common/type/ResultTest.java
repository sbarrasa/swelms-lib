package com.swelms.java.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    void success() {
        var result = new Result.Success<>(10);
        assertEquals(10, result.value());
    }

    @Test
    void fail() {
        var result = new Result.Fail<>(new ArithmeticException("no puede ser mayor que 1"));
        assertNull(result.value());
        assertInstanceOf(ArithmeticException.class, result.error());
    }

    @Test
    void resultOf() {
        var result1 = Result.of(() -> 10 / 2);
        assertInstanceOf(Result.Success.class, result1);

        var result2 = Result.of(() -> 10 / 0);
        assertInstanceOf(Result.Fail.class, result2);

    }

    @Test
    void orElseSuccess() {
        var result1 = Result.<Object>of(() -> 10 / 2).orElse(r -> "Error");
        assertInstanceOf(Result.Success.class, result1);
        assertEquals(5, result1.value());
    }

    @Test
    void orElseValue() {
        var result = Result.of(() -> 10 / 0).orElse(r -> 0);
        assertInstanceOf(Result.Success.class, result);
        assertEquals(0, result.value());
    }

    @Test
    void orElseString() {
        var result2 = Result.<Object>of(() -> 10 / 0).orElse(r -> "Error");
        assertInstanceOf(Result.Success.class, result2);
        assertEquals("Error", result2.value());
    }
    @Test
    void orElseAndValue() {
        var value = Result.<Object>of(() -> 10 / 0)
                .orElse(r -> "Error")
                .value();
        assertEquals("Error", value);
    }

    @Test
    void orElseFailPipe() {
       var result = Result.of(() -> 10/0)
                .orElse(r -> { throw new RuntimeException("Fail");} )
                .orElse(r -> { throw new ArithmeticException("Result fails");});

        if(result instanceof Result.Fail(Throwable error))
           assertInstanceOf(ArithmeticException.class, error);
    }

    @Test
    void allSubclasses() {
        var subtypes = Result.class.getPermittedSubclasses();
        assertEquals(2, subtypes.length);
        assertSame(Result.Success.class, subtypes[0]);
        assertSame(Result.Fail.class, subtypes[1]);
    }

    @Test
    void switchResultSuccess(){
        var result = Result.of(() -> "Hola");
        var message = switch (result){
            case Result.Success r ->  r.value();
            case Result.Fail r ->  r.error().getMessage();
        };
        assertEquals("Hola", message);
    }

    @Test
    void switchResultFail(){
        var result = Result.of(() -> {throw new RuntimeException("Error");});
        var message = switch (result){
            case Result.Success r ->  r.value();
            case Result.Fail r ->  r.error().getMessage();
        };
        assertEquals("Error", message);
    }
}