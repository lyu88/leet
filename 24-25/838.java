class Solution {
    public String pushDominoes(String d) {
        int index = 0;
        char pt = 'L';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length(); i++) {
            char c = d.charAt(i);
            if (c == '.') {
                continue;
            }
            if (c == 'R') {
                if (pt == 'L') {
                    for (int j = index; j < i; j++) {
                        sb.append('.');
                    }
                    sb.append('R');
                } else {
                    for (int j = index; j <= i; j++) {
                        sb.append('R');
                    }
                }
                index = i+ 1;
                pt = 'R';
            } else {
                if (pt == 'L') {
                    for (int j = index; j <= i; j++) {
                        sb.append('L');
                    }
                } else {
                    StringBuilder left = new StringBuilder();
                    StringBuilder right = new StringBuilder();
                    int j = index, k = i - 1;
                    while (j < k) {
                        left.append('R');
                        right.append('L');
                        j++;
                        k--;
                    }
                    sb.append(left);
                    if (j == k) {
                        sb.append('.');
                    }
                    sb.append(right);
                    sb.append('L');
                }
                index = i+ 1;
                pt = 'L';
            }
        }
        if (pt == 'R') {
            for (int i = index; i < d.length(); i++) {
                sb.append('R');
            }
        } else {
            for (int i = index; i < d.length(); i++) {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}


// don't do append, but instead modify value in array
// in this way, analysis and code will look easier
class Solution {
    public String pushDominoes(String d) {
        int index = -1;
        char pt = 'L';
        char[] arr = d.toCharArray();
        for (int i = 0; i < d.length(); i++) {
            char c = d.charAt(i);
            if (c == '.') {
                continue;
            }
            if (c == 'R') {
                if (pt == 'R') {
                    for (int j = index + 1; j < i; j++) {
                        arr[j] = 'R';
                    }
                }
                pt = 'R';
                index = i;
            } else {
                if (pt == 'L') {
                    for (int j = index + 1; j < i; j++) {
                        arr[j] = 'L';
                    }
                } else {
                    int left = index + 1;
                    int right = i - 1;
                    while (left < right) {
                        arr[left] = 'R';
                        arr[right] = 'L';
                        left++;
                        right--;
                    }
                }
                pt = 'L';
                index = i;
            }
        }
        if (pt == 'R') {
            for (int i = index + 1; i < d.length(); i++) {
                arr[i] = 'R';
            }
        }
        return new String(arr);
    }
}