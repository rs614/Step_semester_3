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
Q3
    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal readings provided");
            return;
        }
        char bestColor = signalLog.charAt(0);
        int bestLen = 1;
        int currentLen = 1;
 
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            if (currentLen > bestLen) {
                bestLen = currentLen;
                bestColor = signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLen + " times");
    }
Q4
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }
 
        int max = sectionA[0];
        char maxSection = 'A';
        int maxIndex = 0;
 
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > max) {
                max = sectionA[i];
                maxSection = 'A';
                maxIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > max) {
                max = sectionB[i];
                maxSection = 'B';
                maxIndex = i;
            }
        }
 
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + max
                + " (Section " + maxSection + ", Item " + (maxIndex + 1) + ")");
    }
Q5
static void classifyWordLengths(String review) {
        int shortCount = 0, mediumCount = 0, longCount = 0;
        String[] words = review.trim().split("\\s+");
 
        for (String word : words) {
            // count letters only, so punctuation doesn't inflate length
            int len = word.replaceAll("[^A-Za-z]", "").length();
            if (len == 0) continue;
            if (len <= 4) shortCount++;
            else if (len <= 8) mediumCount++;
            else longCount++;
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
 
    public static void main(String[] args) {
        System.out.println("--- Problem 1 ---");
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
 
        System.out.println("\n--- Problem 2 ---");
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
 
        System.out.println("\n--- Problem 3 ---");
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
 
        System.out.println("\n--- Problem 4 ---");
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
 
        System.out.println("\n--- Problem 5 ---");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
