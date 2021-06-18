package com.interview;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Yulin.Wang
 * @date 2021/6/9
 * @description
 */

public class Tester {

    public static void main(String[] args) {
        List<StringBuilder> list = IntStream.range(0, 10_000_000)
                .mapToObj(i -> new StringBuilder(0))
                .filter(s -> ((s.hashCode() ^ s.hashCode() >>> 16) & 0xfff) == 0) // & 4096
                .sorted(Comparator.comparingInt(Object::hashCode))
                .collect(Collectors.toList());

        StringBuilder sb = list.remove(IntStream.range(1, list.size())
                .filter(i -> list.get(i).hashCode() == list.get(i - 1).hashCode())
                .findFirst()
                .orElseThrow());

        Set<StringBuilder> set = new HashSet<>(list);
        set.add(sb);
        System.out.println(set.contains(sb));
        System.out.println(sb.hashCode());
        sb.append("oops");
        set.contains(sb);
        System.out.println(set.contains(sb));
        System.out.println(sb.hashCode());
    }

}
