package org.gulhe.pandemic;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import org.gulhe.pandemic.domain.City;
import org.gulhe.pandemic.domain.Network;
import org.gulhe.pandemic.domain.Route;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class GraphConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(
            Network.class,
            (DataTable raw) -> {
                List<List<String>> lines = raw.asLists();
                List<String> head = head(lines);
                List<String> columnTitles = tail(head);
                List<String> lineTitles = tail(lines).stream().map(l->l.get(0)).collect(Collectors.toList());

                List<Route> links = new LinkedList<>();
                for (int i = 0; i < columnTitles.size(); i++) {
                    for (int j = 0; j < lineTitles.size()-(i+1); j++) {
                        List<String> line = lines.get(i + 1);
                        String s = line.get(j + 1);
                        if(s.equals("x")){
                            City cityA = new City(columnTitles.get(j));
                            City cityB = new City(lineTitles.get(i));
                            links.add(new Route(cityB,cityA));
                        }
                    }
                }
                return new Network(links.toArray(new Route[0]));
            }
        ));
    }

    private <T> T head(List<T> l) {
        return l.get(0);
    }
    private <T> List<T> tail(List<T> l) {
        return new ArrayList<>(l).subList(1,l.size());
    }
}
