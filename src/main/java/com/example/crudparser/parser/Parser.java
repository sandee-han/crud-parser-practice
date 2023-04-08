package com.example.crudparser.parser;

public interface Parser<T> {
    T parse(String str);
}
