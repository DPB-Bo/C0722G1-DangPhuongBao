package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tsax {
    static int solution(Integer[] arr) {
        int toltal = 0;
        for(int i =0; i<arr.length;i++){
            toltal += arr[i];}
        int count =0;
        if(toltal%4==0){
            count = toltal /4;
        }else{
            count = (toltal / 4) + 1;
        }
        return count;
    }
    static int solution2(Integer[] arr){
        int x = 0;
        int y = 0;
        for (int i=0; i<arr.length;i++) {
            x+=arr[i];
            if (x>4){
                y++;
                x=x-4;
            }
        }
        if (x>0){
            y++;
        }
        return y;
    }
    static int solution3(Integer[] arr){
        List<Integer> arr2 = Arrays.asList(arr);
        int size = arr2.size();
        int count =0;
        for(int i =0;i<size;i++){

        }
        return 1;
    }
    public static void main(String[] args) {
        Integer[]arr = new Integer[]{3,3,3,3};

//        System.out.println(arr2);
        System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }
}

//    Để chúc mừng ngày 8/3, các bạn học sinh lớp 12A3 dự định tổ chức dã ngoại đến biển Nha Trang và lớp sẽ đi bằng taxi.
//        Các bạn trong lớp được chia thành n nhóm, mỗi nhóm thứ i gồm arri bạn (1 ≤ arri ≤ 4) và mỗi chiếc taxi chở tối đa 4 hành khách.
//        Vậy lớp 12A3 cần thuê ít nhất bao nhiêu chiếc taxi để chở các nhóm đi, với điều kiện là các bạn trong nhóm phải ngồi chung taxi (một taxi có thể chở một nhóm trở lên).
//        Ví Dụ:
//        Với arr = [1 ,2 ,4 ,3 ,3] thì taxi(arr) = 4 Các bạn học sinh có thể sắp xếp như sau:
//
//        Nhóm thứ 3 gồm 4 học sinh
//        Nhóm thứ 4 gồm 3 học sinh
//        Nhóm thứ 5 gồm 3 học sinh
//        Nhóm thứ nhất và nhóm thứ 2 gồm 3 học sinh (1 và 2 học sinh) Vậy cần 4 taxi.
//        Với arr = [1 ,1 ,1 ,1 ,1] thì taxi(arr) = 2
//        Với arr = [2 ,2 ,2 ,2] thì taxi(arr) = 2
//        Với arr = [4 ,2 ,3 ,1] thì taxi(arr) = 3
