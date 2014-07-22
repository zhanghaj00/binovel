package com.binovel.util;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.analyzing.AnalyzingQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class SearchUtil {
	private static Version VERSION_CURRENT = Version.LUCENE_4_9;
	
	private final static Analyzer ChineseAnalyzer = new SmartChineseAnalyzer(VERSION_CURRENT); 
	public static void searchDemo1(String key,int indexType){
		
		String filepath = IndexUtil.getFilepath(indexType);
		
		Directory directory = null;
		IndexReader indexReader = null;
		IndexSearcher indexSearcher = null;
		
		try {
			directory  = FSDirectory.open(new File(filepath));
			
			indexReader = DirectoryReader.open(directory);
			
			indexSearcher = new IndexSearcher(indexReader);
			
			
			//key是在外面拼接需要搜索的内容，比如
			
			QueryParser qp = new AnalyzingQueryParser(VERSION_CURRENT,"",
					ChineseAnalyzer);
 
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
