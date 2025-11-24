class Solution { 
    private void findnum(int can,int peo,int[] res,int count){
        while(can>0){
            for(int i=0;i<peo;i++){
                if(can>=count){
                    res[i]+=count;
                    can-=count;
                    count++;
                }
                else if(can==0){
                    return;
                }
                else{
                    res[i]=res[i]+can;
                    return;
                }
            }
        }
        return;
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        int count=1;
        findnum(candies, num_people, res, count);
        return res;
    }
}