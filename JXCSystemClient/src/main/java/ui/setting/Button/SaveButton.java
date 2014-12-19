package ui.setting.Button;

import ui.FatherPanel;

public class SaveButton {
	MyButton saveButton;
	public SaveButton(FatherPanel prePanel) {
		saveButton = new MyButton("Image/save.png", 736, 493, "Image/save_stop.png", "Image/save_stop");
		prePanel.add(saveButton);
	}
}
