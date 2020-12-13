package com.epam.aggregationandcomposition.entity.state;

import com.epam.aggregationandcomposition.exceptions.StateLogicalException;

import java.util.List;

public class District extends AdministrativeTerritorialUnit {
    public District(String name, Measurable administrativeCenter, List<Measurable> includedUnits) throws
            StateLogicalException {
        super(name, administrativeCenter, includedUnits);
    }

    @Override
    public String toString() {
        return "District {name:" + this.getName() +
                "; administrative center: " + this.getAdministrativeCenter() +
                "; included settlements: " + this.getIncludedUnits() + "}";
    }
}
