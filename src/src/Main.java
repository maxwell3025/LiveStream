package src;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(1080,720);
		for(;;){
			game.update();
		}
	}

}
