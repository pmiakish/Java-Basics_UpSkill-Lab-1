package com.epam.aggregationandcomposition.entity.state;

import com.epam.aggregationandcomposition.exceptions.StateLogicalException;
import java.util.ArrayList;
import java.util.List;

public class State extends AdministrativeTerritorialUnit {

    public State(String name, Measurable administrativeCenter, List<Measurable> includedUnits) throws
            StateLogicalException {
        super(name, administrativeCenter, includedUnits);
    }

    public List<Measurable> getAdministrativeCentersOfRegions() {
        List<Measurable> administrativeCentersOfRegions = new ArrayList<>();
        this.getIncludedUnits().forEach(region -> administrativeCentersOfRegions.add(region.getAdministrativeCenter()));
        return administrativeCentersOfRegions;
    }

    @Override
    public String toString() {
        return "State {name:" + this.getName() +
                "; administrative center: " + this.getAdministrativeCenter() +
                "; included regions: " + this.getIncludedUnits() + "}";
    }

}
