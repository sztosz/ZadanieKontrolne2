/**
 * Created by Bartosz Nowak on 2015-01-04.
 */

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ZadanieKontrolne2 extends Applet implements ActionListener {

    int width, height;

    Button clickMeButton;
    Button dontClickMeButton;
    Button showImage;
    Button drawOval;
    Button drawPolygon;
    Image image;
    Boolean showImageSwitch = false;
    Boolean drawOvalSwitch = false;
    Boolean drawPolygonSwitch = false;
    Label label;

    public void init() {
        width = getSize().width;
        height = getSize().height;
        setLayout(new FlowLayout());

        clickMeButton = new Button("Click me!");
        dontClickMeButton = new Button("DO NOT click me!");
        showImage = new Button("Show Image");
        drawOval = new Button("Draw Oval");
        drawPolygon = new Button("Draw Polygon");
        label = new Label("");

        clickMeButton.addActionListener(this);
        dontClickMeButton.addActionListener(this);
        showImage.addActionListener(this);
        drawOval.addActionListener(this);
        drawPolygon.addActionListener(this);

        try {
            URL picture = new URL(getDocumentBase(), "img.png");
            image = ImageIO.read(picture);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(clickMeButton);
        add(dontClickMeButton);
        add(showImage);
        add(drawOval);
        add(drawPolygon);
        add(label);

    }


    public void paint(Graphics graphics) {
        if (showImageSwitch) {
            graphics.drawImage(image, 100, 100, this);
        }
        if (drawOvalSwitch) {
            graphics.setColor(Color.red);
            graphics.drawOval(200, 100, 20, 30);
        }
        if (drawPolygonSwitch) {
            graphics.setColor(Color.green);
            int x[] = {50, 50, 75, 100, 100, 50};
            int y[] = {50, 100, 125, 100, 50, 50};
            graphics.drawPolygon(x, y, 6);
        }
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == clickMeButton) {
            clickMeButton.setLabel("Thank You");
            label.setText("THANK YOU");
            repaint();
        } else if (event.getSource() == dontClickMeButton) {
            remove(clickMeButton);
            setBackground(Color.red);
            dontClickMeButton.setLabel("WHAT DID YOU DO?");
        } else if (event.getSource() == showImage) {
            showImageSwitch = true;
            repaint();
        } else if (event.getSource() == drawOval) {
            drawOvalSwitch = true;
            repaint();
        } else if (event.getSource() == drawPolygon) {
            drawPolygonSwitch = true;
            repaint();
        }


    }
}
