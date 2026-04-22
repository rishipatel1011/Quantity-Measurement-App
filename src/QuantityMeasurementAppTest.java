// ==========================================
// UC9: WEIGHT MEASUREMENT TESTS
// ==========================================

@Test
public void testWeightEquality_KilogramToGram() {
    QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
    QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
    assertEquals(kg, g);
}

@Test
public void testWeightEquality_KilogramToPound() {
    QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
    QuantityWeight lb = new QuantityWeight(2.20462, WeightUnit.POUND);
    assertEquals(kg, lb);
}

@Test
public void testWeightConversion_PoundToKilogram() {
    QuantityWeight lb = new QuantityWeight(2.20462, WeightUnit.POUND);
    QuantityWeight expectedKg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

    QuantityWeight actualKg = lb.convertTo(WeightUnit.KILOGRAM);
    assertEquals(expectedKg, actualKg);
}

@Test
public void testWeightAddition_KilogramPlusGram() {
    QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
    QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);

    // Result defaults to unit of first operand (KILOGRAM)
    QuantityWeight expected = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
    assertEquals(expected, kg.add(g));
}

@Test
public void testWeightAddition_ExplicitTargetUnit() {
    QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
    QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);

    // Result explicitly requested in GRAMS
    QuantityWeight expected = new QuantityWeight(2000.0, WeightUnit.GRAM);
    assertEquals(expected, kg.add(g, WeightUnit.GRAM));
}

// ==========================================
// TYPE SAFETY TEST: LENGTH VS WEIGHT
// ==========================================

@Test
public void testEquality_WeightVsLength_Incompatible() {
    QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
    QuantityLength ft = new QuantityLength(1.0, LengthUnit.FEET);

    // Different measurement categories should NEVER be equal
    assertNotEquals(kg, ft);
}