package com.abc.filtersensitiveword;



public class Main {
     public static void main(String[] args){
        	FilterSensitiveWord fsw=FilterSensitiveWord.getInstance("a.txt");
        	long starttime=System.currentTimeMillis();
        	System.out.println(starttime);
        	//检测文本中的敏感词并输出
            fsw.checkSentitiveWord("逗比ihoao 毛泽东hwoufhaohfnoi n你们的haoihfoiwhoihuaihuhaiuvhuhauvhauhvaiuhviuahiuvhaiuhviueahviueaniuhiuhwaiuhfiuahiuvcheahvoiueavoiuheaiuvhaiuhiuahfiahfoiuhwaofwoclklwoca");
            long endtime=System.currentTimeMillis();
        	System.out.println(endtime);
            System.out.println(endtime-starttime);
            
            long starttime2=System.currentTimeMillis();
        	System.out.println(starttime);
        	fsw.insertIntoDict("毛泽东");
        	//检测文本中的敏感词并输出
            fsw.checkSentitiveWord("逗比ihoao 毛泽东hwoufhaohfnoi n你们的haoihfoiwhoihuaihuhaiuvhuhauvhauhvaiuhviuahiuvhaiuhviueahviueaniuhiuhwaiuhfiuahiuvcheahvoiueavoiuheaiuvhaiuhiuahfiahfoiuhwaofwoclklwoca");
            long endtime2=System.currentTimeMillis();
            System.out.println(endtime2-starttime2);
     }
}
