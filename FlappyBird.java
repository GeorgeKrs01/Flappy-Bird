import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlappyBird extends JPanel implements ActionListener {
    int boardWidth = 360;
    int boardHeight = 640;

    //images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    //Bird
    int birdX = boardWidth / 8;
    int birdY = boardHeight / 2;
    int birdWidth = 34;
    int birdHeight = 24;



    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img){
            this.img = img;
        }
    }

    //game logic
    Bird bird;
    int velocityY = -6;

    Timer gameLoop;

    FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
//        setBackground(Color.CYAN);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./images/flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./images/flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./images/toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./images/bottompipe.png")).getImage();

        //bird
        bird = new Bird(birdImg);

        //game timer
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
//        System.out.println("draw");
        //backfround
        g.drawImage(backgroundImg, 0,0,boardWidth,boardHeight,null);

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }

    public void move() {
        //bird
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }


}
