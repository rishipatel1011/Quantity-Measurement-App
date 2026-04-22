// ==========================================
// UC7: ADDITION WITH EXPLICIT TARGET UNIT TESTS
// ==========================================

@Test
public void testAddition_ExplicitTargetUnit_Feet() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
    // Result explicitly requested in FEET
    assertEquals(new QuantityLength(2.0, LengthUnit.FEET), f1.add(i1, LengthUnit.FEET));
}

@Test
public void testAddition_ExplicitTargetUnit_Inches() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
    // Result explicitly requested in INCHES
    assertEquals(new QuantityLength(24.0, LengthUnit.INCH), f1.add(i1, LengthUnit.INCH));
}

@Test
public void testAddition_ExplicitTargetUnit_Yards() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
    // 1ft + 12in(1ft) = 2ft. 2ft in Yards = 2/3 Yards (~0.667)
    assertEquals(new QuantityLength(2.0 / 3.0, LengthUnit.YARD), f1.add(i1, LengthUnit.YARD));
}

@Test
public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
    assertThrows(IllegalArgumentException.class, () -> f1.add(i1, null));
}