package view;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.*;

/**
 * GarageTableView is not a table view. It is a GridPane inside a ScrollPane. 
 * It requires a ParkingLot object to be constructed.
 * The public function refreshGrid requires a ParkingLot object, and refreshes the grid
 * Has a getter and setter for the ScrollPane 
 * @author chris
 *
 */

public class GarageTableView {
	/**
	 * @param container is the ScrollPane that holds the grid of spaces
	 * @param grid is a GridPane that will hold a 10xn array of Labels
	 * @param lot is a reference to the active parking lot
	 * @param root is a reference to the parent borderpane
	 */
	private ScrollPane container;
	private GridPane grid;
	private ParkingLot lot;
	private BorderPane root;
	private Timeline timeline;
	/**
	 * A constructor used in testing
	 * @param lot is the runtime instance of the parking lot used by the program
	 */
	public GarageTableView(ParkingLot lot) {
		this.lot = lot;
		this.generateLayout();
		container = new ScrollPane();
		
	}
	/**
	 * The constructor used by the program
	 * @param lot is the runtime instance of the parking lot used by the program
	 * @param root is the parent border pane
	 */
	public GarageTableView(ParkingLot lot, BorderPane root) {
		this.lot = lot;
		this.root = root;
		container = new ScrollPane();
		this.generateLayout();
		this.startTimer(this);
	}

	/**
	 * Generates a 10xn grid pane that represents the parking lot. 
	 * Occupied spaces are represented by yellow boxes and free spaces are represented by green boxes.
	 */
	private void generateLayout() {
		grid = new GridPane();
		ArrayList<Space> spaces = this.lot.getParkingLotArray();
		
		/*this loop creates a bunch of clickable labels that represent each spot in the garage. 
		 * If the spot is taken the button is made yellow and the license plate number is shown
		 * If the spot is free the button is made green and "Space is Empty" is shown
		 */
		for (int i = 0; i < spaces.size(); i++) {
			String info = new String ("" + i);
			Button label = new Button();
			if (spaces.get(i).getVehicleParked() != null) {
				info+= "\nSpace Occupied";
				label.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
				label.setMinHeight(50);
				label.setMinWidth(100);
				
			//	this.giveMouseOver(label, spaces.get(i));
			}
			else {
				info+= "\nSpace Empty";
				label.setBackground(new Background(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY, Insets.EMPTY)));
				label.setMinHeight(50);
				label.setMinWidth(100);
			//	this.giveMouseOver(label, spaces.get(i));
			}
			// 
			label.setText(info);
			int j = i;
			label.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if(spaces.get(j).getVehicleParked()!= null) {
					String message = spaces.get(j).getVehicleParked().toString();
					JOptionPane.showMessageDialog(null, message);
					}else {
						String message = spaces.get(j).toString();
						JOptionPane.showMessageDialog(null, message);
					}
				}
			});
			
			//The grid is 10xn 
			grid.add(label, i%10, i/10);
			GridPane.setMargin(label, new Insets(5, 0,0, 5));
			
		}
		container.setContent(grid);
	}
	/**
	 * start timer starts a timer that refreshes the grid every second
	 * @param view is this GarageView, the view passes itself into this function in the constructor
	 */
	private void startTimer(GarageTableView view) {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				view.refreshGrid();
			}	
		};
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO),
				new KeyFrame(Duration.seconds(1.0), handler));
		timeline.play();
	}
	/**
	 * @param label is taken in and given a tooltip derived from the space object
	 * @param space is taken in from the lot
	 */
	public void giveMouseOver (Label label, Space space) {
		Tooltip tooltip = new Tooltip();
		label.setTooltip(tooltip);
		tooltip.setText(space.toString());
	}
	/**
	 * can turn the yellow boxes into buttons that close and order
	 * @param label represents the space in the grid view
	 * @param space the actual space 
	 */
	@Deprecated
	public void giveCloseAction(Label label, Space space) {
		label.setOnMouseClicked(e->{
//			CheckOutPane checkout = new CheckOutPane(this.lot);
//			checkout.setGarageView(this);
//			this.root.setCenter(checkout);
		});
	}
	/**
	 * can turn the green boxes into buttons that start an order
	 * @param label represents the space in the grid view
	 * @param space the actual space 
	 */
	@Deprecated
	public void giveOpenAction(Label label, Space space) {
		label.setOnMouseClicked(e->{
//			CheckInPane checkin = new CheckInPane(this.lot);
//			checkin.setGarageView(this);
//			this.root.setCenter(checkin);
		});
	}
	/**
	 * Refreshed the layout
	 */
	public void refreshGrid() {
		this.generateLayout();
	}

	public ScrollPane getContainer() {
		return container;
	}

	public void setContainer(ScrollPane container) {
		this.container = container;
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}
	
	

}
