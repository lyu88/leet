# Problem

With the increasing frequency of cyber intrusions, safeguarding authentication systems has become essential. A dedicated research division has been established to examine different forms of security breaches. During one such evaluation, the team identifies a malware that specifically targets user passwords.
This malware operates based on a predefined sequence known as infiltrationPattern, which is a rearrangement (permutation) of numbers from 1 to n. At the i-th second of the breach, the malware corrupts the character at position infiltrationPattern[i] in the password, substituting it with the infected symbol '*' . That is, after i seconds, accessKey[infiltrationPattern[i]] = '*'. (**1-based index**)
A password is classified as unrecoverable once the count of distinct portions within it that include at least one occurrence of '*' reaches or surpasses m. The security team’s objective is to ascertain the minimum duration needed for the password to become unrecoverable.
**Note**:
If the password is already unrecoverable from the outset, return 1 as the output.
**Function Description**
Complete the function helpAmazonFindMinTimeAgain in the editor.
helpAmazonFindMinTimeAgain has the following parameter:
string accessKey: the original password before the malware attack
int infiltrationPattern[]: a permutation array containing integers [1, 2, ..., n] that determines the breach order
int threshold: the parameter defining when the password is considered compromised
**Returns**
int: the smallest duration required for the password to be classified as unrecoverable
**Example**
Input
accessKey = "bcced"
infiltrationPattern = [2, 3, 1, 4, 5]
threshold = 10
Output
2

# Solution

```java


public class Main {
    public static void main(String[] args) {
       String accessKey = "bcced";
        int[] infiltrationPattern = {2, 3, 1, 4, 5};
        int threshold = 10;
        System.out.println(helpAmazonFindMinTimeAgain(accessKey, infiltrationPattern, threshold));
    }

    static int helpAmazonFindMinTimeAgain(String accessKey, int[] infiltrationPattern, int threshold) {
        int n = accessKey.length();
        char[] chars = accessKey.toCharArray();

        // At every second, corrupt one position and check segments
        for (int i = 0; i < n; i++) {
            int pos = infiltrationPattern[i] - 1; // convert to 0-based index
            chars[pos] = '*';

            if (countSegments(chars) >= threshold) {
                return i + 1; // time in seconds, 1-based
            }
        }

        return n; // fallback, although by constraints this case shouldn't occur
    }

    private static int countSegments(char[] chars) {
        int n = chars.length;
        long totalSubstrings = (long) n * (n + 1) / 2;
        long withoutStars = 0;

        int i = 0;
        while (i < n) {
            if (chars[i] != '*') {
                int j = i;
                while (j < n && chars[j] != '*') {
                    j++;
                }
                int len = j - i;
                withoutStars += (long) len * (len + 1) / 2;
                i = j;
            } else {
                i++;
            }
        }

        return (int) (totalSubstrings - withoutStars);
    }
}
```


