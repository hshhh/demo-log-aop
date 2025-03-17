package com.example.demologaop.designpattern.proxy.example.library;

import com.example.demologaop.designpattern.proxy.example.media.Video;

import java.util.HashMap;

/**
 * 远程服务接口
 */
public interface ThirdPartyYouTubeLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
