package com.pryadko.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cell {
    private final int id;
    private int value;
    private Set<Integer> allowNumbers;

    public Cell(int id) {
        this.id = id;
        initValue();
    }

    public Cell(Cell cell) {
        this.id = cell.getId();
        this.value = cell.getValue();
        this.allowNumbers = cell.getAllowNumbers();
    }

    public String getString() {
        return Arrays.toString(allowNumbers.toArray());
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
        if (this.value == value) {
            return;
        }
        if (!allowNumbers.contains(value)) {
            throw new UnsupportedOperationException("Number = " + value + " not allow for cellId = " + id);
        }
        cleanAllowNumbers();

        this.value = value;
    }

    private void cleanAllowNumbers() {
        allowNumbers = new HashSet<>();
    }

    @Override
    public String toString() {
        return "C[" + id + "]=" + value;
    }

    public void removeDependency(Integer key) {
        allowNumbers.remove(key);
    }

    public boolean hasOneVariant() {
        return allowNumbers.size() == 1;
    }

    public int getVariant() {
        if (!hasOneVariant()) {
            throw new UnsupportedOperationException("We have not One variant for " + this);
        }

        return allowNumbers.iterator().next();
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public Set<Integer> getAllowNumbers() {
        return new HashSet<>(allowNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (id != cell.id) return false;
        if (value != cell.value) return false;
        return allowNumbers.equals(cell.allowNumbers);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + value;
        result = 31 * result + allowNumbers.hashCode();
        return result;
    }
}
