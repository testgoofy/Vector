//MIT License
//
//    Copyright (c) 2021 testgoofy
//
//    Permission is hereby granted, free of charge, to any person obtaining a copy
//    of this software and associated documentation files (the "Software"), to deal
//    in the Software without restriction, including without limitation the rights
//    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//    copies of the Software, and to permit persons to whom the Software is
//    furnished to do so, subject to the following conditions:
//
//    The above copyright notice and this permission notice shall be included in all
//    copies or substantial portions of the Software.
//
//    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//    SOFTWARE.

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
