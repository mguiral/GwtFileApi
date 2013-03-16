package gwt.html5.file.client.handler;


import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public interface LoadEventHandler extends EventHandler{

	public static class LoaEvent extends GwtEvent<LoadEventHandler>{

		public static final Type<LoadEventHandler> TYPE = new Type<LoadEventHandler>();
		
		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<LoadEventHandler> getAssociatedType() {
			return TYPE;
		}

		@Override
		protected void dispatch(LoadEventHandler handler) {
			handler.onLoad(this);
		}
		
	}

	void onLoad(LoaEvent loaEvent);

	
}