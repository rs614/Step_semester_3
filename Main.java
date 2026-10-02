public class Main {

    static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatch = -1; // 1-based position

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1;
            }
        }

        double accuracy = (total == 0) ? 100.0 : (matched * 100.0) / total;

        String result = "Matched: " + matched + "/" + total
                + " | Accuracy: " + String.format("%.2f", accuracy) + "%";
        if (firstMismatch == -1) {
            result += " | No Mismatches";
        } else {
            result += " | First Mismatch at position " + firstMismatch
                    + " ('" + original.charAt(firstMismatch - 1) + "' vs '"
                    + typed.charAt(firstMismatch - 1) + "')";
        }
        System.out.println(result);
    }
Q2 
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
public class Main {

    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean seenBefore = false;
            for (int j = 0; j < i; j++) {
                if (seatNumbers[j] == seatNumbers[i]) {
                    seenBefore = true;
                    break;
                }
            }
            if (seenBefore) continue;

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
