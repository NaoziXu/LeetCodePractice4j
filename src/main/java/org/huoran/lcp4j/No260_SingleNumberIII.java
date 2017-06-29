package org.huoran.lcp4j;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Naozi on 2017/6/29.
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class No260_SingleNumberIII {

    /**
     * fuck your mother bitch!
     * see you.
     * @author Naozi
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        // use HashMap
        HashMap<Integer,Boolean> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],false);
            }
            else{
                map.put(nums[i],true);
            }
        }
        Set<Integer> keySet = map.keySet();
        int[] result = new int[2];
        int i = 0;
        for(Integer key : keySet){
            if(map.get(key)){
                result[i] = key;
                i++;
                if(i == 2){
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        No260_SingleNumberIII clazz = new No260_SingleNumberIII();
        int[] array = new int[]{1, 2, 1, 3, 2, 5, 1};
        int[] result = clazz.singleNumber(array);
        System.out.println(JSONObject.toJSONString(result));
    }
}
