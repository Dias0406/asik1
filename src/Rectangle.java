public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        this.id = idGen++;
    }
    public Rectangle(double width, double height) {
        this();
        setWidth(width);
        setHeight(height);
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        if (height <= 0){
            throw new IllegalArgumentException("Height must be positive");
        }
        else this.height = height;
    }

    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        if (width <= 0){
            throw new IllegalArgumentException("Width must be positive");
        }
        else this.width = width;
    }

    public double area(){
        return this.width * this.height;
    }
    public double perimeter(){
        return 2*(this.width + this.height);
    }

    @Override
    public String toString(){
        return "ID: " + id + ", width: " + width + ", height: " + height;
    }

}