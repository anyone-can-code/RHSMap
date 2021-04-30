package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Main extends JPanel implements Runnable, MouseMotionListener, MouseListener {
	int viewX = 0;
	int viewY = 0;
	int prevX = 0;
	int prevY = 0;
	ImageIcon map = new ImageIcon(getClass().getResource("/resources/map.png"));
	
	public Main() {
		setVisible(true);
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		new Thread(this).start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(map.getImage(), 0, 0, getWidth(), getHeight(), viewX, viewY, viewX + getWidth(), viewY + getHeight(), this);
	}
	
	public void run() {
		long a = System.currentTimeMillis();
		while(true) {
			if(viewX < 0) viewX++;
			else if(viewX > map.getIconWidth() - getWidth()) viewX--;
			if(viewY < 0) viewY++;
			else if(viewY > map.getIconHeight() - getHeight()) viewY--;
			
			repaint();
			
			if(a < 30) try {
				Thread.sleep(30 - a);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a = System.currentTimeMillis();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		viewX -= e.getX() - prevX;
		viewY -= e.getY() - prevY;
		prevX = e.getX();
		prevY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		prevX = e.getX();
		prevY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
