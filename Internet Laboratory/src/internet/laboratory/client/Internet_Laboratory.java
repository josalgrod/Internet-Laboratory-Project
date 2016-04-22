package internet.laboratory.client;

import java.util.Date;
import java.util.GregorianCalendar;

import internet.laboratory.shared.Event;
import internet.laboratory.shared.TypeEvent;

import com.gargoylesoftware.htmlunit.StorageHolder.Type;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Internet_Laboratory implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	
	private static ListBox listEvents;
	
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		RootPanel.get("errorLabelContainer").add(errorLabel);

		FlowPanel rightPanel = new FlowPanel();
		rootPanel.add(rightPanel, 0, 100);
		rightPanel.setSize("154px", "400px");

		Button btnCreate = new Button("Create Event");
		rightPanel.add(btnCreate);
		btnCreate.setWidth("153px");
		btnCreate.addDoubleClickHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Event e = new Event("Alvaro", new Date(),
						"Tu casa", "telefono", "alvaro@gmail.com", 18.0, 20,
						TypeEvent.OTHER, "Hola", true, 18, "soy el mejor");
				listEvents.addItem(e.toString());
			}
		});

		Button btnUpdate = new Button("Update Event");
		rightPanel.add(btnUpdate);
		btnUpdate.setWidth("153px");

		Button btnDelete = new Button("Delete Event");
		rightPanel.add(btnDelete);
		btnDelete.setWidth("153px");

		AbsolutePanel topPanel = new AbsolutePanel();
		rootPanel.add(topPanel, 0, 0);
		topPanel.setSize("685px", "100px");

		Label lbTitle = new Label("Party&Go");
		lbTitle.setStyleName("h1");
		topPanel.add(lbTitle, 264, 0);

		Hyperlink logout = new Hyperlink("Logout", false, "newHistoryToken");
		topPanel.add(logout, 636, 10);

		Label lbNameUser = new Label("Name");
		topPanel.add(lbNameUser, 577, 61);

		Image image = new Image((String) null);
		topPanel.add(image, 511, 52);
		image.setSize("47px", "38px");

		Button btnSettings = new Button("");
		topPanel.add(btnSettings, 636, 61);
		btnSettings.setSize("16px", "18px");

		TextBox txtbxSearch = new TextBox();
		txtbxSearch.setText("search");
		topPanel.add(txtbxSearch, 266, 54);
		txtbxSearch.setSize("142px", "18px");

		AbsolutePanel leftPanel = new AbsolutePanel();
		rootPanel.add(leftPanel, 513, 100);
		leftPanel.setSize("172px", "400px");

		HTML googleMaps = new HTML("Google Maps", true);
		leftPanel.add(googleMaps, 10, 31);
		googleMaps.setSize("152px", "121px");

		AbsolutePanel centerPanel = new AbsolutePanel();
		rootPanel.add(centerPanel, 153, 100);
		centerPanel.setSize("361px", "400px");

		listEvents = new ListBox();
		centerPanel.add(listEvents, 0, 30);
		listEvents.setSize("361px", "370px");
		listEvents.setVisibleItemCount(5);

		Label lblNewLabel = new Label("Your events");
		lblNewLabel.setStyleName("h2");
		centerPanel.add(lblNewLabel, 126, 0);
		lblNewLabel.setSize("107px", "30px");

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
	}
}
