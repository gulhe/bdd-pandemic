package org.gulhe.pandemic.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Network {
    public final Set<Route> routes;
    public final Set<City> cities;

    public Network(Route... routes) {
        this.routes = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(routes)));
        cities = Arrays.stream(routes)
                .flatMap(route -> route.endpoints.stream())
                .collect(Collectors.toSet());
    }
}
