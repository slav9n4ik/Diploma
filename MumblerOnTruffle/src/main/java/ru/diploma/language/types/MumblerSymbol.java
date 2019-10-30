package ru.diploma.language.types;

public class MumblerSymbol {
    public final String name;

    public MumblerSymbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "'" + this.name;
    }
}
