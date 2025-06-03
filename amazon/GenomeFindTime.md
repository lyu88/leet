# Problem

![Screenshot 2025-05-25 at 10.07.24 AM.png](/Users/leadingyu88/Desktop/Screenshot%202025-05-25%20at%2010.07.24 AM.png)

![Screenshot 2025-05-25 at 10.07.18 AM.png](/Users/leadingyu88/Desktop/Screenshot%202025-05-25%20at%2010.07.18 AM.png)

test case

luvzliz z = 3

ttztzttz z = 3

tzluvzliz z = 4

zttttzttz z = 5

# Solution

还蛮多edge cases

first letter split then first item is empty String ""

but at last letter there is not empty String at the end (tricky)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(findTime("luvzliz", 'z')); // Should be 3
        System.out.println(findTime("tzluvzliz", 'z')); // should be 4
        System.out.println(findTime("zttttzttz", 'z')); // should be 5
        System.out.println(findTime("zttzxyxyt", 'z')); // should be 3
        System.out.println(findTime("ttt", 'z')); // should be 0
        System.out.println(findTime("ttztzttz", 'z')); // should be 3
    }

    static int findTime(String genome, char c) {
        String[] arr = (genome + " ").split(""+ c);
        int max = 0, t = 0;
        if (arr.length == 1) {
            return 0;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            String st = arr[i];
            if (st.length() >= max) {
                max = st.length();
                t = i;
            }
        }
        return t == 0 ? max : max + 1;
    }
}
```
