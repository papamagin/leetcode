// https://leetcode.com/problems/roman-to-integer/
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romans = new HashMap();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (i == s.length() - 1) {
                res += romans.get(s.charAt(i));
                i++;
            } else {
                char cur = s.charAt(i);
                char next = s.charAt(i + 1);
                switch (s.charAt(i)) {
                    case 'I': 
                        {
                            if (next == 'V') {
                                res += 4;
                                i++;
                            } else if (next == 'X') {
                                res += 9;
                                i++;
                            } else {
                                res += 1;
                            }
                            break;
                        }
                    case 'V': 
                        {
                            res += 5;
                            break;
                        }
                    case 'X': 
                        {
                            if (next == 'L') {
                                res += 40;
                                i++;
                            } else if (next == 'C') {
                                res += 90;
                                i++;
                            } else {
                                res += 10;
                            }
                            break;
                        }
                    case 'L': 
                        {
                            res += 50;
                            break;
                        }
                    case 'C': 
                        {
                            if (next == 'D') {
                                res += 400;
                                i++;
                            } else if (next == 'M') {
                                res += 900;
                                i++;
                            } else {
                                res += 100;
                            }
                            break;
                        }
                    case 'D': 
                        {
                            res += 500;
                            break;
                        }
                    case 'M': 
                        {
                            res += 1000;
                            break;
                        }
                }
                i++;
            }
        }
        return res;
    }
}
