import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // --- Same Unit Equality Tests ---
    @Test
    public void testEquality_FeetToFeet_SameValue() {
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertEquals(f1, f2);
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        QuantityLength i1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength i2 = new QuantityLength(1.0, LengthUnit.INCH);
        assertEquals(i1, i2);
    }

    // --- Cross-Unit Equality Tests (The Magic of UC3) ---
    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
        assertEquals(f1, i1); // 1 ft == 12 inches
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertEquals(i1, f1); // Symmetric check
    }

    // --- Inequality Tests ---
    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertNotEquals(f1, f2);
    }

    // --- Null and Reference Tests ---
    @Test
    public void testEquality_NullComparison() {
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertNotEquals(null, f1);
    }

    @Test
    public void testEquality_SameReference() {
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertEquals(f1, f1);
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        });
    }
}