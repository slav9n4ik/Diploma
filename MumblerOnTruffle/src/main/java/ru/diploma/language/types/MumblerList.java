package ru.diploma.language.types;

import ru.diploma.language.MumblerException;

import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class MumblerList<T extends Object> implements Iterable<T> {
    public static final MumblerList<?> EMPTY = new MumblerList();

    private final T car;
    private final MumblerList<T> cdr;
    private final int length;

    private MumblerList() {
        this.car = null;
        this.cdr = null;
        this.length = 0;
    }

    private MumblerList(T car, MumblerList<T> cdr) {
        this.car = car;
        this.cdr = cdr;
        this.length = cdr.length + 1;
    }

    public static <T> MumblerList<T> list(T... objs) {
        return list(asList(objs));
    }

    public static <T> MumblerList<T> list(List<T> objs) {
        MumblerList<T> l = (MumblerList<T>) EMPTY;
        for (int i = objs.size() - 1; i >= 0; i--) {
            l = l.cons(objs.get(i));
        }
        return l;
    }

    public MumblerList<T> cons(T node) {
        return new MumblerList<T>(node, this);
    }

    public T car() {
        if (this != EMPTY) {
            return this.car;
        }
        throw new MumblerException("Cannot car the empty list");
    }

    public MumblerList<T> cdr() {
        if (this != EMPTY) {
            return this.cdr;
        }
        throw new MumblerException("Cannot cdr the empty list");
    }

    public long size() {
        return this.length;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MumblerList<T> l = MumblerList.this;

            public boolean hasNext() {
                return this.l != EMPTY;
            }

            public T next() {
                if (this.l == EMPTY) {
                    throw new MumblerException("At end of list");
                }
                T car = this.l.car;
                this.l = this.l.cdr;
                return car;
            }

            public void remove() {
                throw new MumblerException("Iterator is immutable");
            }
        };
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MumblerList)) {
            return false;
        }
        if (this == EMPTY && other == EMPTY) {
            return true;
        }

        MumblerList<?> that = (MumblerList<?>) other;
        if (this.cdr == EMPTY && that.cdr != EMPTY) {
            return false;
        }
        return this.car.equals(that.car) && this.cdr.equals(that.cdr);
    }

    @Override
    public String toString() {
        if (this == EMPTY) {
            return "()";
        }

        StringBuilder b = new StringBuilder("(" + this.car);
        MumblerList<T> rest = this.cdr;
        while (rest != null && rest != EMPTY) {
            b.append(" ");
            b.append(rest.car);
            rest = rest.cdr;
        }
        b.append(")");
        return b.toString();
    }
}
