package com.methord;

/**
 * User: edward
 * Date: 9/9/13
 * Time: 11:02 AM
 */
public interface TestMethord {
    public String[][] BoundaryValues(int width, String[][] inputString);

    public String[][] EquivalenceClass(boolean generateFalseClass, String[][] inputString);

    public String[][] OrthogonalDecomposition();

    public String[][] RandomMatrix();
}
