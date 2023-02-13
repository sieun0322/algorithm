class Solution {
    public int countOdds(int low, int high) {
        int diff = (high -low)+high%2+low%2;
        return diff/2;
    }
}