class Solution {

    public String encode(List<String> strs) {
        int totalStringCount = 0;
        String stringCharacterCount = "";
        String stringsConcatenated = "";

        for (String s : strs) {
            totalStringCount++;

            String characterCount = String.valueOf(s.length()) + "b";
            stringCharacterCount += characterCount;

            stringsConcatenated += s;
        }

        String response = String.valueOf(totalStringCount) + "a" +
            stringCharacterCount + "c" +
            stringsConcatenated;

        return totalStringCount == 0 ? "" : response;
    }

    public List<String> decode(String str) {
        if (str == "") { return new ArrayList<>();}
        
        int totalStringCount = 0;

        totalStringCount = Integer.parseInt(str.substring(0, str.indexOf('a')));
        str = str.substring(str.indexOf('a') + 1);

        String[] stringCharacterCountStrArr = new String[totalStringCount];
        int[] stringCharacterCounts = new int[totalStringCount];

        stringCharacterCountStrArr = str.substring(0, str.indexOf('c')).split("b");
        for (int i = 0; i < stringCharacterCountStrArr.length; i++) {
            stringCharacterCounts[i] = Integer.parseInt(stringCharacterCountStrArr[i]);
        }

        String stringsConcatenated = "";

        stringsConcatenated = str.substring(str.indexOf('c') + 1);
        
        List<String> response = new ArrayList<>();

        for (int count : stringCharacterCounts) {
            response.add(stringsConcatenated.substring(0, count));
            stringsConcatenated = stringsConcatenated.substring(count);
        }

        return response;
    }
}
