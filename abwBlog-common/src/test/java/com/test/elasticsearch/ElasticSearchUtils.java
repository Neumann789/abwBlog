package com.test.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetSocketAddress;

/**
 * Created by fanghuabao on 2018/4/28 0028.
 *
 * 提供elasticsearch的相关功能：
 * 连接
 * 创建索引
 * 搜索
 *
 *
 */
public class ElasticSearchUtils {

    /**
     * hosts格式形如：ip1:port1,ip2:port2
     * @param hosts
     * @return
     */
    public static TransportClient buidlClient(String hosts){
        Settings settings = Settings.builder()
                .put("client.transport.ping_timeout", 10)
                .put("client.transport.sniff", "true")
                .put("client.transport.ignore_cluster_name", "true")
                .build();
        TransportClient transportClient = TransportClient.builder().build();
        String[] split = hosts.split(",");
        for(String host:split){
            String[] arr = host.split(":");
            String ip = arr[0];
            Integer port = Integer.valueOf(arr[1]);
            transportClient.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(ip,port)));
        }
        return transportClient;

    }
    public static TransportClient buidlDefaultClient(){
        return buidlClient("127.0.0.1:9300");
    }

    /**
     * 创建索引
     * @param index
     * @param type
     */
    public static void createIndex(String index,String type){

        IndexRequestBuilder indexRequestBuilder = buidlDefaultClient().prepareIndex(index,type);
        IndexResponse indexResponse = indexRequestBuilder.execute().actionGet();
        System.out.println(JSON.toJSONString(indexResponse));

    }

    public static void main(String[] args) {
       /* String hosts = "127.0.0.1:9300";
        TransportClient transportClient =ElasticSearchUtils.buidlClient(hosts);
        System.out.println("elastic search client buind success");*/

        ElasticSearchUtils.createIndex("hello","hello");
    }

}
