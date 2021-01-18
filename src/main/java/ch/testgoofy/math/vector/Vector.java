package ch.testgoofy.math.vector;

import ch.testgoofy.math.matrix.Matrix;

public class Vector extends Matrix {

  /**
   * Calculates the dot product of tow vectors
   * @param v1 First Vector to be multiplied
   * @param v2 Second Vector to be multiplied
   * @return  The dot product
   */
  public static double dot(Vector v1, Vector v2){
    if (v1.rows != v2.rows || v1.columns != v2.columns){
      throw new IllegalArgumentException("Vector 'v1' and Vector 'v2' don't have the same dimensions");
    }
    double product = 0;
    for (int i = 0; i < v1.rows; i++) {
      product += v1.data[i][0] * v2.data[i][0];
    }
    return product;
  }

  /**
   * Calculates the dot product with the vector
   * @param vector  The vector to be multiplied
   * @return  The dot product
   */
  public double dot(Vector vector){
    return dot((Vector) new Matrix(this.data), vector);
  }

  public Vector(Vector vector){
    super((Matrix) vector);
  }

  public Vector(double[] data){
    double[][] matrix = new double[data.length][1];
    for (int i = 0; i < data.length; i++) {
      matrix[i][0] = data[i];
    }
    this.data = matrix;
    this.rows = data.length;
    this.columns = 1;
  }

  public Vector(int rows){
    data = new double[rows][1];
    this.rows = rows;
    columns = 1;
  }
}
