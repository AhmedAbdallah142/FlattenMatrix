import java.util.Arrays;

public class MatrixFlatten3D<T> {
    T[][][] matrix3d;

    public MatrixFlatten3D(T[][][] matrix3d){
        this.matrix3d = matrix3d;
    }

    private T[] Required1D(){
        return  (T[]) new Object[matrix3d.length*matrix3d[0].length*matrix3d[0][0].length];
    }

    public T[] apply(){
        T[] matrix1d = Required1D();
        for (int i = 0; i < matrix3d.length;i++){
            for (int j = 0; j < matrix3d[0].length;j++){
                for (int k = 0; k < matrix3d[0][0].length;k++){
                    matrix1d[index1D(i,j,k)] = matrix3d[i][j][k];
                }
            }
        }
        return matrix1d;
    }
    private int index1D(int i ,int j ,int k){
        return i+matrix3d.length*(j+matrix3d[0].length*k);
    }

    public static void main(String[] args){
        Integer[][][] m = new Integer[2][2][2];
        for (int i = 0; i < m.length;i++){
            for (int j = 0; j < m[0].length;j++){
                for (int k = 0; k < m[0][0].length;k++){
                    m[i][j][k] = i+j+k;
                }
            }
        }
        MatrixFlatten3D<Integer> f = new MatrixFlatten3D<>(m);
        System.out.println(Arrays.toString(f.apply()));
    }
}
