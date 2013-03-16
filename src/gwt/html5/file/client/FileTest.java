package gwt.html5.file.client;

import gwt.html5.file.client.handler.LoadEndEventHandler;
import gwt.html5.file.dom.FileElement;
import gwt.html5.file.dom.FileListElement;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class FileTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		MultipleFileUpload fileUpload = new MultipleFileUpload();
		fileUpload.addChangeHandler(new MultipleFileUpload.MultiFileSelectedHandler() {
			
			@Override
			public void onFileSelected(FileListElement fileList) {
				for (int i = 0; i < fileList.getLength(); i++) {
					FileElement file = fileList.getItem(i);
					FileReader fr = new FileReader();
					fr.readFile(file, new LoadEndEventHandler() {
						@Override
						public void onLoadEnd(LoadEndEvent loadEndEvent) {
							RootPanel.get().add(new Label(loadEndEvent.getFileContent()));
						}
					});
				}
			}
		});
		RootPanel.get().add(fileUpload);
	}

}
