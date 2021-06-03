class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int prehorCut=0;
        int preverCut=0;
        
        int maxHeight=-1;
        int maxWidth=-1;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        for(int i=0;i<horizontalCuts.length;i++){
            maxWidth=Math.max(maxWidth,horizontalCuts[i]-prehorCut);
            prehorCut=horizontalCuts[i];
        }
        maxWidth=Math.max(maxWidth,h-prehorCut); 
          for(int i=0;i<verticalCuts.length;i++){
            maxHeight=Math.max(maxHeight,verticalCuts[i]-preverCut);
            preverCut=verticalCuts[i];
        }
        maxHeight=Math.max(maxHeight,w-preverCut);
        int max = 1000000007;
        return (int)((long)maxHeight * maxWidth % max);
    }
}