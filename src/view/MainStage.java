package view;

import static util.ImgUtil.GARAGE_ICON;
import static util.ImgUtil.loadImg;

import app.App;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Garage;
import util.DataSaver;
import util.LightWork;

/**
 * Contains the LoginPane where the user is allowed to enter in his/her credentials.  
 * @author Michael Campos
 */
public class MainStage extends Stage {
	
	public MainStage(Garage garage) {
		setTitle(App.TITLE);
		getIcons().add(loadImg(GARAGE_ICON));
		setScene(new Scene(new LoginPane(garage), LoginPane.WIDTH, LoginPane.HEIGHT));
		setOnCloseRequest(e -> {
			DataSaver.writeObject(garage, LightWork.GARAGE_SRC);
		});
	}
}
