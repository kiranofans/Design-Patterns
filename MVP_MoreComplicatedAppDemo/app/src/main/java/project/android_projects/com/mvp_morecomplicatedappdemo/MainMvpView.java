package project.android_projects.com.mvp_morecomplicatedappdemo;

import java.util.List;

import Data.ui.MvpView;
import Model.FeedItem;

public interface MainMvpView extends MvpView {

    void updateFeed(List<FeedItem> feedItemList);
}
