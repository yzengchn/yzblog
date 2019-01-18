package xyz.yzblog.article.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class TestCrawler implements PageProcessor{

	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		page.addTargetRequests(page.getHtml().links().regex("https://www.yzblog.xyz/^.{1,50}$.html").all());
		String title = page.getHtml().xpath("//*[@class=\"post-title\"]/a/text()").get();
		String content = page.getHtml().xpath("//*[@id=\"article_content\"]/div/div[1]").get();
		//获取页面内容
		System.out.println("标题：" + title);
		System.out.println("内容：" + content);
	}

	@Override
	public Site getSite() {
		return Site.me().setSleepTime(100).setRetryTimes(3);
	}
	
	public static void main(String[] args) {
		Spider.create(new TestCrawler()).addUrl("https://www.yzblog.xyz/StudyVideo.html").run();
	}
}
