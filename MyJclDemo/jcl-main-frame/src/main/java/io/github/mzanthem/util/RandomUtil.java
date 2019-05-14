package io.github.mzanthem.util;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;


/**
 * 根据传入的数据进行随机数选取
 * 
 * @author guangming.ma
 * 
 */
public class RandomUtil{

    public static final int ZERO = 0;
    public static final int ONE = 1;
    /**
     * 根据传入的最小值以及最大值选取随机数
     * [minimum, maximum]
     * @param minimum
     *            最小值
     * @param maximum
     *            最大值
     * @return 选取的最小值
     */
    public static int randomByNumber(int minimum,int maximum){
        Random random = new Random();
        if (maximum < minimum){
            maximum = maximum ^ minimum;
            minimum = maximum ^ minimum;
            maximum = maximum ^ minimum;
        }
        int ran = random.nextInt(maximum - minimum + 1) + minimum;
        return ran;
    }

    
    /**
     * 根据传入的最小值以及最大值选取随机数
     * 
     * @param minimum
     *            最小值
     * @param maximum
     *            最大值
     * @param rightEq
     *            右侧是否可以取等           
     *            
     * @return 选取的最小值
     */
    public static int randomByNumber(int minimum,int maximum, boolean rightEq){
        
        if (maximum < minimum){
            maximum = maximum ^ minimum;
            minimum = maximum ^ minimum;
            maximum = maximum ^ minimum;
        }
        
        int r = rightEq ? ONE : ZERO;
        
        int ran = (int) (Math.random() * (maximum - minimum + r) + minimum);
        return ran;
    }
    
    /**
     * 从0开始的随机
     * [0, maxinun]
     * @param maximun
     * @return
     */
    public static int randomByNumber(int maximun) {
        return randomByNumber(ZERO, maximun);
    }
    

    
    /**
     * 随机数字：从[1,2,3...,N]中,随机取r个(r<  N)
     * 
     * eg：从所有的仓库中，随机取出N个
     * @param size
     * @return
     */
    public static int[] getRandomIndex(int size) {
        //索引的个数
        int r = RandomUtil.randomByNumber(1, size); //[1,size]
        
        int[] indexs = new int[r];//仓库的索引数组
        int time = 0;
        while (time < r) {
            //从所有的仓库中取一个
            int index = RandomUtil.randomByNumber(1, size);
            if (!ArrayUtils.contains(indexs, index)) {
                indexs[time] = index;
                time++;
            }
        }
        
        return indexs;
    }
    
    //-----------------------------------------------------//
    /**
     * 获取指定长度的字符串
     * 注意：
     * 长度为4情况下：
     * 1k次请求下 重复率为2
     * 1w次请求下 重复率为50左右
     * 10w次请求下 重复率为500左右
     * 
     * 长度为6情况下：
     * 10w次请求下 重复率 3
     * 100w次请求下 重复率为300
     * 
     * @param length
     * @return
     * @see http://blog.csdn.net/yaodong_y/article/details/8115250
     */
    public static String getStringRandom(int length){

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        String charOrNum;
        for (int i = 0; i < length; i++){

            charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)){
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            }else if ("num".equalsIgnoreCase(charOrNum)){
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    
    /**
     * 获取一个指定长度的随机数
     * @param length 小于16位
     */
    public static String getRandomByLength(int length) {
        
        if (length < 1) {
            length = 1;
        }
        if (length > 16) {
            length = 16;
        }
        Double random = Math.random();
        String str = random.toString().substring(2, 2 + length);
        
        return str;
    }
    
}
