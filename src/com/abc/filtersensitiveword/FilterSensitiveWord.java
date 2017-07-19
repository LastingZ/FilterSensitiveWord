package com.abc.filtersensitiveword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FilterSensitiveWord {
	private static FilterSensitiveWord fsw=null;
	private static Map<String,Object> wordmap=new HashMap<String,Object>();
	private FilterSensitiveWord(String filename){
	}
	public static FilterSensitiveWord getInstance(String filename){
		if (fsw == null){
			fsw = new FilterSensitiveWord(filename);
			wordmap = fsw.getWordDict(fsw.getWordSet(filename));
		}
		return fsw;
	} 
	

	//从敏感词词典读取所有的敏感词，加载到set中
	private Set<String> getWordSet(String filename){
		File file=new File(filename);
		Set<String> wordset=new HashSet<String>();
		if(file.exists() && file!=null){
			try{
				BufferedReader bf=new BufferedReader(new FileReader(file));
				String tmp;
				while((tmp=bf.readLine())!=null){
					wordset.add(tmp);
				}
				bf.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return wordset;
	}
	private Map<String, Object> getWordDict(Set<String> set){
		Iterator<String> it=set.iterator();
		String word;
		while(it.hasNext()){
			word=it.next();
			insertIntoDict(word, wordmap);
		}
		return wordmap;
	}
	
	//将敏感词加入到字典树
	public void insertIntoDict(String word,Map<String,Object> wordmap){
		String tmp;
		Map<String,Object> nowmap=wordmap;
		for(int i=0;i<word.length();i++){
			tmp=String.valueOf(word.charAt(i));
			if(!nowmap.containsKey(tmp)){
				Map<String, Object> tmap=new HashMap<String,Object>();
				nowmap.put(tmp, tmap);
				nowmap=(Map) nowmap.get(tmp);
			}else{
				nowmap=(Map) nowmap.get(tmp);
				
			}
			if(i==(word.length()-1)){
			    nowmap.put("isEnd", "true");
			}
			
		}
	}
	//检测敏感词，并输出
	public void checkSentitiveWord(String stringtodeal){
		String tmp;
		int i=0,count=0;
		StringBuilder br = new StringBuilder();
		Map<String,Object> nowmap=wordmap;
		while(i<stringtodeal.length()){
			tmp=String.valueOf(stringtodeal.charAt(i));
			if(nowmap.containsKey(tmp)){
               nowmap=(Map) nowmap.get(tmp);
               br.append(tmp);
               if(nowmap.containsKey("isEnd")){
            	count++;
   				System.out.println("This txt contains sensitive words : "+br);
   			  }
			}else{
			   nowmap=wordmap;
			   br.delete(0, br.length());
			}
			i++;
			if(i==stringtodeal.length() && count == 0){
				System.out.println("This txt does not contains sensitive words");
			}
		}

	}
}
