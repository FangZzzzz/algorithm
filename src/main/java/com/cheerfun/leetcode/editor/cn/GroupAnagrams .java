//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

package com.cheerfun.leetcode.editor.cn;

import java.util.*;

class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new LinkedList<>();
            if (strs.length == 0) {
                return result;
            }
            Map<String, List> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String str = String.valueOf(chars);
                if(map.containsKey(str)) {
                    map.get(str).add(strs[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    map.put(str,list);
                    list.add(strs[i]);
                    result.add(list);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}