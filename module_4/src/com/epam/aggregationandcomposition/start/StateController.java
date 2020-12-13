package com.epam.aggregationandcomposition.start;

import com.epam.aggregationandcomposition.entity.state.*;
import com.epam.aggregationandcomposition.exceptions.StateLogicalException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateController {

    // Minsk region
    private static final String[] SETTLEMENTS_OF_MINSK_DISTRICT = {"Minsk", "Borovlyany", "Zhdanovichi", "Senitsa",
            "Krupitsa"};
    private static final double[] AREAS_OF_MINSK_DISTRICT = {348.84, 6.22, 8.5, 11.2, 8.9};
    private static final String[] SETTLEMENTS_OF_VILEYKA_DISTRICT = {"Vileyka", "Osipovichi", "Vyazyn", "Naroch",
            "Izha"};
    private static final double[] AREAS_OF_VILEYKA_DISTRICT = {10.2, 8.78, 12.6, 10.7, 7.1};
    private static final String[] SETTLEMENTS_OF_NESVIZH_DISTRICT = {"Nesvizh", "Gorodeya", "Kozly", "Snov", "Lan"};
    private static final double[] AREAS_OF_NESVIZH_DISTRICT = {13.4, 6.4, 11.7, 11.6, 11.22};

    // Grodno region
    private static final String[] SETTLEMENTS_OF_GRODNO_DISTRICT = {"Grodno", "Skidel", "Indura", "Ozery", "Koptevka"};
    private static final double[] AREAS_OF_GRODNO_DISTRICT = {142.1, 35.5, 25.2, 18.8, 17.5};
    private static final String[] SETTLEMENTS_OF_LIDA_DISTRICT = {"Lida", "Berozovka", "Berdovka", "Belitsa",
            "Tarnovo"};
    private static final double[] AREAS_OF_LIDA_DISTRICT = {50.1, 15.1, 13.4, 11.2, 10.3};
    private static final String[] SETTLEMENTS_OF_MOSTY_DISTRICT = {"Mosty", "Gudevichi", "Dubno", "Kurilovichi",
            "Lunno"};
    private static final double[] AREAS_OF_MOSTY_DISTRICT = {11.6, 8.4, 9.2, 7.5, 9.0};

    // Brest region
    private static final String[] SETTLEMENTS_OF_BREST_DISTRICT = {"Brest", "Domachevo", "Muhavets", "Znamenka",
            "Kleyniki"};
    private static final double[] AREAS_OF_BREST_DISTRICT = {146.12, 23.5, 22.0, 21.3, 16.4};
    private static final String[] SETTLEMENTS_OF_PINSK_DISTRICT = {"Pinsk", "Logishin", "Novyi Dvor", "Osnezhytsy",
            "Okhovo"};
    private static final double[] AREAS_OF_PINSK_DISTRICT = {47.36, 12.2, 14.1, 13.7, 13.1};
    private static final String[] SETTLEMENTS_OF_KOBRIN_DISTRICT = {"Kobrin", "Gorodets", "Divin", "Tevli",
            "Bukhovichi"};
    private static final double[] AREAS_OF_KOBRIN_DISTRICT = {20.3, 4.42, 12.4, 5.3, 8.25};

    public static void main(String[] args) {

        try {
            // Minsk region
            List<Measurable> minskDistrictUnits = generateDistrict(SETTLEMENTS_OF_MINSK_DISTRICT,
                    AREAS_OF_MINSK_DISTRICT);
            Measurable minskDistrict = new District("Minsk district", minskDistrictUnits.get(0),
                    minskDistrictUnits);
            List<Measurable> vileykaDistrictUnits = generateDistrict(SETTLEMENTS_OF_VILEYKA_DISTRICT,
                    AREAS_OF_VILEYKA_DISTRICT);
            Measurable vileykaDistrict = new District("Vileyka district", vileykaDistrictUnits.get(0),
                    vileykaDistrictUnits);
            List<Measurable> nesvizhDistrictUnits = generateDistrict(SETTLEMENTS_OF_NESVIZH_DISTRICT,
                  AREAS_OF_NESVIZH_DISTRICT);
            Measurable nesvizhDistrict = new District("Nesvizh district", nesvizhDistrictUnits.get(0),
                    nesvizhDistrictUnits);
            List<Measurable> minskRegionUnits = Arrays.asList(minskDistrict, vileykaDistrict, nesvizhDistrict);
            Measurable minskRegion = new Region("Minsk Region", minskDistrictUnits.get(0), minskRegionUnits);

            // Grodno region
            List<Measurable> grodnoDistrictUnits = generateDistrict(SETTLEMENTS_OF_GRODNO_DISTRICT,
                    AREAS_OF_GRODNO_DISTRICT);
            Measurable grodnoDistrict = new District("Grodno district", grodnoDistrictUnits.get(0),
                    grodnoDistrictUnits);
            List<Measurable> lidaDistrictUnits = generateDistrict(SETTLEMENTS_OF_LIDA_DISTRICT,
                    AREAS_OF_LIDA_DISTRICT);
            Measurable lidaDistrict = new District("Lida district", lidaDistrictUnits.get(0), lidaDistrictUnits);
            List<Measurable> mostyDistrictUnits = generateDistrict(SETTLEMENTS_OF_MOSTY_DISTRICT,
                    AREAS_OF_MOSTY_DISTRICT);
            Measurable mostyDistrict = new District("Mosty district", mostyDistrictUnits.get(0),
                    mostyDistrictUnits);
            List<Measurable> grodnoRegionUnits = Arrays.asList(grodnoDistrict, lidaDistrict, mostyDistrict);
            Measurable grodnoRegion = new Region("Grodno Region", grodnoDistrictUnits.get(0), grodnoRegionUnits);

            // Brest region
            List<Measurable> brestDistrictUnits = generateDistrict(SETTLEMENTS_OF_BREST_DISTRICT,
                    AREAS_OF_BREST_DISTRICT);
            Measurable brestDistrict = new District("Brest district", brestDistrictUnits.get(0),
                    brestDistrictUnits);
            List<Measurable> pinskDistrictUnits = generateDistrict(SETTLEMENTS_OF_PINSK_DISTRICT,
                    AREAS_OF_PINSK_DISTRICT);
            Measurable pinskDistrict = new District("Pinsk district", pinskDistrictUnits.get(0),
                    pinskDistrictUnits);
            List<Measurable> kobrinDistrictUnits = generateDistrict(SETTLEMENTS_OF_KOBRIN_DISTRICT,
                    AREAS_OF_KOBRIN_DISTRICT);
            Measurable kobrinDistrict = new District("Kobrin district", kobrinDistrictUnits.get(0),
                    kobrinDistrictUnits);
            List<Measurable> brestRegionUnits = Arrays.asList(brestDistrict, pinskDistrict, kobrinDistrict);
            Measurable brestRegion = new Region("Brest Region", brestDistrictUnits.get(0), brestRegionUnits);

            // State
            List<Measurable> stateUnits = Arrays.asList(minskRegion, grodnoRegion, brestRegion);
            State state = new State("The Republic of Belarus", minskDistrictUnits.get(0),
                    stateUnits);
            System.out.println("The capital of " + state.getName() + " is " + state.getAdministrativeCenter());
            System.out.println(state.getName() + " includes " + state.countIncludedUnits() + " regions with the " +
                    "following administrative centers: " + state.getAdministrativeCentersOfRegions());
            System.out.println("The common area of the state is " + state.getArea() + " km^2");


        } catch (StateLogicalException e) {
            e.printStackTrace();
        }


    }

    private static List<Measurable> generateDistrict (String[] settlementNames, double[] settlementAreas) {
        if (settlementNames.length == settlementAreas.length) {
            List<Measurable> districtUnits = new ArrayList<>();
            for (int i = 0; i < settlementNames.length; i++) {
                districtUnits.add(new Settlement(settlementNames[i], settlementAreas[i]));
            }
            return districtUnits;
        }
        return null;
    }

}
