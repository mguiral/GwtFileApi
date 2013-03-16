package gwt.html5.file.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;


public interface ErrorEventHandler extends EventHandler{

	public static class ErrorEvent extends GwtEvent<ErrorEventHandler>{

		public static final Type<ErrorEventHandler> TYPE = new Type<ErrorEventHandler>();
		
		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<ErrorEventHandler> getAssociatedType() {
			return TYPE;
		}

		@Override
		protected void dispatch(ErrorEventHandler handler) {
			handler.onError(this);
		}
		
	}

	void onError(ErrorEvent errorEvent);
	
}
