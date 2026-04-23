package com.swelms.java.common.result;

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
        assertTrue(result1 instanceof Result.Success);

        var result2 = Result.of(() -> 10 / 0);
        assertTrue(result2 instanceof Result.Fail);

    }

    @Test
    void orElseSuccess() {
        var result1 = Result.<Object>of(() -> 10 / 2).orElse(_ -> "Error");
        assertTrue(result1 instanceof Result.Success);
        assertEquals(5, result1.value());
    }

    @Test
    void orElseValue() {
        var result2 = Result.of(() -> 10 / 0).orElse(_ -> 0);
        assertTrue(result2 instanceof Result.Success);
        assertEquals(0, result2.value());
    }

    @Test
    void orElseString() {
        var result2 = Result.<Object>of(() -> 10 / 0).orElse(_ -> "Error");
        assertTrue(result2 instanceof Result.Success);
        assertEquals("Error", result2.value());
    }
    @Test
    void orElseAndValue() {
        var value = Result.<Object>of(() -> 10 / 0)
                .orElse(_ -> "Error")
                .value();
        assertEquals("Error", value);
    }

    @Test
    void orElseFailPipe() {
       var result = Result.of(() -> 10/0)
                .orElse(_ -> { throw new RuntimeException("Fail");} )
                .orElse(_ -> { throw new ArithmeticException("Result fails");});

        assertTrue(result instanceof Result.Fail);
        Result.Fail r2 = (Result.Fail) result;
        assertTrue(r2.error() instanceof ArithmeticException);
    }

    @Test
    void allSubclasses() {
        var subtypes = Result.class.getPermittedSubclasses();
        assertTrue(subtypes.length == 2);
        assertTrue(subtypes[0] ==  Result.Success.class);
        assertTrue(subtypes[1] ==  Result.Fail.class);
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