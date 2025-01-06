class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int missing=arr[mid]-(mid+1); //missing numbers at mid index
            if(missing<k){ 
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low+k; 
    }
}
/*since after this loop high and low will be crossed to find the range where missing numbers will be in range of  k and 
answer= arr[high]+k-(arr[high]-(high-1))
which can be concluded as ans=high+1+k
since high+1=low
then we can say that ans could be low+k

*/
