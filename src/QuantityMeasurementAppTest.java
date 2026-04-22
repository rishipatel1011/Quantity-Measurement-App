// ==========================================
// UC8: LENGTH UNIT ENUM RESPONSIBILITY TESTS
// ==========================================

@Test
public void testConvertToBaseUnit_FeetToFeet() {
    assertEquals(5.0, LengthUnit.FEET.convertToBaseUnit(5.0), 0.0001);
}

@Test
public void testConvertToBaseUnit_InchesToFeet() {
    // 12 Inches should be converted to 1 Foot
    assertEquals(1.0, LengthUnit.INCH.convertToBaseUnit(12.0), 0.0001);
}

@Test
public void testConvertToBaseUnit_YardsToFeet() {
    // 1 Yard should be converted to 3 Feet
    assertEquals(3.0, LengthUnit.YARD.convertToBaseUnit(1.0), 0.0001);
}

@Test
public void testConvertFromBaseUnit_FeetToInches() {
    // 1 Foot should be converted to 12 Inches
    assertEquals(12.0, LengthUnit.INCH.convertFromBaseUnit(1.0), 0.0001);
}

@Test
public void testConvertFromBaseUnit_FeetToCentimeters() {
    // 1 Foot should be converted to 30.48 cm
    assertEquals(30.48, LengthUnit.CENTIMETER.convertFromBaseUnit(1.0), 0.0001);
}