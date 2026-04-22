// ==========================================
// UC5: CONVERSION TESTS
// ==========================================

@Test
public void testConversion_FeetToInches() {
    double result = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
    assertEquals(12.0, result, 0.0001);
}

@Test
public void testConversion_InchesToFeet() {
    double result = QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET);
    assertEquals(2.0, result, 0.0001);
}

@Test
public void testConversion_YardsToInches() {
    double result = QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.INCH);
    assertEquals(36.0, result, 0.0001);
}

@Test
public void testConversion_CentimetersToInches() {
    double result = QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH);
    assertEquals(1.0, result, 0.0001); // 2.54 cm is approx 1 inch
}

@Test
public void testConversion_ZeroValue() {
    double result = QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH);
    assertEquals(0.0, result, 0.0001);
}

@Test
public void testConversion_NegativeValue() {
    double result = QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH);
    assertEquals(-12.0, result, 0.0001);
}

@Test
public void testConversion_RoundTrip_PreservesValue() {
    double feet = 5.0;
    double inches = QuantityLength.convert(feet, LengthUnit.FEET, LengthUnit.INCH);
    double backToFeet = QuantityLength.convert(inches, LengthUnit.INCH, LengthUnit.FEET);
    assertEquals(feet, backToFeet, 0.0001);
}

// ==========================================
// UC5: VALIDATION TESTS
// ==========================================

@Test
public void testConversion_InvalidUnit_Throws() {
    assertThrows(IllegalArgumentException.class, () -> {
        QuantityLength.convert(1.0, null, LengthUnit.INCH);
    });
}

@Test
public void testConversion_NaNOrInfinite_Throws() {
    assertThrows(IllegalArgumentException.class, () -> {
        QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH);
    });
    assertThrows(IllegalArgumentException.class, () -> {
        QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCH);
    });
}