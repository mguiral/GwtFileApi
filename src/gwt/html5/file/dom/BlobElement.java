package gwt.html5.file.dom;

import com.google.gwt.core.client.JavaScriptObject;

public class BlobElement extends JavaScriptObject {

	protected BlobElement() {
	}
	
	public final native int getSize()/*-{
		return this.size;
	}-*/;

	public final native String getType()/*-{
		return this.type;
	}-*/;

	public final native BlobElement slice(int start, int end, String contentType)/*-{
		return this.slice(start, end, contentType);
	}-*/;

	public final native void close()/*-{
		this.close();
	}-*/;

}
