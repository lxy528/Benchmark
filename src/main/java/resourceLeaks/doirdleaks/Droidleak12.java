package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
/*
 * A real resource leak example extracted from  
 * https://github.com/wordpress-mobile/WordPress-Android/commit/094a6490b9b846c1c34f66cc617191e6011d268b
 */

public class Droidleak12 {
	public class StatsSummary implements Serializable{
	    private static final long serialVersionUID = 1951520106663020694L;

	    @SerializedName("visitors_today")
	    private int visitorsToday;

	    @SerializedName("visitors_yesterday")
	    private int visitorsYesterday;

	    @SerializedName("views_today")
	    private int viewsToday;

	    @SerializedName("views_yesterday")
	    private int viewsYesterday;

	    @SerializedName("views_best_day")
	    private String viewsBestDay;

	    @SerializedName("views_best_day_total")
	    private int viewsBestDayTotal;

	    @SerializedName("views")
	    private int viewsAllTime;

	    @SerializedName("comments")
	    private int commentsAllTime;

	    @SerializedName("posts")
	    private int posts;

	    @SerializedName("followers_blog")
	    private int followersBlog;

	    @SerializedName("followers_comments")
	    private int followersComments;

	    @SerializedName("comments_per_month")
	    private int commentsPerMonth;

	    @SerializedName("comments_most_active_recent_day")
	    private String commentsMostActiveRecentDay;

	    @SerializedName("comments_most_active_time")
	    private String commentsMostActiveTime;

	    @SerializedName("comments_spam")
	    private int commentsSpam;

	    @SerializedName("categories")
	    private int categories;

	    @SerializedName("tags")
	    private int tags;

	    @SerializedName("shares")
	    private int shares;

	    public int getVisitorsToday() {
	        return visitorsToday;
	    }

	    public void setVisitorsToday(int visitorsToday) {
	        this.visitorsToday = visitorsToday;
	    }

	    public int getVisitorsYesterday() {
	        return visitorsYesterday;
	    }

	    public void setVisitorsYesterday(int visitorsYesterday) {
	        this.visitorsYesterday = visitorsYesterday;
	    }

	    public int getViewsToday() {
	        return viewsToday;
	    }

	    public void setViewsToday(int viewsToday) {
	        this.viewsToday = viewsToday;
	    }

	    public int getViewsYesterday() {
	        return viewsYesterday;
	    }

	    public void setViewsYesterday(int viewsYesterday) {
	        this.viewsYesterday = viewsYesterday;
	    }

	    public String getBestDay() {
	        return viewsBestDay;
	    }

	    public void setViewsBestDay(String viewsBestDay) {
	        this.viewsBestDay = viewsBestDay;
	    }

	    public int getViewsBestDayTotal() {
	        return viewsBestDayTotal;
	    }

	    public void setBestDayTotal(int viewsBestDayTotal) {
	        this.viewsBestDayTotal = viewsBestDayTotal;
	    }

	    public int getViewsAllTime() {
	        return viewsAllTime;
	    }

	    public void setViewsAllTime(int viewsAllTime) {
	        this.viewsAllTime = viewsAllTime;
	    }

	    public int getCommentsAllTime() {
	        return commentsAllTime;
	    }

	    public void setCommentsAllTime(int commentsAllTime) {
	        this.commentsAllTime = commentsAllTime;
	    }

	    public int getPosts() {
	        return posts;
	    }

	    public void setPosts(int posts) {
	        this.posts = posts;
	    }

	    public int getFollowersBlog() {
	        return followersBlog;
	    }

	    public void setFollowersBlog(int followersBlog) {
	        this.followersBlog = followersBlog;
	    }

	    public int getFollowersComments() {
	        return followersComments;
	    }

	    public void setFollowersComments(int followersComments) {
	        this.followersComments = followersComments;
	    }

	    public int getCommentsPerMonth() {
	        return commentsPerMonth;
	    }

	    public void setCommentsPerMonth(int commentsPerMonth) {
	        this.commentsPerMonth = commentsPerMonth;
	    }

	    public String getCommentsMostActiveRecentDay() {
	      //  return StatsUtils.parseDate(commentsMostActiveRecentDay, "yyyy-MM-dd", "MMMMM d, yyyy");
	    	return "";
	    }

	    public void setCommentsMostActiveRecentDay(String commentsMostActiveRecentDay) {
	        this.commentsMostActiveRecentDay = commentsMostActiveRecentDay;
	    }

	    public String getCommentsMostActiveTime() {
	        return commentsMostActiveTime;
	    }

	    public void setCommentsMostActiveTime(String commentsMostActiveTime) {
	        this.commentsMostActiveTime = commentsMostActiveTime;
	    }

	    public int getCommentsSpam() {
	        return commentsSpam;
	    }

	    public void setCommentsSpam(int commentsSpam) {
	        this.commentsSpam = commentsSpam;
	    }

	    public int getCategories() {
	        return categories;
	    }

	    public void setCategories(int categories) {
	        this.categories = categories;
	    }

	    public int getTags() {
	        return tags;
	    }

	    public void setTags(int tags) {
	        this.tags = tags;
	    }

	    public int getShares() {
	        return shares;
	    }

	    public void setShares(int shares) {
	        this.shares = shares;
	    }
	}
	private static final String STAT_SUMMARY = "StatSummary_";
	 public static StatsSummary getSummary(String blogId) {
	        StatsSummary stat = null;
	        try {
	            FileInputStream fis = new FileInputStream(new File(""));//WordPress.getContext().openFileInput(STAT_SUMMARY + blogId);//WordPress是一个application类型的
	            StringBuilder fileContent = new StringBuilder();

	            byte[] buffer = new byte[1024];

	            int bytesRead = fis.read(buffer);
	            while (bytesRead != -1) {
	                fileContent.append(new String(buffer, 0, bytesRead, "ISO-8859-1"));
	                bytesRead = fis.read(buffer);
	            }
	          // fis.close();

	            Gson gson = new Gson();
	            stat = gson.fromJson(fileContent.toString(), StatsSummary.class);

	        } catch (FileNotFoundException e) {
	            // stats haven't been downloaded yet
	        } catch (IOException e) {
	           // AppLog.e(T.STATS, e);
	        }
	        return stat;
	    }
}
