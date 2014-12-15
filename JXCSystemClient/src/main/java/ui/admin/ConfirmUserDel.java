package ui.admin;

import java.awt.event.ActionEvent;

import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import vo.UserVO;

public class ConfirmUserDel extends ConfirmUserPanel {

	public ConfirmUserDel(MyFrame frame, String url, AdminAllUIController controller, UserVO user, String type) {
		super(frame, url, controller, user, type);
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(270, 300);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == forwardButton) {
			switch (userblService.delUser_up(user)) {
			case 0:
//				adminAllUIController.setResult(type);
				break;
			}
		}
	}
}
