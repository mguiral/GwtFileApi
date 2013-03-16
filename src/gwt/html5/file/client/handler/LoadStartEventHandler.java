package gwt.html5.file.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public interface LoadStartEventHandler extends EventHandler{
	
	public static class LoadStartEvent extends GwtEvent<LoadStartEventHandler>{

		public static final Type<LoadStartEventHandler> TYPE = new Type<LoadStartEventHandler>();
		
		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<LoadStartEventHandler> getAssociatedType() {
			return TYPE;
		}

		@Override
		protected void dispatch(LoadStartEventHandler handler) {
			handler.onLoadStart(this);
		}
		
	}

	void onLoadStart(LoadStartEvent loadStartEvent);

}
