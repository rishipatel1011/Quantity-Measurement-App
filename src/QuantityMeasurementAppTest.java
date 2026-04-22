// --- UC4: YARD TESTS ---
@Test
public void testEquality_YardToYard_SameValue() {
    QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARD);
    QuantityLength y2 = new QuantityLength(1.0, LengthUnit.YARD);
    assertEquals(y1, y2);
}

@Test
public void testEquality_YardToFeet_EquivalentValue() {
    QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARD);
    QuantityLength f1 = new QuantityLength(3.0, LengthUnit.FEET);
    assertEquals(y1, f1); // 1 Yard == 3 Feet
}

@Test
public void testEquality_YardToInches_EquivalentValue() {
    QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARD);
    QuantityLength i1 = new QuantityLength(36.0, LengthUnit.INCH);
    assertEquals(y1, i1); // 1 Yard == 36 Inches
}

// --- UC4: CENTIMETER TESTS ---
@Test
public void testEquality_CentimeterToCentimeter_SameValue() {
    QuantityLength cm1 = new QuantityLength(2.0, LengthUnit.CENTIMETER);
    QuantityLength cm2 = new QuantityLength(2.0, LengthUnit.CENTIMETER);
    assertEquals(cm1, cm2);
}

@Test
public void testEquality_CentimeterToInches_EquivalentValue() {
    QuantityLength cm1 = new QuantityLength(1.0, LengthUnit.CENTIMETER);
    QuantityLength i1 = new QuantityLength(0.393701, LengthUnit.INCH);
    assertEquals(cm1, i1); // 1 CM == 0.393701 Inches
}

// --- Multi-Unit / Transitive Property ---
@Test
public void testEquality_MultiUnit_TransitiveProperty() {
    QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARD);
    QuantityLength f1 = new QuantityLength(3.0, LengthUnit.FEET);
    QuantityLength i1 = new QuantityLength(36.0, LengthUnit.INCH);

    // If A == B and B == C, then A == C
    assertEquals(y1, f1);
    assertEquals(f1, i1);
    assertEquals(y1, i1);
}