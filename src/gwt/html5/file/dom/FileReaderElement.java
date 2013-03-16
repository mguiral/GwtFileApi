package gwt.html5.file.dom;

import com.google.gwt.core.client.JavaScriptObject;

public class FileReaderElement extends JavaScriptObject{
	protected FileReaderElement() {
	}
	
	public static native FileReaderElement instance()/*-{
		return new FileReader();
	}-*/;


	public final native void readAsArrayBuffer(BlobElement blob)/*-{
		this.readAsArrayBuffer(blob);
	}-*/;

	public final native void readAsText(BlobElement blob)/*-{
		this.readAsText(blob);
	}-*/;

	public final native void readAsText(BlobElement blob, String encoding)/*-{
		this.readAsText(blob, encoding);
	}-*/;

	public final native void readAsBinaryString(BlobElement blob)/*-{
		this.readAsBinaryString(blob);
	}-*/;
	
	public final native void readAsDataURL(BlobElement blob)/*-{
		this.readAsDataURL(blob);
	}-*/;

	public final native void abort()/*-{
		this.abort();
	}-*/;

	public final native int getReadyState()/*-{
		return this.readyState;
	}-*/;

	
}