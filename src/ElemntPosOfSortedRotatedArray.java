

/**
 * Created by achy_ on 3/20/2016.
 */
/*
Problem: Given a sorted array,rotated to the right by an unknown number of times,find the position of an element.
Solution: The fact that the array is sorted,finding an element directly send me to binary search.Being rotated an unknown nr of times
changes the binary search by imposing more conditions, but we can check which half is sorted by comparing the start and the end element
of either the left side or the right side of the binary array;
 */
public class ElemntPosOfSortedRotatedArray {
    int[] array;

    public int solve(int nr) throws Exception{
        int result = find_nr(0,this.array.length-1,nr);
        switch (result){
            case -1:
                throw new Exception("The number is not in the array");
            default:
                return result;

        }
    }
    public ElemntPosOfSortedRotatedArray(int[] array){
        this.array = array;
    }
    /*
    start - initialized with 0.our lower bound
    end - initialized with the last position of the array
    number - the number we're searching for
     */
    public int find_nr(int start, int end, int number){
        if(start > end){
            return -1;
        }
        if(this.array[start] == number){
            return start;
        }
        if(this.array[end] == number){
            return end;
        }
        int mid = (start+end)/2;
        System.out.println("mid value "+ this.array[mid]);

        if(this.array[mid] == number){
            return mid;
        }
        // check what branch is sorted left(1st if) or right (the else)
        if (this.array[start] <= this.array[mid]){
            // check if the nr is in the 1st half of the 1st array else its the right half
            if (this.array[start]<=number && this.array[mid] >= number ){
                return find_nr(start,mid -1, number);
            }
            else{
                return  find_nr(mid+1,end,number);
            }
        }
        else {
            //check if the nr is in the 2nd half else its in the first
            if (this.array[mid] <= number && this.array[end] >= number){
                return find_nr(mid +1,end,number);
            }
            else
            {
                return find_nr(start,mid-1,number);
            }
        }

    }
}
