// 开头想到
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, min * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}

// 网友更酷
class Solution {
    public int maxArea(int[] height) {
        int i = 0,j = height.length-1,max = 0;
        while(i < j){
            int min = Math.min(height[i],height[j]);
            max = Math.max(max,(j-i)*min);
            while(i < j && height[i] <= min) i++;
            while(i < j && height[j] <= min) j--;
        }
        return max;
    }
}