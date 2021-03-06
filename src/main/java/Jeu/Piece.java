package Jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JComponent;


public class Piece extends JComponent {

	public int faces[] = new int[4];	
	private int rotate;	
	private Point size;	


	public void Face(int faceOuestPiece, int faceNordPiece, int faceEstPiece, int faceSudPiece){
		faces[0] = faceOuestPiece;
		faces[1] = faceNordPiece;
		faces[2] = faceEstPiece;
		faces[3] = faceSudPiece;
	}	
	public Piece(int s){
//		System.out.println("Creation d'une piece vide");		
		faces[0] = 0;
		faces[1] = 0;
		faces[2] = 0;
		faces[3] = 0;
		rotate = 0;		
		size = new Point(s,s);
		repaint();		
	}

	public Piece(int s,int faceOuestPiece, int faceNordPiece, int faceEstPiece, int faceSudPiece){
//		System.out.println("Creation d'une piece complete");		
		faces[0] = faceOuestPiece;
		faces[1] = faceNordPiece;
		faces[2] = faceEstPiece;
		faces[3] = faceSudPiece;		
		size = new Point(s,s);
		repaint();		
	}
		
	//SWAP FUNCTION
	public void Echange(Piece piece2)	{
		Piece piece3 = new Piece(size.x,piece2.faces[0], piece2.faces[1], piece2.faces[2], piece2.faces[3]);
		piece2.faces[0]=this.faces[0];
			piece2.faces[1]=this.faces[1];
			piece2.faces[2]=this.faces[2];
			piece2.faces[3]=this.faces[3];

		this.faces[0]=piece3.faces[0];
		this.faces[1]=piece3.faces[1];
		this.faces[2]=piece3.faces[2];
		this.faces[3]=piece3.faces[3];
	}
	

	
	public void rotationDroite(){
		int temp = faces[0];
		faces[0]=faces[3];
		faces[3]=faces[2];
		faces[2]=faces[1];
		faces[1]=temp;
		rotate = (rotate-1)%4;
	}

	
	public void rotationGauche(){
		int temp = faces[0];
		faces[0]=faces[1];
		faces[1]=faces[2];
		faces[2]=faces[3];
		faces[3]=temp;
		rotate = (rotate+1)%4;
	}	


	//////////////////////////////////////////////////////////////FONCTION POUR LE COLORIAGE/////////////////////////////////////////////////////
	public void paintComponent(Graphics g) {
	    g.setColor(Color.black);
	    g.fillRect(0, 0, 100, 100);	    
	    build(g);	    
	}
	
	private void setColorFace(int face, Graphics g){
		   switch (face) {
		          case 0: 
		            g.setColor(Color.white);
		                 break;
		          case 1:  
		            g.setColor(Color.black);
		            break;
		          case 2:  
		            g.setColor(new Color(54,156,228));
		            break;
		          case 3:  
		            g.setColor(new Color(54,228,185));
		            break;
		          case 4:  
		            g.setColor(new Color(225,228,54));
		            break;
		          case 5: 
		            g.setColor(new Color(210,112,182));
		            break;
		          default:
		            g.setColor(Color.black);
		            break;
		   }  
		 
		 }
	
	public void update() {
		repaint();		    
	}
	
	public int getFace(int i){
		return faces[i];
	}
	public double getPiecePointX(){
		return this.size.getX();
	}
	public double getPiecePointY(){
		return this.size.getY();
	}

	private void build(Graphics g){
		
		setColorFace(faces[1], g);
		Polygon p1 = new Polygon();
		p1.addPoint(0,0);
		p1.addPoint(size.x,0);
		p1.addPoint(size.x/2,size.y/2);        
		((Graphics2D) g).fill(p1);
		
	    
		setColorFace(faces[0], g);
	    Polygon p2 = new Polygon();
        p2.addPoint(0,0);
        p2.addPoint(0,size.y);
        p2.addPoint(size.x/2,size.y/2);       
	    ((Graphics2D) g).fill(p2);
	    
		setColorFace(faces[2], g);
	    Polygon p3 = new Polygon();
        p3.addPoint(size.x,0);
        p3.addPoint(size.x,size.y);
        p3.addPoint(size.x/2,size.y/2);        
	    ((Graphics2D) g).fill(p3);
	    
		setColorFace(faces[3], g);
	    Polygon p4 = new Polygon();
        p4.addPoint(size.x,size.y);
        p4.addPoint(0,size.y);
        p4.addPoint(size.x/2,size.y/2);       
	    ((Graphics2D) g).fill(p4);
		
	}

	
	
	
}

