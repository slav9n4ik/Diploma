// CheckStyle: start generated
package ru.sbt.diploma.runtime;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import ru.sbt.diploma.runtime.TLLNull;

@GeneratedBy(TLLNull.class)
final class TLLNullGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(TLLNull.class, new InteropLibraryExports());
    }

    private TLLNullGen() {
    }

    @GeneratedBy(TLLNull.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, TLLNull.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof TLLNull;
            return InteropLibraryExports.UNCACHED;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof TLLNull;
            return InteropLibraryExports.CACHE;
        }

        @GeneratedBy(TLLNull.class)
        private static final class Cached extends InteropLibrary {

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof TLLNull) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.sbt.diploma.runtime.TLLNull'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof TLLNull;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TLLNull) receiver).isNull();
            }

        }
        @GeneratedBy(TLLNull.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof TLLNull) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.sbt.diploma.runtime.TLLNull'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof TLLNull;
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
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TLLNull) receiver) .isNull();
            }

        }
    }
}
