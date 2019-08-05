package practice;

interface Shape{
	void draw();
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Shape:Rectangle");		
	}	
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Shape:Circle");
	}	
}

abstract class ShapeDecorator implements Shape{  // ≥ÈœÛ◊∞ Œ¿‡
	protected Shape decoratorShape;
	public ShapeDecorator(Shape decoratorShape){
		this.decoratorShape = decoratorShape;
	}
	public void draw(){
		decoratorShape.draw();
	}
} 

class RedShapeDecorator extends ShapeDecorator{
	public RedShapeDecorator(Shape decoratorShape){
		super(decoratorShape);
	}
	@Override
	public void draw() {
		decoratorShape.draw();
		setRedBorder(decoratorShape);
		
	}
	private void setRedBorder(Shape decoratorShape){
		System.out.println("Border Color: Red");
	}
}

public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape redCircle = new RedShapeDecorator(new Circle());
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		circle.draw();
		redCircle.draw();
		redRectangle.draw();
	}
	
}
