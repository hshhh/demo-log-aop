package com.example.demologaop.designpattern.proxy.example.proxy;

import com.example.demologaop.designpattern.proxy.example.library.ThirdPartyYouTubeClass;
import com.example.demologaop.designpattern.proxy.example.library.ThirdPartyYouTubeLib;
import com.example.demologaop.designpattern.proxy.example.media.Video;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();


    public YouTubeCacheProxy() {
        this(new ThirdPartyYouTubeClass());
    }

    public YouTubeCacheProxy(ThirdPartyYouTubeLib youtubeService) {
        this.youtubeService = youtubeService;
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }

        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video 【" + videoId + "】from cache.");
        }
        return video;
    }

    public void reset() {
        cacheAll.clear();
        cachePopular.clear();
    }
}
