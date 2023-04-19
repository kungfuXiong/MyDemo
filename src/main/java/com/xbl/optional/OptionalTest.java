package com.xbl.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add( 1 );
            add( 2 );
            add( 3 );
        }};

        List<Object> objectList = null;
        // 如果list为null就获取orElse中的内容，可以有效避免空指针
        Optional.ofNullable( list ).orElse( new ArrayList<>() ).forEach( System.out::println );
        Optional.ofNullable( objectList ).orElse( new ArrayList<>() ).forEach(System.out::println );
    }
}
