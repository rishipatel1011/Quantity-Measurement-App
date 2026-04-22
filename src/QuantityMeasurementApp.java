System.out.println("\n=== UC9: Weight Measurements ===");
QuantityWeight kg1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
QuantityWeight g1000 = new QuantityWeight(1000.0, WeightUnit.GRAM);
QuantityWeight lb2 = new QuantityWeight(2.0, WeightUnit.POUND);

        System.out.println(kg1 + " == " + g1000 + " -> " + kg1.equals(g1000));
        System.out.println("Converted 2 POUND to KILOGRAM -> " + lb2.convertTo(WeightUnit.KILOGRAM));
        System.out.println("add(" + kg1 + ", " + g1000 + ") -> " + kg1.add(g1000));
        System.out.println("add(" + kg1 + ", " + g1000 + ", GRAM) -> " + kg1.add(g1000, WeightUnit.GRAM));

QuantityLength ft1 = new QuantityLength(1.0, LengthUnit.FEET);
        System.out.println("Type Safety Check: 1 KG == 1 FOOT? -> " + kg1.equals(ft1));