package com.binovel.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.binovel.domain.Blog;

public class IndexUtil {

	private static double RAMBufferSizeMB;

	private static int MaxBufferedDocs;

	private static Version VERSION_CURRENT = Version.LUCENE_4_9;

	// 返回一个indexconfig
	private final static IndexWriterConfig getIndexWriterConfig(
			Analyzer analyzer) {
		IndexWriterConfig iwc = new IndexWriterConfig(VERSION_CURRENT, analyzer);
		/*
		 * iwc.setRAMBufferSizeMB(RAMBufferSizeMB);
		 * iwc.setMaxBufferedDocs(MaxBufferedDocs);
		 */return iwc;
	}

	// 关闭方法
	private static void closeWriter(IndexWriter indexWriter) throws IOException {
		if (indexWriter != null) {
			indexWriter.close();
		}
	}
	//关闭方法
	private static void closeDirectory(Directory  directory){
		if(directory != null){
			try {
				directory.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 创建索引，考虑大量索引的创建，所以这里采用多线程创建索引，然后合并索引的方式
	// 想到可能要分不同的目录来创建不同的索引，所以这里传入一个标量
	public static  void createIndex(int indexType, Blog blog) {
		String filePath = getFilepath(indexType);
		IndexWriter indexWriter = null;
		Directory dir = null;;
		try {
			dir = FSDirectory.open(new File(filePath));
			indexWriter = new IndexWriter(dir,
					getIndexWriterConfig(new SmartChineseAnalyzer(
							VERSION_CURRENT)));
			Document doc = new Document();
			doc.add(new StringField("id", String.valueOf(blog.getId()), Store.YES));
			doc.add(new StringField("title", blog.getTitle(), Store.YES));
			doc.add(new TextField("context",BlogUtil.getDigest(blog.getContext()), Store.YES));
			//doc.add(new StringField("author",blog.getAuthor(),Store.YES));
			indexWriter.addDocument(doc, new SmartChineseAnalyzer(
					VERSION_CURRENT));
			indexWriter.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeDirectory(dir);
				closeWriter(indexWriter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String getFilepath(int indexType) {

		switch (indexType) {
		case 1:
			return "D:\\lucence\\binovelindex";
		default:
			return "D:\\lucence\\binovelindex";
		}
	}

	
	/**
	 * g测试工具类
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("create index for for binovel.....");
		ExecutorService exec = Executors.newFixedThreadPool(2);
		final Blog blog = new Blog();
		blog.setId(1);
		blog.setTitle("nihao");
		blog.setContext("woxihuanzhengjiao");

		exec.execute(new Runnable() {

			public void run() {
				try {
					System.out.println("Thread 1 create index ....");
					IndexUtil.createIndex(1, blog);
					System.out.println("Thread 1 create index ..finished..");
					Thread.sleep(5000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		System.out.println("---------------我是分割线---------------");
		exec.execute(new Runnable() {

			public void run() {
				try {
					System.out.println("Thread 2 create index ....");
					IndexUtil.createIndex(1, blog);
					System.out.println("Thread 2 create index ..finished..");
					Thread.sleep(5000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		exec.shutdown();
	}

	/**
	 * 删除一个特定的id的文件
	 * @param indexPath
	 * @param id
	 */
	public static void delete(String indexPath, String id) {
		IndexWriter indexWriter = null;
		Directory directory = null;
		try {
			directory = FSDirectory.open(new File(indexPath));// 打开文件索引目录
			indexWriter = new IndexWriter(directory,
					getIndexWriterConfig(new SmartChineseAnalyzer(
							VERSION_CURRENT)));

			IndexReader reader = DirectoryReader.open(directory);// 读取目录
			Query q = new TermQuery(new Term("id", id));
			indexWriter.deleteDocuments(q);// 删除指定ID的Document
			indexWriter.commit();// 提交
			indexWriter.close();// 关闭
			reader.close();// 关闭
			System.out.println("删除id为" + id + "的记录成功");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				closeDirectory(directory);
				closeWriter(indexWriter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 更新一个特定的id
	 * @param indexPath
	 * @param docID
	 * @param map
	 */
	//TODO  传入参数还未修改
	public synchronized void updateByID(String indexPath, String docID,
			HashMap<String, String> map) {
		IndexWriter indexWriter = null;
		Directory directory = null;
		try {
			directory = FSDirectory.open(new File(indexPath));// 打开文件索引目录

			indexWriter = new IndexWriter(directory,
					getIndexWriterConfig(new SmartChineseAnalyzer(
							VERSION_CURRENT)));
			// IndexReader reader=DirectoryReader.open(directory);//读取目录
			// Document doc=reader.document(Integer.parseInt(docID));
			Document d = new Document();
			d.add(new StringField("id", map.get("id").toString(), Store.YES));
			d.add(new TextField("name", map.get("name").toString(), Store.YES));
			d.add(new TextField("content", map.get("content").toString(),
					Store.YES));
			indexWriter.updateDocument(new Term("id", docID), d);
			indexWriter.commit();
			indexWriter.close();// 关闭
			directory.close();// 关闭
			System.out.println("更新成功!");
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				
				closeWriter(indexWriter);
				closeDirectory(directory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
