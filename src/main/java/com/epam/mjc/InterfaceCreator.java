package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String i : x) {
                if (!Character.isUpperCase(i.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> x.addAll(x.stream()
                .filter(element -> Integer.remainderUnsigned(element, 2) == 0)
                .collect(Collectors.toList()));

    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(element -> Character.isUpperCase(element.charAt(0))
                && element.charAt(element.length() - 1) == '.'
                && element.split(" ").length > 3).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            HashMap<String, Integer> result = new HashMap<>();
            for(String i : x){
                result.put(i, i.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {ArrayList<Integer> result = new ArrayList<>(list1);
        result.addAll(list2);
        return result;
        };
    }
}
