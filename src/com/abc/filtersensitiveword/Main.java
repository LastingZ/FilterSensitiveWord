package com.abc.filtersensitiveword;



public class Main {
     public static void main(String[] args){
        	FilterSensitiveWord fsw=FilterSensitiveWord.getInstance("a.txt");
        	long starttime=System.currentTimeMillis();
        	System.out.println(starttime);
        	//����ı��е����дʲ����
            fsw.checkSentitiveWord("����ihoao ë��hwoufhaohfnoi n���ǵ�haoihfoiwhoihuaihuhaiuvhuhauvhauhvaiuhviuahiuvhaiuhviueahviueaniuhiuhwaiuhfiuahiuvcheahvoiueavoiuheaiuvhaiuhiuahfiahfoiuhwaofwoclklwoca");
            long endtime=System.currentTimeMillis();
        	System.out.println(endtime);
            System.out.println(endtime-starttime);
            
            long starttime2=System.currentTimeMillis();
        	System.out.println(starttime);
        	fsw.insertIntoDict("ë��");
        	//����ı��е����дʲ����
            fsw.checkSentitiveWord("����ihoao ë��hwoufhaohfnoi n���ǵ�haoihfoiwhoihuaihuhaiuvhuhauvhauhvaiuhviuahiuvhaiuhviueahviueaniuhiuhwaiuhfiuahiuvcheahvoiueavoiuheaiuvhaiuhiuahfiahfoiuhwaofwoclklwoca");
            long endtime2=System.currentTimeMillis();
            System.out.println(endtime2-starttime2);
     }
}
