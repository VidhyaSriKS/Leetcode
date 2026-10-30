class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long minWorkerTime = Long.MAX_VALUE;
        for (int w : workerTimes) {
            minWorkerTime = Math.min(minWorkerTime, w);
        }

        // Binary search bounds
        long low = 0;
        long high = minWorkerTime * mountainHeight * (mountainHeight + 1L) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int targetHeight, int[] workerTimes) {
        long totalReduced = 0;

        for (int w : workerTimes) {
    
            long k = (long) ((-1 + Math.sqrt(1 + 8.0 * time / w)) / 2);
            totalReduced += k;

            if (totalReduced >= targetHeight) {
                return true;
            }
        }

        return totalReduced >= targetHeight;
    }
}