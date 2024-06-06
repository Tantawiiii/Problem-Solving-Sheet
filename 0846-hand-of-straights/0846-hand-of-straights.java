class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
          if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cardCount.keySet());

        while (!minHeap.isEmpty()) {
            int firstCard = minHeap.poll();
            int count = cardCount.get(firstCard);

            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = firstCard + i;
                    if (cardCount.getOrDefault(currentCard, 0) < count) {
                        return false;
                    }
                    cardCount.put(currentCard, cardCount.get(currentCard) - count);
                    if (cardCount.get(currentCard) == 0 && currentCard != firstCard) {
                        minHeap.remove(currentCard);
                    }
                }
            }
        }

        return true;
    }
}