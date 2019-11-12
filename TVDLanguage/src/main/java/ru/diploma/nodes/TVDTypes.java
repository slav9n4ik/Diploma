package ru.diploma.nodes;

import com.oracle.truffle.api.dsl.TypeSystem;

/**
 * The type system of SL, as explained in {@link TVDLanguage}. Based on the {@link TypeSystem}
 * annotation, the Truffle DSL generates the subclass {@link TVDTypesGen} with type test and type
 * conversion methods for some types. In this class, we only cover types where the automatically
 * generated ones would not be sufficient.
 */
@TypeSystem({long.class, boolean.class})
public abstract class TVDTypes {
}
