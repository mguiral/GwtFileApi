package gwt.html5.file.client;

import gwt.html5.file.client.handler.AbortEventHandler;
import gwt.html5.file.client.handler.ErrorEventHandler;
import gwt.html5.file.client.handler.LoadEndEventHandler;
import gwt.html5.file.client.handler.LoadEventHandler;
import gwt.html5.file.client.handler.ProgressEventHandler;
import gwt.html5.file.client.handler.LoadEndEventHandler.LoadEndEvent;
import gwt.html5.file.dom.FileElement;
import gwt.html5.file.dom.FileListElement;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class FileTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		final MultipleFileUpload fileUpload = new MultipleFileUpload();
		final FileReader fileReader = new FileReader();
		final SimplePanel simplePanel = new SimplePanel();
		simplePanel.getElement().getStyle().setHeight(20, Unit.PX);
		simplePanel.getElement().getStyle().setBackgroundColor("#DD6666");
		simplePanel.getElement().getStyle().setWidth(0, Unit.PCT);
		final Button cancelRead = new Button("Cancel", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				fileReader.abort();
			}
		});
		fileReader.addAbortEventHandler(new AbortEventHandler() {
			@Override
			public void onAbort(AbortEvent abortEvent) {
				Window.alert("File read cancelled");
			}
		});
		fileReader.addProgressEventHandler(new ProgressEventHandler() {
			
			@Override
			public void onProgress(ProgressEvent progressEvent) {
				if (progressEvent.isLengthComputable()) {
					int round = (int) Math.round(((double) progressEvent.getLoaded() / (double) progressEvent.getTotal()) * 100);
					if (round < 100) {
						simplePanel.getElement().getStyle().setWidth(round, Unit.PCT);
						simplePanel.getElement().setInnerHTML(round + "%");
					}
				}
			}
		});
		fileReader.addErrorEventHandler(new ErrorEventHandler() {
			
			@Override
			public void onError(ErrorEvent errorEvent) {
				Window.alert("Error");
			}
		});
		fileReader.addLoadEventHandler(new LoadEventHandler() {
			
			@Override
			public void onLoad(LoaEvent loaEvent) {
				simplePanel.getElement().getStyle().setWidth(100, Unit.PCT);
				simplePanel.getElement().setInnerHTML("100%");
				simplePanel.getElement().getStyle().setBackgroundColor("#66DD66");
			}
		});
		fileUpload.addChangeHandler(new MultipleFileUpload.MultiFileSelectedHandler() {
			@Override
			public void onFileSelected(FileListElement fileList) {
				for (int i = 0; i < fileList.getLength(); i++) {
					FileElement file = fileList.getItem(i);
					fileReader.readFile(file);
				}
			}
		});
		RootPanel.get().add(fileUpload);
		RootPanel.get().add(cancelRead);
		RootPanel.get().add(simplePanel);
	}

}
