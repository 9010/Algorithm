package cn.com.self;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 2019.4.1 zx
 * 二分查找mid计算出错，后来上网看到的解决方法，牢记。
 */
public class BinarySearch {
    public static void main(String[] args) {
        boolean isExist = false;
        int [][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        BinarySearch binarySearch = new BinarySearch();
        isExist = binarySearch.Find(1, array);
        System.out.println(isExist);
    }

    private boolean BS(int target, int [] array){  //二分查找
        boolean isExist = false;
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high)/2;

        while (low >= 0 && high <= array.length - 1 && low <= high){
            if (target > array[mid]){
                low = mid + 1;  //low为中间值+1，注意
                mid = (low + high)/2;
            }
            else if (target < array[mid]){
                high = mid - 1;
                mid = (low + high)/2;
            }
            else if (target == array[mid]){
                isExist = true;
                return isExist;
            }
        }

        return isExist;
    }

    public boolean Find(int target, int [][] array){
        boolean isExist = false;

        for (int i = 0; i < array.length; i++){  //行数
            int [] array2 = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++){  //列数
                array2[j] = array[i][j];  //将二维数组转为一维数组，送入二分查找函数BS
            }
            isExist = BS(target, array2);
            if(isExist == true){
                return isExist;
            }
        }


        return isExist;
    }
}
