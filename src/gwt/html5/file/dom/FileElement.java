package gwt.html5.file.dom;

import java.sql.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class FileElement extends JavaScriptObject {

	protected FileElement() {
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

	public final native BlobElement slice(int start, int end)/*-{
		return this.slice(start, end);
	}-*/;

	public final native void close()/*-{
		this.close();
	}-*/;
	
	public final native String getName()/*-{
		return this.name;
	}-*/;

	public final native Date getLastModifiedDate()/*-{
		return this.lastModifiedDate;
	}-*/;


}
