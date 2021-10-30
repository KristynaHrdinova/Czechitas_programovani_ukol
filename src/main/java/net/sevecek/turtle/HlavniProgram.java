package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {
    Turtle zofka;


    public void main(String[] args) {


        zofka = new Turtle();

        Color lightBlue = new Color(173, 216, 230);
        Color black = new Color(0, 0, 0);
        Color vanilla = new Color(243, 229, 171);
        Color bakeryBrown = new Color(171, 144, 120);

        zofka.setLocation(200,250);
        drawIceCream(250, 40, bakeryBrown, vanilla);
        zofka.turnLeft(20);
        zofka.setLocation(380,300);
        drawSnowmen(100, 70, 45, 30, lightBlue);
        zofka.turnRight(90);
        zofka.setLocation(870,400);
        drawChooChoo(150, 240, black);


    }

    public void drawEquilateralTriangle(double sideEquilateralTriangle) {
        zofka.penDown();
        for (int i = 0; i < 3; i++) {
            zofka.move(sideEquilateralTriangle);
            zofka.turnLeft(120);
        }
        zofka.penUp();


    }

    /*   base-zakladna, leg-odvesna, base angle-uhel zakladny, vertex angle-vrcholovy uhel

     */
    public void drawIsoscelesTriangle(double legIsoscelesTriangle, double vertexAngleIsoscelesTriangle) {
        zofka.penDown();
        zofka.move(countBaseIsoscelesTriangle(legIsoscelesTriangle, vertexAngleIsoscelesTriangle));
        zofka.turnLeft(180 - countBaseAngleIsoscelesTriangle(vertexAngleIsoscelesTriangle));
        zofka.move(legIsoscelesTriangle);
        zofka.turnLeft(180 - vertexAngleIsoscelesTriangle);
        zofka.move(legIsoscelesTriangle);
        zofka.penUp();
    }

    public void drawSquare(double sideSquare, Color red) {
        zofka.penDown();
        for (int i = 0; i < 4; i++) {
            zofka.move(sideSquare);
            zofka.turnRight(90);
        }
        zofka.penUp();
    }

    public void drawRectangle(double lengthRectangle, double widthRectangle) {
        zofka.penDown();
        for (int i = 0; i < 2; i++) {
            zofka.move(lengthRectangle);
            zofka.turnRight(90);
            zofka.move(widthRectangle);
            zofka.turnRight(90);
        }
        zofka.penUp();
    }

    public void drawCircle(double radiusCircle) {

        zofka.penDown();
        double stepLength = countCircumferenceCircle(radiusCircle) / 360;
        for (int i = 0; i < 360; i++) {
            zofka.move(stepLength);
            zofka.turnLeft(1);
        }
        zofka.penUp();
    }

    public void drawQuarterCircle(double radiusCircle) {
        zofka.turnLeft(180);
        zofka.penDown();
        for (int i = 0; i < 90; i++) {

            zofka.move(countCircumferenceCircle(radiusCircle) / 360);
            zofka.turnLeft(1);
        }
        zofka.penUp();
        zofka.turnLeft(180);
    }

    public double countBaseIsoscelesTriangle(double legIsoscelesTriangle, double vertexAngleIsoscelesTriangle) {
        double baseIsoscelesTriangle;
        baseIsoscelesTriangle = Math.abs((legIsoscelesTriangle
                * Math.sin((vertexAngleIsoscelesTriangle / 2.0) * Math.PI / 180.0))
                * 2.0);

        return baseIsoscelesTriangle;
    }

    public double countBaseAngleIsoscelesTriangle(double vertexAngleIsoscelesTriangle) {
        double baseAngleIsoscelesTriangle;
        baseAngleIsoscelesTriangle = (180.0 - vertexAngleIsoscelesTriangle) / 2;
        return baseAngleIsoscelesTriangle;
    }

    public double countCircumferenceCircle(double radiusCircle) {
        double circumferenceCircle;
        circumferenceCircle = 2 * Math.PI * radiusCircle;
        return circumferenceCircle;
    }

    public void drawIceCream(double legIsoscelesTriangle, double vertexAngleIsoscelesTriangle, Color colorCornet, Color colorIceCream) {
        zofka.turnLeft(90);
        zofka.setPenColor(colorCornet);
        drawIsoscelesTriangle(legIsoscelesTriangle, vertexAngleIsoscelesTriangle);
        zofka.setPenColor(colorIceCream);
        drawCircle((3*countBaseIsoscelesTriangle(legIsoscelesTriangle, vertexAngleIsoscelesTriangle))/(4*(Math.sqrt(2))));
    }

    public void drawSnowmen(double radiusCircleDownBall, double radiusCircleCentralBall, double radiusCircleHeadBall, double radiusCircleArms, Color colorSnowmen) {
        zofka.setPenColor(colorSnowmen);
        zofka.turnLeft(90);
        drawCircle(radiusCircleDownBall);
        drawQuarterCircle(radiusCircleCentralBall);
        drawCircle(radiusCircleArms);
        drawQuarterCircle(radiusCircleCentralBall);
        drawCircle(radiusCircleHeadBall);
        drawQuarterCircle(radiusCircleCentralBall);
        drawCircle(radiusCircleArms);
        drawQuarterCircle(radiusCircleCentralBall);

    }

    public void drawChooChoo(double widthRectangleChimney, double lengthRectangleChimney, Color colorChooChoo) {

        zofka.setPenColor(colorChooChoo);
        drawRectangle(lengthRectangleChimney, widthRectangleChimney);
        zofka.turnRight(180);
        drawCircle(widthRectangleChimney / 2);
        zofka.turnRight(90);
        drawRectangle(lengthRectangleChimney, lengthRectangleChimney / 2);
        zofka.move(lengthRectangleChimney / 4);
        drawCircle(widthRectangleChimney / 4);
        zofka.move(lengthRectangleChimney / 2);
        drawCircle(widthRectangleChimney / 4);
        zofka.move(lengthRectangleChimney / 4);
        zofka.turnRight(90);
        zofka.move(lengthRectangleChimney / 3);
        zofka.turnLeft(135);
        drawIsoscelesTriangle(lengthRectangleChimney / 2, 90);
    }

}
