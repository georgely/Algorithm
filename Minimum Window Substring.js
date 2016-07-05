/**
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

//https://github.com/yuzhangcmu/LeetCode/blob/master/string/MinWindow.java
//http://codeganker.blogspot.com/2014/03/minimum-window-substring-leetcode.html

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    var tSet = {},
        tFoundSet = {},
        hasFound = 0,
        lenS = s.length,
        lenT = t.length,
        winStart = -1,
        winEnd = lenS,
        result,
        start,
        c,
        i,
        j;
        
    for (i = 0; i < lenT; i++) {
        tFoundSet[t.charAt(i)] = 0;
        tSet[t.charAt(i)] = tSet[t.charAt(i)]? tSet[t.charAt(i)] + 1 : 1;
    }

    for (i = 0, start = 0; i < lenS; i++) {
        c = s.charAt(i);
        if (tSet.hasOwnProperty(c)) {
            if (tFoundSet[c] < tSet[c]) {
                hasFound++;
            }
            
            tFoundSet[s.charAt(i)]++;
        }
        
        if (hasFound === lenT) {
            while (!tSet[s.charAt(start)] || tFoundSet[s.charAt(start)] > tSet[s.charAt(start)]) {
                if (tFoundSet[s.charAt(start)]) {
                    tFoundSet[s.charAt(start)]--;
                }
                start++;
            }
            
            if (winEnd - winStart > i - start) {
                winStart = start;
                winEnd = i;
            }
            
            tFoundSet[s.charAt(start)]--;
            start++;
            hasFound--;
        }
    }
    
    return winStart !== -1? s.substr(winStart, winEnd - winStart + 1) : '';
};
