class Solution {
    public int singleNonDuplicate(int[] nums) {
       int left=0;
       int right=nums.length-1;
       while(left<right){
        int mid=left+(right-left)/2;
        if(mid%2==1){ //for easy comparsion since single element will be at even index
            mid--;
        }
        if(nums[mid]==nums[mid+1]){ //comparison with next element
            left=mid+2; //right half
        }else{
            right=mid; //left half
        }
       }
       return nums[left];  //ans
    }
}
