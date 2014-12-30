package ui.setting.Button;

import ui.FatherPanel;
/**
 * 保存草稿单按钮
 * @author ZYC
 *
 */
public class SaveButton {
	public MyButton saveButton;
	public SaveButton(FatherPanel prePanel,int x,int y) {
		saveButton = new MyButton("Image/save.png", x, y, "Image/save_stop.png", "Image/save_stop");
		prePanel.add(saveButton);
	}
}
