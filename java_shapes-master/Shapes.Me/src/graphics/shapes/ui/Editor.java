package graphics.shapes.ui;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;



public class Editor extends JFrame
{
	ShapesView sview;
	SCollection model;
	
	private static final long serialVersionUID=0;
	
	
	public Editor()
	{	
		super("Recon x Jeff");

		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				System.exit(0);
			}
		});
		
		this.buildModel();
		
		this.sview = new ShapesView(this.model);
		this.sview.setPreferredSize(new Dimension(1000,1000));
		this.getContentPane().add(this.sview, BorderLayout.CENTER);
		
		MenuBar menu = new MenuBar();
		menu.menu(this);
	}

	
	private void buildModel()
	{
		this.model = new SCollection();
		this.model.addAttributes(new SelectionAttributes());
		
		/*SRectangle r = new SRectangle(new Point(100,100),200,300);
		r.addAttributes(new ColorAttributes(true,false,Color.BLUE,Color.BLUE));
		r.addAttributes(new SelectionAttributes());
		this.model.add(r);
		
		SCircle c = new SCircle(new Point(500,500),100);
		c.addAttributes(new ColorAttributes(true,true,Color.RED,Color.BLUE));
		c.addAttributes(new SelectionAttributes());
		this.model.add(c);
		
		SText t= new SText(new Point(500,500),"hello");
		t.addAttributes(new ColorAttributes(true,true,Color.YELLOW,Color.BLUE));
		t.addAttributes(new FontAttributes());
		t.addAttributes(new SelectionAttributes());
		this.model.add(t);
		
		SCollection sc = new SCollection();
		sc.addAttributes(new SelectionAttributes());
		r= new SRectangle(new Point(200,300),300,300);
		r.addAttributes(new ColorAttributes(true,true,Color.MAGENTA,Color.YELLOW));
		r.addAttributes(new SelectionAttributes());
		sc.add(r);
		c = new SCircle(new Point(750,500),200);
		c.addAttributes(new ColorAttributes(false,true,Color.BLUE,Color.DARK_GRAY));
		c.addAttributes(new SelectionAttributes());
		sc.add(c);
		this.model.add(sc);*/
	}
	
	/*private void buildModel() {
		
		this.model = new SCollection();
		
		SRectangle r = new SRectangle(new Point(10,10),50,100);
		r.addAttributes(new ColorAttributes(false,true,Color.BLUE,Color.RED));
		
		SRectangle r2 = new SRectangle(new Point(200,200),100,50);
		r2.addAttributes(new ColorAttributes(true,true,Color.RED,Color.BLACK));
	
		SCircle c = new SCircle(new Point(100,100),50);
		c.addAttributes(new ColorAttributes(true,true,Color.BLUE,Color.BLUE));
		
		SText t= new SText(new Point(500,500),"Hello World !");
		t.addAttributes(new ColorAttributes(true,true,Color.YELLOW,Color.BLUE));
		t.addAttributes(new FontAttributes());
		
		JLabel hello = new JLabel();
		hello.setText("hello");
		hello.setFont(new Font("Verdana", Font.BOLD,75));
		hello.setSize(900, 300);
		this.add(hello);
		
		this.model.add(r);
		this.model.add(r2);
		this.model.add(c);
		this.model.add(t);
	}*/
	
	public static void main(String[] args)
	{
		Editor self = new Editor();
		self.pack();
		self.setVisible(true);

	  }
	}

