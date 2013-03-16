package gwt.html5.file.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public interface ProgressEventHandler extends EventHandler {

	public static class ProgressEvent extends GwtEvent<ProgressEventHandler> {

		public static final Type<ProgressEventHandler> TYPE = new Type<ProgressEventHandler>();
		private int loaded;
		private int total;
		private boolean lengthComputable;

//		public ProgressEvent(int loaded, int total, boolean lengthComputable) {
//			this.loaded = loaded;
//			this.total = total;
//			this.lengthComputable = lengthComputable;
//		}
		
		public ProgressEvent() {
		}

		public int getLoaded() {
			return loaded;
		}

		public void setLoaded(int loaded) {
			this.loaded = loaded;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public boolean isLengthComputable() {
			return lengthComputable;
		}

		public void setLengthComputable(boolean lengthComputable) {
			this.lengthComputable = lengthComputable;
		}

		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<ProgressEventHandler> getAssociatedType() {
			return TYPE;
		}

		@Override
		protected void dispatch(ProgressEventHandler handler) {
			handler.onProgress(this);
		}

	}

	void onProgress(ProgressEvent progressEvent);

}
