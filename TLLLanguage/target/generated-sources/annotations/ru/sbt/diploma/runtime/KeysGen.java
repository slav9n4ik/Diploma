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
import ru.sbt.diploma.runtime.TLLObjectType.Keys;

@GeneratedBy(Keys.class)
final class KeysGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(Keys.class, new InteropLibraryExports());
    }

    private KeysGen() {
    }

    @GeneratedBy(Keys.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, Keys.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof Keys;
            return InteropLibraryExports.UNCACHED;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof Keys;
            return InteropLibraryExports.CACHE;
        }

        @GeneratedBy(Keys.class)
        private static final class Cached extends InteropLibrary {

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof Keys) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.diploma.runtime.TLLObjectType.Keys'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof Keys;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver).readArrayElement(index);
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver).hasArrayElements();
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver).getArraySize();
            }

            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver).isArrayElementReadable(index);
            }

        }
        @GeneratedBy(Keys.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof Keys) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.diploma.runtime.TLLObjectType.Keys'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof Keys;
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
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver) .readArrayElement(index);
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Keys) receiver) .isArrayElementReadable(index);
            }

        }
    }
}
