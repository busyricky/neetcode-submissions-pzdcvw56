class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1chars = new HashMap<>();
        int s1length = s1.length();

        for (char c : s1.toCharArray()) {
            s1chars.put(c, s1chars.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;

        while (r < s2.length() && s1length > 0) {
            if (s1chars.getOrDefault(s2.charAt(r),0) != 0) {
                char c = s2.charAt(r);
                s1chars.put(c, s1chars.get(c) - 1);
                s1length--;
            } else {
                while (l <= r) {
                    char c = s2.charAt(l);
                    if (s1length < s1.length()) {
                        if(c == s2.charAt(r)) {
                            l++;
                            break;
                        }
                        s1chars.put(c, s1chars.getOrDefault(c,0) + 1);
                        s1length++;
                    }
                    
                    l++;
                    // if (l < s2.length() && r >= l) {
                    //     c = s2.charAt(l);
                    //     if (s1chars.getOrDefault(c, 0) != 0) {
                    //         s1chars.put(c, s1chars.get(c) - 1);
                    //         s1length--;
                    //         break;
                    //     }
                    // }
                }
            }
            r++;
        }

        return s1length == 0 ? true : false;
    }
}
