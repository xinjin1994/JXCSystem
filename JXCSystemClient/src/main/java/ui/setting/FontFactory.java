package ui.setting;

import java.awt.Font;
/**
 * 程序中所有字体，字体工程
 * @author ZYC
 *
 */
public class FontFactory {
	public Font font;
	public FontFactory(int i){
		font = new Font("微软雅黑", Font.PLAIN, i);
	}
}
