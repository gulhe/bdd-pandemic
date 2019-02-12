package org.gulhe.pandemic.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.gulhe.pandemic.domain.Network;

public class MyStepdefs {
    @Given("^the occidental sub-network$")
    public void theOccidentalSubNetwork() {

    }

    @Then("^([\\w]*) should be linked to ([\\w]*)$")
    public void shouldBeLinkedTo(String cityA, String cityB) {
        System.out.println("cityA = [" + cityA + "], cityB = [" + cityB + "]");
    }

    @Then("^the network should be:$")
    public void the_network_should_be(Network arg1) {
        throw new PendingException();
    }
}
