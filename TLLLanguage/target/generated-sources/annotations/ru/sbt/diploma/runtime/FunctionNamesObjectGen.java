// CheckStyle: start generated
package ru.sbt.diploma.runtime;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import ru.sbt.diploma.runtime.FunctionsObject.FunctionNamesObject;

@GeneratedBy(FunctionNamesObject.class)
final class FunctionNamesObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(FunctionNamesObject.class, new InteropLibraryExports());
    }

    private FunctionNamesObjectGen() {
    }

    @GeneratedBy(FunctionNamesObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, FunctionNamesObject.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof FunctionNamesObject;
            return InteropLibraryExports.UNCACHED;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof FunctionNamesObject;
            return InteropLibraryExports.CACHE;
        }

        @GeneratedBy(FunctionNamesObject.class)
        private static final class Cached extends InteropLibrary {

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof FunctionNamesObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.diploma.runtime.FunctionsObject.FunctionNamesObject'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof FunctionNamesObject;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver).hasArrayElements();
            }

            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver).isArrayElementReadable(index);
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver).getArraySize();
            }

            @Override
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver).readArrayElement(index);
            }

        }
        @GeneratedBy(FunctionNamesObject.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof FunctionNamesObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.diploma.runtime.FunctionsObject.FunctionNamesObject'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof FunctionNamesObject;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver) .isArrayElementReadable(index);
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionNamesObject) receiver) .readArrayElement(index);
            }

        }
    }
}
