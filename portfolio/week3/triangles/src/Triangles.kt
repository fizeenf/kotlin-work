// COMP2850 Portfolio: Week 3

import kotlin.math.sqrt // square root function imported to calculate triangles area

typealias Triangle = Triple<Double,Double,Double>
// a triangle contains three double values( one for eahc side)

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle( tri: Triangle ) : Boolean {

    val a = tri.first.toDouble() // gets first side length from the Triple 
    val b = tri.second.toDouble() // gets second side --
    val c = tri.third.toDouble() // gets thirds sids --
    val check = a < (b + c) && b < (a + c) && c < (a + b) 
    // for a valid triangle the sum of any 2 sides must be greater than the third side
   
    return check  // true only if all conditions valid
} 

fun triangleArea( tri: Triangle ) : Double {
    // checks if the triangle is valid before calculation area
    // condition becomes true if triangle is invalid
    if (!isValidTriangle(tri)) {
        //calculation stops and error reported
       throw IllegalArgumentException("triangle not valid")

    }   
    // getting the length for each side from The Triple
    val a = tri.first
    val b = tri.second
    val c = tri.third

    val s =  (a + b + c) / 2  //calculating the semi perimeter
    val area =  sqrt( s * ( s- a) * (s-b) * (s-c) )  // usig Heron's formula to calculate area

return area
}


   