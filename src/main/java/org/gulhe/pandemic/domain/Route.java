package org.gulhe.pandemic.domain;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Route {
    public final Collection<City> endpoints;

    public Route(
            @NotNull City cityA,
            @NotNull City cityB
    ) {
        if(cityA.equals(cityB)){
            throw new IllegalArgumentException("Can't link city " + cityA + " to itslef, déso ...");
        }
        endpoints = Collections.unmodifiableSet(
                new HashSet<>(
                        Arrays.asList(cityA, cityB)
                )
        );
    }

    @Override
    public String toString() {
        return String.join(
                "<=>",
                endpoints
                        .stream()
                        .map(City::toString)
                        .collect(Collectors.toSet())
        );
    }

    public String toStringOrdered() {
        return String.join(
                "<=>",
                endpoints
                        .stream()
                        .map(City::toString)
                        .sorted()
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(endpoints, route.endpoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoints);
    }
}
