package gwt.html5.file.dom;

import com.google.gwt.core.client.JavaScriptObject;

public class FileListElement extends JavaScriptObject {

	protected FileListElement() {
	}
	
	public final native FileElement getItem(int index)/*-{
		return this.item(index);
	}-*/;

	public final native int getLength()/*-{
		return this.length;
	}-*/;
	
}
