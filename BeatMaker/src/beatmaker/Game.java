package beatmaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	// 게임에 필요한 이미지 파일을 불러오기 위한 변수 선언
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("/Images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("/Images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("/Images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteSP1Image = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteSP2Image = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image keyPadSP1Image = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image keyPadSP2Image = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	private boolean gameMaker = true;

	ArrayList<Note> noteList = new ArrayList<Note>();

	// 생성자 
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);

	}
	// 게임 화면에 출력될 화면 생성을 위한 method 생성
	public void screenDraw(Graphics2D g) {

		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSP1Image, 540, 30, null);
		g.drawImage(noteRouteSP2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);

		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);

		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("/Images/miss.png")).getImage();
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26)) ;
		g.setColor(Color.BLUE);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.drawImage(blueFlareImage, 390, 430, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSP1Image, 540, 580, null);
		g.drawImage(keyPadSP2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);

	}
	
	// 키보드를 입력 시 이미지 변경 및 사운드 출력
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " S");
		}
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " D");
		}
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " F");
		}
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	}

	public void pressSP() {
		judge("SP");
		noteRouteSP1Image = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		noteRouteSP2Image = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		keyPadSP1Image = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		keyPadSP2Image = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		new Music("drumBig1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " SP");
		}
	}

	public void releaseSP() {
		noteRouteSP1Image = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		noteRouteSP2Image = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		keyPadSP1Image = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
		keyPadSP2Image = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " J");
		}
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " K");
		}
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("/Images/keypad.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " L");
		}
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("/Images/keypadbasic.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(titleName);
	}

	public void close() {  // 실행되는 음악을 종료하는 method
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {  // 게임에 출력되는 note를 만드는 method
		Beat[] beats = null;
		if (titleName.equals("Hope") && difficulty.equals("Easy")) {
			int startTime = 3000 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(startTime, "Space"),

			};
		} else if (titleName.equals("CandyLand") && difficulty.equals("Easy")) {
			int startTime = 2900 - Main.REACH_TIME * 1000;
			int gap = 235;
			beats = new Beat[] { new Beat(startTime, "S"), new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "L"), new Beat(startTime + gap * 6, "K"),
					new Beat(startTime + gap * 8, "F"), new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "J"), new Beat(startTime + gap * 14, "K"),
					new Beat(startTime + gap * 16, "S"), new Beat(startTime + gap * 18, "L"),
					new Beat(startTime + gap * 20, "D"), new Beat(startTime + gap * 22, "K"),
					new Beat(startTime + gap * 24, "F"), new Beat(startTime + gap * 26, "J"),
					new Beat(startTime + gap * 28, "S"), new Beat(startTime + gap * 30, "L"),
					new Beat(startTime + gap * 32, "D"), new Beat(startTime + gap * 34, "K"),
					new Beat(startTime + gap * 36, "S"), new Beat(startTime + gap * 38, "L"),
					new Beat(startTime + gap * 40, "F"), new Beat(startTime + gap * 42, "J"),
					new Beat(startTime + gap * 44, "D"), new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "K"), new Beat(startTime + gap * 50, "K"),
					new Beat(startTime + gap * 52, "S"), new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 56, "L"), new Beat(startTime + gap * 58, "L"),
					new Beat(startTime + gap * 60, "F"), new Beat(startTime + gap * 62, "F"),
					new Beat(startTime + gap * 64, "SP"), new Beat(startTime + gap * 66, "D"),
					new Beat(startTime + gap * 68, "K"), new Beat(startTime + gap * 70, "S"),
					new Beat(startTime + gap * 72, "L"), new Beat(startTime + gap * 74, "F"),
					new Beat(startTime + gap * 76, "J"), new Beat(startTime + gap * 78, "S"),
					new Beat(startTime + gap * 80, "F"), new Beat(startTime + gap * 82, "L"),
					new Beat(startTime + gap * 84, "J"), new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "K"), new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 92, "S"), new Beat(startTime + gap * 94, "J"),
					new Beat(startTime + gap * 96, "F"), new Beat(startTime + gap * 98, "F"),
					new Beat(startTime + gap * 100, "K"), new Beat(startTime + gap * 102, "K"),
					new Beat(startTime + gap * 104, "S"), new Beat(startTime + gap * 106, "S"),
					new Beat(startTime + gap * 108, "L"), new Beat(startTime + gap * 110, "L"),
					new Beat(startTime + gap * 112, "D"), new Beat(startTime + gap * 114, "D"),
					new Beat(startTime + gap * 116, "J"), new Beat(startTime + gap * 118, "J"),
					new Beat(startTime + gap * 120, "L"), new Beat(startTime + gap * 122, "L"),
					new Beat(startTime + gap * 124, "F"), new Beat(startTime + gap * 126, "F"),
					new Beat(startTime + gap * 128, "SP"), // 여기서부터 변주

					new Beat(startTime + gap * 129, "S"), new Beat(startTime + gap * 130, "D"),
					new Beat(startTime + gap * 131, "F"), new Beat(startTime + gap * 134, "S"),
					new Beat(startTime + gap * 137, "F"), new Beat(startTime + gap * 138, "D"),
					new Beat(startTime + gap * 139, "F"), new Beat(startTime + gap * 140, "S"),
					new Beat(startTime + gap * 142, "F"),

					new Beat(startTime + gap * 145, "L"), new Beat(startTime + gap * 146, "K"),
					new Beat(startTime + gap * 147, "J"), new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 153, "J"), new Beat(startTime + gap * 154, "K"),
					new Beat(startTime + gap * 155, "J"), new Beat(startTime + gap * 156, "L"),
					new Beat(startTime + gap * 158, "J"),

					new Beat(startTime + gap * 159, "S"), new Beat(startTime + gap * 161, "D"),
					new Beat(startTime + gap * 163, "L"), new Beat(startTime + gap * 165, "K"),
					new Beat(startTime + gap * 167, "F"), new Beat(startTime + gap * 169, "D"),
					new Beat(startTime + gap * 171, "J"), new Beat(startTime + gap * 173, "K"),
					new Beat(startTime + gap * 175, "S"), new Beat(startTime + gap * 177, "L"),
					new Beat(startTime + gap * 179, "D"), new Beat(startTime + gap * 181, "K"),
					new Beat(startTime + gap * 183, "F"), new Beat(startTime + gap * 185, "J"),
					new Beat(startTime + gap * 187, "S"), new Beat(startTime + gap * 189, "L"),
					new Beat(startTime + gap * 191, "D"), new Beat(startTime + gap * 193, "K"),
					new Beat(startTime + gap * 195, "S"), new Beat(startTime + gap * 197, "L"),
					new Beat(startTime + gap * 199, "F"),

					new Beat(startTime + gap * 202, "S"), new Beat(startTime + gap * 204, "D"),
					new Beat(startTime + gap * 206, "L"), new Beat(startTime + gap * 208, "K"),
					new Beat(startTime + gap * 210, "F"), new Beat(startTime + gap * 212, "D"),
					new Beat(startTime + gap * 214, "J"), new Beat(startTime + gap * 216, "K"),
					new Beat(startTime + gap * 218, "S"), new Beat(startTime + gap * 220, "L"),
					new Beat(startTime + gap * 222, "D"), new Beat(startTime + gap * 224, "K"),
					new Beat(startTime + gap * 226, "F"), new Beat(startTime + gap * 228, "J"),
					new Beat(startTime + gap * 230, "S"), new Beat(startTime + gap * 232, "L"),
					new Beat(startTime + gap * 234, "D"), new Beat(startTime + gap * 236, "K"),
					new Beat(startTime + gap * 238, "S"), new Beat(startTime + gap * 240, "L"),
					new Beat(startTime + gap * 242, "F"),

					new Beat(startTime + gap * 244, "S"), new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 248, "L"), new Beat(startTime + gap * 250, "K"),
					new Beat(startTime + gap * 252, "F"), new Beat(startTime + gap * 254, "D"),

					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 258, "F"), new Beat(startTime + gap * 259, "D"),
					new Beat(startTime + gap * 260, "L"), new Beat(startTime + gap * 261, "K"),
					new Beat(startTime + gap * 262, "J"), new Beat(startTime + gap * 263, "S"),
					new Beat(startTime + gap * 264, "S"), new Beat(startTime + gap * 265, "D"),
					new Beat(startTime + gap * 266, "F"), new Beat(startTime + gap * 267, "D"),
					new Beat(startTime + gap * 268, "K"), new Beat(startTime + gap * 269, "F"),
					new Beat(startTime + gap * 269, "J"), new Beat(startTime + gap * 270, "D"),
					new Beat(startTime + gap * 270, "K"), new Beat(startTime + gap * 271, "S"),
					new Beat(startTime + gap * 271, "L"), new Beat(startTime + gap * 272, "D"),
					new Beat(startTime + gap * 273, "L"), new Beat(startTime + gap * 274, "F"),
					new Beat(startTime + gap * 275, "J"), new Beat(startTime + gap * 276, "D"),
					new Beat(startTime + gap * 277, "K"), new Beat(startTime + gap * 278, "SP"),
					new Beat(startTime + gap * 279, "L"), new Beat(startTime + gap * 280, "S"),
					new Beat(startTime + gap * 281, "J"), new Beat(startTime + gap * 282, "K"),
					new Beat(startTime + gap * 283, "L"), new Beat(startTime + gap * 284, "F"),
					new Beat(startTime + gap * 285, "S"), new Beat(startTime + gap * 286, "D"),
					new Beat(startTime + gap * 287, "S"), new Beat(startTime + gap * 288, "J"),
					new Beat(startTime + gap * 289, "F"), new Beat(startTime + gap * 290, "K"),
					new Beat(startTime + gap * 291, "L"), new Beat(startTime + gap * 292, "F"),
					new Beat(startTime + gap * 293, "F"), new Beat(startTime + gap * 294, "J"),
					new Beat(startTime + gap * 295, "J"), new Beat(startTime + gap * 296, "K"),
					new Beat(startTime + gap * 297, "L"), new Beat(startTime + gap * 298, "D"),
					new Beat(startTime + gap * 299, "S"), new Beat(startTime + gap * 300, "D"),
					new Beat(startTime + gap * 301, "D"), new Beat(startTime + gap * 302, "D"),
					new Beat(startTime + gap * 303, "D"), new Beat(startTime + gap * 304, "D"),
					new Beat(startTime + gap * 305, "D"), new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 307, "D"), new Beat(startTime + gap * 308, "D"),
					new Beat(startTime + gap * 309, "D"), new Beat(startTime + gap * 310, "D"),
					new Beat(startTime + gap * 311, "D"), new Beat(startTime + gap * 312, "D"),

					new Beat(startTime + gap * 313, "D"), new Beat(startTime + gap * 314, "D"),
					new Beat(startTime + gap * 315, "D"), new Beat(startTime + gap * 316, "D"),
					new Beat(startTime + gap * 317, "D"), new Beat(startTime + gap * 318, "D"),

					new Beat(startTime + gap * 319, "D"), new Beat(startTime + gap * 320, "D"),

					new Beat(startTime + gap * 321, "D"),

			};
		} else if (titleName.equals("Spectre") && difficulty.equals("Easy")) {
			int startTime = 2800 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(startTime, "Space"),

			};

		} else if (titleName.equals("Hope") && difficulty.equals("Hard")) {
			int startTime = 2800 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(startTime, "Space"),

			};

		} else if (titleName.equals("CandyLand") && difficulty.equals("Hard")) {
			int startTime = 2800 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(startTime, "Space"),

			};

		} else if (titleName.equals("Spectre") && difficulty.equals("Hard")) {
			int startTime = 2800 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(startTime, "Space"),

			};
		}

		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteMane());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	public void judgeEvent(String judge) {
		if (!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("/Images/flare.png")).getImage();
		}
		if (judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("/Images/miss.png")).getImage();
		}
		if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("/Images/good.png")).getImage();
		}
		if (judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("/Images/great.png")).getImage();
		}
		if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("/Images/perfect.png")).getImage();
		}
	}
}
