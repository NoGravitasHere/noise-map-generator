import java.awt.*;
import javax.swing.*;

public class Map extends JPanel {

    private double[][] noise;
    private int width;
    private int height;
    private int scaling;

    public Map() {
        width = 50;
        height = 50;
        scaling = 10;

        JFrame mainFrame = new JFrame();
        Dimension d = new Dimension(width * scaling, height * scaling);
        this.setPreferredSize(d);
        mainFrame.add(this);

        // noise = Noise.generateRandomNoise(width, height);
        // noise = Noise.generateSimplexNoise(width, height);
        noise = Noise.generateSimplexNoiseC(width, height);

        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Map m = new Map();
        m.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        for (int i = 0; i < noise.length; i++) {
            for (int j = 0; j < noise[0].length; j++) {
                Color c = null;
                if(noise[i][j] < 0.2) {
                    c = Color.BLUE;
                } else if (noise[i][j] < 0.25){
                    c = Color.CYAN;
                } else if (noise[i][j] < 0.7){
                    c = Color.GREEN;
                } else {
                    c = Color.GRAY;
                }
                g.setColor(c);
                g.fillRect(i * scaling, j * scaling, i * scaling + scaling, j * scaling + scaling);
            }
        }
    }

}