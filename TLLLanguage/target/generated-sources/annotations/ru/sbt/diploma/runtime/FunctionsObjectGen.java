// CheckStyle: start generated
package ru.sbt.diploma.runtime;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import ru.sbt.diploma.runtime.FunctionsObject;

@GeneratedBy(FunctionsObject.class)
final class FunctionsObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(FunctionsObject.class, new InteropLibraryExports());
    }

    private FunctionsObjectGen() {
    }

    @GeneratedBy(FunctionsObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, FunctionsObject.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof FunctionsObject;
            return InteropLibraryExports.UNCACHED;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof FunctionsObject;
            return InteropLibraryExports.CACHE;
        }

        @GeneratedBy(FunctionsObject.class)
        private static final class Cached extends InteropLibrary {

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof FunctionsObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.sbt.diploma.runtime.FunctionsObject'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof FunctionsObject;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver).hasMembers();
            }

            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver).readMember(member);
            }

            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver).isMemberReadable(member);
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver).getMembers(includeInternal);
            }

        }
        @GeneratedBy(FunctionsObject.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof FunctionsObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.sbt.diploma.runtime.FunctionsObject'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof FunctionsObject;
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
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver) .readMember(member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver) .isMemberReadable(member);
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((FunctionsObject) receiver) .getMembers(includeInternal);
            }

        }
    }
}
