package util;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Constant {
	public static final Color BACKGROUND_COLOR = new Color(254, 250, 224);
	public static final Color CYAN_1 = new Color(206, 253, 253);
	public static final Color CYAN_2 = new Color(164, 237, 237);
	public static final Color CYAN_3 = new Color(117, 215, 221);
	public static final Color CYAN_4 = new Color(74, 192, 208);
	public static final Color CYAN_5 = new Color(53, 164, 188);
	public static final Color CYAN_6 = new Color(16, 96, 141);
	public static final Color CYAN_7 = new Color(8, 65, 107);
	public static final Font BOLD_22_TITLE = new Font("Tahoma", Font.BOLD, 22);
	public static final Font BOLD_16 = new Font("Tahoma", Font.BOLD, 16);

	public static final int PORT = 8603;
	
	public static LocalDate convertToLocalDateViaInstant(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

//	convert LocalDate to Date
	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
