class Solution {
	final static int INITIAL = -10000;   //棋盘位置初始值 

    public int totalNQueens(int n) {
	    int resultNum = 0;  
	    int[] a = new int[n]; //代表棋盘解空间
	    for (int i = 0; i < n; i++) {
	    	a[i] = INITIAL; //棋盘初始化
	    }
	    int row = 0, col = 0;  
	    while (row < n){  
	        while (col < n) {       //对row行的每一列进行探测，看是否可以放置皇后  
	            if(valid(a, n, row, col)) {    //该位置可以放置皇后  
	                a[row] = col;        //第row行放置皇后  
	                col = 0;           //第row行放置皇后以后，需要继续探测下一行的皇后位置，所以此处将col清零，从下一行的第0列开始逐列探测  
	                break;  
	            } else{  
	                ++col;             //继续探测下一列  
	            }  
	        } 
	        if(a[row] == INITIAL) {        //第row行没有找到可以放置皇后的位置  
	            if (0 == row)             //回溯到第一行，仍然无法找到可以放置皇后的位置，则说明已经找到所有的解，程序终止  
	                break;  
	            else {                  //没有找到可以放置皇后的列，此时就应该回溯  
	                --row;  
	                col = a[row] + 1;        //把上一行皇后的位置往后移一列  
	                a[row] = INITIAL;      //把上一行皇后的位置清除，重新探测  
	                continue;  
	            }  
	        }  
	        if (row == n - 1)  {        //最后一行找到了一个皇后位置，说明找到一个结果
	            resultNum++;
	            //不能在此处结束程序，因为我们要找的是N皇后问题的所有解，此时应该清除该行的皇后，从当前放置皇后列数的下一列继续探测。  
	            col = a[row] + 1;             //从最后一行放置皇后列数的下一列继续探测  
	            a[row] = INITIAL;           //清除最后一行的皇后位置  
	            continue;  
	        }  
	        ++row;              //继续探测下一行的皇后位置  
	    }
	    return resultNum;
    }

    private boolean valid(int[] a, int length, int row, int col) {   //判断第row行第col列是否可以放置皇后  
	    int i;  
	    for (i = 0; i < length; ++i) {  //对棋盘进行扫描  
	        if (a[i] == col || Math.abs(i - row) == Math.abs(a[i] - col))   //判断列冲突与斜线上的冲突  
	            return false;  
	    }  
	    return true;  
	} 
}