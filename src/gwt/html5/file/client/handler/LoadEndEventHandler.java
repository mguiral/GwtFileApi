package gwt.html5.file.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public interface LoadEndEventHandler extends EventHandler{

	public static class LoadEndEvent extends GwtEvent<LoadEndEventHandler>{

		public static final Type<LoadEndEventHandler> TYPE = new Type<LoadEndEventHandler>();
		
		private String fileContent;
		
		public String getFileContent() {
			return fileContent;
		}

		public void setFileContent(String fileContent) {
			this.fileContent = fileContent;
		}

		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<LoadEndEventHandler> getAssociatedType() {
			return TYPE;
		}

		@Override
		protected void dispatch(LoadEndEventHandler handler) {
			handler.onLoadEnd(this);
		}
		
	}

	void onLoadEnd(LoadEndEvent loadEndEvent);
	
}
