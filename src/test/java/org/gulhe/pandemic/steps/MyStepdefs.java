package org.gulhe.pandemic.steps;

import cucumber.api.java.en.*;
import org.gulhe.pandemic.domain.Network;
import org.gulhe.pandemic.domain.Route;

import java.util.Comparator;

public class MyStepdefs {
    @Given("^the occidental sub-network$")
    public void theOccidentalSubNetwork() {}

    @Then("^([\\w]*) should be linked to ([\\w]*)$")
    public void shouldBeLinkedTo(String cityA, String cityB) {
        System.out.println("cityA = [" + cityA + "], cityB = [" + cityB + "]");
    }

    @Then("^the network should be:$")
    public void the_network_should_be(Network arg1) {
        arg1.cities
                .stream()
                .sorted(Comparator.comparing(c -> c.name))
                .forEachOrdered(System.out::println);
        arg1.routes
                .stream()
                .map(Route::toStringOrdered)
                .sorted()
                .forEachOrdered(System.out::println);
    }
}
