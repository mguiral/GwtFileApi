package gwt.html5.file.client;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

import gwt.html5.file.client.handler.AbortEventHandler;
import gwt.html5.file.client.handler.ErrorEventHandler;
import gwt.html5.file.client.handler.LoadEndEventHandler;
import gwt.html5.file.client.handler.AbortEventHandler.AbortEvent;
import gwt.html5.file.client.handler.ErrorEventHandler.ErrorEvent;
import gwt.html5.file.client.handler.LoadEndEventHandler.LoadEndEvent;
import gwt.html5.file.client.handler.LoadEventHandler;
import gwt.html5.file.client.handler.LoadStartEventHandler;
import gwt.html5.file.client.handler.LoadStartEventHandler.LoadStartEvent;
import gwt.html5.file.client.handler.ProgressEventHandler;
import gwt.html5.file.client.handler.ProgressEventHandler.ProgressEvent;
import gwt.html5.file.dom.BlobElement;
import gwt.html5.file.dom.FileElement;
import gwt.html5.file.dom.FileReaderElement;

public class FileReader {

	public enum ReadyState {
		EMPTY, LOADING, DONE;
	}

	private final FileReaderElement readerElement;
	private final HandlerManager readerHandlerManager;

	public FileReader() {
		readerElement = FileReaderElement.instance();
		readerHandlerManager = new HandlerManager(this);
	}

	public void readAsArrayBuffer(BlobElement blob) {
		readerElement.readAsArrayBuffer(blob);
	}

	public void readAsText(BlobElement blob) {
		readerElement.readAsText(blob);
	}

	public void readAsBinaryString(BlobElement blob) {
		readerElement.readAsBinaryString(blob);
	}

	public void readAsText(BlobElement blob, String encoding) {
		readerElement.readAsText(blob, encoding);
	}

	public void readAsDataUrl(BlobElement blob) {
		readerElement.readAsDataURL(blob);
	}

	public void abort() {
		readerElement.abort();
	}

	private void fireEvent(Object event) {
		if (event instanceof GwtEvent<?>)
			readerHandlerManager.fireEvent((GwtEvent<?>) event);
	}

	public ReadyState getReadyState() {
		return ReadyState.values()[readerElement.getReadyState()];
	}

	public HandlerRegistration addLoadStartHandler(
			LoadStartEventHandler loadStartHandler) {
		addLoadStartEventListener();
		return readerHandlerManager.addHandler(LoadStartEvent.TYPE,
				loadStartHandler);
	}

	public HandlerRegistration addAbortEventHandler(AbortEventHandler handler) {
		addAbortEventListener();
		return readerHandlerManager.addHandler(AbortEvent.TYPE, handler);
	}

	public HandlerRegistration addErrorEventHandler(ErrorEventHandler handler) {
		addErrorEventListener();
		return readerHandlerManager.addHandler(ErrorEvent.TYPE, handler);
	}

	public HandlerRegistration addLoadEndEventHandler(
			LoadEndEventHandler handler) {
		HandlerRegistration handlerRegistration = readerHandlerManager
				.addHandler(LoadEndEvent.TYPE, handler);
		addLoadEndEventListener();
		return handlerRegistration;
	}

	public HandlerRegistration addLoadEventHandler(LoadEventHandler handler) {
		addLoadEventListener();
		return readerHandlerManager.addHandler(LoadEventHandler.LoaEvent.TYPE,
				handler);
	}

	public void readFile(FileElement file) {
		readFile(file, 0, file.getSize());
	}

	public void readFile(FileElement file, int start, int end) {
		final BlobElement slice = file.slice(start, end);
		this.readAsText(slice);
	}

	public HandlerRegistration addProgressEventHandler(
			ProgressEventHandler handler) {
		addProgressEventListener();
		return readerHandlerManager.addHandler(ProgressEvent.TYPE, handler);
	}

	private final native void addAbortEventListener()/*-{
		var readerElement = this.@gwt.html5.file.client.FileReader::readerElement;
		var reader = this;
		readerElement.onabort = function() {
			var event = @gwt.html5.file.client.handler.AbortEventHandler.AbortEvent::new()();
			reader.@gwt.html5.file.client.FileReader::fireEvent(Ljava/lang/Object;)(event);
		};
	}-*/;

	private final native void addErrorEventListener()/*-{
		var readerElement = this.@gwt.html5.file.client.FileReader::readerElement;
		var reader = this;
		readerElement.onerror = function() {
			var event = @gwt.html5.file.client.handler.ErrorEventHandler.ErrorEvent::new()();
			reader.@gwt.html5.file.client.FileReader::fireEvent(Ljava/lang/Object;)(event);
		};
	}-*/;

	private final native void addLoadEndEventListener()/*-{
		var readerElement = this.@gwt.html5.file.client.FileReader::readerElement;
		var reader = this;
		readerElement.onloadend = function(e) {
			var event = @gwt.html5.file.client.handler.LoadEndEventHandler.LoadEndEvent::new()();
			event.@gwt.html5.file.client.handler.LoadEndEventHandler.LoadEndEvent::setFileContent(Ljava/lang/String;)(e.target.result);
			reader.@gwt.html5.file.client.FileReader::fireEvent(Ljava/lang/Object;)(event);
		};
	}-*/;

	private final native void addLoadEventListener()/*-{
		var readerElement = this.@gwt.html5.file.client.FileReader::readerElement;
		var reader = this;
		readerElement.onload = function() {
			var event = @gwt.html5.file.client.handler.LoadEventHandler.LoaEvent::new()();
			reader.@gwt.html5.file.client.FileReader::fireEvent(Ljava/lang/Object;)(event);
		};
	}-*/;

	private final native void addProgressEventListener()/*-{
		var readerElement = this.@gwt.html5.file.client.FileReader::readerElement;
		var reader = this;
		readerElement.onprogress = function(e) {
			var event = @gwt.html5.file.client.handler.ProgressEventHandler.ProgressEvent::new()();
			event.@gwt.html5.file.client.handler.ProgressEventHandler.ProgressEvent::setLengthComputable(Z)(e.lengthComputable);
			event.@gwt.html5.file.client.handler.ProgressEventHandler.ProgressEvent::setLoaded(I)(e.loaded);
			event.@gwt.html5.file.client.handler.ProgressEventHandler.ProgressEvent::setTotal(I)(e.total);
			reader.@gwt.html5.file.client.FileReader::fireEvent(Ljava/lang/Object;)(event);
		};
	}-*/;

	private final native void addLoadStartEventListener()/*-{
		var readerElement = this.@gwt.html5.file.client.FileReader::readerElement;
		var reader = this;
		readerElement.onloadstart = function() {
			var event = @gwt.html5.file.client.handler.LoadStartEventHandler.LoadStartEvent::new()();
			reader.@gwt.html5.file.client.FileReader::fireEvent(Ljava/lang/Object;)(event);
		};
	}-*/;

}