package com.epam.aggregationandcomposition.entity.state;

import com.epam.aggregationandcomposition.exceptions.StateLogicalException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public abstract class AdministrativeTerritorialUnit implements Measurable{

    private String name;
    private Measurable administrativeCenter;
    private List<Measurable> includedUnits;

    public AdministrativeTerritorialUnit(String name, Measurable administrativeCenter, List<Measurable> includedUnits)
            throws StateLogicalException {
        if (isCorrectName(name) && administrativeCenter != null && includedUnits != null && includedUnits.size() != 0) {
            this.name = name;
            this.administrativeCenter = administrativeCenter;
            this.includedUnits = includedUnits;
        } else {
            throw new StateLogicalException("Incorrect parameters. Can't create an administrative territorial unit!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws StateLogicalException {
        if (isCorrectName(name)) {
            this.name = name;
        } else {
            throw new StateLogicalException("Incorrect parameter. Can't change the name of the administrative " +
                    "territorial unit!");
        }
    }

    public Settlement getAdministrativeCenter() {
        return (Settlement) administrativeCenter;
    }

    public void setAdministrativeCenter(Measurable administrativeCenter) throws StateLogicalException {
        if (administrativeCenter != null) {
            this.administrativeCenter = administrativeCenter;
        } else {
            throw new StateLogicalException("Incorrect parameter. Can't change the administrative center!");
        }
    }

    public List<Measurable> getIncludedUnits() {
        return includedUnits;
    }

    public void setIncludedUnits(List<Measurable> includedUnits) throws StateLogicalException {
        if (includedUnits != null && includedUnits.size() != 0) {
            this.includedUnits = includedUnits;
        } else {
            throw new StateLogicalException("Incorrect parameter. Can't change the included units!");
        }
    }

    public int countIncludedUnits() {
        return includedUnits.size();
    }

    private boolean isCorrectName(String name) {
        return (name != null &&
                name.length() != 0 &&
                Pattern.compile("^[A-Z]+[A-Za-z -]+[0-9]*$").matcher(name).matches());
    }

    @Override
    public double getArea() {
        double area = 0.0;
        for (Measurable unit : includedUnits) {
            area += unit.getArea();
        }
        return area;
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrativeTerritorialUnit other = (AdministrativeTerritorialUnit) o;
        return Objects.equals(name, other.name) &&
                Objects.equals(administrativeCenter, other.administrativeCenter) &&
                Objects.equals(includedUnits, other.includedUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, administrativeCenter, includedUnits);
    }
}
