package hellofx;

import org.curiousworks.BlueMarble;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueMarbleController {

	@FXML
	private ImageView image;

	@FXML
	private DatePicker datePicker;

	String getStringValueFromDatePicker() {

		int day = datePicker.getValue().getDayOfMonth();
		int month = datePicker.getValue().getMonthValue();
		int year = datePicker.getValue().getYear();

		String dayToString = "";
		if (day < 10)
			dayToString = "-0" + Integer.toString(day);
		else
			dayToString = "-" + Integer.toString(day);
		System.out.println(dayToString);
		String monthToString = "";
		if (month < 10)
			monthToString = "-0" + Integer.toString(month);
		else
			monthToString = "-" + Integer.toString(month);
		System.out.println(monthToString);
		return year + monthToString + "-" + dayToString;
	}

	@FXML
	void updateDate(ActionEvent event) throws Throwable {

		BlueMarble blueMarble = new BlueMarble();
		blueMarble.setDate(getStringValueFromDatePicker());
		if (datePicker.getValue().getMonthValue() > 7 && datePicker.getValue().getYear() == 2019) {
			throw new Exception("Not valid date");
		}

		image.setImage(new Image(blueMarble.getImage()));
	}

	@FXML
	void viewEnhancedImage(ActionEvent event) {

		BlueMarble blueMarble = new BlueMarble();
		blueMarble.setDate(getStringValueFromDatePicker());

		if (datePicker.getValue().getMonthValue() > 7 && datePicker.getValue().getYear() >= 2018) {

			blueMarble.setEnhanced(false);
			
		} else {

			blueMarble.setEnhanced(true);
			image.setImage(new Image(blueMarble.getImage()));
		}
	}

	@FXML
	void convertImageToBlackAndWhite(ActionEvent event) {
		ColorAdjust colorAdjust = new ColorAdjust();
		colorAdjust.setSaturation(-1);
		image.setEffect(colorAdjust);
	}
}
