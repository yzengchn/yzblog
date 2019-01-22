package xyz.yzblog.article.crawler.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import xyz.yzblog.article.crawler.TestCrawler;

public class ArticleProcessor implements PageProcessor {

	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		page.addTargetRequests(page.getHtml().links().regex("https://blog.csdn.net/[a‐z 0‐9 ‐]+/article/details/[0‐9]{8}").all());
		String title = page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[1]/div[1]/h1/text()").get();
		String content = page.getHtml().xpath("//*[@id=\"article_content\"]/div/div[1]").get();
		//获取页面内容
		System.out.println("标题：" + title);
		System.out.println("内容：" + content);
		
		if(title != null && content != null) {
			page.putField("title", title);
			page.putField("content", content);
		}else {
			//跳过
			page.setSkip(true);
		}
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return Site.me().setSleepTime(100).setRetryTimes(3);
	}
	
	public static void main(String[] args) {
		Spider.create(new ArticleProcessor()).addUrl("https://blog.csdn.net/nav/ai").run();
	}

}
