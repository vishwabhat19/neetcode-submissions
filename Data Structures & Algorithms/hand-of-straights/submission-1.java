class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);
        for(int card : hand) {
            if (map.get(card) == 0) continue;
            for(int i=0;i<groupSize;i++) {
                int currentCard = card + i;
                //Try to find the next consecutive card to start forming a hand
                int count = map.getOrDefault(currentCard, 0);
                if (count == 0) return false;
                map.put(currentCard, count - 1);
            }
        }
        return true;
    }
}
