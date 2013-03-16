package gwt.html5.file.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;


public interface AbortEventHandler extends EventHandler{
	
	public static class AbortEvent extends GwtEvent<AbortEventHandler>{

		public static final Type<AbortEventHandler> TYPE = new Type<AbortEventHandler>();
		
		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<AbortEventHandler> getAssociatedType() {
			return TYPE;
		}

		@Override
		protected void dispatch(AbortEventHandler handler) {
			handler.onAbort(this);
		}
		
	}

	void onAbort(AbortEvent abortEvent);
	
	
}
