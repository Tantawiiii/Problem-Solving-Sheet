class Solution {
    
        static class Job {
        int difficulty;
        int profit;

        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        // Create list of jobs
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }

        // Sort jobs by difficulty
        jobs.sort((a, b) -> a.difficulty == b.difficulty ? b.profit - a.profit : a.difficulty - b.difficulty);

        // Sort worker abilities
        Arrays.sort(worker);

        int maxProfit = 0;
        int currentMaxProfit = 0;
        int jobIndex = 0;

        for (int i = 0; i < m; i++) {
            //  find the most profitable job they can do
            while (jobIndex < n && worker[i] >= jobs.get(jobIndex).difficulty) {
                currentMaxProfit = Math.max(currentMaxProfit, jobs.get(jobIndex).profit);
                jobIndex++;
            }
            maxProfit += currentMaxProfit;
        }

        return maxProfit;
    }
}