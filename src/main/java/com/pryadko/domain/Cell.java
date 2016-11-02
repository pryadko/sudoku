package com.pryadko.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cell {
    private int id;
    private int value;
    private Set<Integer> allowNumbers;

    public Cell(int id) {
        this.id = id;
        initValue();
    }

    private void initValue() {
        value = 0;
        allowNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public String valueToString() {
        return value == 0 ? " " : String.valueOf(value);
    }

    public void setValue(int value) {
        if (!allowNumbers.contains(value)) {
            throw new UnsupportedOperationException("Number = " + value + " not allow for cellId = " + id);
        }
        allowNumbers.remove(value);
        this.value = value;
        proceedDependentCells();
    }

    private void proceedDependentCells() {

    }

    public void setValue(String value) {
        setValue(Integer.parseInt(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (id != cell.id) return false;
        return value == cell.value;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "C[" + id + "]=" + value;
    }
}
