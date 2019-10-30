package ru.diploma.language.types;

import com.oracle.truffle.api.dsl.TypeSystem;

@TypeSystem({long.class, boolean.class, MumblerFunction.class,
        MumblerSymbol.class, MumblerList.class})
public abstract class MumblerTypes {
}
