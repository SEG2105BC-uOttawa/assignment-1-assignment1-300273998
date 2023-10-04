public class PointCP2 extends PointCP5{
 /**
 * Contains a double to represent the radius of the point.
 */
    private double rho;
 /**
 * Contains a double to represent the angle (theta) of the point.
 */
    private double theta;
 /**
 * Constructs a polar coordinate object with the two parameters.
 */
    public PointCP2 (char type, double xOrRho, double yOrTheta) {
        if(type != 'C' && type != 'P') {
            throw new IllegalArgumentException();
        } else if (type=='C') {
            this.rho = Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta,2));
            this.theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
        } else {
            this.rho = xOrRho;
            this.theta = yOrTheta;
    }
}
    public double getX(){
        return (Math.cos(Math.toRadians(theta)) * rho);
    }

    public double getY(){
        return (Math.sin(Math.toRadians(theta)) * rho);
    }
    public double getRho () {
        return rho;
    }
    public double getTheta () {
        return theta;
    }
/**
 * Converts Polar coordinates to Cartesian coordinates.
 */
    public PointCP3 convertStorageToCartesian(){
    //Calculate X and Y
        double yOrTheta = getY();
        double xOrRho = getX();

        char typeCoord = 'C'; //Change coord type identifier

        return new PointCP3(typeCoord, xOrRho, yOrTheta);
    }
 /**
 * Calculates the distance in between two points using the Pythagorean
 * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
 *
 * @param pointA The first point.
 * @param other The second point.
 * @return The distance between the two points.
 */
    public double getDistance(PointCP5 other){
 //System.out.println("This getDistance method is in Design 2.");
        double deltaX = getX() - other.getX();
        double deltaY = getY() - other.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
 }
 /**
 * Rotates the specified point by the specified number of degrees.
 * Not required until E2.30
 *
 * @param point The point to rotate
 * @param rotation The number of degrees to rotate the point.
 * @return The rotated image of the original point.
 */
    public PointCP2 rotatePoint(double rotation){

        double rho1 = this.getRho() + rotation;
        double theta1 = this.getTheta();
        return new PointCP2 ('P', rho1, theta1);
    }
 /**
 * Returns information about the coordinates.
 *
 * @return A String containing information about the coordinates.
 */
    public String toString(){
        return ( "Stored as Polar "+"[" + getRho() + "," + getTheta() + "]" + "\n");
    }
@Override
    public PointCP2 convertStorageToPolar() {
        return new PointCP2('P', this.rho, this.theta);
    }
@Override
    public char getType() {
        return 'P';
    }
}
