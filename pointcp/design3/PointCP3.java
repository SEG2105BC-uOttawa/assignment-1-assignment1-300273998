public class PointCP3 extends PointCP5{
/**
 * Contains the current value of X or RHO depending on the type
 * of coordinates.
 */
    private double x;

 /**
 * Contains the current value of Y or THETA value depending on the
 * type of coordinates.
 */
    private double y;
 //Constructors **
 /**
 * Constructs a coordinate object, with a type identifier.
 */
    public PointCP3(char type, double xOrRho, double yOrTheta){
        if(type != 'C' && type != 'P')
            throw new IllegalArgumentException();
        else if(type =='P'){
            this.x = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
            this.y = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
        }
        else{
            this.x = xOrRho;
            this.y = yOrTheta;
        }
    }


 //Instance methods *


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getRho(){
        return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public double getTheta(){
        return Math.toDegrees(Math.atan2(y, x));
 }

 /**
 * Converts Cartesian coordinates to Polar coordinates.
 */
    public PointCP2 convertStorageToPolar(){

        //Calculate RHO and THETA
        double y = getTheta();
        double x = getRho();

        char typeCoord = 'P';

        return new PointCP2(typeCoord, x, y);
    }
 /*
 * theorem (C ^ 2 = A ^ 2 + B ^ 2).
 *
 * @param pointA The first point.
 * @param pointB The second point.
 * @return The distance between the two points.
 */
    public double getDistance(PointCP5 pointB){
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }
 /**
 *
 * @param point The point to rotate
 * @param rotation The number of degrees to rotate the point.
 * @return The rotated image of the original point.
 */
    public PointCP3 rotatePoint(double rotation){
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP3( 'C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
        (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    public String toString(){
        return "Stored as Cartesian (" + getX() + "," + getY() + ")" + "\n";
    }
@Override
    public PointCP3 convertStorageToCartesian() {
        return new PointCP3('C', this.x, this.y);
    }
@Override
    public char getType() {
        return 'C';
    }
}
