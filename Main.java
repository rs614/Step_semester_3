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

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}