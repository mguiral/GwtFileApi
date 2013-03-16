package gwt.html5.file.client;

import gwt.html5.file.dom.FileListElement;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FileUpload;

public class MultipleFileUpload extends FileUpload{

	public interface MultiFileSelectedHandler {
		void onFileSelected(FileListElement fileList);
	}
	

	public MultipleFileUpload() {
		super();
		getElement().setAttribute("multiple", "");
	}
	
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		throw new UnsupportedOperationException(
				"Please use addChangeHandler(MultiFileSelectedHandler handler) method instead");
	}

	public void addChangeHandler(final MultiFileSelectedHandler handler) {
		if (handler == null)
			throw new IllegalStateException("handler must not be null");
		addDomHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				FileListElement fileList = getFileList(event.getNativeEvent());
				handler.onFileSelected(fileList);
			}
		}, ChangeEvent.getType());
	}

	private native FileListElement getFileList(JavaScriptObject event)/*-{
		return event.target.files;
	}-*/;

}
