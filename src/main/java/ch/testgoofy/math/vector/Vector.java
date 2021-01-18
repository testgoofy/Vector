package ch.testgoofy.math.vector;

import ch.testgoofy.math.matrix.Matrix;

public class Vector extends Matrix {

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
