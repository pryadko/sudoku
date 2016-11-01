package com.pryadko.domain;

import java.util.Objects;

public class Cell {
    private int id;
    private int value;

    public Cell(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String valueToString() {
        return value == 0 ? " " : String.valueOf(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValue(String value) {
        if (Objects.equals(value, " ")) {
            this.value = 0;
        } else {
            setValue(Integer.parseInt(value));
        }
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
}
