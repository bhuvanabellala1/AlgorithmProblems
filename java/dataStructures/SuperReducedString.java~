import java.util.*;

/**
 * Steve has a string, , consisting of  lowercase English alphabetic letters.
 * In one operation, he can delete any pair of adjacent letters with same value.
 * For example, string "aabcc" would become either "aab" or "bcc" after operation.
 * Steve wants to reduce  as much as possible. To do this, he will repeat the
 * above operation as many times as it can be performed.
 * Help Steve out by finding and printing 's non-reducible form!
 * Note: If the final string is empty, print Empty String .
 */

public class Dynamic {


    /**
     * Using a stack keep popping until all pairs are deleted and
     * push until a pair is detected, then pop again
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String sent = scan.next();
        Deque<Character> que = new ArrayDeque<>();

        for (int i = 0; i < sent.length(); i++) {
            if (que.peek() == sent.charAt(i)) {
                que.pop();
            } else {
                que.push(sent.charAt(i));
            }
        }

        if (que.size() == 0) {
            System.out.println("Empty String");
        } else {
            for (int i = 0; que.size() != 0; ) {
                System.out.print(que.pop());
            }
        }


    }
}
