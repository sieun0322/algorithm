class Solution {
    public int countOdds(int low, int high) {
        return ((high -low)+high%2+low%2)/2;
    }
}