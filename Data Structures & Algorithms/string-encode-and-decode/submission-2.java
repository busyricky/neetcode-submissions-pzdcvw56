class Solution {

    public String encode(List<String> strs) {
        // using O(n) time

        String response = "";

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> resp = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (j < str.length() && str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            resp.add(str.substring(j + 1, j + length + 1));
            i = j + length + 1;
        }

        return resp;
    }
}
