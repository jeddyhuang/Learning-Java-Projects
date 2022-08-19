/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author domdavid
 */
public class MainFrame extends JPanel implements ActionListener, MouseListener, KeyListener {

    public static Token token;
    public ArrayList<Obstacle> pillars = new ArrayList<Obstacle>();
    private Ellipse2D.Float ellipse = new Ellipse2D.Float();
    private double esize;
    private Logic log  = new Logic();
    private double maxSize = 0;
    private BufferedImage bg;
    private int tokenLift = 0;
    private boolean start = false;
    private int score = 0;
    private boolean neutral = true;
    private int neutral_counter = 4;
    private boolean initialize = true;
    Random rnd;

    Timer timer;

    ActionListener updateProBar;

    public MainFrame(String fileName) {

        String src = new File("").getAbsolutePath() + "/src/";
 //Create a list of obstacles.
         ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

        //instantiate obstacles by supplying the image for a pillar and specifying
        //how to place the pillar either as a top pillar or bottom pillar.
        obstacles.add(new Obstacle("pillar.png", false));
        obstacles.add(new Obstacle("pillar.png", false));
        obstacles.add(new Obstacle("pillar.png", false));
        obstacles.add(new Obstacle("pillar_s_down.png", true));
        obstacles.add(new Obstacle("pillar_s_down.png", true));
        obstacles.add(new Obstacle("pillar_s_down.png", true));

        //add the pillars to the mainframe
        placePillars(obstacles);
        try {
            //
            bg = ImageIO.read(new File(src + fileName));
        } catch (Exception e) {
            System.out.println("background file not found");
        }
        setXY(20 * Math.random(), 200, 200);
        timer = new Timer(20, this);

        timer.setInitialDelay(190);
        timer.start();
        this.addMouseListener(this);
        this.addKeyListener(this);

        rnd = new Random(34);

    }

    public MainFrame(Token token) {
        this.token = token;
        setXY(20 * Math.random(), 200, 200);
       
        timer = new Timer(33, this);
        timer.setInitialDelay(190);
        timer.start();
    }

    /**
     * This allows a user to set their own token instead of the default bird.
     *
     * @param token a token object to be the character
     * @return none
     */
    public void setToken(Token token) {
        this.token = token;
    }

    public void placePillars(ArrayList<Obstacle> pillar) {

        int x1 = 500, x2 = 500, y1 = 0, y2 = 0;
        int cntr1 = 0;
        int cntr2 = 0;
        int i = 0;
        
        
        for (Obstacle o : pillars) {
            if (o.top) {
                y1 = rnd.nextInt(80) + 100;
                o.setPosition(pillars.get(i - 3).getX(), -y1);
                cntr1++;

            } else {

                y2 = 693 - o.getHeight() + rnd.nextInt(90);
                x2 += o.getWidth() * 2 + (int) (rnd.nextInt(120));
                o.setPosition(x2, y2);
                cntr2++;
            }
            i++;
        }
        pillars = pillar;

    }

    public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if (icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if (nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }

    public void setXY(double size, int w, int h) {
        esize = size;
        ellipse.setFrame(10, 10, size, size);
    }

    public void reset(int w, int h) {
        maxSize = w / 10;
        setXY(maxSize * Math.random(), w, h);
    }

    public void step(int w, int h) {
        esize++;
        if (esize > maxSize) {
            setXY(1, w, h);
        } else {
            ellipse.setFrame(ellipse.getX(), ellipse.getY(), esize, esize);
        }
    }
    int offset = 5;

    public void render(int w, int h, Graphics2D g2) {
        if (bg != null) {
            g2.drawImage(bg, 0, 0, null);
        }

        if (token != null) {
            if (tokenLift > 0 && start) {
                token.setPosition(token.getX(), token.getY() - token.getPowerLevel() * 1 - 3);
                g2.drawImage(token.tokenUp.getImage(), token.getX(), token.getY(), null);

            } else if (start) {
                token.setPosition(token.getX(), (int) (token.getY() + offset));
                g2.drawImage(token.tokenDown.getImage(), token.getX(), token.getY(), null);
            } else {
                int offset = neutral ? neutral_counter : -neutral_counter;
                neutral = neutral_counter <= 0 ? !neutral : neutral;
                if (neutral_counter <= 0) {
                    neutral_counter = 10;
                }
                neutral_counter--;

                g2.drawImage(token.tokenImage.getImage(), token.getX(), token.getY() + offset, null);

            }
        }
        if (pillars != null) {
            for (Obstacle e : pillars) {
                g2.drawImage(e.tokenImage.getImage(), e.getX(), e.getY(), null);
                e.setPosition(e.getX() - 5, e.getY());
            }
        }
        if (start && log.collided(pillars, token)) {
            timer.stop();
            start = false;
            token.setPosition(250 - token.getWidth(), 200);

        }

        if (start) {
            score = log.updateScore(pillars, score);
        }

        g2.setColor(Color.white);
        g2.setFont(new Font("OCR A Std", Font.BOLD, 50));
        g2.drawString("" + score, 245, 200);

        if (tokenLift > 0) {
            tokenLift--;
        }

    }

    public static int x1 = 0, y1 = 0, x2 = 23, y2 = 24;

    public void paint(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);
        Dimension size = getSize();

        if (initialize) {
            reset(size.width, size.height);
            initialize = false;
        }
        this.step(size.width, size.height);
        render(size.width, size.height, g2);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * Method to setup the frame object.
     *
     * @param none
     * @return none
     */
    public void setup() {
        JFrame frame = new JFrame("Flappy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.setSize(500, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        if (!start) {
            System.out.println("Starting");
            start = true;
            score = 0;
            timer.start();
            placePillars(pillars);
        } else {
            tokenLift = 15 * token.getPowerLevel();

        }
        this.requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38) {
            tokenLift += 1;
            token.setPosition(token.getX(), token.getY() - 10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       /* if (e.getKeyCode() == 38) {
            tokenLift += 15;
            token.setPosition(token.getX(), token.getY() - 10);
        }*/
       // System.out.println(e.getKeyCode());

    }
    
        @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
}
