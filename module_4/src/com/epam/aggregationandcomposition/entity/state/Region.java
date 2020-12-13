package com.epam.aggregationandcomposition.entity.state;

import com.epam.aggregationandcomposition.exceptions.StateLogicalException;
import java.util.List;

public class Region extends AdministrativeTerritorialUnit {
    public Region(String name, Measurable administrativeCenter, List<Measurable> includedUnits) throws
            StateLogicalException {
        super(name, administrativeCenter, includedUnits);
    }

    @Override
    public String toString() {
        return "Region {name:" + this.getName() +
                "; administrative center: " + this.getAdministrativeCenter() +
                "; included districts: " + this.getIncludedUnits() + "}";
    }

}
