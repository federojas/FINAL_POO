package game.backend;

import game.backend.element.Bomb;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.HorizontalStripedCandy;
import game.backend.element.VerticalStripedCandy;
import game.backend.element.WrappedCandy;

import java.awt.Point;

public enum Figure {
	
	F6(new Point[]{ new Point(0,-2), new Point(0,-1), new Point(0,1), new Point(0,2)}, 240, new Bomb(), false),
	F15(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(1,0), new Point(2,0)}, 15, new Bomb(), false),
	F4(new Point[]{ new Point(0,-1), new Point(0,1), new Point(0,2)}, 112,   new VerticalStripedCandy()),
	F5(new Point[]{ new Point(0,-2), new Point(0,-1), new Point(0,1)}, 208, new VerticalStripedCandy()),
	F13(new Point[]{ new Point(-1,0), new Point(1,0), new Point(2,0)}, 13,  new HorizontalStripedCandy()),
	F14(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(1,0)}, 7,  new HorizontalStripedCandy()),
	F7(new Point[]{ new Point(0,1), new Point(0,2), new Point(1,0), new Point(2,0)}, 60, new WrappedCandy()),
	F8(new Point[]{ new Point(0,-1), new Point(0,1), new Point(1,0), new Point(2,0)}, 92, new WrappedCandy()),
	F9(new Point[]{ new Point(0,-2), new Point(0,-1), new Point(1,0), new Point(2,0)}, 204, new WrappedCandy()),
	F16(new Point[]{ new Point(-1,0), new Point(1,0), new Point(0,1), new Point(0,2)}, 53, new WrappedCandy()),
	F17(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(0,1), new Point(0,2)}, 51, new WrappedCandy()),
	F18(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(0,-1), new Point(0,-2)}, 195,new WrappedCandy()),
	F19(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(0,-1), new Point(0,1)}, 83,new WrappedCandy()),
	F20(new Point[]{ new Point(-1,0), new Point(1,0), new Point(0,-2), new Point(0,-1)}, 197, new WrappedCandy()),
	F1(new Point[]{new Point(0,1), new Point(0,2)}, 48),
	F2(new Point[]{new Point(0,-1), new Point(0,1)}, 80),
	F3(new Point[]{new Point(0,-1), new Point(0,-2)}, 192),
	F10(new Point[]{ new Point(1,0), new Point(2,0)}, 12),	
	F11(new Point[]{ new Point(-1,0), new Point(1,0)}, 5),	
	F12(new Point[]{ new Point(-2,0), new Point(-1,0)}, 3);
	
	
	private Point[] points;
	private int value;
	private Element replacement;
	private boolean isCandyRepl = true;

	Figure(Point[] points, int value, Element replacementClass) {
		this.points = points;
		this.value = value;
		this.replacement = replacementClass;
	}
	
	Figure(Point[] points, int value, Element replacementClass, boolean isCandyRepl) {
		this.points = points;
		this.value = value;
		this.replacement = replacementClass;
		this.isCandyRepl = isCandyRepl;
	}
	
	Figure(Point[] points, int value) {
		this.points = points;
		this.value = value;
		this.replacement = null;
	}
	
	public Point[] getPoints() {
		return points;
	}
	
	public int size() {
		return points.length;
	}

	public boolean hasReplacement() {
		return replacement != null;
	}
	
	public boolean matches(int acum) {
		return value == (value & acum);
	}
	
	public Element generateReplacement(CandyColor color) {
			if (isCandyRepl) {
				((Candy)replacement).setColor(color);
			} 
			return replacement;

	}	
}
