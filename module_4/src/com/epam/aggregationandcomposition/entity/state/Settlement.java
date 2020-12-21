package com.epam.aggregationandcomposition.entity.state;

import java.util.Objects;

public class Settlement implements Measurable {

    private String name;
    private double area;

    public Settlement(String name, double area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public Settlement getAdministrativeCenter() {
        return this;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return name + " (area = " + area + " km^2)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settlement other = (Settlement) o;
        return Double.compare(other.area, area) == 0 &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area);
    }
}
