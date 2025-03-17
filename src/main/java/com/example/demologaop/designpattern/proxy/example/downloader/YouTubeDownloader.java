package com.example.demologaop.designpattern.proxy.example.downloader;

import com.example.demologaop.designpattern.proxy.example.library.ThirdPartyYouTubeLib;
import com.example.demologaop.designpattern.proxy.example.media.Video;
import com.example.demologaop.designpattern.proxy.example.proxy.YouTubeCacheProxy;

import java.util.HashMap;

public class YouTubeDownloader {
    private ThirdPartyYouTubeLib api;

    public YouTubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);

        System.out.println("\n----------------");
        System.out.println("Video page (imagine fancy html)");
        System.out.println("ID: " + videoId);
        System.out.println("Title: " + video.title);
        System.out.println("Video: " + video.data);
        System.out.println("----------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = api.popularVideos();

        System.out.println("\n----------------");
        System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " / Title: " + video.title);
        }
        System.out.println("----------------\n");
    }

}
