package com.zjs.product1.utils;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/22 10:20
 */
public class MyUtil {
    static String familyName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻水云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅卞齐康伍余元卜顾孟平"

            + "黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计成戴宋茅庞熊纪舒屈项祝董粱杜阮席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田胡凌霍万柯卢莫房缪干解应宗丁宣邓郁单杭洪包诸左石崔吉"

            + "龚程邢滑裴陆荣翁荀羊甄家封芮储靳邴松井富乌焦巴弓牧隗山谷车侯伊宁仇祖武符刘景詹束龙叶幸司韶黎乔苍双闻莘劳逄姬冉宰桂牛寿通边燕冀尚农温庄晏瞿茹习鱼容向古戈终居衡步都耿满弘国文东殴沃曾关红游盖益桓公晋楚闫";

    static String firstName2 = "欧阳太史端木上官司马东方独孤南宫万俟闻人夏侯诸葛尉迟公羊赫连澹台皇甫宗政濮阳公冶太叔申屠公孙慕容仲孙钟离长孙宇文司徒鲜于司空闾丘子车亓官司寇巫马公西颛孙壤驷公良漆雕乐正宰父谷梁拓跋夹谷轩辕令狐段干百里呼延东郭南门羊舌微生公户公玉公仪梁丘公仲公上公门公山公坚左丘公伯西门公祖第五公乘贯丘公皙南荣东里东宫仲长子书子桑即墨达奚褚师吴铭";

    static String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";

    static String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

    static String ordName = "牙膏-5.00 牙刷-6.00 洗手液-7.00 洗面奶-22.00 帽子-32.12 手套-23.18 冰箱-1999 电视机-3999.99 手机-5999 平板电脑-3599 显卡-12999 显示器-3499";
    public static String randFamilyName() {
        String str = "";
        int strLen;
        int randNum = new Random().nextInt(2) + 1;
        int index;
        if (randNum == 1) {
            strLen = familyName.length();
            index = new Random().nextInt(strLen);
            str = String.valueOf(familyName.charAt(index));
        } else {
            strLen = firstName2.length();
            index = new Random().nextInt(strLen);
            if (index % 2 == 0) {
                str = firstName2.substring(index, index + 2);
            } else {
                str = firstName2.substring(index - 1, index + 1);
            }
        }
        return str;
    }

    public static String randSex() {
        int randNum = new Random().nextInt(2) + 1;
        return randNum == 1 ? "男" : "女";
    }

    public static String randName(String sex) {
        String firstName = randFamilyName();
        String name = "";
        int randNum = new Random().nextInt(2) + 1;
        int index;
        if (sex.equals("男")) {
            int strLen = boyName.length();
            if (randNum % 2 == 0) {
                index = new Random().nextInt(strLen - 1);
                name = boyName.substring(index, index + randNum);
            } else {
                index = new Random().nextInt(strLen);
                name = boyName.substring(index, index + randNum);
            }
        } else {
            int strLen = girlName.length();
            if (randNum % 2 == 0) {
                index = new Random().nextInt(strLen - 1);
                name = girlName.substring(index, index + randNum);
            } else {
                index = new Random().nextInt(strLen);
                name = girlName.substring(index, index + randNum);
            }
        }
        return firstName + name;
    }

    public static String randName() {
        String sex = randSex();
        return randName(sex);
    }

    public static int randAge() {
        return new Random().nextInt(4) + 18;
    }

    public static String getRandomIp() {
        // 指定 IP 范围
        int[][] range = {
                {607649792, 608174079}, // 36.56.0.0-36.63.255.255
                {1038614528, 1039007743}, // 61.232.0.0-61.237.255.255
                {1783627776, 1784676351}, // 106.80.0.0-106.95.255.255
                {2035023872, 2035154943}, // 121.76.0.0-121.77.255.255
                {2078801920, 2079064063}, // 123.232.0.0-123.235.255.255
                {-1950089216, -1948778497}, // 139.196.0.0-139.215.255.255
                {-1425539072, -1425014785}, // 171.8.0.0-171.15.255.255
                {-1236271104, -1235419137}, // 182.80.0.0-182.92.255.255
                {-770113536, -768606209}, // 210.25.0.0-210.47.255.255
                {-569376768, -564133889}, // 222.16.0.0-222.95.255.255
        };

        Random random = new Random();
        int index = random.nextInt(10);
        String ip = num2ip(range[index][0] + random.nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    public static String num2ip(int ip) {
        int[] b = new int[4];
        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        // 拼接 IP
        String x = b[0] + "." + b[1] + "." + b[2] + "." + b[3];
        return x;
    }

    public static String getRandomOrd(){
        String[] s = ordName.split(" ");
        int index = new Random().nextInt(s.length - 1);
        return s[index];
    }

    public static Date randomDate(){
        long date = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date beginDate = format.parse("2023-01-01 00:00:00");
            Date endDate = format.parse("2023-03-31 00:00:00");
            if(beginDate.getTime() >= endDate.getTime()){
                return new Date();
            }
            date = random(beginDate.getTime(),endDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Date(date);
    }
    public static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(MyUtil.randomDate());
    }
}

