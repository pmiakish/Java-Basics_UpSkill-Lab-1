package com.epam.dragontreasure.start;

import com.epam.dragontreasure.entity.Cave;
import com.epam.dragontreasure.entity.treasure.Treasure;
import com.epam.dragontreasure.util.init.TreasureInitializer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DragonTreasureController {

    private static final int NUMBER_OF_EACH_TYPE_TREASURES = 25;

    public static void main(String[] args) {
        Cave cave = new Cave();
        try {
            TreasureInitializer.fillCave(cave, NUMBER_OF_EACH_TYPE_TREASURES);
            Cave.Dragon dragon = cave.callDragon();

            Scanner console = new Scanner(System.in).useLocale(Locale.US);
            System.out.print ("------ Treasures of the dragon ------\n");

            int choice = 0;
            while (choice != 3) {
                System.out.print ("MENU:\n1 - show treasures\n2 - select treasures\n3 - exit\n\n-> ");
                choice = console.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("\n--- Treasures ---\n" + dragon.showTreasures() + "\n--- End of treasures" +
                                " ---\n");
                        break;
                    case 2:
                        System.out.println("--- Select treasures ---\nEnter the minimal price:");
                        double minPrice = console.nextDouble();
                        System.out.println("Enter the maximal price:");
                        double maxPrice = console.nextDouble();
                        try {
                            List<Treasure> selectedTreasures = dragon.selectTreasuresByPrice(BigDecimal.
                                            valueOf(minPrice), BigDecimal.valueOf(maxPrice));
                            if (selectedTreasures.size() > 0) {
                                System.out.println("\n--- Treasures ---\n");
                                selectedTreasures.forEach(System.out::print);
                                System.out.println("\n--- End of treasures ---\n");
                            } else {
                                System.out.println("Treasures with the specified borders of the price not found!\n");
                            }
                        } catch (NullPointerException | IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Unknown command! Try again\n");
                }
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}