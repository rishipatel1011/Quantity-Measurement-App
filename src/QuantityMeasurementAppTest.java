// ==========================================
// UC6: ADDITION TESTS
// ==========================================

@Test
public void testAddition_SameUnit_FeetPlusFeet() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength f2 = new QuantityLength(2.0, LengthUnit.FEET);
    QuantityLength result = f1.add(f2);
    assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
}

@Test
public void testAddition_CrossUnit_FeetPlusInches() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
    // Result should be in the unit of the first operand (Feet)
    QuantityLength result = f1.add(i1);
    assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
}

@Test
public void testAddition_CrossUnit_InchPlusFeet() {
    QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength result = i1.add(f1);
    assertEquals(new QuantityLength(24.0, LengthUnit.INCH), result);
}

@Test
public void testAddition_CrossUnit_YardPlusFeet() {
    QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARD);
    QuantityLength f1 = new QuantityLength(3.0, LengthUnit.FEET);
    QuantityLength result = y1.add(f1);
    assertEquals(new QuantityLength(2.0, LengthUnit.YARD), result);
}

@Test
public void testAddition_CrossUnit_CentimeterPlusInch() {
    QuantityLength cm1 = new QuantityLength(2.54, LengthUnit.CENTIMETER);
    QuantityLength i1 = new QuantityLength(1.0, LengthUnit.INCH);
    QuantityLength result = cm1.add(i1);
    // 2.54 cm + 1 inch(2.54 cm) ≈ 5.08 cm
    assertEquals(new QuantityLength(5.08, LengthUnit.CENTIMETER), result);
}

@Test
public void testAddition_Commutativity() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);

    // A + B (Result in Feet) == B + A (Result in Inches)
    // Note: Our equals() method handles cross-unit equality automatically!
    assertEquals(f1.add(i1), i1.add(f1));
}

@Test
public void testAddition_WithZero() {
    QuantityLength f1 = new QuantityLength(5.0, LengthUnit.FEET);
    QuantityLength i0 = new QuantityLength(0.0, LengthUnit.INCH);
    assertEquals(new QuantityLength(5.0, LengthUnit.FEET), f1.add(i0));
}

@Test
public void testAddition_NegativeValues() {
    QuantityLength f1 = new QuantityLength(5.0, LengthUnit.FEET);
    QuantityLength f2 = new QuantityLength(-2.0, LengthUnit.FEET);
    assertEquals(new QuantityLength(3.0, LengthUnit.FEET), f1.add(f2));
}

@Test
public void testAddition_NullSecondOperand() {
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    assertThrows(IllegalArgumentException.class, () -> f1.add(null));
}

@Test
public void testAddition_LargeValues() {
    QuantityLength f1 = new QuantityLength(1e6, LengthUnit.FEET);
    QuantityLength f2 = new QuantityLength(1e6, LengthUnit.FEET);
    assertEquals(new QuantityLength(2e6, LengthUnit.FEET), f1.add(f2));
}