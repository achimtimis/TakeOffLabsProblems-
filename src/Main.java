import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {
        MatrixRotation90 m = new MatrixRotation90();
        m.printMatrix();
        m.rotate90();
        m.printMatrix();


        int[] array={7,8,9,1,2,3,4,5,6};
        ElemntPosOfSortedRotatedArray e = new ElemntPosOfSortedRotatedArray(array);
        try {
            System.out.println("Position found at index " + e.solve(5));
            assert(e.solve(10)==-1)==true;
            assert(e.solve(1)==3)==true;
            assert(e.solve(6)==8)==true;
        } catch (Exception e1) {
            System.out.println(e1.toString());
        }
    }
}
