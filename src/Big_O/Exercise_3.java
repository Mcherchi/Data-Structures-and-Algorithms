package Big_O;

public class Exercise_3 {
   public static void compressBoxesTwice(int[] boxes, int[] boxes2) {
        for (int box : boxes) {
            System.out.println(box);
        }

        for (int box : boxes2) {
            System.out.println(box);
        }
    }

    public static void main(String[] args) {
        int[] boxes = {1, 2, 3};
        int[] boxes2 = {4, 5, 6};

        compressBoxesTwice(boxes, boxes2); // Time Complexity: O(a + b)
    }
}
